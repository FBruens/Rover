package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoverTest {


@Test
    void createRoverTest(){

    Rover rover = new Rover(0,0,'S');

    // x value of the Rover
    assertEquals(0,rover.getX());
    // y value of the Rover
    assertEquals(0,rover.getY());
    // directionValue of the Rover
    assertEquals('S',rover.getDirection());
}
@Test
    void moveRoverTest(){
    Rover rover = new Rover(0,0,'S');
    rover.moveRover("f");
    assertEquals(-1,rover.getY());
}
@Test
    void turnRoverTest(){
    Rover rover = new Rover(0,0,'S');
    rover.turnRover("r");
    assertEquals('W',rover.getDirection());
}

}