package com.in.service.serviceImpl;

import com.in.ProductHistory.RecentlyViewServiceGrpc;
import com.in.ProductHistory.UpdateRecentViewResponse;
import com.in.dashboard.ProductDashboardServiceGrpc;
import com.in.dashboard.ProductDataResponse;
import com.in.dto.CustomDataResponse;
import com.in.dto.CustomStatusCode;
import com.in.dto.ProductDataRequestDto;
import com.in.dto.ProductDataResponseDto;
import com.in.mapper.Mapper;
import com.in.service.ProductDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    private static final Logger log = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);

    private final RecentlyViewServiceGrpc.RecentlyViewServiceBlockingStub recentlyViewServiceBlockingStub;
    private final ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productDashboardServiceBlockingStub;

    public ProductDetailsServiceImpl(RecentlyViewServiceGrpc.RecentlyViewServiceBlockingStub recentlyViewServiceBlockingStub, ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productDashboardServiceBlockingStub) {
        this.recentlyViewServiceBlockingStub = recentlyViewServiceBlockingStub;
        this.productDashboardServiceBlockingStub = productDashboardServiceBlockingStub;
    }

    @Override
    public CustomDataResponse getProductDetails(ProductDataRequestDto productDataRequest) {
        ProductDataResponse productDataResponse = productDashboardServiceBlockingStub.fetchProductDetails(Mapper.productDataReqDtoToProductDataReqProto(productDataRequest));
        log.info("Getting details of products: {}", productDataResponse.getProduct());

        ProductDataResponseDto response = Mapper.productProtoToProductDataResDto(productDataResponse.getProduct(), productDataResponse.getSimilarProductsList());

        UpdateRecentViewResponse recentViewResponse = recentlyViewServiceBlockingStub.updatedRecentlyViewProducts(Mapper.productDataReqDtoToUpdateRecentViewReqProto(productDataRequest));
     log.info("Updated List of recently view product: {}",recentViewResponse);
        return new CustomDataResponse(CustomStatusCode.SUCCESS, response);
    }
}
