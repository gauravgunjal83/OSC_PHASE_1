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
public class ProductDataResponseDto {

    private ProductDataRequestDto productData;
    private List<ProductDataRequestDto> similarProducts;
}
