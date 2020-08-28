package com.excilys.formation.apirestcdb;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.excilys.formation.apirestcdb.model.Company;
import com.excilys.formation.apirestcdb.persistence.ComputerRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ComputerRestControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ComputerRepository computerRepository;
	
	
	@Test
	@WithMockUser(roles="ADMIN")
	public void getCompaniesAdminGet() throws Exception {
		mockMvc.perform(get("/api/rest/companies").contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isFound());
	}
	
	@Test
	@WithMockUser(roles="USER")
	public void getCompaniesUserGet() throws Exception {
		mockMvc.perform(get("/api/rest/companies").contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isForbidden());
	}
	
	@Test
	@WithMockUser(roles="USER")
	public void getCompaniesUserPost() throws Exception {
		mockMvc.perform(post("/api/rest/companies").contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isForbidden());
	}
	
	
	
	
	
	
	/*@Test
	public void delete() throws Exception{
		long countBefore = computerRepository.count();
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/api/rest/{id}", "3c905c29-3a02-46c9-bd63-46e062eaf3a2");
		
		MockHttpServletResponse response = mockMvc.perform(builder)
				.andExpect(status().isOk())
				.andReturn()
				.getResponse();
		
		long countAfter = computerRepository.count();
		
		assertThat(countBefore).isNotEqualTo(countAfter);
	} 
	*/
	
	
}