package com.company.entities;

public class pets {
    private String vid;
    private String name;
    private int id;

    public pets(String name, String password, int id) {
        this.name = name;
        this.id = id;
        this.vid= vid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String password) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}