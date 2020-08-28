package com.excilys.formation.apirestcdb.restcontroller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.formation.apirestcdb.model.Computer;
import com.excilys.formation.apirestcdb.persistence.ComputerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/rest")
public class ComputerRESTController {
	
	@Autowired
	ComputerRepository computerRepository;

	@GetMapping("/computers")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Computer> getComputers(){
		return computerRepository.findAll();
		
	}
	@GetMapping("/computers/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<Computer> getOneComputer(@PathVariable long id){
		return ResponseEntity.of(computerRepository.findById(id));
		
	}
	
	@PostMapping("/computers")
	@ResponseStatus(HttpStatus.CREATED)
	public Computer addComputer(@RequestBody Computer computer) {
		return computerRepository.save(computer);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteComputer(@PathVariable UUID id) {
		Computer computer = new Computer();
		computer.setId(id);
		computerRepository.delete(computer);
	}
	
	
	
}
