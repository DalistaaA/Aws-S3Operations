package com.auxenta.fileUploadApplication;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void test_main() {
		App.main(new String[]{});
		App.main(new String[]{"gffgf","fxcxb", "sdasd"});
		App.main(new String[]{" ", " ", " "});
	}

}
