package experiment2;

import experiment2.util.DLinkNode;

public class SortedDoublyLinkedList <T extends Comparable<T>> extends DoublyLinkedList<T>{
	public SortedDoublyLinkedList(){
		   super();
	   }
	   
	   //构造方法，将element数组中所有对象插入构造排序的顺序表，直接插入排序
	   public SortedDoublyLinkedList(T[] element){
		   super();
		   if(element != null)
			   for(int i = 0;i < element.length;i++)
				   this.insert(element[i]);
	   }
	   
	   
	   //覆盖父类的set()方法，设置第i(i>=0)个元素值为x，若x不按顺序则抛出错误参数异常
	   public void set(int i,T x){
		   if(x == null)
			   return;
		   if(this.get(i-1).compareTo(x) <= 0 && this.get(i+1).compareTo(x) >= 0)
			   super.set(i,x);
		   else 
			   throw new IllegalArgumentException("Wrong Argument");
	   }
	   
	   //重载insert()方法,插入元素x到顺序表中
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
	   
	   //插入x作为第i个元素，本类不支持该方法
	   public void insert(int i,T x){
		   throw new UnsupportedOperationException("insert(int i,T x)");
	   }     
	   
	   //在线性表最后插入x元素，本类不支持该方法
	   public void append(T x){
		   throw new UnsupportedOperationException("append(T x)");
	   }  


}
