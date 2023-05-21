package org.example.entity;


public class ItemEntity {
    private Long id;
    private String name;
    private String price;
    private String color;
    private String brand;
    private String category;

    public ItemEntity(Long id, String name, String price, String color,  String brand, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.category = category;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", brand=" + brand +
                ", category=" + category +
                '}';
    }
}
