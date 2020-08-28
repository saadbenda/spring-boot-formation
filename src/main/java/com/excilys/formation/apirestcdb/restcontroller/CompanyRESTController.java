package com.excilys.formation.apirestcdb.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.formation.apirestcdb.model.Company;
import com.excilys.formation.apirestcdb.persistence.CompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/rest/")
public class CompanyRESTController {
	
	ObjectMapper obj = new ObjectMapper();
	
	@Autowired
	CompanyRepository companyRepository;
	
	@GetMapping("/coucou")
	public String get() {
		return "coucou";
	}
	
	@GetMapping("{id}")
	
	public ResponseEntity<Company> findById(@PathVariable long id){
		System.out.println("\n----ALL COMPANIES controller ----" + companyRepository.findAll());
		
		return ResponseEntity.of(companyRepository.findById(id));
	}
	
	@GetMapping("companies")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Company> getCompanies() {
		List<Company> listCompanies = companyRepository.findAll();
		return listCompanies;
		/*try {

			return ResponseEntity.ok(obj.writeValueAsString(listCompanies));
		} catch (JsonProcessingException jsonExc) {
			jsonExc.printStackTrace();

			return new ResponseEntity<String>("Cannot get companies", HttpStatus.BAD_REQUEST);
		}*/
	}
	
	@PutMapping("company")
	public ResponseEntity<String> edit(long id, String name) {
		Company company = companyRepository.getOne(id);
		if ( company != null) {
			company.setName(name);
			companyRepository.save(company);
			System.out.println("\n--------" + companyRepository.findAll());
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		System.out.println("\n--------" + companyRepository.findAll());
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("{/id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		Company company = companyRepository.getOne(id);
		if (company != null) {
			companyRepository.delete(company);
			companyRepository.save(company);
			System.out.println("\n--------" + companyRepository.findAll());
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}
		System.out.println("\n--------" + companyRepository.findAll());
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("company")
	public ResponseEntity<String> add(String name){
		Company company = new Company();
		company.setName(name);
		
		if (companyRepository.save(company) != null) {
			System.out.println("\n--------" + companyRepository.findAll());
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}
		System.out.println("\n--------" + companyRepository.findAll());
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	
	/*@PostMapping("companyV2")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Company> create (@RequestBody Company company) {
		if (company.getId() != 0 ) {
			return ResponseEntity.badRequest().build();
		}
		Company savedCompany = companyRepository.save(company);
		URI location = URI.create("api/rest/")
	}*/
	
}
