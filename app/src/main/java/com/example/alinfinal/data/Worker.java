package com.example.alinfinal.data;

public class Worker {
    private String id;
    private String name;
    private int age;
    private String location;

    public Worker(String id, String name, int age, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getWorkerDetails() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nLocation: " + location;
    }
}

