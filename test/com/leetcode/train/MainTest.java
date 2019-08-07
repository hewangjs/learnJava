package com.leetcode.train;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.train.common.Main;

public class MainTest {
	private static Main main = new Main();

	@Test
	public void testComputeTwoSum01() {
		assertArrayEquals(new int[] {2, 4}, main.computeTwoSum01(new int[] {1, 2, 3, 4, 5}, 8));
	}
	
	@Test
	public void testComputeTwoSum02() {
		assertArrayEquals(new int[] {2, 4}, main.computeTwoSum02(new int[] {1, 2, 3, 4, 5}, 8));
	}
	
	@Test
	public void testComputeTwoSum03() {
		assertArrayEquals(new int[] {4, 2}, main.computeTwoSum03(new int[] {1, 2, 3, 4, 5}, 8));
	}

}
