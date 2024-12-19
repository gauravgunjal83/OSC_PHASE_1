package com.in.service.utilService;

import com.in.avro.ProductViewCount;
import com.in.dto.ProductViewCountDto;
import com.in.entity.ProductViewCountEntity;
import com.in.repository.ProductCountRepository;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@EnableScheduling
@Component
public class ProductViewCountService {

    private final ReadOnlyKeyValueStore<String, ProductViewCount> productCountStore;
    private final ProductCountRepository productCountRepository;
    private final ModelMapper mapper;

    public ProductViewCountService(ReadOnlyKeyValueStore<String, ProductViewCount> productCountStore, ProductCountRepository productCountRepository, ModelMapper mapper) {
        this.productCountStore = productCountStore;
        this.productCountRepository = productCountRepository;
        this.mapper = mapper;
    }

    public List<ProductViewCountDto> getAllProduct() {
        List<ProductViewCountEntity> product = productCountRepository.findAll();
        return product.stream().map(prod -> mapper.map(prod, ProductViewCountDto.class)).collect(Collectors.toList());
    }

    @Scheduled(fixedRate = 60000)
    public void saveProductViewCountToDatabase() {
        Map<String, ProductViewCountEntity> batchMap = new HashMap<>();
        productCountStore.all().forEachRemaining(entry -> {
            String productId = entry.key;
            ProductViewCount productViewCount = entry.value;
            batchMap.merge(productId, new ProductViewCountEntity(productId, productViewCount.getCount(),
                    productViewCount.getCategoryId().toString()), (existing, newEntry) -> {
                existing.setCount(existing.getCount() + newEntry.getCount());
                return existing;
            });
        });
        if (!batchMap.isEmpty()) {
            try {
                productCountRepository.saveAll(batchMap.values());
            } catch (Exception e) {
                System.err.println("Error in saving product view count to database: " + e.getMessage());
            }
        }
    }
}
