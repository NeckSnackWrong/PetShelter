package com.company.data;

import com.company.data.DBinterface.DataBaseInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PGSQLDB implements DataBaseInterface {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/petshelterDB";
        try {
            // Here we load the driverâs class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "1593578246");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
