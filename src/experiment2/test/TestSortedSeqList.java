package experiment2.test;

import java.util.Arrays;

import experiment2.SortedSeqList;

public class TestSortedSeqList {

	public static void main(String[] args) {
		Integer[] element = {1,4,2,6,3,8,7};
		System.out.println("����һ�����飺\n" + Arrays.toString(element));
		SortedSeqList<Integer> list = new SortedSeqList<Integer>(element);
		System.out.println("�����������ж�����빹������ĵ������У�\n" + list.toString());
		list.insert(new Integer(5));
		System.out.println("������ֵΪ5�Ķ���֮��\n" + list.toString());
		list.remove(new Integer(8));
		System.out.println("ɾ����ֵΪ8�Ķ���֮��\n" + list.toString());
	}
}
