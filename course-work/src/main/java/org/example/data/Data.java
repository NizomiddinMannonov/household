package org.example.data;


import org.example.entity.ItemEntity;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data {

    private final static String DATA_FILE_DATA_PATH = "src/main/resources/data.csv";

    public List<ItemEntity> getItem() {
        List<String[]> data = getData(DATA_FILE_DATA_PATH);
        return data.stream().map(this::convert).toList();

    }

    public ItemEntity getItem(Long id) {
        List<String[]> data = getData(DATA_FILE_DATA_PATH);
        return data
                .stream()
                .map(this::convert)
                .filter(item -> Objects.equals(id, item.getId()))
                .findAny()
                .orElse(null);
    }


    public void writeBrandData(List<ItemEntity> items) {

        List<String[]> brandData = new ArrayList<>();

        for (ItemEntity item : items) {
            String[] fields = getFields(item);
            brandData.add(fields);
        }

        writeData(DATA_FILE_DATA_PATH, brandData);
    }

    private List<String[]> getData(String path) {

        List<String[]> rows = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] row = line.split(splitBy);

            rows.add(row);
        }
        return rows;

    }

    private void writeData(String filePath, List<String[]> dataLines) {
        FileWriter csvFile = null;
        try {
            csvFile = new FileWriter(filePath);

            try (PrintWriter pw = new PrintWriter(csvFile)) {
                dataLines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    private ItemEntity convert(String[] fields) {
        String id = fields[0];
        String name = fields[1];
        String price = fields[2];
        String color = fields[3];
        String registrationDate = fields[4];
        String brand = fields[5];
        String category = fields[6];

        return new ItemEntity(
                Long.valueOf(id),
                name,
                Double.valueOf(price),
                color,
                registrationDate,
                brand,
                category
        );

    }

    private String[] getFields(ItemEntity item) {

        Field[] fields = item.getClass().getDeclaredFields();
        String[] fieldValues = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                Object fieldValue = field.get(item);
                fieldValues[i] = fieldValue.toString();
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return fieldValues;
    }

}
