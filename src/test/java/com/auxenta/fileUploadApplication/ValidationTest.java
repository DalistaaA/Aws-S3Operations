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
		assertTrue(Validation.checkInputsEmpty(""));
		assertFalse(Validation.checkInputsEmpty("test"));
		assertFalse(Validation.checkInputsEmpty(" "));
	}

	@Test
	void test_checkIsFile() {
		assertTrue(Validation.checkIsFile(sourcefile));
		assertFalse(Validation.checkIsFile(new File("")));
		assertFalse(Validation.checkIsFile(new File("test")));
	}

	@Test
	void test_checkAll() {
		ArrayIndexOutOfBoundsException arrException = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Validation.checkAll(new String[] { "bucketName ", "sourcefile " });
		});
		assertEquals("You passed more than or less than three inputs. You must provide three inputs only",
				arrException.getMessage());

		NullPointerException nullException = assertThrows(NullPointerException.class, () -> {
			Validation.checkAll(new String[] { "", "", "" });
		});
		assertEquals("You passed empty values. Please check your all three values are valid or not",
				nullException.getMessage());

		FileNotFoundException fileException = assertThrows(FileNotFoundException.class, () -> {
			Validation.checkAll(new String[] { "nbs-training", "Documets/Aws.docx", "test" });
		});
		assertEquals("There is no file in that location. Please check your filepath", fileException.getMessage());
	}

}
