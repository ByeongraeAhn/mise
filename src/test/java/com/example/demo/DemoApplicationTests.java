package com.example.demo;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Floors;
import com.example.demo.entity.Total;
import com.example.demo.repository.TotalRepository;
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
	TotalRepository totalRepository;

	@Test
	public void save() {
		// Given
		Floors floors = Floors.builder().floor("3층").sensor("미세먼지").build();

		// Total total = Total.builder().date(new Date()).build();
		Total total = new Total();
		total.setDate(new Date());
		total.addFloors(floors);

		Total newTotal = totalRepository.save(total);

		// Then

	}

	@Test
	public void crud() throws JsonProcessingException {
		// Given

		// When
		// Optional<Total> total = totalRepository.findById(1l);
		List<Total> total = totalRepository.findAll();

		System.out.println("================================================");
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(total));
		System.out.println(total.get(0).getFloor().get(0).getFloor());

		// Then

	}

}
