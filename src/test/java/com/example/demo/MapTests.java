package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapTests {

	@Test
	void mapGetsInitialized() {
		Map map = new Map();
		String[][] map2 = new String[5][5];
		map.createField(5,5);
		Assertions.assertThat(map.getMap()).isEqualTo(map2);
	}

}
