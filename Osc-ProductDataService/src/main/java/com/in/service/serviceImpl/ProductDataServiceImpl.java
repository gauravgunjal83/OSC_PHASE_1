package com.in.service.serviceImpl;

import com.in.dto.ProductDataRequestDto;
import com.in.entity.ProductEntity;
import com.in.repository.ProductRepository;
import com.in.service.ProductDataService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Produce data from db to topic
@Service
public class ProductDataServiceImpl implements ProductDataService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductDataServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDataRequestDto> getAllProducts() {
        List<ProductEntity> productEntity = productRepository.findAll();
        return productEntity.stream().map(p -> mapper.map(p, ProductDataRequestDto.class)).collect(Collectors.toList());
    }
}
