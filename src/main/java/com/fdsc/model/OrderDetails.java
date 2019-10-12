package com.fdsc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderDetails {
    //private String rfidf;
    private String name;//名称
    private String orderNumber;//匹数
    private String color;//颜色
    private BigDecimal riceNumber;//米数
    private Timestamp orderTime;//订单日期
    private Timestamp shippingDate;//出厂日期
    private String factroy;//加工厂

    public String getFactroy() {
        return factroy;
    }

    public void setFactroy(String factroy) {
        this.factroy = factroy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getRiceNumber() {
        return riceNumber;
    }

    public void setRiceNumber(BigDecimal riceNumber) {
        this.riceNumber = riceNumber;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Timestamp shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}