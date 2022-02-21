package com.company.repos;

import com.company.user;

import java.util.List;

public interface userInterface {
    boolean createUser(user user);
    user getUser(int id);
    List<user> getAllUsers();

}
