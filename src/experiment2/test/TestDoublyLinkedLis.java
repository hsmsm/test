package experiment2.test;

import experiment2.DoublyLinkedList;

public class TestDoublyLinkedLis {
	
	public static void main(String[] args){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		System.out.println("˫�����ѹ�����");
		for(int i = 5;i >= 1;i--)
			list.insert(0,new Integer(i));
		System.out.println("list�Ƿ�Ϊ�գ� " + list.isEmpty() + " ���䳤��Ϊ��" + list.length());
		System.out.println("list:" + list.toString());
		list.append(new Integer(6));
		System.out.println("��list��������ֵΪ6��Ԫ��:" + list.toString());
		list.set(0, list.get(5));                             //��get()������ȡ����
		System.out.println("��list��0��Ԫ�ص���ֵ����Ϊ��5��Ԫ�ص���ֵ:" + list.toString());
		list.set(2, list.search(new Integer(5)));             //��search()������ȡ����
		System.out.println("��list��2��Ԫ�ص���ֵ����Ϊ5:" + list.toString());
		list.remove(5);
		System.out.println("ɾ��list��5��Ԫ��:" + list.toString());
		list.removeAll();
		System.out.println("list��Ԫ����ȫ��ɾ����" + list.toString() + " ���䳤��Ϊ��" + list.length());
	}
}
