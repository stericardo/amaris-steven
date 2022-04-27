package com.amaris.steven.test.request;

import com.amaris.steven.test.exception.BrandConstraint;
import com.amaris.steven.test.exception.ProductConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PricesRequest {

    @NotBlank(message = "Start Date is mandatory")
    private String startDate;

    @NotBlank(message = "End date is mandatory")
    private String endDate;

    @NotNull(message = "Brand is mandatory")
    @BrandConstraint
    private int brand;

    @NotNull(message = "Product is mandatory")
    @ProductConstraint
    private int product;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }
}
