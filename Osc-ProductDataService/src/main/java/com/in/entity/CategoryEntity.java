package com.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @Column(name = "categoryid")
    private String categoryId;

    @Column(name = "categoryname")
    private String categoryName;

    @Column(name = "imagepath")
    private String imagePath;



}
