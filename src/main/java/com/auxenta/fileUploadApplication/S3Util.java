package com.auxenta.fileUploadApplication;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.auxenta.fileUploadApplication.exception.BucketDoesNotExistException;

public class S3Util {

	private S3Util() {}
	private static final Logger logger = LogManager.getLogger(S3Util.class);
	
	public static S3Response upload(S3Request s3Request) throws Exception {
		try {
			if (!AwsClient.getS3client().doesBucketExistV2(s3Request.getBucket())) {
				throw new BucketDoesNotExistException("Bucket does not exist");
			}
			AwsClient.getS3client().putObject(buildPutObject(s3Request));
			logger.info(S3Response.UPLOADED);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return S3Response.UPLOADED;
	}
	
	public static PutObjectRequest buildPutObject(S3Request s3Request) throws BucketDoesNotExistException {
		if (!AwsClient.getS3client().doesBucketExistV2(s3Request.getBucket())) {
			throw new BucketDoesNotExistException("Bucket does not exist");
		}
		return new PutObjectRequest(s3Request.getBucket(), s3Request.getKey(), new File(s3Request.getFilePath()));
	}

	public static S3Response delete(S3Request s3Request) {
		AwsClient.getS3client().deleteObject(buildDeleteObject(s3Request));
		logger.info(S3Response.DELETED);
		return S3Response.DELETED;
	}
	
	public static DeleteObjectRequest buildDeleteObject(S3Request s3Request) {
		return new DeleteObjectRequest(s3Request.getBucket(), s3Request.getKey());
	}
	
	public static boolean s3ObjectDoesExist (S3Request s3Request) {
		return AwsClient.getS3client().doesObjectExist(s3Request.getBucket(), s3Request.getKey());
	}
}
