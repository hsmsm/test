package experiment2.test;

import experiment2.DoublyLinkedList;

public class TestDoublyLinkedLis {
	
	public static void main(String[] args){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		System.out.println("双链表已构建：");
		for(int i = 5;i >= 1;i--)
			list.insert(0,new Integer(i));
		System.out.println("list是否为空？ " + list.isEmpty() + " ，其长度为：" + list.length());
		System.out.println("list:" + list.toString());
		list.append(new Integer(6));
		System.out.println("在list最后添加数值为6的元素:" + list.toString());
		list.set(0, list.get(5));                             //用get()方法获取对象
		System.out.println("在list第0个元素的数值设置为第5个元素的数值:" + list.toString());
		list.set(2, list.search(new Integer(5)));             //用search()方法获取对象
		System.out.println("在list第2个元素的数值设置为5:" + list.toString());
		list.remove(5);
		System.out.println("删除list第5个元素:" + list.toString());
		list.removeAll();
		System.out.println("list中元素已全部删除：" + list.toString() + " ，其长度为：" + list.length());
	}
}
