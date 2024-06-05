package com.daroca.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(length = 50)
    private String name;

    public ProductCategory(Integer productId, String name){
        this.productId = productId;
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(ProductCategory other) {
        return this.productId.equals(other.getProductId()) && this.name.equals(other.getName());
    }

    public String toString(){
        return "ProductCategory[ productId = " + this.productId + ", name = " + this.name + "]";
    }

}
