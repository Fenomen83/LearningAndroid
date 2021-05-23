package com.definex.learningandroid.models;

public class SliderModel {
    private int id;
    private String title;
    private String description;
    private String imageName;

    public SliderModel(int id, String title, String description, String imageName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}