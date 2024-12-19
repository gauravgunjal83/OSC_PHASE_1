package com.in.repository;

import com.in.entity.RecentlyViewProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentViewProductRepository extends JpaRepository<RecentlyViewProductEntity, String> {
}
