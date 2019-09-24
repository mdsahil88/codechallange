package com.example.continent.service;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.continent.model.Country;

/**
 * @author sahil.md
 *
 */
@Service
public class ContinentServiceImpl implements ContinentService {

	private Map<String, Set<Country>> map;
	private jasonReadServiceImpl jasonReadSimple = new jasonReadServiceImpl();
	private  final Logger logger = LoggerFactory.getLogger(jasonReadServiceImpl.class);

	public Map<String, Set<Country>> continentService() {

		jasonReadSimple.parseJason();
		map = jasonReadSimple.continentMapObject();
		logger.info("******Return Continent and setOfCountries from service class ******");
		return map;

	}
}
