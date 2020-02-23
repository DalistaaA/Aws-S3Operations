package com.auxenta.fileUploadApplication;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class S3UtilTest {

	String fileSeparator = System.getProperty("file.separator");
	String currentDir = System.getProperty("user.dir");
	File sourcefile = new File(currentDir + fileSeparator + "Log" + fileSeparator + "logging.log");
	
	@Test
	void test_uploadFile() {
		assertTrue(S3Util.uploadFile("nbs-training", "Documents/logging.log", sourcefile));
		assertFalse(S3Util.uploadFile("nbs-training", "", sourcefile));
		assertFalse(S3Util.uploadFile("nbs-training", "Documents/logging.log", new File("")));
		assertFalse(S3Util.uploadFile("", "", new File("")));
		assertFalse(S3Util.uploadFile(" ", " ", new File("")));
	}

}
