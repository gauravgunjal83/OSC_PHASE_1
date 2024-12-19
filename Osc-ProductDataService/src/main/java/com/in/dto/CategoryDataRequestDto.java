package com.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDataRequestDto {
    private String categoryId;
    private String categoryName;
    private String imagePath;
}
