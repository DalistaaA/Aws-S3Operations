package com.auxenta.fileUploadApplication;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void test_main() {
		
		String fileSeparator = System.getProperty("file.separator");
		String currentDir = System.getProperty("user.dir");
		String sampleDirPath = currentDir + fileSeparator + "Example";
		String sourcefilePath = sampleDirPath + fileSeparator +"Note.txt";
		
		App.main(new String[]{});
		App.main(new String[]{"nbs-training", "Dalistaa/Note.txt", sourcefilePath});
		App.main(new String[]{" ", " ", " "});
		App.main(new String[]{"test", "key" , "sourcefilePath"});
	}

}
