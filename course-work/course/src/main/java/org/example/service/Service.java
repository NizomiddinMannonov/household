package org.example.service;

import org.example.data.Data;
import org.example.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class Service {

    private final Data data;

    public Service() {
        data = new Data();
    }


    public List<ItemEntity> add(ItemEntity item) {

        List<ItemEntity> items = data.getItem();

        ArrayList<ItemEntity> itemEntities = new ArrayList<>(items);
        itemEntities.add(item);

        data.writeBrandData(itemEntities);

        return data.getItem();

    }

    public List<ItemEntity> getAll() {

        return data.getItem();
    }

    public List<ItemEntity> search(String searchingText) {

        List<ItemEntity> items = data.getItem();
        List<ItemEntity> result = new ArrayList<>();

        for (ItemEntity item : items) {
            if (item.getBrand().contains(searchingText)
                    || item.getCategory().contains(searchingText)
                    || item.getName().contains(searchingText)) {
                result.add(item);
            }
        }
        return result;
    }
    public List<ItemEntity> searchBrand(String searchingText) {

        List<ItemEntity> items = data.getItem();
        List<ItemEntity> result = new ArrayList<>();

        for (ItemEntity item : items) {
            if (item.getBrand().toUpperCase().contains(searchingText.toUpperCase())
                    || item.getBrand().contains(searchingText)) {
                result.add(item);
            }
        }
        return result;
    }
    public List<ItemEntity> searchCategory(String searchingText) {

        List<ItemEntity> itemCategories = data.getItem();
        List<ItemEntity> result = new ArrayList<>();

        for (ItemEntity item : itemCategories) {
            if (item.getCategory().toUpperCase().contains(searchingText.toUpperCase())
                    || item.getCategory().contains(searchingText)) {
                result.add(item);
            }
        }
        return result;
    }


    public List<String> getBrands() {
        List<ItemEntity> itemEntities = getAll();
        return itemEntities.stream().map(ItemEntity::getBrand).collect(Collectors.toList());
    }

    public List<String> getCategories() {
        List<ItemEntity> itemEntities = getAll();
        return itemEntities.stream().map(ItemEntity::getCategory).collect(Collectors.toList());
    }

    public static void getFormatEntity(ItemEntity item) {
        String result =
                "Id : " + item.getId() + " | " +
                        "Name = " + item.getName() + " | " +
                        "Price = " + item.getPrice() + " | " +
                        "Color = " + item.getColor() + " | " +
                        "Brand = " + item.getBrand() + " | " +
                        "Category = " + item.getCategory() + " | ";
        System.out.println(result);
    }
}





