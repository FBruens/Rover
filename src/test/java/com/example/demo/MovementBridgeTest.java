package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MovementBridgeTest {

    @Test
    void ValidateMovementOrdersTest(){
        MovementBridge movementBridge = new MovementBridge();
        assertEquals("fflff",movementBridge.validateMovementOrders("fAf@lff"));

    }

    @Test
    void ProcessMovementOrdersTest(){
        MovementBridge movementBridge = new MovementBridge();
        assertEquals('f', movementBridge.processMovementOrders("fflff")[0]);
        assertEquals('l', movementBridge.processMovementOrders("fflff")[2]);

    }
}
