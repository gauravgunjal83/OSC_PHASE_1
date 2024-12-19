package com.in.grpcService;

import com.in.ProductHistory.*;
import com.in.dto.RecentlyViewProductDto;
import com.in.mapper.Mapper;
import com.in.service.RecentlyViewProductService;
import com.in.service.UpdateRecentlyViewProductService;
import com.in.service.serviceImpl.RecentlyViewProductListService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GrpcService
public class RecentViewProduct_Grpc_Service extends RecentlyViewServiceGrpc.RecentlyViewServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(RecentViewProduct_Grpc_Service.class);

    private final RecentlyViewProductService recentlyViewService;
    private final UpdateRecentlyViewProductService updateRecentlyViewProductService;
    private final RecentlyViewProductListService recentlyViewProductListService;

    public RecentViewProduct_Grpc_Service(RecentlyViewProductService recentlyViewService, UpdateRecentlyViewProductService updateRecentlyViewProductService, RecentlyViewProductListService recentlyViewProductListService) {
        this.recentlyViewService = recentlyViewService;
        this.updateRecentlyViewProductService = updateRecentlyViewProductService;
        this.recentlyViewProductListService = recentlyViewProductListService;
    }

    @Override
    public void fetchRecentlyViewedHistory(RecentlyViewRequest request, StreamObserver<RecentlyViewResponse> responseObserver) {
        try {
            log.info("Received request for fetching userId: {}", request.getUserId());
            List<String> viewProducts = recentlyViewService.getRecentlyViewProducts(request.getUserId());
            //  save the recent view product in Database
            if (!viewProducts.isEmpty()) {
                recentlyViewProductListService.saveRecentViewProduct(new RecentlyViewProductDto(request.getUserId(), viewProducts));
                log.info("save recently view product..!");
            }
            RecentlyViewResponse.Builder responseBuilder = RecentlyViewResponse.newBuilder();
            if (viewProducts != null) responseBuilder.addAllProductIds(viewProducts);

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error in getting recently view Product").withCause(e).asRuntimeException());
        }

    }

    @Override
    public void updatedRecentlyViewProducts(UpdateRecentViewRequest request, StreamObserver<UpdateRecentViewResponse> responseObserver) {
        try {
            log.info("Received request to update recently view product for userId: {}", request.getUserId());
            boolean status = updateRecentlyViewProductService.updateRecentlyViewProducts(Mapper.updateRecentViewProtoToRecentViewReqDto(request));
            log.info("Recently view updated data is saved in db ");
            responseObserver.onNext(Mapper.booleanToUpdateRecentViewResProto(status));
            responseObserver.onCompleted();

        } catch (RuntimeException e) {
            responseObserver.onError(Status.INTERNAL.withDescription("Error in update list of recently view Product").withCause(e).asRuntimeException());
        }
    }
}
