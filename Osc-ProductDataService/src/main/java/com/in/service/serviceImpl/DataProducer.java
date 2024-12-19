package com.in.service.serviceImpl;

import com.in.dto.CategoryDataRequestDto;
import com.in.dto.ProductDataRequestDto;
import com.in.dto.ProductViewCountDto;
import com.in.kafka.KafkaProducer.KafkaCategoryProducer;
import com.in.kafka.KafkaProducer.KafkaProductCountProducer;
import com.in.kafka.KafkaProducer.KafkaProductProducer;
import com.in.mapper.Mapper;
import com.in.service.CategoryDataService;
import com.in.service.ProductDataService;
import com.in.service.utilService.ProductViewCountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DataProducer implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(DataProducer.class);

    private final ProductDataService productDataService;
    private final CategoryDataService categoryDataService;
    private final KafkaProductProducer productProducer;
    private final KafkaCategoryProducer categoryProducer;
    private final KafkaProductCountProducer productCountProducer;
    private final ProductViewCountService productViewCountService;

    private final Set<String> publishedProduct = new HashSet<>();
    private final Set<String> publishedCategory = new HashSet<>();
    private final Set<String> publishedProductCount = new HashSet<>();

    public DataProducer(ProductDataService productDataService, CategoryDataService categoryDataService, KafkaProductProducer productProducer, KafkaCategoryProducer categoryProducer, @Qualifier("productViewCountProducer") KafkaProductCountProducer productCountProducer, ProductViewCountService productViewCountService) {
        this.productDataService = productDataService;
        this.categoryDataService = categoryDataService;
        this.productProducer = productProducer;
        this.categoryProducer = categoryProducer;
        this.productCountProducer = productCountProducer;
        this.productViewCountService = productViewCountService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
log.info("Starting Data producer.......");

//publishProducts();
//publishCategories();
//publishProductViewCounts();
    }

    private void publishProducts() {
        List<ProductDataRequestDto> products = productDataService.getAllProducts();
        List<ProductDataRequestDto> productsToPublish = products.stream().filter(product -> !publishedProduct.contains(product.getProductId())).toList();

        if (!productsToPublish.isEmpty()) {
            log.info("Publishing {} products to Kafka...", productsToPublish.size());
            productsToPublish.forEach(product -> {
                try {
                    productProducer.publishProductDataToKafka(product.getProductId(), Mapper.productDataReqDtoToProductDetailsAvro(product));
                    publishedProduct.add(product.getProductId());
                } catch (Exception e) {
                    log.error("Failed to publish product: {}", product.getProductId(), e);
                }
            });
            log.info("Finished publishing products.");
        }
    }

    private void publishProductViewCounts() {
        List<ProductViewCountDto> allProductViewCount = productViewCountService.getAllProduct();
        List<ProductViewCountDto> productsViewToPublish = allProductViewCount.stream().filter(product -> !publishedProductCount.contains(product.getProductId()))
                .collect(Collectors.toList());

        if (!productsViewToPublish.isEmpty()) {
            log.info("Publishing {} product view counts to Kafka...", productsViewToPublish.size());
            productsViewToPublish.forEach(product -> {
                try {
                    productCountProducer.publishProductViewCountToKafka(product.getProductId(), Mapper.productViewCountDtoToProductViewCountAvro(product));
                    publishedProductCount.add(product.getProductId());
                } catch (Exception e) {
                    log.error("Failed to publish product view count: {}", product.getProductId(), e);

                }
            });
            log.info("Finished publishing product view counts.");
        }
    }

    private void publishCategories() {
        List<CategoryDataRequestDto> categories = categoryDataService.getAllCategory();
        List<CategoryDataRequestDto> categoriesToPublish = categories.stream().filter(category -> !publishedCategory.contains(category.getCategoryId())).collect(Collectors.toList());
        if (!categoriesToPublish.isEmpty()) {
            log.info("Publishing {} categories to Kafka...", categoriesToPublish.size());
            categoriesToPublish.forEach(category -> {
                try {
                    categoryProducer.publishCategoryDataToKafka(category.getCategoryId(), Mapper.categoryReqDtoToCategoryDetailsAvro(category));
                    publishedCategory.add(category.getCategoryId());
                } catch (Exception e) {
                    log.error("Failed to publish category: {}", category.getCategoryId(), e);
                }
            });
            log.info("Finished publishing Categories.");
        }
    }
}
