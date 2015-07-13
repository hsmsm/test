package experiment2;

import java.util.Random;

public class MyRandom {
	public static int[] randomArray(SinglyLinkedList<Integer> list){
		//初始化给定范围的待选数组
		int n = list.length();
		int[] source = new int[n];
		for(int i = 0;i < n;i++)
			source[i] = list.get(i);
		
		int[] result = new int[source.length];
		Random random = new Random();
		int index = 0;
		for (int i = 0 ; i < result.length ; i++) {  
	           //待选数组0到(n-2)随机一个下标  
	           index = Math.abs(random.nextInt() % n--);  
	           //将随机到的数放入结果集  
	           result[i] = source[index];  
	           //将待选数组中被随机到的数，用待选数组(n-1)下标对应的数替换  
	           source[index] = source[n];  
	       }  
		return result;
	}
	
	public static void main(String[] args){
		Integer[] element = new Integer[10];
		for(int i = 0 ; i < element.length ; i++)
			element[i] = new Integer(i + 1);
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(element);
		int[] reult = randomArray(list);  
		System.out.println("原始随机序列:");
	    for (int i : reult) {  
	        System.out.print(i + "  ");  
	    }  
	    list.append(new Integer(11));
	    reult = randomArray(list);
	    System.out.println("\n增加序列11后的随机序列:");
	    for (int i : reult) {  
	        System.out.print(i + "  ");  
	    }  
	    list.remove(new Integer(8));
	    reult = randomArray(list);
	    System.out.println("\n删除序列8后的随机序列:");
	    for (int i : reult) {  
	        System.out.print(i + "  ");  
	    }  
	}
}
