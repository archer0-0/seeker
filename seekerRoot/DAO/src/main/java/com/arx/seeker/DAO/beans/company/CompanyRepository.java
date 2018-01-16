package com.arx.seeker.DAO.beans.company;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, Long> {
	Company findByEmail(String email);
	List<Company> findByArea(String area);
	

}
