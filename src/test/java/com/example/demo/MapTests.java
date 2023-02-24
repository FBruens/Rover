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
		map.createField(xCoordinate,yCoordinate);
		Assertions.assertThat(map.getMap()).isEqualTo(map2);
	}

	@Test
	void roverGetsSetOnMap() {
		Map map = new Map();
		String[][] map2 = new String[][]{
			{"R"," "," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "},
			{" "," "," "," "," "}
		};
		map.createField(5,5);
		map.setRover(0,0);
		Assertions.assertThat(map.getMap()).isEqualTo(map2);
	}
}
