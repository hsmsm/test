package experiment3.test;

import experiment3.CirDLinkedQueue;

public class TestCirDLinkedQueue {

	public static void main(String[] args) {
		CirDLinkedQueue<Integer> queue = new CirDLinkedQueue<Integer>();
		System.out.println("创建队列,1~5依次入队：\n" + queue.toString());
		for(int i = 1;i <= 5;i++){
			queue.enqueue(new Integer(i));
			System.out.println(queue.toString());
		}
		System.out.println("队列元素出队：\n" + queue.toString());
		for(int i = 1;i <= 5;i++){
			queue.dequeue();
			System.out.println(queue.toString());
		}
	}

}
