package com.example.demo;

public class MapField {
    String visualizedField;
    int height;
    boolean roverOnField;

    MapField(int height) {
        this.visualizedField = " ";
        this.height = height;
        this.roverOnField = false;
    }

    public String getVisualizedField(int roverHeight) {
        setVisualizedField(roverHeight);
        return visualizedField;
    }

    public void setVisualizedField(int roverHeight) {
        if (!roverOnField) {
            if (height - roverHeight > 15)
                visualizedField = "M";
            else if (height - roverHeight < -15)
                visualizedField = "V";
            else
                this.visualizedField = " ";
        }
    }
}
