package experiment2.test;

import java.util.Arrays;
import experiment2.SinglyLinkedList;

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		Integer[] element = {1,2,3,4,5};
		System.out.println("�������飺\n" + Arrays.toString(element));
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>(element);  
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>(list1);    
		System.out.println("���쵥����\n" + "list1��" + list1.toString() + "\nlist2��" + list2.toString());
		System.out.println("list1��list2�Ƿ���ȣ� " + list1.equals(list2));           
		list1.concat(list2);
		System.out.println("��list2�νӵ�list1��\n" + "list1��" + list1.toString() + "\nlist2��" + list2.toString());
		System.out.println("list1��list2�Ƿ���ȣ� " + list1.equals(list2));
		System.out.println("list1�Ƿ������ֵ6�� " + list1.contain(new Integer(6)));
		list1.replace(new Integer(1), new Integer(6));
		System.out.println("��list1�е��״γ��ֵ���ֵ1�滻����ֵ6��:\n" + list1.toString());
		System.out.println("list1�Ƿ������ֵ6�� " + list1.contain(new Integer(6)));
		list1.remove(list1.search(new Integer(6)));                         //��search��remove��ͬʱtest��������
		System.out.println("��list1�е��״γ��ֵ���ֵ6�Ƴ���:\n" + list1.toString());
	}

}
