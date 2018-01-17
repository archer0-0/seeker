package com.arx.seeker.savior.helpers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arx.seeker.DAO.beans.company.Company;
import com.arx.seeker.DAO.beans.company.CompanyRepository;
import com.arx.seeker.savior.steps.Connector;

@Component
public class Searcher {
	@Autowired
	CompanyRepository companyRepository;

	/**
	 * Get all the Url of Services
	 * @param document
	 * @return
	 */
	public List<String> getWebsOfServices(Document document){
		List<String> response= new ArrayList<String>();
		Elements gemneralContainer=document.selectFirst("div#content").selectFirst("div.container").select("a[href]");
		for (Element element : gemneralContainer) {
			URL url = null;
			try {
				url = new URL(element.attr("abs:href"));
				response.add(url.getAuthority()+"/all");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		}
		
		return response;
	}
	/**
	 * Get all the web of categories
	 * Services > Categories
	 * @param document
	 * @return
	 */
	public List<String> getWebOfCategories(Document document){
		List<String> listOfServices= new ArrayList<>();
		Elements hrefOfServices= document.selectFirst("div.mod2Content").select("a[href]");
		for (Element element : hrefOfServices) {
			listOfServices.add(element.attr("abs:href"));
		}
		return listOfServices;
		
	}
	public List<String> getAllCompanies(String urlOfCategory) {
		boolean broken=false;
		String tempString=urlOfCategory;
		List<String > pagesOfListsOfCompanies= new ArrayList<>();
		List<String> pagesOfCompanies= new ArrayList<>();
		while (broken==false) {
			pagesOfListsOfCompanies.add(tempString);
			Document document=Connector.customConnect(tempString);
			if(document.select("href:contains(siguiente)").isEmpty()==false)
				tempString=document.select("a:contains(siguiente)").attr("href");
			else
				broken=true;
		}
		for (String string : pagesOfListsOfCompanies) {
			Document document=Connector.customConnect(string);
			Elements elements=document.selectFirst("div#listado").select("div.top").select("h3").select("a[href]");
			pagesOfCompanies.addAll(elements.eachAttr("abs:href"));
		}
		return pagesOfCompanies;
	}
	/**
	 * Create a Company model to save in DB
	 * @param document
	 */
	public void saveCompanyFromHtml(Document document){
		Company company= new Company();
		company.setAddress(document.select("div#infoOc").select("img").attr("alt"));
		company.setPhone(document.selectFirst("span.tlf").text());
		company.setWeb(document.selectFirst("span.www").text());
		company.setAddress(document.selectFirst("div#infoOc").select("i").text() );
		companyRepository.save(company);
	}

}
