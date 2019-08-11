package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;
/**
 * leetCode 80 删除排序数组中的重复项 II
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * leetCode 中不需要return 这个数组
 * */
public class removeDuplicates2 {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		ArrayUtils.printArray(removeDuplicates2Impl(nums));
	}
	
	public static int[] removeDuplicates2Impl(int[] nums) {
		if (nums.length == 0) {
			return nums;
		}
		int k = 1; // 新数组移动索引位置
		int currVal = nums[0]; // 遍历的当前值
		int num = 1; // 当前值数量
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == currVal) {
				num ++;
				if (num == 2) {
					nums[k] = currVal;
					k++;
				} else {
					continue;
				}
			} else {
				currVal = nums[i];
				nums[k] = currVal;
				k++;
				num = 1;
			}
		}
		return nums;
	}
}
