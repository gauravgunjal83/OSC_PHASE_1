package com.in.service.serviceImpl;

import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.dto.CategoryDataRequestDto;
import com.in.dto.DashboardProductResponseDto;
import com.in.dto.ProductDataRequestDto;
import com.in.mapper.Mapper;
import com.in.service.DashboardService;
import com.in.service.utilService.CategoryUtilService;
import com.in.service.utilService.FeatureProductsUtilService;
import com.in.service.utilService.SimilarProductsUtilService;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DashboardServiceImpl implements DashboardService {
    private static final Logger log = LoggerFactory.getLogger(DashboardServiceImpl.class);

    private final ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore;
    private final ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore;
    private final SimilarProductsUtilService similarProductsService;
    private final FeatureProductsUtilService featureProductService;
    private final CategoryUtilService categoryService;

    public DashboardServiceImpl(ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore, ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore, SimilarProductsUtilService similarProductsService, FeatureProductsUtilService featureProductService, CategoryUtilService categoryService) {
        this.productDetailsStore = productDetailsStore;
        this.productViewCountStore = productViewCountStore;
        this.similarProductsService = similarProductsService;
        this.featureProductService = featureProductService;
        this.categoryService = categoryService;
    }


    @Override
    public DashboardProductResponseDto getProductById(List<String> productIdList) {
        List<CategoryDataRequestDto> categories = categoryService.getTopCategories(6);

        if (productIdList == null || productIdList.isEmpty()) {
            List<ProductDataRequestDto> featureProducts = featureProductService.featureProducts(12);
            return buildDashboardResponse(featureProducts, categories, Collections.emptyList(), Collections.emptyList());
        } else {
            List<ProductDataRequestDto> recentlyViewedProducts = productIdList.stream().map(productId -> {
                ProductDetails productDetails = productDetailsStore.get(productId);
                ProductViewCount productViewCount = productViewCountStore.get(productId);
                return productDetails != null ? Mapper.productDetailsAvroToProductReqDto(productId, productDetails, productViewCount.getCount()) : null;
            }).filter(Objects::nonNull).collect(Collectors.toList());

            // similar products based on the recently viewed products
            List<ProductDataRequestDto> similarProducts = similarProductsService.getSimilarProducts(recentlyViewedProducts);
            return buildDashboardResponse(Collections.emptyList(), categories, recentlyViewedProducts, similarProducts);
        }
    }

    private DashboardProductResponseDto buildDashboardResponse(List<ProductDataRequestDto> featuredProducts,
                                                               List<CategoryDataRequestDto> categories,
                                                               List<ProductDataRequestDto> recentlyViewedProducts,
                                                               List<ProductDataRequestDto> similarProducts) {

        DashboardProductResponseDto responseDto = new DashboardProductResponseDto();
        responseDto.setFeaturedProducts(featuredProducts);
        responseDto.setCategories(categories);
        responseDto.setSimilarProducts(similarProducts);
        responseDto.setRecentlyViewedProducts(recentlyViewedProducts);
        return responseDto;
    }
}
