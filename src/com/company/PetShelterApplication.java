package com.company;

import com.company.controllers.UserControl;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.in;

public class PetShelterApplication {// creation of class
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1593578246";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/petshelterDB";//data to connect to database

    private final UserControl controller;
    public PetShelterApplication(UserControl controller) {//creation of constructor for PetShelterApplication class
        this.controller = controller;
        Scanner scanner = new Scanner(in);
    }


    public static void start() throws SQLException {//throws exception to avoid errors
        Scanner scanner = new Scanner(in);//Creation of scanner for saving user's data
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);//connecting database
        while (true) {//Endless loop
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1.Get donate list");
            System.out.println("2.Get shelters list");
            System.out.println("3.Add new donator");
            System.out.println("4.Get shelters by location");
            System.out.println("5.Get shelters by id");
            System.out.println("6.Get pets list");
            System.out.println("7.Get pets by id");
            System.out.println("0.Exit");
            System.out.println();//Menu items
            try {//use of trycatch to avoid errors
                System.out.println("Enter option (1-4):");
                int option = scanner.nextInt();//Scanner for saving user's choices in menu
                if (option == 1) {//conditional operator for user's choice of 1st menu item
                Statement statement = connection.createStatement();//Using of Statement operator
                String SQL_SELECT_USERS = "SELECT t.*\n" +//declaring of line of sql code which would be sent to sql console
                        "                     FROM public.\"user\" t\n" +
                        "                     LIMIT 501";
                ResultSet rs = statement.executeQuery(SQL_SELECT_USERS);//Saving of results which would be sent to database
                while (rs.next()) {//loop which allows to send all data
                    System.out.println(rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getString("surname") + " " +
                            "The sum of donates: " + rs.getString("donateSum") + "$");//output to console of results of 1st action
                }

                } else if (option == 2) {//conditional operator for user's choice of 2nd menu item
                    Statement statement = connection.createStatement();//Using of Statement operator
                    String SQL_SELECT_USERS = "SELECT t.*\n" +//declaring of line of sql code which would be sent to sql console
                            "                     FROM public.\"shelters\" t\n" +
                            "                     LIMIT 501";//request to show all items of shelter table
                    ResultSet rs = statement.executeQuery(SQL_SELECT_USERS);//Saving of results which would be sent to database
                    while (rs.next()) {//loop which allows to send all data
                        System.out.println(rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("location"));//output to console of results of 2nd action
                    }

                } else if (option == 3) {//conditional operator for user's choice of 3rd menu item
                    String SQL_CREATE_USER = "INSERT INTO public.\"user\" (name, surname, id, \"donateSum\") VALUES (? , ?, DEFAULT, ?)";
                    PreparedStatement prepareStatement = connection.prepareStatement(SQL_CREATE_USER);//Usage of PreparedStatement operator

                    System.out.println("Please, enter name:");//output of request to input data
                    String name = scanner.next();//Saving via scanner of entered data
                    prepareStatement.setString(1, name);//substitution of saved data in preparestatement
                    System.out.println("Please, enter surname:");//output of request to input data
                    String surname = scanner.next();//Saving via scanner of entered data
                    prepareStatement.setString(2, surname);//substitution of saved data in preparestatement
                    System.out.println("Please, enter the sum of donates:");//output of request to input data
                    int sum = scanner.nextInt();//Saving via scanner of entered data
                    prepareStatement.setInt(3, sum);//substitution of saved data in preparestatement

                    prepareStatement.executeUpdate();//Execution of prepare statement
                } else if (option == 4) {//conditional operator for user's choice of 4th menu item

                    System.out.println("Please, pick a city:");
                    System.out.println("1.Almaty \n" +
                            "2.Nur-Sultan \n" +
                            "3.Karaganda");//Output of request to input city
                    int city = scanner.nextInt();//Saving of entered data
                    if (city == 1) { //whether user chose 1 execute following code
                        Statement statement = connection.createStatement();//Using of Statement operator
                        String SQL_PICK_SHELTER = "SELECT * FROM public.\"shelters\" WHERE location = 'Almaty' ";//declaring of line of sql code which would be sent to sql console
                        ResultSet rs = statement.executeQuery(SQL_PICK_SHELTER);//Saving of results which would be sent to database
                        while (rs.next()) {//loop which allows to send all data
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));//output to console of results
                        }
                    } else if (city == 2) {//whether user chose 2 execute following code
                        Statement statement = connection.createStatement();//Using of Statement operator
                        String SQL_PICK_SHELTER = "SELECT * FROM public.\"shelters\" WHERE location = 'Nur-Sultan' ";//declaring of line of sql code which would be sent to sql console
                        ResultSet rs = statement.executeQuery(SQL_PICK_SHELTER);//Saving of results which would be sent to database
                        while (rs.next()) {//loop which allows to send all data
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));//output to console of results
                        }
                    }
                    if (city == 3) {//whether user chose 3 execute following code
                        Statement statement = connection.createStatement();//Using of Statement operator
                        String SQL_PICK_SHELTER = "SELECT * FROM public.\"shelters\" WHERE location = 'Karaganda' ";//declaring of line of sql code which would be sent to sql console
                        ResultSet rs = statement.executeQuery(SQL_PICK_SHELTER);//Saving of results which would be sent to database
                        while (rs.next()) {//loop which allows to send all data
                            System.out.println(rs.getInt("id") + " " +
                                    rs.getString("name") + " " +
                                    rs.getString("location"));//output to console of results
                        }
                    }
                }
                else if (option == 5) {//conditional operator for user's choice of 5th menu item
                    String SQL_SELECT_SH_ID = "SELECT * FROM public.\"shelters\" WHERE id = ?;";
                    PreparedStatement prepareStatement = connection.prepareStatement(SQL_SELECT_SH_ID);//Usage of PreparedStatement operator

                    System.out.println("Please, enter id of the shelter:");//output of request to input data
                    int id = scanner.nextInt();//Saving via scanner of entered data
                    prepareStatement.setInt(1, id);//substitution of saved data in preparestatement

                    ResultSet rs = prepareStatement.executeQuery();//Saving of results which would be sent to database
                    while (rs.next()) {//loop which allows to send all data
                        System.out.println(rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("location"));//output to console of results
                    }
                }
               else if (option == 6) {//conditional operator for user's choice of 6th menu item
                    Statement statement = connection.createStatement();//Using of Statement operator
                    String SQL_SELECT_USERS = "SELECT t.*\n" +//declaring of line of sql code which would be sent to sql console
                            "                     FROM public.\"pets\" t\n" +
                            "                     LIMIT 501";
                    ResultSet rs = statement.executeQuery(SQL_SELECT_USERS);//Saving of results which would be sent to database
                    while (rs.next()) {//loop which allows to send all data
                        System.out.println(rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("vid") + " " +
                                "ShelterId: " + rs.getString("shelterID"));//output to console of results of 1st action
                    }
                    }
                else if (option == 7) {//conditional operator for user's choice of 7th menu item
                    String SQL_SELECT_SH_ID = "SELECT * FROM public.\"shelters\" WHERE id = ?;";
                    PreparedStatement prepareStatement = connection.prepareStatement(SQL_SELECT_SH_ID);//Usage of PreparedStatement operator

                    System.out.println("Please, enter id of the shelter:");//output of request to input data
                    int id = scanner.nextInt();//Saving via scanner of entered data
                    prepareStatement.setInt(1, id);//substitution of saved data in preparestatement

                    ResultSet rs = prepareStatement.executeQuery();//Saving of results which would be sent to database
                    while (rs.next()) {//loop which allows to send all data
                        System.out.println(rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("vid") + " " +
                                "ShelterId: " + rs.getString("shelterID"));//output to console of results of 1st action
                    }
                }

                 else {
                    break;
                }
            } catch (Exception e) {//catch exception
                System.out.println("ОЙ ЧТО-ТО ПОШЛО НЕ ТАК");//Error message
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
