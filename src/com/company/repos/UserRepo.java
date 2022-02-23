package com.company.repos;

import com.company.data.DBinterface.DataBaseInterface;
import com.company.entities.user;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class UserRepo implements userInterface {
    private final DataBaseInterface db;

    public UserRepo(DataBaseInterface db) {
        this.db = db;
    }
    @Override
    public boolean createUser(user user) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "INSERT INTO users(name,password) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());

            statement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public user getUser(int id) {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "SELECT name, id, password FROM users WHERE id=?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user user = new user(rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("id"));

                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<user> getAllUsers() {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM users";
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<user> users = new LinkedList<>();
            while (rs.next()) {
                user user = new user(rs.getString("name"),
                        rs.getString("password"),
                        rs.getInt("id"));

                users.add(user);
            }

            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
