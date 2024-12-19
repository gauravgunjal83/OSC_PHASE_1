package com.in.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
public class FilterProductRequestDto {
    private String productId;
    private String categoryId;
    private String prodName;
    private double prodMarketPrice;
    private String productDescription;
    private String imagePath;
    private LocalDateTime dateOfProduct;
}
