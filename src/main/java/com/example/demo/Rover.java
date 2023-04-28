package com.example.demo;

public class Rover {

    private int x;
    private int y;
    private int height;
    private String  direction;

    //private char height;

    public Rover(int x, int y,int h, String direction) {
        this.x = x;
        this.y = y;
        this.height = h;
        this.direction = direction;
    }


    public Rover moveRover(String movement) {
        if (movement.equals("f")) {
            switch (direction) {
                case "S" -> setY(-1);
                case "N" -> setY(+1);
                case "E" -> setX(+1);
                case "W" -> setX(-1);
            }
        }
        if (movement.equals("b")) {
            switch (direction) {
                case "S" -> setY(+1);
                case "N" -> setY(-1);
                case "E" -> setX(-1);
                case "W" -> setX(+1);
            }
        }
        return this;
    }

    public void turnRover(String turnDirection) {
        if (turnDirection.equals("l")) {
            switch (direction) {
                case "N" -> setDirection("W");
                case "W" -> setDirection("S");
                case "S" -> setDirection("E");
                case "E" -> setDirection("N");
            }

        }
        if (turnDirection.equals("r")) {
            switch (direction) {
                case "N" -> setDirection("E");
                case "W" -> setDirection("N");
                case "S" -> setDirection("W");
                case "E" -> setDirection("S");
            }

        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y += y;
    }

    public String  getDirection() {
        return direction;
    }

    public void setDirection(String  direction) {
        this.direction = direction;
    }


}
