package cn.ucaner.datastructure.test;

import cn.ucaner.datastructure.list.LinkedList;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：LinkedListTest   
* @Description：   <p> LinkedListTest </p>
* @Author： -    
* @CreatTime：2018年6月8日 上午10:42:35   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class LinkedListTest {
	
	
	public static void main(String[] args) throws Exception {
		
		LinkedList<String> list1 = new LinkedList<String>();
		list1.add("Rico");
		list1.add("Rico");
		list1.add("Livia");
		list1.add("TJU");
		list1.add("Livia");
		list1.add("NEU");
		list1.add("NEU");
		list1.add("Rico");
		list1.add("NEU");
		
		System.out.println("原链表：");
		list1.print();
		System.out.println();
		
		list1.remove();
		System.out.println("删除尾节点后的链表：");
		list1.print();
		
		System.out.println();
		
		list1.removeDuplicateNodes();
		System.out.println("删除重复点后的链表：");
		list1.print();
		System.out.println();
		
		System.out.println("打印倒数第K个节点：");
		System.out.println(list1.getEndK(2));
		System.out.println();
		
		list1.reverseLinkedList();
		System.out.println("反转链表：");
		list1.print();
		list1.reverseLinkedList();
		list1.print();
		System.out.println();
		
		System.out.println("倒序打印链表：");
		list1.reversePrint(list1.getHead());
		System.out.println();
		System.out.println();
		
		System.out.println("打印链表中间节点：");
		list1.printMiddleNodes();
		System.out.println();
		
		
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("书呆子");
		list2.add(list1.getEndK(2));
		System.out.println("判断两链表是否相交：");
		list1.print();
		list2.print();
		System.out.println(list1.size() + " : " + list2.size());
		System.out.println("是否相交 : " + list1.isIntersect(list2));
		System.out.println("交点是 ： " + list1.getIntersectionPoint(list2));
		System.out.println();
		
		list1.deleteNodeWithoutHead(list1.getEndK(2));
		System.out.println("打印删除特定节点后的链表：");
		list1.print();
	}
}
