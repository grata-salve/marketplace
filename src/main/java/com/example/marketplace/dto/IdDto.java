package com.example.marketplace.dto;

import javax.validation.constraints.NotNull;

public class IdDto {
    @NotNull
    private int userId;
    @NotNull
    private int productID;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
