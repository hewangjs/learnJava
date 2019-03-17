package com.leetcode.train;

import java.util.HashMap;

public class Main {
	/**
	 * 0001
	 * 给定一个整数数组 nums 和一个目标值 target，
	 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 */
	// 0001暴力法
	public int[] computeTwoSum01(int[] nums, int target) {
		for (int i = 0; i < nums.length;i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	// 0001两遍哈希表 消耗空间换取时效
	public int[] computeTwoSum02(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i); // 用元素作为键值，可以去重
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	// 0001一遍哈希表
	public int[] computeTwoSum03(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i= 0; i < nums.length; i++) {
			int complete = target - nums[i];
			if(map.containsKey(complete) && map.get(complete) != i) {
				return new int[] {i, map.get(complete)};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
