package org.example.entity;


public class ItemEntity {
    private Long id;

    private String name;

    private Double price;

    private String color;
    private String registrationDate;
    private String brand;
    private String category;

    public ItemEntity() {
    }

    public ItemEntity(Long id, String name, Double price, String color, String registrationDate, String brand, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.registrationDate = registrationDate;
        this.brand = brand;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", registrationDate=" + registrationDate +
                ", brand=" + brand +
                ", category=" + category +
                '}';
    }
}
