package com.company;

import com.company.controllers.UserControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PetShelterApplication {
//    private static final String DB_USERNAME = "postgres";
//    private static final String DB_PASSWORD = "1593578246";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/petshelterDB";

    private final UserControl controller;
    public PetShelterApplication(UserControl controller) {
        this.controller = controller;
    }


    public static void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
//        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        while (true) {
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1.Get all users");
            System.out.println("2.Get user by id");
            System.out.println("3.Create new user");
            System.out.println("4.Calculate the cost");
            System.out.println("0.Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-4):");
                int option = scanner.nextInt();
                if (option == 1) {


                } else if (option == 2) {

                } else if (option == 3) {
                    createNewUserMenu();
                } else if (option == 4) {

                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void getAllUsersMenu(){
        String response = controller.getAllUsers();
        System.out.println(response);
    }
        public static void createNewUserMenu() {

        }
}
