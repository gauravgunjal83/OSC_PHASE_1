package com.in.service;

import com.in.dto.CustomDataResponse;
import com.in.dto.FilterProductRequestDto;

public interface FilterProductsService {
    public CustomDataResponse filterProducts(FilterProductRequestDto filterProductDto);
}
