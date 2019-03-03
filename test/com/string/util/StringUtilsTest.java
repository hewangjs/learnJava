package com.string.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class StringUtilsTest {
	
	@Test
	public void testIsEmpty() {
		assertEquals(true, new StringUtils().isEmpty(" "));
	}
	
	@Test
	public void testReadString() throws IOException{
		assertEquals(true, new StringUtils().readString("testProject.key"));
	}
	
	@Test
	public void testStringToBase64() throws UnsupportedEncodingException{
		assertEquals("commonStr", new StringUtils().stringToBase64("commonStr"));
	}
	
	@Test
	public void testConvertStrToBase64Byte() {
		assertEquals(true, new StringUtils().convertStrToBase64Byte("commonStr"));
	}
	
	@Test
	public void testStrToByte() throws UnsupportedEncodingException {
		assertEquals(true, new StringUtils().strToByte("a23456文"));
	}
	
	@Test
	public void testSplitString() {
		assertEquals(true, new StringUtils().splitString("6214570581000509950|6214570228100251750|6214571781011054587"));
	}
}
