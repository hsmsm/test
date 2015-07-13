package experiment3.util;

public class Node<T> {
	public T data;			   //数据域，保存数据元素
	public Node<T> next;	   //地址域，引用后继结点
	
	//构造结点，data指定数据元素，next指定后续结点
	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
	
	public Node(){
		this(null,null);
	}
}
