package com.daroca.models;
import jakarta.persistence.*;


@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double unitPrice;
    @OneToMany
    @JoinColumn(name = "products_category_id", foreignKey = @ForeignKey(name = "FK_ProductsCategory"))
    private ProductCategory productCategory;

    public Product(Integer productId, String name, Double unitPrice){
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
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

    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean equals(Product other) {
        return this.productId.equals(other.getProductId()) && this.name.equals(other.getName());
    }

    public String toString(){
        return "Product[ productId = " + this.productId + ", name = " + this.name + " ]";
    }
}
