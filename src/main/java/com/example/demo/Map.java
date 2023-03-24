package com.example.demo;

public class Map {
    RoverField[][] roverFieldMap;
    String[][] visualizedMap = null;

    public void generateMap(int xCoordinate, int yCoordinate) {
        this.roverFieldMap = new RoverField[xCoordinate][yCoordinate];
        for (int row = 0; row < roverFieldMap.length; row++) {
            for (int col = 0; col < roverFieldMap[row].length; col++) {
                roverFieldMap[row][col] = new RoverField(50);
            }
        }
    }

    public String[][] getVisualizedMap() {
            this.visualizedMap = new String[roverFieldMap.length][roverFieldMap[0].length];
            for (int row = 0; row < roverFieldMap.length; row++) {
                for (int col = 0; col < roverFieldMap[row].length; col++) {
                    visualizedMap[row][col] = roverFieldMap[row][col].getVisualizedField();
                }
            }
        return this.visualizedMap;
    }

    public void setRover(int x, int y) {
        roverFieldMap[x][y].visualizedField = "S";
    }

    public void setRover(int x, int y, char direction) {
        if (direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W') {
            roverFieldMap[x][y].visualizedField = String.valueOf(direction);
        } else roverFieldMap[x][y].visualizedField = "S";
    }
}
