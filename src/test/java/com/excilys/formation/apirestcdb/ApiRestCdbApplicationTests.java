package com.excilys.formation.apirestcdb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;
import static java.util.Arrays.asList;

import static org.assertj.core.api.Assertions.assertThat;


import com.excilys.formation.apirestcdb.model.Company;
import com.excilys.formation.apirestcdb.persistence.CompanyRepository;
import com.excilys.formation.apirestcdb.persistence.ComputerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureMockMvc
class ApiRestCdbApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	ObjectMapper obj;
	
	@Autowired
	private ComputerRepository computerRepository;

	
	
	/*@AfterEach
	void tearDown() {
		companyRepository.deleteAll();
	}*/

	@Test
	public void findAll() throws Exception {
		
		Company company = new Company();
		company.setName("test");
		companyRepository.save(company);
		
		MockHttpServletRequestBuilder builder = get("/api/rest/companies").contentType(APPLICATION_JSON);
		
		MockHttpServletResponse response = mockMvc.perform(builder)
			.andExpect(status().isOk())
			.andReturn()
			.getResponse();
		
		List<Company> companies = asList(obj.readValue(response.getContentAsString(), Company[].class));
		assertThat(companies).contains(company);
		

	}
	@Test
	public void findById() throws Exception {
		Company companyTest = new Company();
		companyTest.setName("test");
		companyRepository.save(companyTest);
		System.out.println("\n----ALL COMPANIES ----" + companyRepository.findAll());
		
		MockHttpServletRequestBuilder builder = get("/api/rest/3").contentType(APPLICATION_JSON);
		
		MockHttpServletResponse response = mockMvc.perform(builder)
				.andExpect(status().isOk())
				.andReturn()
				.getResponse();
		
		Company company = obj.readValue(response.getContentAsString(), Company.class);
		assertThat(company).equals(companyTest);
		
		
	}
	
	
	
	
	
}
