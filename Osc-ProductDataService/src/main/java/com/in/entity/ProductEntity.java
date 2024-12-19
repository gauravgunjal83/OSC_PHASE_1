package com.in.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "productid")
    private String productId;

    @Column(name = "productname")
    private String prodName;

    @Column(name = "productprice")
    private String prodMarketPrice;

    @Column(name = "productdescription", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "imagepath")
    private String imagePath;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryid")
    @JsonBackReference
    private CategoryEntity category;
}
