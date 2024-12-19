package com.in.repository;

import com.in.entity.ProductViewCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCountRepository extends JpaRepository<ProductViewCountEntity, String> {
}
