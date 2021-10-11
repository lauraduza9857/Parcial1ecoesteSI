package com.example.parcialapp.model;

public class GroupModel {
    private String name;
    private int amount;
    private int x;
    private int y;
    private int[] color;

    public GroupModel(String name, int amount, int x, int y, int[] color) {
        this.name = name;
        this.amount = amount;
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
