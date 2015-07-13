package experiment2.test;

import java.util.Arrays;

import experiment2.SortedSeqList;

public class TestSortedSeqList {

	public static void main(String[] args) {
		Integer[] element = {1,4,2,6,3,8,7};
		System.out.println("构建一个数组：\n" + Arrays.toString(element));
		SortedSeqList<Integer> list = new SortedSeqList<Integer>(element);
		System.out.println("将数组中所有对象插入构造排序的单链表中：\n" + list.toString());
		list.insert(new Integer(5));
		System.out.println("插入数值为5的对象之后：\n" + list.toString());
		list.remove(new Integer(8));
		System.out.println("删除数值为8的对象之后：\n" + list.toString());
	}
}
