package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;
/**
 * leetCode 26 删除排序数组中的重复项
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * leetCode 中 return 剩余数组元素的长度
 * */
public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		ArrayUtils.printArray(removeDuplicatesImpl(nums));
	}
	
	 public static int[] removeDuplicatesImpl(int[] nums) {
		 if (nums.length == 0) {
			return nums;
		}
	        int k = 1; // 新数组索引
	        int currVal = nums[0];
	        for (int i = 1; i < nums.length; i++) {
				if (currVal == nums[i]) {
					continue;
				} else {
					currVal = nums[i];
					nums[k] =currVal;
					k ++;
				}
			}
	        return nums;
	 } 
}
