package com.project.xml.domain;

/**
 * Created by vladbulimac on 08/05/16.
 */
public class Food {

    private String name;
    private String species;
    private String amount;
    private String price;
    private String discount;
    private String total;

    public Food() {
    }

    public Food(String name, String price, String amount, String discount, String species) {
        this.name = name;
        this.species = species;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
