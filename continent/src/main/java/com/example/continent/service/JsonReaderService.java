package com.example.continent.service;

import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

import com.example.continent.model.Country;

/**
 * @author sahil.md
 *
 */
public interface JsonReaderService {
	public void parseJason();

	public void parseContinentObject(JSONObject con);

	public Map<String, Set<Country>> continentMapObject();
}
