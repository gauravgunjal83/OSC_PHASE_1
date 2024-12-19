package com.in.controller;

import com.in.dto.*;
import com.in.service.DashboardRequestService;
import com.in.service.FilterProductsService;
import com.in.service.ProductDetailsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DashboardController {

    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);
    private final DashboardRequestService dashboardRequestService;
    private final ProductDetailsService productDetailsService;
    private final FilterProductsService filterProductsService;

    public DashboardController(DashboardRequestService dashboardRequestService, ProductDetailsService productDetailsService, FilterProductsService filterProductsService) {
        this.dashboardRequestService = dashboardRequestService;
        this.productDetailsService = productDetailsService;
        this.filterProductsService = filterProductsService;
    }

    @PostMapping("/user/dashBoard")
    public ResponseEntity<CustomDataResponse> dashBoardRequest(@Valid @RequestBody DashboardRequestDto dashboardRequest) {
        log.info("Received request for dashboard view for this userId : {}", dashboardRequest.getUserId());
        CustomDataResponse response = dashboardRequestService.dashBoardRequest(dashboardRequest);
        return ResponseEntity.status(CustomStatusCode.SUCCESS).body(response);
    }

    @PostMapping("/product/details")
    public ResponseEntity<CustomDataResponse> getProductDetails(@RequestBody ProductDataRequestDto requestDto){
       log.info("Received request for view details of product of this productId: {}", requestDto.getProductId());
       CustomDataResponse response = productDetailsService.getProductDetails(requestDto);
        return  ResponseEntity.status(CustomStatusCode.SUCCESS).body(response);
    }

    @PostMapping("/filter/product")
    public ResponseEntity<CustomDataResponse> filterProduct(@RequestBody FilterProductRequestDto filterProductDto){
        log.info("Received request for filter product :{}",filterProductDto.getCategoryId());
        CustomDataResponse response = filterProductsService.filterProducts(filterProductDto);
        return ResponseEntity.status(CustomStatusCode.SUCCESS).body(response);
    }
}
