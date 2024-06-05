package com.daroca.models;

import jakarta.persistence.*;

@Entity
@Table
public class SalesOrderItem {

    @EmbeddedId
    private SalesOrderItemKey salesOrderItemId;

    @ManyToOne
    @MapsId("salesOrderId")
    @JoinColumn(name = "sales_order_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_SalesOrder"))
    private SalesOrder salesOrder;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductId", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_Product"))
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    public SalesOrderItem(){
        // default constructor
    }

    public SalesOrderItem(SalesOrder salesOrder, Product product, Integer quantity){
        this.salesOrder = salesOrder;
        this.product = product;
        this.quantity = quantity;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
