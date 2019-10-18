package com.company.monthConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.*;
import org.junit.runner.RunWith;
import org.junit.Before;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner)
@WebMvcTest(MonthConverterApplication.class)
public class MonthConverterApplicationTests {
	//Wiring in the MockMvc object
	@Autowired
	private MockMvc mockMvc;
	//ObjectMapper used to convert Java objects to JSON and vice versa
	private ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void setUp() {

		@Test
		public void shouldReturnNameOfMonth() {
			// ARRANGE
			//convert Java Object to Json
			String outputJson = mapper.writeValueAsString(month);

			// ACT
			mockMvc.perform(get("/month/{monthNumber}"))                 //perform get request
					.andDo(print())                               //print results to console
					.andExpect(status().isOk())                     //ASSERT(status code
					.andExpect(content().json(outputJson));       //ASSERT output is asserted


		}


	}
}
