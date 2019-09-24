package com.example.continent.model;
import java.util.Set;

/**
 * @author sahil.md
 *
 */
public class Continent {

	private String continentName;
    private Set<Country> setOfCountries;
	

	public Set<Country> getSetOfCountries() {
		return setOfCountries;
	}

	/**
	 * @param setOfCountries
	 */
	public void setSetOfCountries(Set<Country> setOfCountries) {
		this.setOfCountries = setOfCountries;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName.toLowerCase();
	}

}
