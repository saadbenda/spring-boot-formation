package com.excilys.formation.apirestcdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.excilys.formation.apirestcdb.model.Company;
import com.excilys.formation.apirestcdb.persistence.CompanyRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ApiRestCdbApplication {
	@Autowired
	CompanyRepository companyRepository;	

	public static void main(String[] args) {
		SpringApplication.run(ApiRestCdbApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return(args)->{
			Company company = new Company();
			company.setName("company");
			companyRepository.save(company);
			System.out.println("\n--------" + companyRepository.findAll());
			
		};
		
	}

}
