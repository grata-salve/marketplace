package com.example.marketplace.dto;

import com.example.marketplace.models.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDTO {

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be 2 to 100 characters long")
    private String name;

    @NotNull
    @Min(value = 0, message = "Price should be more than zero")
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
