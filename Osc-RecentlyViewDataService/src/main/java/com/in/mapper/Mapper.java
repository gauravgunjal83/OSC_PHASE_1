package com.in.mapper;

import com.in.ProductHistory.UpdateRecentViewRequest;
import com.in.ProductHistory.UpdateRecentViewResponse;
import com.in.avro.RecentViewProduct;
import com.in.dto.RecentlyViewRequestDto;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static RecentViewProduct stringToRecentViewProductAvro(List<CharSequence> listProductIds) {
        return RecentViewProduct.newBuilder().setProductIds(new ArrayList<>(listProductIds)).build();
    }

    public static RecentlyViewRequestDto updateRecentViewProtoToRecentViewReqDto(UpdateRecentViewRequest request) {
        return new RecentlyViewRequestDto(request.getUserId(), request.getProductId());
    }

    public static UpdateRecentViewResponse booleanToUpdateRecentViewResProto(boolean status) {
        return UpdateRecentViewResponse.newBuilder()
                .setStatus(status).build();
    }

}
