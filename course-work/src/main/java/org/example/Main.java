package org.example;

import org.example.entity.ItemEntity;
import org.example.service.Service;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Long id = 1L;

    public static void main(String[] args) {
        Service service = new Service();
        boolean runnig = true;
        System.out.println("Project");
        while (runnig) {
            try {


                Scanner scanner = new Scanner(System.in);

                System.out.println("""
                        1. ADD ITEM
                        2. EDIT ITEM
                        3. GET ALL ITEM
                        4. REMOVE ITEM
                        5. SEARCH
                        0. EXIT
                        """);
                int command = scanner.nextInt();

                if (command == 1) {
                    scanner = new Scanner(System.in);

                    System.out.println("Enter name item");
                    String name = scanner.nextLine();

                    System.out.println("Enter price item only number");
                    Double price = scanner.nextDouble();


                    scanner = new Scanner(System.in);

                    System.out.println("Enter color item");
                    String color = scanner.nextLine();

                    System.out.println("Enter registrationDate item");
                    String registrationDate = scanner.nextLine();

                    System.out.println("Enter brand item");
                    String brand = scanner.nextLine();

                    System.out.println("Enter category item");
                    String category = scanner.nextLine();

                    service.add(new ItemEntity(
                            id++,
                            name,
                            price,
                            color,
                            registrationDate,
                            brand,
                            category
                    ));
                    System.out.println("Success");
                }

                if (command == 2) {
                    List<ItemEntity> brands = service.getAll();
                    brands.forEach(System.out::println);
                    System.out.println("Enter id editing item");

                    scanner = new Scanner(System.in);
                    Long id = scanner.nextLong();

                    scanner = new Scanner(System.in);

                    System.out.println("Enter new name item");
                    String name = scanner.nextLine();

                    System.out.println("Enter new price item");
                    Double price = scanner.nextDouble();

                    scanner = new Scanner(System.in);

                    System.out.println("Enter new color item");
                    String color = scanner.nextLine();

                    System.out.println("Enter new registrationDate item");
                    String registrationDate = scanner.nextLine();

                    System.out.println("Enter new brand item");
                    String brand = scanner.nextLine();

                    System.out.println("Enter new category item");
                    String category = scanner.nextLine();

                    service.edit(
                            id,
                            new ItemEntity(
                                    id,
                                    name,
                                    price,
                                    color,
                                    registrationDate,
                                    brand,
                                    category
                            ));
                    System.out.println("Success");
                }

                if (command == 3) {
                    List<ItemEntity> brands = service.getAll();
                    brands.forEach(Service::getFormatEntity);
                }
                if (command == 4) {
                    scanner = new Scanner(System.in);
                    System.out.println("Please enter you deleting item Id");
                    Long id = scanner.nextLong();

                    service.remove(id);
                    System.out.println("Success");
                }
                if (command == 5) {
                    List<String> brands = service.getBrands();
                    System.out.println(" -------- Example brands ---------");
                    brands.forEach(System.out::println);

                    List<String> categories = service.getCategories();
                    System.out.println(" ----- Example Categories -------");
                    categories.forEach(System.out::println);

                    System.out.println(" ---------- Enter searching text --------------");

                    scanner = new Scanner(System.in);
                    String text = scanner.nextLine();

                    List<ItemEntity> search = service.search(text);
                    search.forEach(System.out::println);


                }
                if (command == 0) {
                    runnig = false;
                }
            } catch (Exception e) {
                System.err.println("ERROR");
            }
        }


    }
}


