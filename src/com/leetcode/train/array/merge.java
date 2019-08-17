package com.leetcode.train.array;

import com.leetcode.train.common.ArrayUtils;

public class merge {
	/**
	 * leetCode 88 合并两个有序数组
	 * 数据特点是，有序的数组
	 * 时间复杂度O（m+n）
	 * 空间复杂度O（1）
	 * 思想：采用双指针，从后向前遍历  原地归并的方法
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0}; // 题目说nums1有足够的空间存储nums2的数据
		int[] nums2 = {2,5,6};
		ArrayUtils.printArray(mergeImpl(nums1, 3, nums2, 3));
	}
	
	public static int[] mergeImpl(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1; // 数组1的尾指阵
		int p2 = n - 1; // 数组2的尾指针
		int p = m + n - 1; // 合并数组的尾指针
		while (p1 >=0 && p2 >=0) {
			if (nums1[p1] > nums2[p2]) {
				nums1[p] = nums1[p1];
				p--;
				p1--;
			} else {
				nums1[p] = nums2[p2];
				p--;
				p2--;
			}
		}
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
		return nums1;
	}
}
