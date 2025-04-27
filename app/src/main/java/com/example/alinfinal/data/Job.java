package com.example.alinfinal.data;

public class Job {
    private String title;
    private String location;

    public Job(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
