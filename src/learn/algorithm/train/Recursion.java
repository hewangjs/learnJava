package learn.algorithm.train;

/**
 * 匠心学习: 坚持，专注
 * 两个关键点：
 * 一个基本案例
 * 一个递推关系
 * */

public class Recursion {

	public static void main(String[] args) {
		
		printRecursion("Hello Algorithm");
	}
	
	/**
	 * 递归从前往后打印一个字符串
	 * */
	private static void printRecursion(String str) {
		
		char[] strArr = str.toCharArray();
		printHelper(0, strArr);
	}
	
	private static void printHelper(int index, char[] strArr) {
		
		if (strArr.length == 0) {
			System.out.println("字符串长度为0");
			return;
		}
		
		if (strArr == null || index == (strArr.length - 1)) {
			System.out.println("打印结束");
			return;
		}
		
		System.out.println(strArr[index]);
		index++;
		printHelper(index, strArr);
	}
}
