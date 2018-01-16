package com.arx.seeker.DAO.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arx.seeker.DAO.beans.company.CompanyRepository;
import com.arx.seeker.DAO.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;

}
