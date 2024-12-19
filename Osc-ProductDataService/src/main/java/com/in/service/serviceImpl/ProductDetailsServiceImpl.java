package com.in.service.serviceImpl;

import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.dto.ProductDataRequestDto;
import com.in.dto.ProductDataResponseDto;
import com.in.kafka.KafkaProducer.KafkaProductCountProducer;
import com.in.mapper.Mapper;
import com.in.service.ProductDetailsService;
import com.in.service.utilService.SimilarProductsUtilService;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);

    private final ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore;
    private final ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore;
    private final KafkaProductCountProducer productCountProducer;
    private final SimilarProductsUtilService similarProductsService;

    public ProductDetailsServiceImpl(ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore, ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore, @Qualifier("productViewCountProducer") KafkaProductCountProducer productCountProducer, SimilarProductsUtilService similarProductsService) {
        this.productViewCountStore = productViewCountStore;
        this.productDetailsStore = productDetailsStore;
        this.productCountProducer = productCountProducer;
        this.similarProductsService = similarProductsService;
    }

    @Override
    public ProductDataResponseDto getProductDetails(String productId) {
        log.info("getting recently view data for productId: {}", productId);
        ProductDetails productDetails = productDetailsStore.get(productId);

        ProductViewCount productViewCount = productViewCountStore.get(productId);
        if (productViewCount == null) {
            productViewCount = new ProductViewCount(1, productDetails.getCategoryId());
        } else {
            productViewCount.setCount(productViewCount.getCount() + 1);
        }
        productCountProducer.publishProductViewCountToKafka(productId, productViewCount);
        ProductDataRequestDto productDataRequest = Mapper.productDetailsAvroToProductReqDto(productId, productDetails, productViewCount.getCount());

        String categoryId = productDetails.getCategoryId().toString();

        //fetching the similar products by categoryId
        List<ProductDataRequestDto> similarProducts = similarProductsService.getSimilarProductsByCategory(categoryId, productId);
        return new ProductDataResponseDto(productDataRequest, similarProducts);
    }
}
