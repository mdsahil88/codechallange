package com.example.continent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.continent.controller.ContinentController;

/**
 * @author sahil.md
 *
 */

@SpringBootApplication
public class ContinentApplication {
	private static final Logger logger = LoggerFactory.getLogger(ContinentApplication.class);
      private static ContinentController  continentController;
    
    @Autowired
	public ContinentApplication(ContinentController continentController) {
		this.continentController = continentController;
	}

	public static void main(String[] args) {

		SpringApplication.run(ContinentApplication.class, args);
		logger.info("Application started....");
		continentController.continentList();
		logger.info("Contry Map created..........");
		
	}

}
