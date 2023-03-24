package com.example.demo;

public class Map {
    String[][] roverFieldMap;
    String[][] heightMap;

    public void createField(int xCoordinate, int yCoordinate) {
        this.roverFieldMap = new String[xCoordinate][yCoordinate];
        for (int row = 0; row < roverFieldMap.length; row++) {
            for (int col = 0; col < roverFieldMap[row].length; col++) {
                roverFieldMap[row][col] = " ";
            }
        }
    }

    public String[][] getRoverFieldMap() {
        return this.roverFieldMap;
    }

    public void setRover(int x, int y) {
        roverFieldMap[x][y] = "S";
    }

    public void setRover(int x, int y, char direction) {
        if (direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W') {
            roverFieldMap[x][y] = String.valueOf(direction);
        } else roverFieldMap[x][y] = "S";
    }
}
