package com.arx.seeker.DAO.beans.company;

import static org.junit.Assert.fail;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CompanyRepositoryTest {
	
	@Autowired
	private CompanyRepository companyRepository;
	

	

	@Test
	public void insert() {
		Company company= new Company();
		company.setAddress("addres");
		company.setArea("area");
		company.setEmail("email");
		company.setName("name");
		company.setPhone("phone");
		company.setWeb("web");
		companyRepository.insert(company);
		assertEquals(1, companyRepository.count());
	}

}
