package com.in.service.serviceImpl;

import com.in.ProductHistory.RecentlyViewResponse;
import com.in.ProductHistory.RecentlyViewServiceGrpc;
import com.in.cart.CartDataProductServiceGrpc;
import com.in.cart.ViewCartProductResponse;
import com.in.dashboard.DashboardResponse;
import com.in.dashboard.ProductDashboardServiceGrpc;
import com.in.dto.CustomDataResponse;
import com.in.dto.DashboardRequestDto;
import com.in.mapper.Mapper;
import com.in.service.DashboardRequestService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DashboardRequestServiceImpl implements DashboardRequestService {

    private static final Logger log = LoggerFactory.getLogger(DashboardRequestServiceImpl.class);

    private final ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productServiceStub;
    private final RecentlyViewServiceGrpc.RecentlyViewServiceBlockingStub recentlyViewServiceStub;
    private final CartDataProductServiceGrpc.CartDataProductServiceBlockingStub cartDataProductStub;

    public DashboardRequestServiceImpl(ProductDashboardServiceGrpc.ProductDashboardServiceBlockingStub productServiceStub, RecentlyViewServiceGrpc.RecentlyViewServiceBlockingStub recentlyViewServiceStub, CartDataProductServiceGrpc.CartDataProductServiceBlockingStub cartDataProductStub) {
        this.productServiceStub = productServiceStub;
        this.recentlyViewServiceStub = recentlyViewServiceStub;
        this.cartDataProductStub = cartDataProductStub;
    }

    @Override
    public CustomDataResponse dashBoardRequest(DashboardRequestDto dashboardRequest) {
        RecentlyViewResponse recentlyViewResponse = recentlyViewServiceStub.fetchRecentlyViewedHistory(Mapper.dashboardReqDtoToRecentlyViewReqProto(dashboardRequest));
        if (recentlyViewResponse.getProductIdsList().isEmpty()) {
            log.info("No recently view product for this userId: {}", dashboardRequest.getUserId());
        } else {
            log.info("List<productId> : {}", recentlyViewResponse.getProductIdsList());
        }
        DashboardResponse dashboardResponse = productServiceStub.fetchProductForDashboard(Mapper.recentlyViewResProtoToDashboardReqProto(recentlyViewResponse));
        //ViewCartProductResponse cartProductResponse = cartDataProductStub.fetchCartOfProduct(Mapper.stringToViewCartProductReqProto(dashboardRequest.getUserId()));
        CustomDataResponse response = com.in.mapper.DashboardResponse.dataResponseToDetails(dashboardRequest.getUserId(), dashboardResponse);
        return response;
    }
}
