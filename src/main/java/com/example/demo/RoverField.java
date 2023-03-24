package com.example.demo;

public class RoverField {
    String visualizedField;
    int height;

    RoverField(int height){
        this.visualizedField = " ";
        this.height = height;
    }

    public String getVisualizedField() {
        return visualizedField;
    }
}
