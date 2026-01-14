package com.project.ecommerce.dto;

public class ProductListDTO {
    private int id;
    private String productName;
    private double price;
    private String image;

    public ProductListDTO() {
    }

    public ProductListDTO(String productName, double price, String image) {
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
