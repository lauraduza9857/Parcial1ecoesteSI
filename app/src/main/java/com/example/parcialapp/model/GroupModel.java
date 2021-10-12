package com.example.parcialapp.model;

public class GroupModel {
    private String name;
    private int amount;
    private int x;
    private int y;
    private int[] colors;

    public GroupModel(String name, int amount, int x, int y, int[] colors) {
        this.name = name;
        this.amount = amount;
        this.x = x;
        this.y = y;
        this.colors = colors;
    }


    public GroupModel() { }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int[] getColors() {

        return colors;
    }

    public void setColors(int[] colors) {

        this.colors = colors;
    }
    public String getNombre() {

        return name;
    }

    public void setNombre(String names) {

        this.name = names;
    }

    public int getamount() {

        return amount;
    }

    public void setamount(int amount) {

        this.amount = amount;
    }

}
