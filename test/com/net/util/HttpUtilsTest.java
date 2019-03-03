package com.net.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.net.util.HttpUtils;

public class HttpUtilsTest {

	@Test
	public void testReturnHttpContent() {
		assertEquals(true, new HttpUtils().returnHttpContent());
	}
}
