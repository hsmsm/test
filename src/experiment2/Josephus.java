package experiment2;

import experiment2.util.LList;

public class Josephus {
	public Josephus(LList<String> list, int number, int start, int distance){
		for (int i = 0;i < number;i++)
	    	list.append((char)('A' + i) + "");
	    System.out.print("约瑟夫环(" + number + "," + start + "," + distance + ")，");
	    System.out.println(list.toString());
		int i = start;                                        
	    while (list.length() > 1){ 
	    	i = (i + distance - 1) % list.length();
	        System.out.print("删除" + list.remove(i).toString() + "，");
	        System.out.println(list.toString());
	    }
	    System.out.println("被赦免者是" + list.get(0).toString());
	}
	
	public static void main(String args[]){
		System.out.println("---------使用单链表求解约瑟夫环问题---------");
		SinglyLinkedList<String> sList = new SinglyLinkedList<String>();
		new Josephus(sList,5,0,2);
		System.out.println("-------使用循环单链表求解约瑟夫环问题--------");
		CircSinglyLinkedList<String> csList = new CircSinglyLinkedList<String>();
		new Josephus(csList,5,0,2);
		System.out.println("---------使用双链表求解约瑟夫环问题---------");
		DoublyLinkedList<String> dsList = new DoublyLinkedList<String>();
		new Josephus(dsList,5,0,2);
	}
}
