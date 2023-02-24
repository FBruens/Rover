package com.example.demo;

public class Map {
    String[][] map;

    public void createField(int xCoordinate, int yCoordinate) {
        this.map = new String[xCoordinate][yCoordinate];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = " ";
            }
        }
    }

    public String[][] getMap() {
        return this.map;
    }

    public void setRover(int x, int y) {
        map[x][y] = "S";
    }

    public void setRover(int x, int y, char direction) {
        if (direction == 'N' || direction == 'E' || direction == 'S' || direction == 'W') {
            map[x][y] = String.valueOf(direction);
        } else map[x][y] = "S";
    }
}
