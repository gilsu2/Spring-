package com.dw.jdbcapp.model;

public class Product {
    private int productNum;
    private String productName;
    private String packagingUnit;
    private double price;
    private int stock;

    public Product() {
    }

    public Product(int productNum, String productName, String packagingUnit, double price, int stock) {
        this.productNum = productNum;
        this.productName = productName;
        this.packagingUnit = packagingUnit;
        this.price = price;
        this.stock = stock;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPackagingUnit() {
        return packagingUnit;
    }

    public void setPackagingUnit(String packagingUnit) {
        this.packagingUnit = packagingUnit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNum=" + productNum +
                ", productName='" + productName + '\'' +
                ", packagingUnit='" + packagingUnit + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
