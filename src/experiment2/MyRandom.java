package experiment2;

import java.util.Random;

public class MyRandom {
	public static int[] randomArray(SinglyLinkedList<Integer> list){
		//��ʼ��������Χ�Ĵ�ѡ����
		int n = list.length();
		int[] source = new int[n];
		for(int i = 0;i < n;i++)
			source[i] = list.get(i);
		
		int[] result = new int[source.length];
		Random random = new Random();
		int index = 0;
		for (int i = 0 ; i < result.length ; i++) {  
	           //��ѡ����0��(n-2)���һ���±�  
	           index = Math.abs(random.nextInt() % n--);  
	           //�������������������  
	           result[i] = source[index];  
	           //����ѡ�����б�������������ô�ѡ����(n-1)�±��Ӧ�����滻  
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
		System.out.println("ԭʼ�������:");
	    for (int i : reult) {  
	        System.out.print(i + "  ");  
	    }  
	    list.append(new Integer(11));
	    reult = randomArray(list);
	    System.out.println("\n��������11����������:");
	    for (int i : reult) {  
	        System.out.print(i + "  ");  
	    }  
	    list.remove(new Integer(8));
	    reult = randomArray(list);
	    System.out.println("\nɾ������8����������:");
	    for (int i : reult) {  
	        System.out.print(i + "  ");  
	    }  
	}
}
