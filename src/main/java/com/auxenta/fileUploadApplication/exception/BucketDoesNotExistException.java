package com.auxenta.fileUploadApplication.exception;

public class BucketDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public BucketDoesNotExistException(String message) {
		super(message);
	}
}
