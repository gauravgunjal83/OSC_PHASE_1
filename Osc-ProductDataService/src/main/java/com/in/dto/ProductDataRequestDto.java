package com.in.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ProductDataRequestDto {

    private String productId;
    private String categoryId;
    private String prodName;
    private double prodMarketPrice;
    private String productDescription;
    private String imagePath;
    private int counts;
}
