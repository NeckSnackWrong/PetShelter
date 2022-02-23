package com.company;

import com.company.controllers.UserControl;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.in;

public class PetShelterApplication {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1593578246";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/petshelterDB";

    private final UserControl controller;
    public PetShelterApplication(UserControl controller) {
        this.controller = controller;
        Scanner scanner = new Scanner(in);
    }


    public static void start() throws SQLException {
        Scanner scanner = new Scanner(in);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        while (true) {
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1.Get donate list");
            System.out.println("2.Get shelters list");
            System.out.println("3.Add new donator");
            System.out.println("4.Get shelters by location");
            System.out.println("5.Get shelters by id");
            System.out.println("0.Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-4):");
                int option = scanner.nextInt();
                if (option == 1) {
                Statement statement = connection.createStatement();
                String SQL_SELECT_USERS = "SELECT t.*\n" +
                        "                     FROM public.\"user\" t\n" +
                        "                     LIMIT 501";
                ResultSet rs = statement.executeQuery(SQL_SELECT_USERS);
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getString("surname") + " " +
                            "The sum of donates: " + rs.getString("donateSum") + "$");
                }

                } else if (option == 2) {
                    Statement statement = connection.createStatement();
                    String SQL_SELECT_USERS = "SELECT t.*\n" +
                            "                     FROM public.\"shelters\" t\n" +
                            "                     LIMIT 501";
                    ResultSet rs = statement.executeQuery(SQL_SELECT_USERS);
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("location"));
                    }

                } else if (option == 3) {
                    String SQL_CREATE_USER = "INSERT INTO public.\"user\" (name, surname, id, \"donateSum\") VALUES (? , ?, DEFAULT, ?)";
                    PreparedStatement prepareStatement = connection.prepareStatement(SQL_CREATE_USER);

                    System.out.println("Please, enter name:");
                    String name = scanner.next();
                    prepareStatement.setString(1, name);
                    System.out.println("Please, enter surname:");
                    String surname = scanner.next();
                    prepareStatement.setString(2, surname);
                    System.out.println("Please, enter the sum of donates:");
                    int sum = scanner.nextInt();
                    prepareStatement.setInt(3, sum);

                    prepareStatement.executeUpdate();
                } else if (option == 4) {

                    System.out.println("Please, pick a city:");
                    System.out.println("1.Almaty \n" +
                            "2.Nur-Sultan \n" +
                            "3.Karaganda");
                    int city = scanner.nextInt();
                    if (city == 1) {
                        Statement statement = connection.createStatement();
                        String SQL_PICK_SHELTER = "SELECT * FROM public.\"shelters\" WHERE location = 'Almaty' ";
                        ResultSet rs = statement.executeQuery(SQL_PICK_SHELTER);
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));
                        }
                    } else if (city == 2) {
                        Statement statement = connection.createStatement();
                        String SQL_PICK_SHELTER = "SELECT * FROM public.\"shelters\" WHERE location = 'Nur-Sultan' ";
                        ResultSet rs = statement.executeQuery(SQL_PICK_SHELTER);
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));
                        }
                    }
                    if (city == 3) {
                        Statement statement = connection.createStatement();
                        String SQL_PICK_SHELTER = "SELECT * FROM public.\"shelters\" WHERE location = 'Karaganda' ";
                        ResultSet rs = statement.executeQuery(SQL_PICK_SHELTER);
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));
                        }
                    }
                }
                else if (option == 5) {
                        String SQL_SELECT_SH_ID = "SELECT * FROM public.\"shelters\" WHERE id = ?;";
                        PreparedStatement prepareStatement = connection.prepareStatement(SQL_SELECT_SH_ID);

                        System.out.println("Please, enter id of the shelter:");
                        int id = scanner.nextInt();
                        prepareStatement.setInt(1, id);

                        ResultSet rs = prepareStatement.executeQuery();
                        while(rs.next()) {
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));
                        }
                    }

                 else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public void getAllUsersMenu(){
//        String response = controller.getAllUsers();
//        System.out.println(response);
//    }
//    public void createNewUserMenu() {
////        Scanner scanner = new Scanner(System.in);
////        System.out.println("Please enter name");
////        String name = scanner.next();
////        System.out.println("Please enter surname");
////        String password = scanner.next();
////        int id = scanner.nextInt();
////
////        String response = controller.createUser(name, password, id);
////        System.out.println(response);
//    }
}
