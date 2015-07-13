package experiment2.test;

import experiment2.MyIterator;
import experiment2.SinglyLinkedList;

public class TestMyIterator {

	public static void main(String[] args) {
		Integer element1[] = {1,2,3,4,5};
		Integer element2[] = {5,4,3,2,1};
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>(element1);
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>(element2);
		System.out.println("list1：" + list1.toString());
		System.out.println("list2：" + list2.toString());
		MyIterator<Integer> iterator1 = list1.interator();
		MyIterator<Integer> iterator2 = list2.interator();
		System.out.println("list1中数值3的序号为：" + iterator1.indexOf(new Integer(3)));
		System.out.println("list1与list2相等？ " + iterator1.equals(iterator2));
	}

}
