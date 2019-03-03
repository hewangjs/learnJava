package com.io.learn;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FileUtilTest {
	private FileUtil fileUtil = new FileUtil();
	
	@Test
	public void testGetFileName() {
		assertEquals(true, fileUtil.getFileName());
	}
	
	@Test
	public void testConstructFileObject () {
		assertEquals(true, fileUtil.constructFileObject());
	}
}
