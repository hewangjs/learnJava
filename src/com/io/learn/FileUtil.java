/**
 * 匠心学习：坚持、专注
 * */
package com.io.learn;

import java.io.File;
import java.io.IOException;
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
		File file = new File("C:/Windows/system.ini");
		System.out.println(pathSeparator);
		System.out.println(nameSepatator);
		System.out.println(file.getName()); // 获取路径最后部分的名字，文件或者文件夹的名字
		System.out.println(file.getParent()); // 返回String对象
		System.out.println(file.getParentFile()); // 返回File对象
		System.out.println(file.length()); // 返回文件的字节数
		System.out.println(file.getAbsoluteFile()); // 返回File对象，获取绝对路径
		System.out.println(file.getAbsolutePath()); // 返回String对象
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
	
	/**
	 * 判断File是文件还是文件夹
	 * */
	public boolean isDirOrFile() {
		File file = new File("C:/Windows/system.ini");
		System.out.println(file.isDirectory()); // 判断File构造方法中封装的路径是不是文件夹，是true，否false
		System.out.println(file.isFile()); // 判断File构造方法中封装的路径是不是文件，是true，否false
		return true;
	}
	
	/**
	 * 文件创建、文件夹创建、文件和文件夹的删除
	 * @throws IOException 
	 * */
	public boolean operateFile() throws IOException {
		File file1 = new File("E:/testOperateFile.txt");
		file1.createNewFile(); // 创建的文件路径和文件名，在File构造方法中给出，文件已经存在，不再创建
		System.out.println("文件testOperateFile.txt创建");
		File file2 = new File("E:/test/testMkdirs");
		System.out.println("文件目录E:/test/testMkdirs创建");
		file2.mkdirs(); // 创建多层文件夹，路径在File构造方法中给出，文件夹已经存在，不再创建
		System.out.println("文件testOperateFile.txt删除");
		file1.delete(); // 删除成功返回true，失败返回返回false，不走回收站，直接从硬盘删除，删除有风险，运行需谨慎
		return true;
	}
}
