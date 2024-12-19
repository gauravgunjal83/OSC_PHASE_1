package com.in.service;

import com.in.dto.CustomDataResponse;
import com.in.dto.ProductDataRequestDto;

public interface ProductDetailsService {

    public CustomDataResponse getProductDetails(ProductDataRequestDto productDataRequest);
}
