package com.daroca.models;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SalesOrderId;
    @Column(nullable = false)
    private LocalDateTime orderDate;
    @Column(nullable = false)
    private LocalDate estimatedDeliveryDate;
    @Column(nullable = false, length = 30)
    private String status;
    @Column(nullable = false)
    private Double total;

    public SalesOrder() {

    }

    public SalesOrder(Integer SalesOrderId, LocalDateTime orderDate, LocalDate estimatedDeliveryDate, String status, Double total){
        this.SalesOrderId = SalesOrderId;
        this.orderDate = orderDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.status = status;
        this.total = total;
    }

    public Integer getSalesOrderId() {
        return SalesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        SalesOrderId = salesOrderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean equals(SalesOrder other) {
        return this.SalesOrderId.equals(other.getSalesOrderId());
    }

    public String toString(){
        return "SalesOrder[ SalesOrderId =" + SalesOrderId + ", orderDate = " + orderDate + ", estimatedDeliveryDate = " + estimatedDeliveryDate +
               ", status = " + status + ", total = " + total + "]";
    }
}
