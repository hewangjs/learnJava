package learn.sort.train;

import com.leetcode.train.common.ArrayUtils;

/**
 * 快速排序
 * 递归的空间复杂度，时间复杂度如何计算？
 * 快速排序的中心思想是？
 * 哨兵发，双指针
 * 思想：
 * 1. 从左边找到比基准值小的元素 
 * 2. 从右边边找到比基准大的元素
 * 3. 交换这两个元素
 * 4. 直到 i = j, 也就是哨兵碰面
 * 6. 将基准值的左边序列，和右边序列，重复执行，其实每一轮的操作，都是在找基准值在整个数组排序号的位置
 * */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
		quickSort(arr, 0, arr.length - 1);
		ArrayUtils.printArray(arr);
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		int i,j,temp,t;
		if (low > high) {
			return;
		}
		i = low;
		j = high;
		temp = arr[low];
		while (i < j) { // 循环停止时，j恰好是等于i的
			while (temp <= arr[j] && i < j) {
				j --;
			}
			
			while (temp >= arr[i] && i < j) {
				i ++;
			}
			
			if (i < j) {
				ArrayUtils.swap(arr, i, j);
			}
		}
		
		ArrayUtils.swap(arr, low, i);
		// 递归左半部分
		quickSort(arr, low, i - 1);
		// 递归有半部分
		quickSort(arr, i + 1, high);
	}
}