package com.auxenta.fileUploadApplication;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validation {

	private static final Logger logger = LogManager.getLogger(Validation.class);
	
	public static boolean checkInputsEmpty(String args) {
		return args.isEmpty();
	}
	
	public static boolean checkIsFile(File file) {
		return file.isFile();
	}
	
	public static void checkAll(String args[]) throws FileNotFoundException {
		if(args.length!=3) {
			logger.error("You passed more than or less than three inputs. You must provide three inputs only");
			throw new ArrayIndexOutOfBoundsException("You passed more than or less than three inputs. You must provide three inputs only");
		}else if(checkInputsEmpty(args[0]) && checkInputsEmpty(args[1]) && checkInputsEmpty(args[2])) {
			logger.error("You passed empty values. Please check your all three values are valid or not");
			throw new NullPointerException("You passed empty values. Please check your all three values are valid or not");
		}else if (!checkIsFile(new File(args[2]))) {
			logger.error("There is no file in that location. Please check your filepath");
			throw new FileNotFoundException("There is no file in that location. Please check your filepath");
		}
	}
	
	
}
