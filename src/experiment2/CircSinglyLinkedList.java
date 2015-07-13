package experiment2;

import experiment2.util.LList;
import experiment2.util.Node;

public class CircSinglyLinkedList<T> implements LList<T> {
	public Node<T> head;                                //ͷָ�룬ָ��ѭ���������ͷ���
	
	//Ĭ�Ϲ��췽���������ѭ��������
	public CircSinglyLinkedList(){                      
        this.head = new Node<T>();                      //����ͷ���
        this.head.next = this.head; 
    }
	
	//�ж�ѭ���������Ƿ�� 	
	public boolean isEmpty() {
		return this.head.next == this.head;
	}

	//����ѭ����������
	public int length() {
		int i=0; 
        for (Node<T> p = this.head.next;p != this.head;p = p.next)
            i++;
        return i;
	}

	//���ص�i����0����Ԫ�أ���i<0����ڱ��򷵻�null
	public T get(int i) {
		if (i>=0)
        {
            Node<T> p=this.head.next;
            for (int j = 0;p != this.head && j<i;j++)
                p = p.next;
            if (p != this.head)
                return p.data;                             //pָ���i�����
        }
        return null;                                       //��i<0����ڱ�ʱ
	}

	//���õ�i����0����Ԫ��ֵΪx����i<0����ڱ����׳����Խ���쳣����x==null����������
	public void set(int i, T x) {
		if (x == null)  
			return;                                          //�������ÿն���
        Node<T> p = this.head.next;
        for (int j = 0;p != this.head && j<i;j++)
            p = p.next;
        if (i >= 0 && p != this.head)
            p.data = x;                                      //pָ���i�����
        else throw new IndexOutOfBoundsException(i + "");    //�׳����Խ���쳣
	}

	//��x������������Ϊi�Ľ��ǰ
	public void insert(int i, T x) {
		if(x == null)
			return;
		Node<T> p = this.head;
		for(int j = 0;p.next != this.head && j < i;j++)
			p = p.next;
		p.next = new Node<T>(x,p.next);
	}

	//��ѭ�������������Ӷ���
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
	}

	//ɾ�����Ϊi�Ľ�㣬�������ɹ����򷵻ر�ɾ���Ķ��󣬷��򷵻�null
	public T remove(int i) {
		if(i >= 0){
			Node<T> p = this.head;
			for(int j = 0;p.next != this.head && j < i;j++)
				p = p.next;
			if(p.next != this.head){
				T old = p.next.data;
				p.next = p.next.next;
				return old;
			}
		}
		return null;
	}

	//ɾ��ѭ������������Ԫ��
	public void removeAll() {
		this.head.next = this.head;
	}

	//˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
	public T search(T key) {
		if (key == null)
            return null;
        for (Node<T> p = this.head.next;p != this.head;p = p.next)
            if (p.data.equals(key))
                return p.data;
        return null;
	}

	//����ѭ������������Ԫ�ص������ַ���
	public String toString(){
        String str = "(";
        Node<T> p = this.head.next;
        while(p != this.head){                         //�����������ѭ�������ı���
            str += p.data.toString();
            if(p.next != this.head) 
                str += ",";                           //�������һ�����ʱ��ӷָ���
            p = p.next;
        }
        return str + ")";                              //�ձ���()
    }
}
