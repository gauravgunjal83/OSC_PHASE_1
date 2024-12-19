package com.in.service.serviceImpl;

import com.in.avro.RecentViewProduct;
import com.in.dto.RecentlyViewRequestDto;
import com.in.kafka.producer.RecentlyViewProductKafkaProducer;
import com.in.mapper.Mapper;
import com.in.service.UpdateRecentlyViewProductService;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateRecentlyViewProductImpl implements UpdateRecentlyViewProductService {

    private static final Logger log = LoggerFactory.getLogger(UpdateRecentlyViewProductImpl.class);

    private final ReadOnlyKeyValueStore<String, RecentViewProduct> recentViewProductStore;
    private final RecentlyViewProductKafkaProducer recentlyViewProducer;

    public UpdateRecentlyViewProductImpl(ReadOnlyKeyValueStore<String, RecentViewProduct> recentViewProductStore, @Qualifier("recentlyViewProductProducer") RecentlyViewProductKafkaProducer recentlyViewProducer) {
        this.recentViewProductStore = recentViewProductStore;
        this.recentlyViewProducer = recentlyViewProducer;
    }

    @Override
    public boolean updateRecentlyViewProducts(RecentlyViewRequestDto requestDto) {
        RecentViewProduct recentViewProduct = recentViewProductStore.get(requestDto.getUserId());
        List<CharSequence> listProductIds;
        if (recentViewProduct != null) {
            listProductIds = new ArrayList<>(recentViewProduct.getProductIds());
        } else {
            log.info("No view product found for userId: {}", requestDto.getUserId());
            listProductIds = new ArrayList<>();
        }
        listProductIds.removeIf(productId -> productId.toString().trim().equals(requestDto.getProductId()));
        listProductIds.add(0, requestDto.getProductId());

        if (listProductIds.size() > 6) {
            listProductIds = listProductIds.subList(0, 6);
        }
        log.info("product IDs after update: {}", listProductIds);
        RecentViewProduct updatedViewProduct = Mapper.stringToRecentViewProductAvro(listProductIds);
        recentlyViewProducer.publishToRecentlyViewProductTopic(requestDto.getUserId(), updatedViewProduct);
        return true;
    }
}
