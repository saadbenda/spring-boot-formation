package com.excilys.formation.apirestcdb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.excilys.formation.apirestcdb.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

	
	
}
