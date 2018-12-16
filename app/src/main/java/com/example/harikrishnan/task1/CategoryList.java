package com.example.harikrishnan.task1;

public class CategoryList {
    private String name;

    int imageNo;
    public CategoryList() {
    }

    public CategoryList(String name, int imageNo) {
        this.name = name;
        this.imageNo = imageNo;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageNo() {
        return imageNo;
    }

    public void setImageNo(int imageNo) {
        this.imageNo = imageNo;
    }
}