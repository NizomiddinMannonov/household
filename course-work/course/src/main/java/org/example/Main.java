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
        System.out.println(" ");
        System.out.println( "HouseHold equipment warehouse"+ " v" + 0.1 + " (" + "5/19/2023" + ")");
        System.out.println("Developer: " + "Nizomiddin" + " (" + "nizom20001975@gmail.com" + ")");
        System.out.println(" ");

        while (runnig) {
            try {


                Scanner scanner = new Scanner(System.in);

                System.out.println("Available commands (menu):");

                System.out.println("""
                            1. GET ALL PRODUCT
                              2. SEARCH
                               0. EXIT
                        
                        """);
                int command = scanner.nextInt();


                if (command == 1) {
                    List<ItemEntity> brands = service.getAll();
                    brands.forEach(Service::getFormatEntity);
                }

                if (command == 2) {
                    boolean bool = true;
                    while (bool) {
                        System.out.println("""
                                .......................
                                      SEARCH PART
                                ========================
                                  __________________
                                | 1. Search by brand |
                                  _____________________
                                | 2. Search by Category |
                                
                                      | 0. EXIT |
                                """);
                        int searchCommand = scanner.nextInt();

                        if (searchCommand == 1) {
                            scanner = new Scanner(System.in);
                            System.out.println("""
                                     
                                    | Enter Brand name |
                                     
                                            """
                                    );
                            String text = scanner.nextLine();
                            List<ItemEntity> search = service.searchBrand(text);
                            if (search.size()==0){
                                System.err.println("No such brand exist");
                            }
                            search.forEach(Service::getFormatEntity);
                        }
                        if (searchCommand == 2) {
                            scanner = new Scanner(System.in);
                            System.out.println("Enter category name");
                            String text = scanner.nextLine();
                            List<ItemEntity> search = service.searchCategory(text);
                            if (search.size() == 0){
                                System.err.println("No such category exist");
                            }
                            search.forEach(Service::getFormatEntity);
                        }

                        if (searchCommand == 0) {
                            bool = false;
                        }
                    }
                }
                if (command == 0) {
                    runnig = false;
                }
            } catch (Exception e) {
                System.err.println("Please Enter The Right Command");
            }
        }


    }
}


