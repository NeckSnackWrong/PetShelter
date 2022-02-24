package com.company.entities;

public class Pets {
    private String name;
    private String vid;
    private int id;
    private int Shelterid;

    public Pets(String name, String vid, int id, int Shelterid) {
        this.name = name;
        this.id = id;
        this.Shelterid = Shelterid;
        this.vid = vid;
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

    public int getShelterid() {
        return Shelterid;
    }

    public void setShelterid(int shelterid) {
        Shelterid = shelterid;
    }
}

