package experiment2;

import experiment2.util.DLinkNode;
import experiment2.util.LList;
import experiment2.util.Node;



public class DoublyLinkedList<T> implements LList<T> {
	
	public DLinkNode<T> head;                    //ͷָ��

	//Ĭ�Ϲ��췽���������ѭ��˫����
    public DoublyLinkedList(){                 
        this.head = new DLinkNode<T>();          //����ͷ��㣬3����ֵ��Ϊnull
    }
    
    //�ж�˫�����Ƿ��
    public boolean isEmpty(){                     
        return this.head.next == null;
    }


    //����˫������
	public int length() {
		int i = 0;
		DLinkNode<T> p = this.head.next;
		while(p != null){
			i++;
			p = p.next;
		}
		return i;
	}

	//���ص�i��i>=0����Ԫ�أ���iָ�������Ч������null
	public T get(int i) {
		if (i>=0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0;p != null && j < i;j++)
                p = p.next;
            if (p != null)
                return p.data;                             //pָ���i�����
        }
        return null;  
	}

	//���õ�i����0����Ԫ��ֵΪx����i<0����ڱ����׳����Խ���쳣����x==null����������
	public void set(int i, T x) {
		if (x == null)  
			return;                                           //��������Ԫ��Ϊ�ն���
        DLinkNode<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        if (i >= 0 && p != null)
            p.data = x;                                      //pָ���i�����
        else throw new IndexOutOfBoundsException(i + "");    //�׳����Խ���쳣
	}

	//��x������������Ϊi���
	public void insert(int i, T x) {
		if (x == null)  
			return;                                          //���ܲ���ն���
        DLinkNode<T> p = this.head;
        for (int j = 0;p.next != null && j < i;j++)          //Ѱ�Ҳ���λ��
            p = p.next;                                      //ѭ��ֹͣʱ��pָ���i-1�����
        DLinkNode<T> q = new DLinkNode<T>(x, p, p.next);     //������p���֮�󣬰���ͷ���롢�м����
        if(p.next != null)
        	p.next.prev = q;                                 //�м����ʱִ��
        p.next = q;
		
	}

	//��˫���������Ӷ���
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
	}

	//ɾ����i����0����Ԫ�أ����ر�ɾ��������i<0��i���ڱ�����ɾ��������null��
	public T remove(int i) {
		if (i >= 0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0;p != null && j < i;j++)             //��λ����ɾ�����
                p = p.next;
            T old = p.data;                                //���ԭ����
            p.prev.next = p.next;                          //ɾ��p����Լ�
            if(p.next != null)
                p.next.prev = p.prev;
            return old;
            }
		return null;
	}

	//ɾ���״γ��ֵĹؼ���Ϊkey
	public void remove(T key){
        if (key == null)
            return;
        DLinkNode<T> front = this.head;
        DLinkNode<T> p = front.next;
        while (p != null && !p.data.equals(key)){
            front = p;
            p = p.next;
        }
        front.next = p.next;        
        if (p.next != null)
        	p.next.prev = front;
    }
	
	//ɾ��˫��������Ԫ��
	public void removeAll() {
		this.head.next = null;
	}

	//˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
	public T search(T key) {
		if (key == null)
            return null;
        for (DLinkNode<T> p = this.head.next;  p != null;  p = p.next)
            if (key.equals(p.data))
                return p.data;
        return null;
	}
	
	//����˫��������Ԫ�ص������ַ���
	public String toString(){    
		String str = "(";
		DLinkNode<T> p = this.head.next;
		while(p != null){
			str += p.data.toString();
			if(p.next != null)
				str += ",";
			p = p.next;
		}
		return str + ")";                               //�ձ���()
    }
}
