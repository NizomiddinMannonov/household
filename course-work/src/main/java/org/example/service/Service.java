package org.example.service;

import org.example.data.Data;
import org.example.entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public boolean edit(Long id, ItemEntity editedItem) {

        ItemEntity item = getById(id);

        if (Objects.isNull(item)) {
            return false;
        }

        if (Objects.nonNull(editedItem.getName()) && !"".equals(editedItem.getName())) {
            item.setName(editedItem.getName());

        }
        if (Objects.nonNull(editedItem.getPrice())) {
            item.setPrice(editedItem.getPrice());

        }
        if (Objects.nonNull(editedItem.getColor()) && !"".equals(editedItem.getColor())) {
            item.setColor(editedItem.getColor());

        }
        if (Objects.nonNull(editedItem.getRegistrationDate()) && !"".equals(editedItem.getRegistrationDate())) {
            item.setRegistrationDate(editedItem.getRegistrationDate());

        }
        if (Objects.nonNull(editedItem.getBrand()) && !"".equals(editedItem.getBrand())) {
            item.setBrand(editedItem.getBrand());

        }
        if (Objects.nonNull(editedItem.getCategory()) && !"".equals(editedItem.getCategory())) {
            item.setCategory(editedItem.getCategory());

        }

        List<ItemEntity> itemEntities = getAll();

        List<ItemEntity> collect = itemEntities
                .stream()
                .filter(i -> !Objects.equals(i.getId(), id))
                .collect(Collectors.toList());
        collect.add(item);

        data.writeBrandData(collect);

        return true;
    }

    public ItemEntity getById(Long id) {
        return data.getItem(id);
    }

    public boolean remove(Long id) {
        List<ItemEntity> brandList = data.getItem();

        ItemEntity removedBrand = getById(id);

        if (Objects.isNull(removedBrand)) {
            return false;
        }

        List<ItemEntity> collect = brandList.stream().filter(item -> !Objects.equals(item.getId(), id)).collect(Collectors.toList());

        data.writeBrandData(collect);

        return true;
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
                        "Name : " + item.getName() + " | " +
                        "Price : " + item.getPrice() + " | " +
                        "Color : " + item.getColor() + " | " +
                        "Registration Date : " + item.getRegistrationDate() + " | " +
                        "Brand : " + item.getBrand() + " | " +
                        "Category : " + item.getCategory() + " | ";
        System.out.println(result);
    }
}





