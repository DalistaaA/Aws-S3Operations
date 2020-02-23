package com.auxenta.fileUploadApplication;

public enum S3Response {

	OK(20000, "OK"), CREATED(20100, "CREATED"), UPLOADED(20200, "UPLOADED"),
	VALIDATION_FAILURE(40000, "VALIDATION_FAILURE"), ERROR(50000, "ERROR"), DELETED(50100, "DELETED");

	private Integer code;
	private String message;

	S3Response(Integer code, String message) {
		this.message = message;
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return code + ":" + message;
	}

}
