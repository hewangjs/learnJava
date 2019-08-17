package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;
/**
 * leetCode 75 颜色分类
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * 思想：使用了三路快排中的思想
 * */
public class sortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 0, 2, 1, 1, 0};
		ArrayUtils.printArray(sortColorsImpl(nums));
	}
	
	public static int[] sortColorsImpl(int[] nums) {
		int len = nums.length;
		int zero = -1; // 0元素的索引范围 [0, zero] // 下面的代码要去维护这个索引 zero
		int two = len; // 2元素的范围 [two, len] // 下面的代码要去维护缩影two
		for (int i = 0; i < two;) {
			if (nums[i] == 0) {
				zero ++;
				ArrayUtils.swap(nums, i, zero);
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				two--;
				ArrayUtils.swap(nums, i, two);
			}
		}
		return nums;
	}
}
