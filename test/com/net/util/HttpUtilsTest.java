package com.net.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.net.util.HttpUtils;
import com.string.util.StringUtils;

public class HttpUtilsTest {

	@Test
	public void testReturnHttpContent() {
		assertEquals(true, new HttpUtils().returnHttpContent());
	}
	
	@Test
	public void testAccountManage() {
		assertEquals(true, new HttpUtils().accountManage());
	}

}
