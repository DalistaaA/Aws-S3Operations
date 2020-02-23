package com.auxenta.fileUploadApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class Validation {

	public static boolean checkInputsEmpty(String args) {
		return StringUtils.isBlank(args);
	}

	public static boolean checkIsFile(File file) throws FileNotFoundException {
		return file.isFile();
	}

	public static void checkAll(String args[]) throws IOException {
		if (args.length != 3) {
			throw new ArrayIndexOutOfBoundsException(
					"\nYou passed more than or less than three inputs. You can provide three inputs only \n Such as ..... \n 1. Aws S3 Bucket Name \n 2. Key - File name -- You want to upload in Aws S3 Bucket. \n 3. Correct file path -- Which is the file you want to upload from your PC");
		}else if(checkInputsEmpty(args[0])) {
			throw new NullPointerException(
					"\nYou passed empty bucket Name. Please provide valid Bucket Name.");
		}else if(checkInputsEmpty(args[1])) {
			throw new NullPointerException(
					"\nYou passed empty key Name. Please provide valid key Name . Where you want to upload file in Aws Bucket");
		}else if (!checkIsFile(new File(args[2]))) {
			throw new FileNotFoundException("\nYour file does not exists. Please check your filepath");
		}
	}

}
