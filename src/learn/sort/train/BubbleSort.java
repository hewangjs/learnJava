package learn.sort.train;

import java.util.Random;

/**
 * 匠心学习：坚持，专注
 * 冒泡排序是较简单的排序算法
 * 核心思想：是交换两个相邻的元素
 * 关键点是：
 * 	1. 控制长度为len的数组 需要交换元素的个数是 len -1  也是外层循环的次数
 * 	2. 控制索引为j的元素，需要交换的次数 len - j -1
 * 时间复杂度是:O(n^2)
 * */
public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = createRandomArray(100);
		bubbleSort(nums);
		printArr(nums);
	}
	
	/**
	 * 创建长度为size的所以数组
	 * @param 长度size
	 * @return 生成的arr
	 * */
	private static int[] createRandomArray(int size) {
		int[] arr = new int[size];
		Random random = new Random(100);
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(1000);
		}
		return arr;
	}
	/**
	 * 冒泡排序
	 * @param int[] 整数数组
	 * @return int[] 整数数组
	 * */
	private static int[] bubbleSort(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) { // 
			for (int j = 0; j < len - i - 1; j++) {
				if (nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
				}
			}
		}
		return nums;
	}
	
	/**
	 * 交换一个整数数组的第位和第j位
	 * @param 整数数组 int[]
	 * @param 索引 i
	 * @param 索引 j
	 * */
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * 打印一个整数数组
	 * @param int[]
	 * */
	private static void printArr(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
