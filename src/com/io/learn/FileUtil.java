/**
 * 匠心学习：坚持、专注
 * */
package com.io.learn;

import java.io.File;
/*
 * java.io.File
 * 将操作系统中的，文件，目录（文件夹），路径，封装成File对象
 * 提供方法，操作系统中的内容
 * File是与系统无关的类
 * file类只能用于表示文件和目录的信息，不能用于文件内容的访问
 */
public class FileUtil {
	public boolean getFileName () {
		String pathSeparator = File.pathSeparator; // 与系统有关的路径分隔符
		String nameSepatator = File.separator; // 与系统有关的默认名称分割
		File file = new File("E:/FileDemo.java");
		System.out.println(pathSeparator);
		System.out.println(nameSepatator);
		System.out.println(file.getName());
		System.out.println(file.getParent());
		return true;
	}
	
	/**
	 * File类的构造方法
	 * 三种重载形式
	 * */
	public boolean constructFileObject () {
		File file1 = new File("E:/app");
		File file2 = new File("E:", "app");
		File parent = new File("E:");
		File file3 = new File(parent, "app");
		System.out.println(file1);
		System.out.println(file2);
		System.out.println(file3);
		return true;
	}
}
