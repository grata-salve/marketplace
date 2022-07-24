package com.example.marketplace.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Buyer")
public class User {
    @Id
    @NotNull(message = "No such user exists")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be 2-100 characters long")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be 2-100 symbols length")
    @Column(name = "second_name")
    private String secondName;

    @NotNull
    //@Min(value = 0, message = "Amount of money should be more than zero")
    @Column(name = "amount_of_money")
    private float amountOfMoney;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    public User() {

    }

    public User(String firstName, String secondName, float amountOfMoney) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.amountOfMoney = amountOfMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Float.compare(user.amountOfMoney, amountOfMoney) == 0 && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(products, user.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, amountOfMoney, products);
    }
}
