package com.in.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class DataResponse {

    private int code;
    private Object dataObject;

}
