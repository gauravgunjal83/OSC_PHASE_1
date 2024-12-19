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
public class FeatureProductsUtilService {
    private static final Logger log = LoggerFactory.getLogger(FeatureProductsUtilService.class);

    private final ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore;
    private final ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore;

    public FeatureProductsUtilService(ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore, ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore) {
        this.productDetailsStore = productDetailsStore;
        this.productViewCountStore = productViewCountStore;
    }

    public List<ProductDataRequestDto> featureProducts(int count) {
        KeyValueIterator<String, ProductViewCount> iterator = productViewCountStore.all();
        List<Map.Entry<String, ProductViewCount>> featureProducts = new ArrayList<>();
        List<ProductDataRequestDto> featuredProduct = new ArrayList<>();
        while (iterator.hasNext()) {
            var productViewCount = iterator.next();
            String productId = productViewCount.key;
            ProductDetails product = productDetailsStore.get(productId);
            if (product != null) {
                featureProducts.add(new AbstractMap.SimpleEntry<>(productId, productViewCount.value));
            }
        }
        featureProducts.sort((entry1, entry2) -> Integer.compare(entry2.getValue().getCount(), entry1.getValue().getCount()));

        featuredProduct = featureProducts.stream().limit(count).map(entry -> {
            String productId = entry.getKey();
            ProductViewCount viewCount = productViewCountStore.get(productId);
            ProductDetails productDetails = productDetailsStore.get(productId);
            return Mapper.productDetailsAvroToProductReqDto(productId, productDetails, viewCount.getCount());
        }).filter(Objects::nonNull).collect(Collectors.toList());
        log.info("Getting list of featured products :");
        return featuredProduct;
    }
}
