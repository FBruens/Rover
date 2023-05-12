package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MapTests {

    @Mock
    private Map map;

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
        map.setRover(0,0);
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
    void ifPitchIsBelow15PercentVisualizedMapContainingSpaces() {
        Map map = new Map();
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

        map.generateMap(5, 5);
        map.setRover(0, 0, 'S');


        String[][] visualizedMap = map.getVisualizedMap();
        Assertions.assertThat(visualizedMap).isEqualTo(controlVisualizedMap);
    }
    @Test
    void ifPitchIsOver15PercentVisualizedMapContaining_M_ToVisualiseMountains() {
        Map map = new Map();
        int[][] controllHeightMap = new int[][]{
                {50, 100, 100, 100, 100},
                {100, 100, 100, 100, 100},
                {100, 100, 100, 100, 100},
                {100, 100, 100, 100, 100},
                {100, 100, 100, 100, 100},
        };

        String[][] controlVisualizedMap = new String[][]{
                {"S", "M", "M", "M", "M"},
                {"M", "M", "M", "M", "M"},
                {"M", "M", "M", "M", "M"},
                {"M", "M", "M", "M", "M"},
                {"M", "M", "M", "M", "M"}
        };
        map.generateMap(5, 5);

        for (int row = 0; row < map.mapFields.length; row++) {
            for (int col = 0; col < map.mapFields[row].length; col++) {
                if (row == 0 && col == 0) continue;
                else {
                    map.mapFields[row][col].height = 100;
                }
            }
        }

        map.setRover(0, 0, 'S');


        String[][] visualizedMap = map.getVisualizedMap();
        Assertions.assertThat(visualizedMap).isEqualTo(controlVisualizedMap);
    }
 @Test
    void ifPitchIsUnder15PercentVisualizedMapContaining_V_ToVisualiseCliffs() {
        Map map = new Map();
        int[][] controllHeightMap = new int[][]{
                {50, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        String[][] controlVisualizedMap = new String[][]{
                {"S", "V", "V", "V", "V"},
                {"V", "V", "V", "V", "V"},
                {"V", "V", "V", "V", "V"},
                {"V", "V", "V", "V", "V"},
                {"V", "V", "V", "V", "V"}
        };
        map.generateMap(5, 5);

        for (int row = 0; row < map.mapFields.length; row++) {
            for (int col = 0; col < map.mapFields[row].length; col++) {
                if (row == 0 && col == 0) continue;
                else {
                    map.mapFields[row][col].height = 0;
                }
            }
        }

        map.setRover(0, 0, 'S');


        String[][] visualizedMap = map.getVisualizedMap();
        Assertions.assertThat(visualizedMap).isEqualTo(controlVisualizedMap);
    }
    @Test
    void ifMapContainBothMinusAndPlus15DegreeHeighDifferencesShowThemOnVisualizedMap() {
        Map map = new Map();
        int[][] controllHeightMap = new int[][]{
                {50, 100, 100, 100, 100},
                {0, 50, 50, 50, 50},
                {0, 50, 50, 50, 50},
                {0, 50, 50, 50, 50},
                {0, 50, 50, 50, 50},
        };

        String[][] controlVisualizedMap = new String[][]{
                {"S", "M", "M", "M", "M"},
                {"V", " ", " ", " ", " "},
                {"V", " ", " ", " ", " "},
                {"V", " ", " ", " ", " "},
                {"V", " ", " ", " ", " "}
        };
        map.generateMap(5, 5);

        for (int row = 0; row < map.mapFields.length; row++) {
            for (int col = 0; col < map.mapFields[row].length; col++) {
                if (row == 0 && col == 0) continue;
                else if (row == 0){
                    map.mapFields[row][col].height = 100;
                } else if (col == 0){
                    map.mapFields[row][col].height = 0;
                }
            }
        }

        map.setRover(0, 0, 'S');


        String[][] visualizedMap = map.getVisualizedMap();
        Assertions.assertThat(visualizedMap).isEqualTo(controlVisualizedMap);
    }

}
