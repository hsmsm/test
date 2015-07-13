package experiment2.test;

import java.util.Arrays;
import experiment2.SinglyLinkedList;

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		Integer[] element = {1,2,3,4,5};
		System.out.println("创建数组：\n" + Arrays.toString(element));
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>(element);  
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>(list1);    
		System.out.println("构造单链表：\n" + "list1：" + list1.toString() + "\nlist2：" + list2.toString());
		System.out.println("list1和list2是否相等？ " + list1.equals(list2));           
		list1.concat(list2);
		System.out.println("将list2衔接到list1后：\n" + "list1：" + list1.toString() + "\nlist2：" + list2.toString());
		System.out.println("list1和list2是否相等？ " + list1.equals(list2));
		System.out.println("list1是否包含数值6？ " + list1.contain(new Integer(6)));
		list1.replace(new Integer(1), new Integer(6));
		System.out.println("将list1中的首次出现的数值1替换成数值6后:\n" + list1.toString());
		System.out.println("list1是否包含数值6？ " + list1.contain(new Integer(6)));
		list1.remove(list1.search(new Integer(6)));                         //先search后remove，同时test两个方法
		System.out.println("将list1中的首次出现的数值6移除后:\n" + list1.toString());
	}

}
