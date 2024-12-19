package com.in.service.serviceImpl;

import com.in.avro.ProductDetails;
import com.in.avro.ProductViewCount;
import com.in.dto.FilterProductRequestDto;
import com.in.mapper.Mapper;
import com.in.service.FilterProductService;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FilterProductDetailsServiceImpl implements FilterProductService {
    private static final Logger log = LoggerFactory.getLogger(FilterProductDetailsServiceImpl.class);

    private final ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore;
    private final ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore;

    public FilterProductDetailsServiceImpl(ReadOnlyKeyValueStore<String, ProductDetails> productDetailsStore, ReadOnlyKeyValueStore<String, ProductViewCount> productViewCountStore) {
        this.productDetailsStore = productDetailsStore;
        this.productViewCountStore = productViewCountStore;
    }

    @Override
    public List<FilterProductRequestDto> filterProducts(String categoryId, String filterType) {
        List<FilterProductRequestDto> filterProduct = new ArrayList<>();
        KeyValueIterator<String, ProductDetails> iterator = productDetailsStore.all();
        iterator.forEachRemaining(entry -> {
            String productId = entry.key;
            ProductDetails productDetails = entry.value;

            if (productDetails.getCategoryId().toString().equals(categoryId)) {
               FilterProductRequestDto productRequestDto = Mapper.productDetailsAvroToFilterProductReqDto(productId,productDetails);
               filterProduct.add(productRequestDto);
            }
        });

        switch (filterType.trim()) {
            case "P":
                filterProduct.sort((p1, p2) -> {
                    long viewCount1 = productViewCountStore.get(p1.getProductId()) != null ?  productViewCountStore.get(p1.getProductId()).getCount() : 0;
                    long viewCount2 = productViewCountStore.get(p2.getProductId()) != null ? productViewCountStore.get(p2.getProductId()).getCount() : 0;
                    return Long.compare(viewCount2, viewCount1);
                });
                break;

            case "LH":
                filterProduct.sort(Comparator.comparingDouble(FilterProductRequestDto::getProdMarketPrice));
                log.info("list LH of filter product: {} ",filterProduct);
                break;

            case "HL":
                filterProduct.sort((p1, p2) -> Double.compare(p2.getProdMarketPrice(), p1.getProdMarketPrice()));
                break;

            case "NF":
                filterProduct.sort(Comparator.comparing(FilterProductRequestDto::getDateOfProduct).reversed());
                break;

            default:
                log.warn("Invalid Filter type: {}", filterType);
                break;
        }
        return filterProduct;
    }
}
