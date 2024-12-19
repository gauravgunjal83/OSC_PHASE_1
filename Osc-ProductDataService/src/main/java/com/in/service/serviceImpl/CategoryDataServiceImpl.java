package com.in.service.serviceImpl;

import com.in.dto.CategoryDataRequestDto;
import com.in.entity.CategoryEntity;
import com.in.repository.CategoryRepository;
import com.in.service.CategoryDataService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

//publish data from db to topic
@Service
public class CategoryDataServiceImpl implements CategoryDataService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryDataServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDataRequestDto> getAllCategory() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream().map(category -> mapper.map(category,CategoryDataRequestDto.class)).toList();
    }
}
