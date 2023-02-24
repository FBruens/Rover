package com.example.demo;

public class Map {
    String[][] map;
    public void createField(int xCoordinate, int yCoordinate) {
        this.map = new String[xCoordinate][yCoordinate];
    }

    public String[][] getMap() {
        return this.map;
    }
}
