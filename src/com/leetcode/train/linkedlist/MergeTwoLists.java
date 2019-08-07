package com.leetcode.train.linkedlist;

public class MergeTwoLists {
	public static void main(String[] args) {
		
		ListNode node01 = new ListNode(0);
		ListNode node02 = new ListNode(6);
		ListNode node03 = new ListNode(9);
		node01.next = node02;
		node02.next = node03;
		
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(7);
		ListNode node13 = new ListNode(8);
		node11.next = node12;
		node12.next = node13;
		
		ListNode mergeNode = mergeTwoLists(node01, node11);
		
		// 打印一个链表
		ListNode nextNode = mergeNode;
		do {
			System.out.println(nextNode.val);
			nextNode = nextNode.next;
		} while (nextNode != null);
	}
	/**
	 * 使用递归的方法合并两个有序的列表
	 * 基本思想是，一个节点的指针域，指向的是剩余节点中，值最小的哪个节点
	 * 递归的两个关键点：
	 * 1. 基本案例（终止方案）：剩余节点为空
	 * 2. 递推关系，当l1的值，比l2的值小的时候，让l1的指针域，指向l1的下一个元素和l2之中的一个
	 * 3. 注意：数据量大的时候，递归容易导致堆栈的溢出
	 * */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			}
			
			if (l2 == null) {
				return l1;
			}
			
			if (l1.val < l2.val) {
				l1.next = mergeTwoLists(l1.next, l2); // 改变l1的指针域的指向，除l1之外的剩下的元素合并后的链表头
				return l1; // l1的位置确定了
			} else {
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
	    }
}
