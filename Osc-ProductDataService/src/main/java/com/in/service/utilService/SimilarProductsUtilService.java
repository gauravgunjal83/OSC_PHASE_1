package com.in.service.utilService;

import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.dto.ProductDataRequestDto;
import com.in.mapper.Mapper;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SimilarProductsUtilService {
    private static final Logger log = LoggerFactory.getLogger(SimilarProductsUtilService.class);

    private final ReadOnlyKeyValueStore<String, ProductViewCount> productCountStore;
    private final ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore;

    public SimilarProductsUtilService(ReadOnlyKeyValueStore<String, ProductViewCount> productCountStore, ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore) {
        this.productCountStore = productCountStore;
        this.productDetailsStore = productDetailsStore;
    }

    public List<ProductDataRequestDto> getSimilarProducts(List<ProductDataRequestDto> recentlyViewedProducts) {
        if (recentlyViewedProducts.isEmpty()) {
            return Collections.emptyList();
        }
        Set<String> categoryIds = recentlyViewedProducts.stream().map(ProductDataRequestDto::getCategoryId)
                .collect(Collectors.toSet());

        Set<String> viewedProductIds = recentlyViewedProducts.stream().map(ProductDataRequestDto::getProductId)
                .collect(Collectors.toSet());

        List<ProductDataRequestDto> similarProducts = new ArrayList<>();

        for (String categoryId : categoryIds) {
            KeyValueIterator<String, ProductViewCount> iterator = productCountStore.all();
            String maxProductId = null;
            int maxViewCount = -1;

            while (iterator.hasNext()) {
                var productEntry = iterator.next();
                ProductViewCount productViewCount = productEntry.value;
                String productId = productEntry.key;

                if (!viewedProductIds.contains(productId) && productViewCount.getCategoryId().toString().equals(categoryId)) {
                    if (productViewCount.getCount() > maxViewCount) {
                        maxViewCount = productViewCount.getCount();
                        maxProductId = productId;
                    }
                }
            }
            if (maxProductId != null) {
                ProductDetails productDetails = productDetailsStore.get(maxProductId);
                ProductViewCount viewCount = productCountStore.get(maxProductId);
                if (productDetails != null) {
                    similarProducts.add(Mapper.productDetailsAvroToProductReqDto(maxProductId, productDetails, viewCount.getCount()));
                }
            }
        }

        if (similarProducts.size() < 6) {
            String firstCategoryId = recentlyViewedProducts.get(0).getCategoryId();
            KeyValueIterator<String, ProductDetails> iterator = productDetailsStore.all();
            while (iterator.hasNext() && similarProducts.size() < 6) {
                var productEntry = iterator.next();
                ProductDetails productDetails = productEntry.value;
                String productId = productEntry.key;

                if (productDetails != null && productDetails.getCategoryId().toString().equals(firstCategoryId)
                        && !viewedProductIds.contains(productId)
                        && similarProducts.stream().noneMatch(prod -> prod.getProductId().equals(productId))) {
                    ProductViewCount viewCount = productCountStore.get(productId);
                    if (viewCount != null) {
                        similarProducts.add(Mapper.productDetailsAvroToProductReqDto(productId, productDetails, viewCount.getCount()));
                    }
                }
            }

        }
        similarProducts.forEach(product -> log.info("Getting similar product: {}", product.getProductId()));
        return similarProducts;

    }

    public List<ProductDataRequestDto> getSimilarProductsByCategory(String categoryId, String prodId) {
        List<ProductDataRequestDto> similarProducts = new ArrayList<>();
        KeyValueIterator<String, ProductDetails> iterator = productDetailsStore.all();
        while (iterator.hasNext()) {
            var productEntry = iterator.next();
            ProductDetails product = productEntry.value;
            String productId = productEntry.key;

            if (product != null
                    && product.getCategoryId().toString().equals(categoryId)
                    && !productId.equals(prodId)) {
                ProductViewCount viewCount = productCountStore.get(productId);
                if (viewCount != null) {
                    similarProducts.add(Mapper.productDetailsAvroToProductReqDto(productId, product, viewCount.getCount()));
                }
            }
        }

        return similarProducts.stream()
                .sorted(Comparator.comparing(ProductDataRequestDto::getProdMarketPrice, Comparator.nullsLast(Comparator.naturalOrder()))
                        .reversed())
                .limit(6).collect(Collectors.toList());
    }
}
