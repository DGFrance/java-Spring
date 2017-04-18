package com.SpringTraining;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesTest {
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeesController()).build();
	}

	@Test
	public void getEmployee() throws Exception {
		this.mockMvc.perform(get("/employees?gender=male"))
				.andExpect(content().json("[{\"name\":\"Leo\",\"gender\":\"Male\"}]"));
	}

	@Test
	public void getEmployee2() throws Exception {
		this.mockMvc.perform(
				post("/employees2").content("{\"name\":\"Jac\",\"gender\":\"Female\"}").contentType("application/json"))
				.andExpect(status().isOk());
	}
	@Test
	public void getEmployee3() throws Exception {
		this.mockMvc.perform(get("/employees3/1"))
				.andExpect(content().json("{"
						+ "\"name\":\"Leo\",\"gender\":\"Male\"}"));
	}
}