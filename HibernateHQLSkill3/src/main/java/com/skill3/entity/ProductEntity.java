package com.skill3.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private double price;
    private int quantity;
    private String description;

    public ProductEntity() {}

    public ProductEntity(String productName, double price, int quantity, String description) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getDescription() { return description; }

    public void setProductId(int productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setDescription(String description) { this.description = description; }
}
