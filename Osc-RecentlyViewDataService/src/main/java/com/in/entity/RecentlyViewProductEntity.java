package com.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recently_view_history")
public class RecentlyViewProductEntity {
    @Id
    private String userId;

    @Column(columnDefinition = "TEXT")
    private String productIdList;

}
