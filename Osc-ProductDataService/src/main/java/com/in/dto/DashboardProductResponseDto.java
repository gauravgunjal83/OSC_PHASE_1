package com.in.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class DashboardProductResponseDto {

    List<ProductDataRequestDto> featuredProducts;
    List<CategoryDataRequestDto> categories;
    List<ProductDataRequestDto> recentlyViewedProducts;
    List<ProductDataRequestDto> similarProducts;
}
