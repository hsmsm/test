package experiment3.util;

public class Node<T> {
	public T data;			   //�����򣬱�������Ԫ��
	public Node<T> next;	   //��ַ�����ú�̽��
	
	//�����㣬dataָ������Ԫ�أ�nextָ���������
	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
	
	public Node(){
		this(null,null);
	}
}
