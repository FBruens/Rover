package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MovementBridge {

    Rover rover = new Rover(0,0,50,"N");


    public String validateMovementOrders(String movementOrders){

        return movementOrders;
    }

    public char[] processMovementOrders(String movementOrders){

        //List<String> processedMovementOrders = new ArrayList<>();

        return movementOrders.toCharArray();

    }
}
