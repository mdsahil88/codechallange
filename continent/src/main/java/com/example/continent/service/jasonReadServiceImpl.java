package com.example.continent.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.continent.model.Continent;
import com.example.continent.model.Country;

//import org.json.simple.JSONArray;
/**
 * @author sahil.md
 *
 */
public class jasonReadServiceImpl implements JsonReaderService {

	private static Map<String, Set<Country>> m = new HashMap<>();
	private final Logger logger = LoggerFactory.getLogger(jasonReadServiceImpl.class);

	@SuppressWarnings("unchecked")
	public void parseJason() {

		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("src/main/resources/continents.json")) {
			logger.info("Read JSON file from continents.json");
			Object obj = jsonParser.parse(reader);
			logger.info("JSON parser object to parse read file");
			JSONArray continetList = (JSONArray) obj;
			logger.info("***continentList Object***");
			System.out.println(continetList);
			logger.info("Iterate over continetList array");
			continetList.forEach(con -> parseContinentObject((JSONObject) con));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void parseContinentObject(JSONObject con) {

		String continentObject = (String) con.get("continent");
//		logger.info("Read Continent object from JSONObject");
		Continent continent = new Continent();
		continent.setContinentName(continentObject);

		JSONArray countriestObject = (JSONArray) con.get("countries");
//		logger.info("Read countries object from JSONArray");
		Set<Country> setOfCountry = new HashSet<Country>();
		Iterator itr = countriestObject.iterator();
		while (itr.hasNext()) {
			Country country = new Country();
			JSONObject e1 = (JSONObject) itr.next();
			country.setFlag((String) e1.get("flag"));
			country.setName((String) e1.get("name"));
			setOfCountry.add(country);

		}
		continent.setSetOfCountries(setOfCountry);
//		System.out.println("**"+continent.getSetOfCountries());
		m.put((String) continent.getContinentName(), continent.getSetOfCountries());
	}

	public Map<String, Set<Country>> continentMapObject() {
		logger.info("***Return Map Object from jasonReadSimple class***");
		return m;
	}

}
