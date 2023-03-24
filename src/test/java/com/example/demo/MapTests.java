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
        Assertions.assertThat(map.getRoverFieldMap().length).isEqualTo(map2.length);
        for (int row = 0; row < map2.length; row++) {
            //Anzahl an Spalten Identisch?
            Assertions.assertThat(map.getRoverFieldMap()[row].length).isEqualTo(map2[row].length);
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
        Assertions.assertThat(map.getRoverFieldMap()).isEqualTo(map2);
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
        Assertions.assertThat(map.getRoverFieldMap()).isEqualTo(map2);
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
        Assertions.assertThat(map.getRoverFieldMap()).isEqualTo(map2);
    }

@Test
    void roverGetsSetOnMapWithIndicationOfDirectionWhichIsNotAllowed() {
        Map map = new Map();
        String[][] map2 = new String[][]{
                {"S", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        map.createField(5, 5);
        map.setRover(0, 0, 'A');
        Assertions.assertThat(map.getRoverFieldMap()).isEqualTo(map2);
    }
    @Test
    void roverCanMoveFieldIfPitchIsBelow15Percent() {
        Rover rover = new Rover();

        Map map = new Map();
        map.createField(5, 5);
        map.setRover(0, 0, 'S');

        int[][] controllHeightMap = new int[][]{
                {50, 50, 50, 50, 50},
                {50, 60, 60, 60, 50},
                {50, 60, 70, 60, 50},
                {50, 60, 60, 60, 50},
                {50, 50, 50, 50, 50}
        };
        String[][] controllPositionMap = new String[][]{
                {" ", " ", " ", " ", " "},
                {"S", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        rover.move('f');
        Assertions.assertThat(map.getRoverFieldMap()).isEqualTo(controllPositionMap);
    }

}
