package com.example.rrcbooking.Model;

public class Gokart {

    private int gokartID;
    private String reperation;


    public Gokart() {
    }

    public Gokart(int gokartID, String reperation) {
        this.gokartID = gokartID;
        this.reperation = reperation;
    }

    public int getGokartID() {
        return gokartID;
    }

    public void setGokartID(int gokartID) {
        this.gokartID = gokartID;
    }

    public String getReperation() {
        return reperation;
    }

    public void setReperation(String reperation) {
        this.reperation = reperation;
    }
}