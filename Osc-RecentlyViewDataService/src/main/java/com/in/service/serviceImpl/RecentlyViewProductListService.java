package com.in.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.dto.RecentlyViewProductDto;
import com.in.entity.RecentlyViewProductEntity;
import com.in.repository.RecentViewProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RecentlyViewProductListService {
    private static final Logger log = LoggerFactory.getLogger(RecentlyViewProductListService.class);

    private final ObjectMapper objectMap;
    private final RecentViewProductRepository recentViewProductRepository;

    public RecentlyViewProductListService(ObjectMapper objectMap, RecentViewProductRepository recentViewProductRepository) {
        this.objectMap = objectMap;
        this.recentViewProductRepository = recentViewProductRepository;

    }

    public void saveRecentViewProduct(RecentlyViewProductDto recentlyViewProduct) {
        try {
            String productJson = objectMap.writeValueAsString(recentlyViewProduct.getProductIdList());
            recentViewProductRepository.save(new RecentlyViewProductEntity(recentlyViewProduct.getUserId(), productJson));
            log.info("Recently view history saved in database");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
