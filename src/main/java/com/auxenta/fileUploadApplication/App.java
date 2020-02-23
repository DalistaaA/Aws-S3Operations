package com.auxenta.fileUploadApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		try {
			UserInput.handlingUserInputs(args);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
	}
}
