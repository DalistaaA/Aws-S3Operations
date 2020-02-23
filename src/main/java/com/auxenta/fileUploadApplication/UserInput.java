package com.auxenta.fileUploadApplication;

import java.io.File;
import java.io.IOException;

public class UserInput {

	public static void handlingUserInputs(String args[]) throws IOException {
		Validation.checkAll(args);
		S3Util.uploadFile(args[0], args[1], new File(args[2]));
	}
}
