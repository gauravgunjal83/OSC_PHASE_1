package com.in.mapper;

import com.google.protobuf.ProtocolStringList;
import com.in.avro.CategoryDetails;
import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.dashboard.*;
import com.in.dto.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static ProductDetails productDataReqDtoToProductDetailsAvro(ProductDataRequestDto requestDto) {
        return ProductDetails.newBuilder()
                .setCategoryId(requestDto.getCategoryId())
                .setProductName(requestDto.getProdName())
                .setProductPrice(requestDto.getProdMarketPrice())
                .setProductDescription(requestDto.getProductDescription())
                .setDate(Instant.now())
                .setImagePath(requestDto.getImagePath())
                .build();
    }

    public static ProductViewCount productViewCountDtoToProductViewCountAvro(ProductViewCountDto productViewCount) {
        return ProductViewCount.newBuilder().setCategoryId(productViewCount.getCategoryId())
                .setCount(productViewCount.getViewCount()).build();
    }

    public static CategoryDetails categoryReqDtoToCategoryDetailsAvro(CategoryDataRequestDto categoryDataRequest) {
        return CategoryDetails.newBuilder().setCategoryName(categoryDataRequest.getCategoryName())
                .setImagePath(categoryDataRequest.getImagePath()).build();
    }

    public static ProductDataRequestDto productDetailsAvroToProductReqDto(String productId, ProductDetails productDetails, int count) {
        return new ProductDataRequestDto(productId,
                productDetails.getCategoryId().toString(),
                productDetails.getProductName().toString(),
                productDetails.getProductPrice(),
                productDetails.getProductDescription().toString(),
                productDetails.getImagePath().toString(), count);
    }

    public static CategoryDataRequestDto categoryDetailsAvroToCategoryReqDto(String categoryId, CategoryDetails categoryDetails) {
        if (categoryDetails == null) {
            return null;
        }
        return new CategoryDataRequestDto(categoryId, categoryDetails.getCategoryName().toString(),
                categoryDetails.getImagePath().toString());
    }

    public static List<String> protocolStringListToList(ProtocolStringList productIdList) {
        return productIdList.stream().toList();
    }

    public static Product productDataReqDtoToProductProto(ProductDataRequestDto dto) {
        return Product.newBuilder()
                .setProductId(dto.getProductId())
                .setCategoryId(dto.getCategoryId())
                .setProductName(dto.getProdName())
                .setProductDesc(dto.getProductDescription())
                .setProductPrice(dto.getProdMarketPrice())
                .setImagePath(dto.getImagePath())
                .build();
    }

    public static List<Product> productDataReqDtoToProductList(List<ProductDataRequestDto> dtoList) {
        return dtoList.stream().map(Mapper::productDataReqDtoToProductProto).collect(Collectors.toList());
    }

    public static DashboardResponse dashboardProdResDtoToDashboardResProto(DashboardProductResponseDto dashboardProduct) {
        DashboardDetails.Builder dashboardDetailsBuilder = DashboardDetails.newBuilder();

        //feature products
        List<Product> featureProducts = productDataReqDtoToProductList(dashboardProduct.getFeaturedProducts());
        dashboardDetailsBuilder.addAllFeaturedProducts(featureProducts);

        //recently view products
        List<Product> recentlyViewProducts = productDataReqDtoToProductList(dashboardProduct.getRecentlyViewedProducts());
        dashboardDetailsBuilder.addAllRecentlyViewedProducts(recentlyViewProducts);

        //similar products
        List<Product> similarProducts = productDataReqDtoToProductList(dashboardProduct.getSimilarProducts());
        dashboardDetailsBuilder.addAllSimilarProducts(similarProducts);

        List<Category> categories = dashboardProduct.getCategories().stream().map(Mapper::categoryDataReqDtoToCategoryProto).collect(Collectors.toList());
        dashboardDetailsBuilder.addAllCategories(categories);

        DashboardDetails dashboardDetails = dashboardDetailsBuilder.build();
        return DashboardResponse.newBuilder()
                .setDashBoardDetails(dashboardDetails).build();
    }


    public static Category categoryDataReqDtoToCategoryProto(CategoryDataRequestDto dto) {
        return Category.newBuilder()
                .setCategoryId(dto.getCategoryId())
                .setCategoryName(dto.getCategoryName())
                .setImagePath(dto.getImagePath())
                .build();
    }


    public static ProductDataResponse ProductDataResponseDtoToProductDataResProto(ProductDataResponseDto productDetails) {
        Product product = Product.newBuilder()
                .setProductId(productDetails.getProductData().getProductId())
                .setCategoryId(productDetails.getProductData().getCategoryId())
                .setProductName(productDetails.getProductData().getProdName())
                .setProductDesc(productDetails.getProductData().getProductDescription())
                .setProductPrice(productDetails.getProductData().getProdMarketPrice())
                .setImagePath(productDetails.getProductData().getImagePath())
                .build();

        // Map the similar products
        List<Product> similarProducts = productDetails.getSimilarProducts().stream()
                .map(similarProduct -> Product.newBuilder()
                        .setProductId(similarProduct.getProductId())
                        .setCategoryId(similarProduct.getCategoryId())
                        .setProductName(similarProduct.getProdName())
                        .setProductDesc(similarProduct.getProductDescription())
                        .setProductPrice(similarProduct.getProdMarketPrice())
                        .setImagePath(similarProduct.getImagePath())
                        .build())
                .collect(Collectors.toList());
        return ProductDataResponse.newBuilder()
                .setProduct(product)
                .addAllSimilarProducts(similarProducts)
                .build();
    }

    public static FilterProductRequestDto productDetailsAvroToFilterProductReqDto(String productId, ProductDetails productDetails) {
        LocalDateTime date = productDetails.getDate().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return new FilterProductRequestDto(productId,
                productDetails.getCategoryId().toString(),
                productDetails.getProductName().toString(),
                productDetails.getProductPrice(),
                productDetails.getProductDescription().toString(),
                productDetails.getImagePath().toString()
                , date);
    }

    public static FilterProductResponse filterProductReqDtoListToFilterProductResProto(List<FilterProductRequestDto> filterProductRequestDto){
       List<Product> filterList = filterProductRequestDto.stream().map(dto ->
               Product.newBuilder().setProductId(dto.getProductId())
                       .setCategoryId(dto.getCategoryId())
                       .setProductName(dto.getProdName())
                       .setProductDesc(dto.getProductDescription())
                       .setProductPrice(dto.getProdMarketPrice())
                       .setImagePath(dto.getImagePath()).build()).collect(Collectors.toList());
        return FilterProductResponse.newBuilder().addAllProduct(filterList).build();
    }
}
