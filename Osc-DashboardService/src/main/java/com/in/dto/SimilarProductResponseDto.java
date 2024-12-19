package com.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarProductResponseDto {

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("catId")
    private String categoryId;

    @JsonProperty("prodName")
    private String productName;

    @JsonProperty("prodDesc")
    private String productDescription;

    @JsonProperty("prodMarketPrice")
    private double productPrice;
}
