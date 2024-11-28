package com.in.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class DataResponse {

    private int code;
    private Object dataObject;

//    public DataResponse(int code, Object dataObject) {
//        this.dataObject = dataObject;
//        this.code = code;
//    }
//
//    public DataResponse() {
//
//    }
//
//    public Object getDataObject() {
//        return dataObject;
//    }
//
//    public void setDataObject(Object dataObject) {
//        this.dataObject = dataObject;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
}
