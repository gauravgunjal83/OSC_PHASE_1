package com.in.service.serviceImpl;

import com.in.avro.RecentViewProduct;
import com.in.service.RecentlyViewProductService;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecentlyViewServiceImpl implements RecentlyViewProductService {
    private static final Logger log = LoggerFactory.getLogger(RecentlyViewServiceImpl.class);
    private final ReadOnlyKeyValueStore<String, RecentViewProduct> recentViewProductStore;

    public RecentlyViewServiceImpl(ReadOnlyKeyValueStore<String, RecentViewProduct> recentViewProductStore) {
        this.recentViewProductStore = recentViewProductStore;
    }

    @Override
    public List<String> getRecentlyViewProducts(String userId) {
        RecentViewProduct recentViewProduct = recentViewProductStore.get(userId);
        if (recentViewProduct == null || !recentViewProduct.getProductIds().iterator().hasNext()) {
            log.info("userId: {} has no products in viewing history", userId);
            return new ArrayList<>();
        } else {
            List<String> productIds = new ArrayList<>();
            for (CharSequence productId : recentViewProduct.getProductIds()) {
                productIds.add(String.valueOf(productId));
            }
            log.info("userId: {} list of recently viewed products: {}", userId, productIds);
            return productIds;
        }

    }
}
