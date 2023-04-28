package com.example.demo;

public class Map {
    MapField[][] mapFields;
    Rover rover;
    String[][] visualizedMap = null;

    public void generateMap(int xCoordinate, int yCoordinate) {
        this.mapFields = new MapField[xCoordinate][yCoordinate];
        for (int row = 0; row < mapFields.length; row++) {
            for (int col = 0; col < mapFields[row].length; col++) {
                mapFields[row][col] = new MapField(50);
            }
        }
    }

    public String[][] getVisualizedMap() {
        this.visualizedMap = new String[mapFields.length][mapFields[0].length];
        for (int row = 0; row < mapFields.length; row++) {
            for (int col = 0; col < mapFields[row].length; col++) {
                visualizedMap[row][col] = mapFields[row][col].getVisualizedField(this.rover.height);
            }
        }
        return this.visualizedMap;
    }

    public void setRover(int x, int y) {
        mapFields[x][y].visualizedField = "S";
        rover = new Rover(x, y, mapFields[x][y].height);
        mapFields[x][y].roverOnField = true;
    }

    public void setRover(int x, int y, char direction) {
        if (direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W') {
            mapFields[x][y].visualizedField = String.valueOf(direction);
        } else mapFields[x][y].visualizedField = "S";
        mapFields[x][y].roverOnField = true;
        rover = new Rover(x, y, mapFields[x][y].height);
    }
}
