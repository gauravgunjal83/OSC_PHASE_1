package com.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDataRequestDto {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("catId")
    private String categoryId;

    @JsonProperty("prodId")
    private String productId;
}
