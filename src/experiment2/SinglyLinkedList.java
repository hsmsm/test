package experiment2;

import experiment2.util.LList;
import experiment2.util.Node;

public class SinglyLinkedList<T> implements LList<T> {
	public Node<T> head;                     //ͷָ�룬ָ�������ͷ���
	
	//Ĭ�Ϲ��췽��������յ���������ͷ��㣬data��nextֵ��Ϊnull
	public SinglyLinkedList(){
		this.head = new Node<T>();
	}
	
	//�жϵ������Ƿ�Ϊ��
	public boolean isEmpty() {
		return this.head.next == null;
	}

	//���ص�������
	public int length() {
		int i = 0;
		Node<T> p = this.head.next;
		while(p != null){
			i++;
			p = p.next;
		}
		return i;
	}

	//���ص�i��i>=0����Ԫ�أ���iָ�������Ч������null
	public T get(int i) {
		if(i >= 0){
			Node<T> p = this.head.next;
			for(int j = 0;p != null && j < i;j++)
				p = p.next;
			if(p != null)
				return p.data;
		}
		return null;
	}

	//���õ�i��i>=0����Ԫ��ֵΪx����iָ�������Ч���׳����Խ���쳣
	public void set(int i, T x) {
		if(x == null)
			return;
		if(i >= 0){
			Node<T> p = this.head.next;
			for(int j = 0;p != null && j < i;j++)
				p = p.next;
			if(p != null)
				p.data = x;
		}
		else
			throw new IndexOutOfBoundsException(i + "");
	}

	//��x������������Ϊi�Ľ��ǰ
	public void insert(int i, T x) {
		if(x == null)
			return;
		Node<T> p = this.head;
		for(int j = 0;p.next != null && j < i;j++)
			p = p.next;
		p.next = new Node<T>(x,p.next);
	}

	//�ڵ����������Ӷ���
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
	}

	//ɾ�����Ϊi�Ľ�㣬�������ɹ����򷵻ر�ɾ���Ķ��󣬷��򷵻�null
	public T remove(int i) {
		if(i >= 0){
			Node<T> p = this.head;
			for(int j = 0;p.next != null && j < i;j++)
				p = p.next;
			if(p.next != null){
				T old = p.next.data;
				p.next = p.next.next;
				return old;
			}
		}
		return null;
	}

	//ɾ������������Ԫ��
	public void removeAll() {
		this.head.next = null;
	}

	//���ص���������Ԫ�ص������ַ���
	public String toString(){
		String str = "(";
		Node<T> p = this.head.next;
		while(p != null){
			str += p.data.toString();
			if(p.next != null)
				str += ",";
			p = p.next;
		}
		return str + ")";
	}
	
	public MyIterator<T> interator(){         //�����������õĵ�����
		return new MyIterator<T>(this);
	}
	
	/*
	 * ����Ϊ�����ĳ�Ա����
	 * */
	
	//��ָ�������еĶ�������쵥����
	public SinglyLinkedList(T[] element){
		this();                                         
        Node<T> rear = this.head;                         
        for (int i = 0;i < element.length;i++){          
            rear.next = new Node<T>(element[i],null);       
            rear = rear.next;                           
        }
	}
	
	//�Ե�����list�����µĵ��������Ƶ�����
	public SinglyLinkedList(SinglyLinkedList<T> list){
		this();
		Node<T> p = list.head.next;
		Node<T> rear = this.head;
	    while(p != null){
	    	rear.next = new Node<T>(p.data,null);
	    	rear = rear.next;
	    	p = p.next;
	    }
	}
	
	//��ָ��������list�����ڵ�ǰ������֮��
	public void concat(SinglyLinkedList<T> list){
		Node<T> rear = this.head.next;
		while(rear.next != null){
			rear = rear.next;
		}
		rear.next = list.head.next;
		list.head.next = null;
	}

	//˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
	public T search(T key){
        if (key == null)
            return null;
        for (Node<T> p = this.head.next;p != null;p = p.next)
            if (p.data.equals(key))
                return p.data;
        return null;
    }
	
	//�Բ��ҽ���жϵ������Ƿ����ָ��Ԫ��key
    public boolean contain(T key){
        return this.search(key) != null;                    
    }

    //��ȥ�״γ��ֵ�ָ��Ԫ��key
    public void remove(T key){
        if (key == null)
            return;
        Node<T> front = this.head;
        Node<T> p = front.next;
        while (p != null && !p.data.equals(key)){
            front = p;
            p = p.next;
        }
        if (p != null)
            front.next = p.next;                     //ͷɾ�����м�/βɾ��
    }
	
    //���״γ��ֵ�Ԫ��x�滻Ϊy
    public void replace(T x, T y){                          
        if (x != null && y != null)
            for (Node<T> p = this.head.next;  p != null;  p = p.next)
                if (p.data.equals(x)){
                    p.data = y;
                    return;
                }
    } 
    
	//�Ƚ������������Ƿ����
	public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (!(obj instanceof SinglyLinkedList))
            return false;
        Node<T> p = this.head.next;
        Node<T> q = ((SinglyLinkedList<T>)obj).head.next;
        while (p != null && q != null && p.data.equals(q.data)){
            p = p.next;
            q = q.next;
        }
        return p == null && q == null;
    }
}
