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
        map.generateMap(xCoordinate, yCoordinate);
        //Anzahl an Reihen Identisch?
        Assertions.assertThat(map.getVisualizedMap().length).isEqualTo(map2.length);
        for (int row = 0; row < map2.length; row++) {
            //Anzahl an Spalten Identisch?
            Assertions.assertThat(map.getVisualizedMap()[row].length).isEqualTo(map2[row].length);
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
        map.generateMap(5, 5);
        map.setRover(0, 0);
        Assertions.assertThat(map.getVisualizedMap()).isEqualTo(map2);
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
        map.generateMap(5, 5);
        map.setRover(2, 2);
        Assertions.assertThat(map.getVisualizedMap()).isEqualTo(map2);
    }

    @ParameterizedTest
    @CsvSource({"'N'", "'E'", "'S'", "'W'"})
    void roverGetsSetOnMapWithIndicationOfDirection(char direction) {
        Map map = new Map();
        String[][] map2 = new String[][]{
                {String.valueOf(direction), " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        map.generateMap(5, 5);
        map.setRover(0, 0, direction);
        Assertions.assertThat(map.getVisualizedMap()).isEqualTo(map2);
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
        map.generateMap(5, 5);
        map.setRover(0, 0, 'A');
        Assertions.assertThat(map.getVisualizedMap()).isEqualTo(map2);
    }

    @Test
    void IfPitchIsBelow15PercentVisualizedMapContainingSpaces() {

        Map map = new Map();
        map.generateMap(5, 5);
        map.setRover(0, 0, 'S');

        int[][] controllHeightMap = new int[][]{
                {50, 50, 50, 50, 50},
                {50, 50, 50, 50, 50},
                {50, 50, 50, 50, 50},
                {50, 50, 50, 50, 50},
                {50, 50, 50, 50, 50},
        };
        String[][] controlVisualizedMap = new String[][]{
                {"S", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };
        Assertions.assertThat(map.getVisualizedMap()).isEqualTo(controlVisualizedMap);
    }

}
