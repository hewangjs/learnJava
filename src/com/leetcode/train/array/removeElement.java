package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;
/**
 * leetCode 27 移除元素
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * leetCode 中 return 剩余数组元素的长度
 * */
public class removeElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,2,3,0,4,2};
		ArrayUtils.printArray(removeElementImpl(nums, 2));
	}
	
	public static int[] removeElementImpl(int[] nums, int val) {
		int k = -1; // 替换元素的索引
		for (int i = 0; i < nums.length; i++) { // 找到第一个等于val的索引
			if (nums[i] == val) {
				k = i;
				break;
			}
		}
		if (k == -1) {
			return nums;
		}
		for (int i = k + 1; i < nums.length; i++) { // 从k+1 往后遍历 
			if (nums[i] == val) {
				continue;
			} else {
				nums[k] = nums[i];
				k++;
			}
		}
		return nums;
	}

}
