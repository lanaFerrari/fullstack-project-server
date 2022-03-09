package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private double price;
    private String duration;
    private String summary;

    public Course(String name, String location, Number number, String duration, String summary) {
        this.name = name;
        this.location = location;
        this.price = (double) number;
        this.duration = duration;
        this.summary = summary;
    }

    public Course(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
