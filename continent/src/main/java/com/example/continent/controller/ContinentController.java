package com.example.continent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.continent.model.Country;
import com.example.continent.service.ContinentService;
import com.example.continent.service.jasonReadServiceImpl;

/**
 * @author sahil.md
 *
 */
@RestController
public class ContinentController {

	@Autowired
	private ContinentService demoService;
	private Map<String, Set<Country>> map= new HashMap<String, Set<Country>>();
	private String continent_Name;
	private final Logger logger = LoggerFactory.getLogger(jasonReadServiceImpl.class);


	@RequestMapping("api/continents")
	public Set<String> listOfContinent() {
		logger.info("***continentList() method calling***");
		
		return map.keySet();

	}

	@RequestMapping(value = "api/continents/{continentName}")
	public List<String> listOfCountry(@PathVariable("continentName") String continentName) {
		logger.info("++++++++++++++++++++++++++++++++++++++");
		this.continent_Name=continentName;
		logger.info("My countinent name  "+continentName);
		List<String> listOfCountry = new ArrayList<String>();
		Set<Country> setOfCountry = map.get(continentName);
		logger.info("ssssssssssssssssss  "+setOfCountry);
		for (Country country : setOfCountry) {
			logger.info(country.getName());
			listOfCountry.add(country.getName());

		}
		return listOfCountry;
	}

	@RequestMapping(value = "api/continents/{continentName}/{countryName}")
	public String countryFlag(@PathVariable("countryName") String countryName) {
		String flagName = null;
	for (Entry<String, Set<Country>> entry : map.entrySet()) {
		Set<Country> set = entry.getValue();
		for (Country country : set) {
			if (country.getName().equalsIgnoreCase(countryName)) {
				flagName = country.getFlag();
			}
		}
		}
		return flagName;

	}

	public void continentList() {
		map = demoService.continentService();
		logger.info("***Assining Map object of controller class from service class***");
	}

}
