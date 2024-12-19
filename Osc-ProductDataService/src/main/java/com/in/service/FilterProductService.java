package com.in.service;

import com.in.dto.FilterProductRequestDto;

import java.util.List;

public interface FilterProductService {

    public List<FilterProductRequestDto> filterProducts(String categoryId, String filterType);
}
