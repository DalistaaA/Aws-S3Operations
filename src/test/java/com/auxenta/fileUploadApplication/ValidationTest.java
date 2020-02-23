package com.auxenta.fileUploadApplication;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

class ValidationTest {

	String fileSeparator = System.getProperty("file.separator");
	String currentDir = System.getProperty("user.dir");
	File sourcefile = new File(currentDir + fileSeparator + "Log" + fileSeparator + "logging.log");

	@Test
	void test_checkInputsEmpty() {
		assertFalse(Validation.checkInputsEmpty("test"));
		assertTrue(Validation.checkInputsEmpty(""));
		assertTrue(Validation.checkInputsEmpty(" "));
		assertTrue(Validation.checkInputsEmpty(null));
	}

	@Test
	void test_checkIsFile() throws FileNotFoundException {
		assertFalse(Validation.checkIsFile(new File("")));
		assertFalse(Validation.checkIsFile(new File("test")));
		assertTrue(Validation.checkIsFile(sourcefile));
	}

	@Test
	void test_checkAll() {
		Exception arrException = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Validation.checkAll(new String[] { "bucketName ", "sourcefile " });
		});
		assertEquals("\nYou passed more than or less than three inputs. You can provide three inputs only \n Such as ..... \n 1. Aws S3 Bucket Name \n 2. Key - File name -- You want to upload in Aws S3 Bucket. \n 3. Correct file path -- Which is the file you want to upload from your PC",
				arrException.getMessage());
		assertNotEquals("test",arrException.getMessage());

		Exception nullException = assertThrows(NullPointerException.class, () -> {
			Validation.checkAll(new String[] { "", "", "" });
		});
		assertEquals("\nYou passed empty bucket Name. Please provide valid Bucket Name.",
				nullException.getMessage());
		assertNotEquals("test",nullException.getMessage());
		
		Exception nullException1 = assertThrows(NullPointerException.class, () -> {
			Validation.checkAll(new String[] { "nbs-training", "", "Documets/Aws.docx" });
		});
		assertEquals("\nYou passed empty key Name. Please provide valid key Name . Where you want to upload file in Aws Bucket",
				nullException1.getMessage());
		assertNotEquals("test",nullException1.getMessage());

		Exception fileException = assertThrows(FileNotFoundException.class, () -> {
			Validation.checkAll(new String[] { "nbs-training", "Documets/Aws.docx", "test" });
		});
		assertEquals("\nYour file does not exists. Please check your filepath", fileException.getMessage());
		assertNotEquals("test", fileException.getMessage());
	}

}
