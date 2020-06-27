package ru.job4j.lsp.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Food {
    private String Name;
    private Date expiredDate;
    private Date createDate;
    private Double price;
    private int discount;

    public Food() {
    }

    public Food(String name, Date expiredDate, Date createDate, Double price, int discount) {
        Name = name;
        this.expiredDate = expiredDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return discount == food.discount &&
                Objects.equals(Name, food.Name) &&
                Objects.equals(expiredDate, food.expiredDate) &&
                Objects.equals(createDate, food.createDate) &&
                Objects.equals(price, food.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, expiredDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "Food{" +
                "Name='" + Name + '\'' +
                ", expiredDate=" + expiredDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }

}
