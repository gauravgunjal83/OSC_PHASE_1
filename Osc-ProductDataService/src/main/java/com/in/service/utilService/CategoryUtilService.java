package com.in.service.utilService;

import com.in.avro.CategoryDetails;
import com.in.avro.ProductViewCount;
import com.in.dto.CategoryDataRequestDto;
import com.in.mapper.Mapper;
import org.apache.kafka.streams.processor.internals.assignment.StreamsAssignmentProtocolVersions;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryUtilService {
    private static final Logger log = LoggerFactory.getLogger(CategoryUtilService.class);

    private final ReadOnlyKeyValueStore<String, CategoryDetails> categoryDetailsStore;
    private final ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore;

    public CategoryUtilService(ReadOnlyKeyValueStore<String, CategoryDetails> categoryDetailsStore, ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore) {
        this.categoryDetailsStore = categoryDetailsStore;
        this.productViewCountStore = productViewCountStore;
    }

    public List<CategoryDataRequestDto> getTopCategories(int count) {
        KeyValueIterator<String, CategoryDetails> iterator = categoryDetailsStore.all();
        Map<String, Long> categoryCountMap = new HashMap<>();
        List<CategoryDataRequestDto> categoryCountList = new ArrayList<>();

        while (iterator.hasNext()) {
            var categoryEntry = iterator.next();
            String categoryId = categoryEntry.key;

            KeyValueIterator<String, ProductViewCount> productCountIterator = productViewCountStore.all();
            long categoryTotalCount = 0;

            while (productCountIterator.hasNext()) {
                var productCountEntry = productCountIterator.next();
                String productId = productCountEntry.key;
                ProductViewCount productViewCount = productCountEntry.value;

                if (productViewCount.getCategoryId().equals(categoryId)) {
                    productViewCount = productViewCountStore.get(productId);
                    if (productViewCount != null) {
                        categoryTotalCount += productViewCount.getCount();
                    }
                }
            }
            categoryCountMap.merge(categoryId, categoryTotalCount, Long::sum);
        }

        categoryCountList = categoryCountMap.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).
                limit(count).map(entry -> {
                    String categoryId = entry.getKey();
                    CategoryDetails categoryDetails = categoryDetailsStore.get(categoryId);
                    return Mapper.categoryDetailsAvroToCategoryReqDto(categoryId, categoryDetails);
                }).filter(Objects::nonNull).collect(Collectors.toList());
        return categoryCountList;
    }
}
