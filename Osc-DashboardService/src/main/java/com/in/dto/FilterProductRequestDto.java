package com.in.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FilterProductRequestDto {

    @JsonIgnoreProperties("userId")
    private String userId;

    @JsonProperty("catId")
    private String categoryId;

    @JsonProperty("filter")
    private String filter;
}
