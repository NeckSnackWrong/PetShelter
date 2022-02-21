package com.company.controllers;

import com.company.repos.userInterface;
import com.company.user;

import java.util.List;

public class UserControl {
    private final userInterface repo;

    public UserControl(userInterface repo) {
        this.repo = repo;
    }
    public String createUser(String name, String password, int id) {
        user user = new user(name,password,id);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getUser(int id) {
        user user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<user> users = repo.getAllUsers();

        return users.toString();
    }
}
