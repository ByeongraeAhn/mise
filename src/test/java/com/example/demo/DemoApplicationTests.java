package com.example.demo;

import java.util.List;

import com.example.demo.entity.Floor;
import com.example.demo.entity.Sensor;
import com.example.demo.repository.FloorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
// @DataJpaTest
public class DemoApplicationTests {

	@Autowired
	FloorRepository floorRepository;

	@Test
	public void save() {
		// Given
		Sensor sensor = Sensor.builder().name("사무실L").build();

		Floor floor = Floor.builder().build();

		// 양방향 링크
		floor.addSensor(sensor);

		// When
		Floor newTotal = floorRepository.save(floor);

		// Then

	}

	@Test
	public void read() throws JsonProcessingException {
		// Given

		// When
		// Optional<Total> total = totalRepository.findById(1l);
		List<Floor> total = floorRepository.findAll();

		System.out.println("================================================");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(total));
		System.out.println(total.get(0).getSensors().get(0).getName());

		// Then

	}

}
