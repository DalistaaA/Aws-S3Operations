package com.auxenta.fileUploadApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		try {
			Validation.checkAll(args);
			S3Util.upload(new S3Request(args[0],args[1],args[2]));
		} catch (Exception e) {
			logger.error("Error Occurred" + e.getMessage());
		}
	}
}
