package com.in.service;

import com.in.dto.DashboardProductResponseDto;

import java.util.List;

public interface DashboardService {

    public DashboardProductResponseDto getProductById(List<String> productIdList);
}
