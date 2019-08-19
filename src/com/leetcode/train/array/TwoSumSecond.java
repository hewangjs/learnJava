package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;
/**
 * leetCode 167 两数值和
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * 特点：给出的数组是有序的
 * 思想：使用对撞指针
 * */
public class TwoSumSecond {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		ArrayUtils.printArray(TwoSumSecondImpl(nums, 9));
	}
	
	public static int[] TwoSumSecondImpl (int[] nums, int target) {
		int[] indexs = {0, 0};
		int i = 0; // 最左边的指针
		int j = nums.length - 1; // 最右边的指针
		boolean flag = false; // 找到标志
		while (!flag) {
			if (nums[i] + nums[j] > target) {
				j --;
			} else if (nums[i] + nums[j] < target){
				i ++;
			} else {
				flag = true;
				indexs[0] = i + 1;
				indexs[1] = j + 1;
				return indexs;
			}
		}
		return indexs;
	}

}
