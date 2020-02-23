package com.auxenta.fileUploadApplication;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Util {

	private S3Util() {}
	private static final Logger logger = LogManager.getLogger(S3Util.class);

	static AWSCredentials awsCredentials = new BasicAWSCredentials("your key",
			"your secret key");
	static AmazonS3 s3client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
			.build();
	static boolean uploaded = false;

	public static boolean uploadFile(String bucketName, String key, File sourceFile) {
		try {
			s3client.putObject(new PutObjectRequest(bucketName, key, sourceFile));
			logger.info("Successfully Uploaded");
			uploaded = true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			uploaded = false;
		}
		return uploaded;
	}

}
