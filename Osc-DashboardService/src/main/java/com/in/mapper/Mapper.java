package com.in.mapper;

import com.in.ProductHistory.RecentlyViewRequest;
import com.in.ProductHistory.RecentlyViewResponse;
import com.in.ProductHistory.UpdateRecentViewRequest;
import com.in.cart.ViewCartProductRequest;
import com.in.dashboard.*;
import com.in.dto.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {


    public static RecentlyViewRequest dashboardReqDtoToRecentlyViewReqProto(DashboardRequestDto dashboardRequest) {
        return RecentlyViewRequest.newBuilder().setUserId(dashboardRequest.getUserId()).build();
    }

    public static DashboardRequest recentlyViewResProtoToDashboardReqProto(RecentlyViewResponse recentlyViewResponse) {
        return DashboardRequest.newBuilder().addAllProductId(recentlyViewResponse.getProductIdsList()).build();
    }

    public static ProductDataRequest productDataReqDtoToProductDataReqProto(ProductDataRequestDto productDataRequestDto) {
        return ProductDataRequest.newBuilder().setProductId(productDataRequestDto.getProductId()).build();
    }

    public static ProductDataResponseDto productProtoToProductDataResDto(Product product, List<Product> similarProductsList) {
        List<SimilarProductResponseDto> similarProducts = similarProductsList.stream()
                .map(Mapper::productProtoToSimilarProductResDto)
                .collect(Collectors.toList());
        return new ProductDataResponseDto(product.getProductId(),
                product.getCategoryId(),
                product.getProductName(),
                product.getProductDesc(),
                product.getProductPrice(),
                similarProducts);
    }

    public static SimilarProductResponseDto productProtoToSimilarProductResDto(Product product) {
        return new SimilarProductResponseDto(product.getProductId(),
                product.getCategoryId(),
                product.getProductName(),
                product.getProductDesc(),
                product.getProductPrice());
    }

    public static UpdateRecentViewRequest productDataReqDtoToUpdateRecentViewReqProto(ProductDataRequestDto productDataRequest) {
        return UpdateRecentViewRequest.newBuilder().setProductId(productDataRequest.getProductId())
                .setUserId(productDataRequest.getUserId()).build();
    }

    public static ViewCartProductRequest stringToViewCartProductReqProto(String userId) {
        return ViewCartProductRequest.newBuilder().setUserId(userId).build();
    }

    public static FilterProductRequest filterProductRequestDtoToFilterProductReqProto(FilterProductRequestDto productRequestDto) {
        return FilterProductRequest.newBuilder().setCategoryId(productRequestDto.getCategoryId()
        ).setFilter(FilterProductRequest.Filter.valueOf(productRequestDto.getFilter().toUpperCase().trim().toString())).build();
    }

    public static CustomDataResponse filterProductResProtoToCustomResponse(FilterProductResponse filterProductData) {
        List<SimilarProductResponseDto> productList = filterProductData.getProductList().stream()
                .map(product -> new SimilarProductResponseDto(
                        product.getProductId(),
                        product.getCategoryId(),
                        product.getProductName(),
                        product.getProductDesc(),
                        product.getProductPrice()
                )).collect(Collectors.toList());
        return new CustomDataResponse(CustomStatusCode.SUCCESS, Map.of("products", productList));
    }
}
