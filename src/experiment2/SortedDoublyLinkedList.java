package experiment2;

import experiment2.util.DLinkNode;

public class SortedDoublyLinkedList <T extends Comparable<T>> extends DoublyLinkedList<T>{
	public SortedDoublyLinkedList(){
		   super();
	   }
	   
	   //���췽������element���������ж�����빹�������˳���ֱ�Ӳ�������
	   public SortedDoublyLinkedList(T[] element){
		   super();
		   if(element != null)
			   for(int i = 0;i < element.length;i++)
				   this.insert(element[i]);
	   }
	   
	   
	   //���Ǹ����set()���������õ�i(i>=0)��Ԫ��ֵΪx����x����˳�����׳���������쳣
	   public void set(int i,T x){
		   if(x == null)
			   return;
		   if(this.get(i-1).compareTo(x) <= 0 && this.get(i+1).compareTo(x) >= 0)
			   super.set(i,x);
		   else 
			   throw new IllegalArgumentException("Wrong Argument");
	   }
	   
	   //����insert()����,����Ԫ��x��˳�����
	   public void insert(T x){
		   if(x == null)
			   return;
		   DLinkNode<T> front = this.head,p = front.next;
		   while(p != null && p.data.compareTo(x) < 0){
			   front = p;
			   p = p.next;
		   }
		   DLinkNode<T> q = new DLinkNode<T>(x,front,p);
		   if(p != null)
			   p.prev = q;
		   front.next = q;
	   }
	   
	   //����x��Ϊ��i��Ԫ�أ����಻֧�ָ÷���
	   public void insert(int i,T x){
		   throw new UnsupportedOperationException("insert(int i,T x)");
	   }     
	   
	   //�����Ա�������xԪ�أ����಻֧�ָ÷���
	   public void append(T x){
		   throw new UnsupportedOperationException("append(T x)");
	   }  


}
