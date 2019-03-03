package com.huaweijishi.niuke;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
	
	private static Main main = new Main();
	
	@Test
	public void testCommon(){
		assertEquals(true, main.common());
	}
	
	@Test
	public void testStrLastWordLen() {
		assertEquals(4, new Main().strLastWordLen("Hello this is test"));
		assertEquals(0, new Main().strLastWordLen(""));
		assertEquals(0, new Main().strLastWordLen(" "));
		assertEquals(5, new Main().strLastWordLen("Hello"));
	}
	
	@Test
	public void testStrIncludeCharName() {
		assertEquals(4, new Main().strIncludeCharName("wesdfHshhh", 'h'));
		assertEquals(1, new Main().strIncludeCharName("wesdf Hshhh", 'w'));
		assertEquals(1, new Main().strIncludeCharName("wesdf Hshhh", ' '));
	}
	
	@Test
	public void testRandomArrFilterSort(){
		assertEquals(true, main.randomArrFilterSort(15000));
	}
}
