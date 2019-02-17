package com.webtest.demo.read;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PictureTest extends BaseTest{
	@Test
	public void picture() throws IOException {
		Action action = new Action(webtest);
		action.qiehuan();
	}

}
