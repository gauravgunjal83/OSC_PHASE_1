package com.in.grpc;

import com.in.dashboard.*;
import com.in.dto.DashboardProductResponseDto;
import com.in.dto.FilterProductRequestDto;
import com.in.dto.ProductDataResponseDto;
import com.in.exception.RecordNotFoundException;
import com.in.mapper.Mapper;
import com.in.service.DashboardService;
import com.in.service.FilterProductService;
import com.in.service.ProductDetailsService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GrpcService
public class ProductData_GrpcService extends ProductDashboardServiceGrpc.ProductDashboardServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(ProductData_GrpcService.class);

    private final DashboardService dashboardService;
    private final ProductDetailsService productDetailsService;
    private final FilterProductService filterProductService;

    public ProductData_GrpcService(DashboardService dashboardService, ProductDetailsService productDetailsService, FilterProductService filterProductService) {
        this.dashboardService = dashboardService;
        this.productDetailsService = productDetailsService;
        this.filterProductService = filterProductService;
    }

    @Override
    public void fetchProductForDashboard(DashboardRequest request, StreamObserver<DashboardResponse> responseObserver) {
        try {
            DashboardProductResponseDto products = dashboardService.getProductById(Mapper.protocolStringListToList(request.getProductIdList()));
            responseObserver.onNext(Mapper.dashboardProdResDtoToDashboardResProto(products));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error in getting product")
                    .withCause(new RecordNotFoundException("Error in fetch product details")).asRuntimeException());
        }
    }

    @Override
    public void fetchProductDetails(ProductDataRequest request, StreamObserver<ProductDataResponse> responseObserver) {
        try {
            log.info("getting request for fetch product:{}", request.getProductId());
            ProductDataResponseDto productDetails = productDetailsService.getProductDetails(request.getProductId());
            responseObserver.onNext(Mapper.ProductDataResponseDtoToProductDataResProto(productDetails));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error in getting product")
                    .withCause(new RecordNotFoundException("Error in update the view count of product"))
                    .asRuntimeException());
        }
    }

    @Override
    public void filterProductData(FilterProductRequest request, StreamObserver<FilterProductResponse> responseObserver) {
        try {
            log.info("Getting request for filter the data for this categoryId:{}", request.getCategoryId());
            List<FilterProductRequestDto> filterProductData = filterProductService.filterProducts(request.getCategoryId(), request.getFilter().toString());
            responseObserver.onNext(Mapper.filterProductReqDtoListToFilterProductResProto(filterProductData));
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error occurs in getting product.......")
                    .withCause(new RecordNotFoundException("Error occurs when filtering the product......")).asRuntimeException());
        }
    }
}
