package com.project.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vouchers")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "voucherCode")
    private String voucherCode;

    @Column(name = "discountPercent")
    private double discountPercentage;

    @Column(name = "expireDate")
    private LocalDateTime expireDate;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Voucher() {
    }

    public Voucher(String voucherCode, double discountPercentage, LocalDateTime expireDate, Order order) {
        this.voucherCode = voucherCode;
        this.discountPercentage = discountPercentage;
        this.expireDate = expireDate;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}