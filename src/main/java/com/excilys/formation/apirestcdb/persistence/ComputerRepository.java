package com.excilys.formation.apirestcdb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excilys.formation.apirestcdb.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long>{

}
