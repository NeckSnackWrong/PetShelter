package com.company;

import com.company.controllers.UserControl;
import com.company.data.DBinterface.DataBaseInterface;
import com.company.data.PGSQLDB;
import com.company.repos.UserRepo;

public class Main {

    public static void main(String[] args) throws Exception {
        DataBaseInterface db = new PGSQLDB();
        UserRepo repo = new UserRepo(db);
        UserControl controller = new UserControl(repo);
        PetShelterApplication app = new PetShelterApplication(controller);
        app.start();
    }


}