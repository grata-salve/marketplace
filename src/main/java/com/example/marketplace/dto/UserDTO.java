package com.example.marketplace.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be 2-100 characters long")
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be 2-100 symbols length")
    private String secondName;

    @NotNull
    @Min(value = 0, message = "Amount of money should be more than zero")
    private float amountOfMoney;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
