package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapTests {

    @ParameterizedTest
    @CsvSource(
            {"1,1",
                    "2,2",
                    "5,5",
                    "80,30",
                    "5,50",
                    "10,20"
            }
    )
    void mapGetsInitialized(int xCoordinate, int yCoordinate) {
        Map map = new Map();
        String[][] map2 = new String[xCoordinate][yCoordinate];
        map.createField(xCoordinate, yCoordinate);
        //Anzahl an Reihen Identisch?
        Assertions.assertThat(map.getMap().length).isEqualTo(map2.length);
        for (int row = 0; row < map2.length; row++) {
            //Anzahl an Spalten Identisch?
            Assertions.assertThat(map.getMap()[row].length).isEqualTo(map2[row].length);
        }
    }

    @Test
    void roverGetsSetOnMap() {
        Map map = new Map();
        String[][] map2 = new String[][]{
                {"S", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        map.createField(5, 5);
        map.setRover(0, 0);
        Assertions.assertThat(map.getMap()).isEqualTo(map2);
    }
    @Test
    void roverGetsSetOnMapInTheMiddle() {
        Map map = new Map();
        String[][] map2 = new String[][]{
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", "S", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        map.createField(5, 5);
        map.setRover(2, 2);
        Assertions.assertThat(map.getMap()).isEqualTo(map2);
    }

    @ParameterizedTest
    @CsvSource({"'N'","'E'","'S'","'W'"})
    void roverGetsSetOnMapWithIndicationOfDirection(char direction) {
        Map map = new Map();
        String[][] map2 = new String[][]{
                {String.valueOf(direction), " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        map.createField(5, 5);
        map.setRover(0, 0, direction);
        Assertions.assertThat(map.getMap()).isEqualTo(map2);
    }

}
