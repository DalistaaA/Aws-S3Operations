package com.auxenta.fileUploadApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.amazonaws.services.s3.model.PutObjectRequest;

class S3UtilTest {

	static String fileSeparator = System.getProperty("file.separator");
	static String currentDir = System.getProperty("user.dir");
	static String sampleDirPath = currentDir + fileSeparator + "Example";
	static String sourcefilePath = sampleDirPath + fileSeparator + "Note.txt";
	static File sampleDir = new File(sampleDirPath);
	static File file = new File(sourcefilePath);

	@BeforeAll
	static void beforeAll() throws IOException {
		sampleDir.mkdir();
		file.createNewFile();
		FileUtils.write(file, "This is a sample testing file", StandardCharsets.UTF_8);
	}

	@Test
	void test_uploadObject() throws Exception {
		assertEquals(S3Response.UPLOADED,S3Util.upload(new S3Request("nbs-training", "Dalistaa/Note.txt", sourcefilePath)));
		assertTrue(S3Util.s3ObjectDoesExist(new S3Request("nbs-training", "Dalistaa/Note.txt")));
		S3Util.buildDeleteObject(new S3Request("nbs-training", "Dalistaa/Note.txt"));
	}

	@Test
	void test_buildObject() throws Exception {
		PutObjectRequest request = S3Util.buildPutObject(new S3Request("nbs-training", "Dalistaa/Note.txt", sourcefilePath));
		assertEquals("nbs-training", request.getBucketName());
		assertEquals("Dalistaa/Note.txt", request.getKey());
		assertEquals(sourcefilePath, request.getFile().getAbsolutePath());
	}

	@AfterAll
	static void afterAll() {
		sampleDir.delete();
		file.delete();
		S3Util.delete(new S3Request("nbs-training", "Dalistaa/Note.txt"));
	}
}
