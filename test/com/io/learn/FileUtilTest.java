package com.io.learn;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class FileUtilTest {
	private FileUtil fileUtil = new FileUtil();
	
	@Test
	public void testGetFileName() {
		assertEquals(true, fileUtil.getFileName());
	}
	
	@Test
	public void testIsDirOrFile () {
		assertEquals(true, fileUtil.isDirOrFile());
	}
	
	@Test
	public void testConstructFileObject () {
		assertEquals(true, fileUtil.constructFileObject());
	}
	
	@Test
	public void testoperateFile () throws IOException {
		assertEquals(true, fileUtil.operateFile());
	}
}
