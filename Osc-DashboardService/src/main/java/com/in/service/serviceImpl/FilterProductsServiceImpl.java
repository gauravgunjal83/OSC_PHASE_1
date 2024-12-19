package com.in.service.serviceImpl;

import com.in.dashboard.FilterProductResponse;
import com.in.dashboard.ProductDashboardServiceGrpc;
import com.in.dto.CustomDataResponse;
import com.in.dto.FilterProductRequestDto;
import com.in.mapper.Mapper;
import com.in.service.FilterProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FilterProductsServiceImpl implements FilterProductsService {
    private static final Logger log = LoggerFactory.getLogger(FilterProductsServiceImpl.class);

    private final ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productStub;

    public FilterProductsServiceImpl(ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productStub) {
        this.productStub = productStub;
    }

    @Override
    public CustomDataResponse filterProducts(FilterProductRequestDto filterProductDto) {
        FilterProductResponse filterProductResponse = productStub.filterProductData(Mapper.filterProductRequestDtoToFilterProductReqProto(filterProductDto));
        log.info("Received filter request..");
        CustomDataResponse response = Mapper.filterProductResProtoToCustomResponse(filterProductResponse);
        return response;
    }
}
