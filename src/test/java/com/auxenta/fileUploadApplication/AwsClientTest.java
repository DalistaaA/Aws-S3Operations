package com.auxenta.fileUploadApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;

class AwsClientTest {

	@Test
	void test_getS3client() {
		AmazonS3 s3Client = AwsClient.getS3client();
		assertNotNull(s3Client);	
		assertEquals(s3Client, AwsClient.getS3client());
		assertEquals(Regions.AP_SOUTHEAST_1.getName(),AwsClient.getS3client().getRegionName());
		
	}

}
