package com.net.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SocketUtilsTest {

	@Test
	public void testGetLocalIntAddress() throws IOException {
		assertEquals(true, new SocketUtils().getLocalIntAddress());
	}
	
	@Test
	public void testGetURLInfo() throws Exception {
		assertEquals(true, new SocketUtils().getURLInfo());
	}
	
	@Test
	public void testGetWebPageContent() throws IOException{
		assertEquals(true, new SocketUtils().getWebPageContent());
	}
	
	@Test
	public void testCreateServerSocket() throws IOException{
		assertEquals(true, new SocketUtils().createServerSocket());
	}
	
	@Test
	public void testCreateClientSocket() throws IOException{
		assertEquals(true, new SocketUtils().createClientSocket());
	}
	
}
