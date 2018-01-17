package com.arx.seeker.savior.steps;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arx.seeker.DAO.beans.company.CompanyRepository;
import com.arx.seeker.savior.helpers.Searcher;

@Component
public class Starter {
	private String firtURl="https://www.vulka.es/home.php";

	@Autowired
	Searcher searcher;
	@Autowired
	CompanyRepository repository;
	private List<String> webOfServices= new ArrayList<>();
	private List<String> webOfCategories= new ArrayList<>();
	
	public void start(){
		Document document= Connector.customConnect(firtURl);
		webOfServices=searcher.getWebsOfServices(document);
		for (String string : webOfServices) {
			Document serviceDocument= Connector.customConnect(string);
			webOfCategories.addAll(searcher.getWebOfCategories(serviceDocument));
		}
		for (String string : webOfCategories) {
			List<String> listOfCompanyPages=searcher.getAllCompanies(string);
			for (String string2 : listOfCompanyPages) {
				Document companyDocument=Connector.customConnect(string2);
				searcher.saveCompanyFromHtml(companyDocument);
			}
		}
		System.out.println("Numero de entidades actuales en la base de datos: "+repository.count());
	}

}
