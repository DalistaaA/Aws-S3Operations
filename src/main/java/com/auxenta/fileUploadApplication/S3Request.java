package com.auxenta.fileUploadApplication;

public class S3Request {

	private String bucket;
	private String key;
	private String filePath;

	public S3Request() {
		super();
	}

	public S3Request(String bucket, String key) {
		super();
		this.bucket = bucket;
		this.key = key;
	}

	public S3Request(String bucket, String key, String filePath) {
		super();
		this.bucket = bucket;
		this.key = key;
		this.filePath = filePath;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
