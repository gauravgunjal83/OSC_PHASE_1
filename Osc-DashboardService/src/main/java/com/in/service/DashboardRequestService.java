package com.in.service;

import com.in.dto.CustomDataResponse;
import com.in.dto.DashboardRequestDto;

public interface DashboardRequestService {

    CustomDataResponse dashBoardRequest(DashboardRequestDto dashboardRequest);
}
