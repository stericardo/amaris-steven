package com.amaris.steven.test.response;

import com.amaris.steven.test.entity.Prices;

import java.time.LocalDateTime;

public final class PricesResponse {

    private int brandId;
    private int productId;
    private double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double totalPrice;

    private PricesResponse(){}

    public PricesResponse(Prices prices){
        setBrandId(prices.getBrandId());
        setProductId(prices.getProductId());
        setPrice(prices.getPrice());
        setStartDate(prices.getStartDate());
        setEndDate(prices.getEndDate());
    }

    public int getBrandId() {
        return brandId;
    }

    private void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getProductId() {
        return productId;
    }

    private void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    private void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    private void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
