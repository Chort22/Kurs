package com.example.kurshact;

public class Tovar {
    private int id;
    private String name;
    private int price;

    public Tovar(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}