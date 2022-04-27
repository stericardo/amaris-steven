package com.amaris.steven.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PRICES")
public class Prices {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="BRAND_ID")
    private int brandId;

    @Column(name="START_DATE")
    private LocalDateTime startDate;

    @Column(name="END_DATE")
    private LocalDateTime endDate;

    @Column(name="PRICE_LIST")
    private int priceList;

    @Column(name="PRODUCT_ID")
    private int productId;

    @Column(name="PRIORITY")
    private int priority;

    @Column(name="PRICE")
    private double price;

    @Column(name="CURR")
    private String curr ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prices prices = (Prices) o;
        return brandId == prices.brandId && priceList == prices.priceList && productId == prices.productId && priority == prices.priority && Double.compare(prices.price, price) == 0 && id.equals(prices.id) && startDate.equals(prices.startDate) && endDate.equals(prices.endDate) && curr.equals(prices.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, startDate, endDate, priceList, productId, priority, price, curr);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
