package com.auxenta.fileUploadApplication;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AwsClient {

	private static final String ACCESS_KEY = "your key ...";
	private static final String SECRET_KEY = "your secret key";
	private static AWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
	private static AmazonS3 s3client;

	private AwsClient() {}
	
	public static AmazonS3 getS3client() {
		if(s3client==null) {
			s3client = AmazonS3ClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.AP_SOUTHEAST_1)
					.build();
		}
		return s3client;
	}

}
