package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;
/**
 * leetCode 283 移动零
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * leetCode 中不需要return 这个数组
 * */
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 0, 3, 12};
		ArrayUtils.printArray(moveZeroes(nums));
	}
	
	public static int[] moveZeroes (int[] nums){
		int k = 0; // [0, k) 第k + 1个非零元素的索引
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (k == i) {
					k++;
					continue;
				}
				nums[k] = nums[i];
				nums[i] = 0;
				k++;
			}
		}
		return nums;
	}
}
