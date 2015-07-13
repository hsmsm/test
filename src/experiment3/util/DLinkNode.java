package experiment3.util;

public class DLinkNode<T>{
	public T data;                       //����Ԫ��
    public DLinkNode<T> prev, next;     //prevָ��ǰ����㣬nextָ���̽��

    //�����㣬dataָ��Ԫ�أ�prevָ��ǰ����㣬nextָ���̽��
    public DLinkNode(T data, DLinkNode<T> prev, DLinkNode<T> next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    
    public DLinkNode(){
        this(null, null, null);
    }

}
