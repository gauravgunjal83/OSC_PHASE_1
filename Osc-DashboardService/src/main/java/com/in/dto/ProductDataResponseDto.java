package com.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataResponseDto {


    @JsonProperty("prodId")
    private String productId;

    @JsonProperty("catId")
    private String categoryId;

    @JsonProperty("prodName")
    private String productName;

    @JsonProperty("prodDesc")
    private String productDescription;

    @JsonProperty("prodPrice")
    private double productPrice;

    private List<SimilarProductResponseDto> similarProducts;
}
