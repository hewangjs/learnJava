package com.huaweijishi.niuke;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	/**
	 * 公共测试方法 
	 */
	
	public boolean common(){
		{
			int x = 12;
			{
				int y = 12;
				String s = "hello";
			}
		}
		return true;
	}
	/**
	 * 一串由空格隔开的字符串，最后一个单词的长度，空格隔开
	 */
	public int strLastWordLen(String str) {
		return str.length()-1-str.lastIndexOf(" ");	
	}
	
	/**
	 * 由字母和数字组成的字符串，和一个字符，
	 * 然后输出输入字符串中含有该字符的个数。不区分大小写。
	 */
	public int strIncludeCharName(String str, char c){
		char[] charArry = str.toCharArray();
		int sum = 0;
		String b = String.valueOf(c);
		for (int i = 0; i < charArry.length; i++) {
			if(b.equalsIgnoreCase(String.valueOf(charArry[i]))){
				sum++;
			}
		}
		return sum;
	}
	
	/**
	 * 生成1000以下的n个随机数，并进行去重，排序
	 */
	
	public boolean randomArrFilterSort(int n){
		int[] inputArray = new int[n];
//		int[] inputArray = {3,7,1,2,3,1,4,5,6,1};
		Random random = new Random();
		/** 生成数组 */
		for(int i=0;i<n;i++){
			inputArray[i] = random.nextInt(1000);
		}
		/** 去除重复元素 */
		int[] filterArray = new int[n];
		int num = 0; // 去重后，数组元素的个数
		for(int value:inputArray){
			if(!arrayContainsValue(filterArray, value)){
				filterArray[num] = value;
				num++;
			}
		}
		
		int[] filterArrayZero = filterArrayZero(filterArray);
		int[] sortArray = sortFromMinToMaxArray(filterArrayZero);
		// 
		for(int i:sortArray){
			System.out.println(i);
		}
		return true;
	}
	
	/**
	 * 判断int数组是否包含某个整数
	 * @param array int数组
	 * @param value int
	 */
	public static boolean arrayContainsValue(int[] array, int value){
		if (array==null || array.length ==0) {
			return false;
		}
		for(int i:array){
			if(i==value){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 去除int数组中的0元素
	 * @param array int数组
	 * @return filterArray过滤后的int数组 
	 */
	public static int[] filterArrayZero(int[] array){
		int num = 0;
		int i = 0;
		for(int value:array){
			if(value != 0){
				num++;
			}
		}
		int[] filterArray = new int[num];
		for(int value:array){
			if(value != 0){
				filterArray[i] = value;
				i++;
			}
		}
		return filterArray;
	}
	
	/** 
	 * 将int 数组 从小到大排序(插入排序)
	 * @param array int数组
	 */
	public static int[] sortFromMinToMaxArray(int[] array){
		int len = array.length;
		if(len==0){
			return array;
		}
		int preIndex,current;
		for(int i=1; i < len;i++){
			preIndex = i-1;
			current = array[i];
			while(preIndex >=0 && array[preIndex] > current){
				array[preIndex + 1] = array[preIndex];
				preIndex--;
			}
			array[preIndex + 1] = current;
		}
		return array;
	}
	
}




































