package experiment2;

import experiment2.util.LList;
import experiment2.util.Node;

public class SinglyLinkedList<T> implements LList<T> {
	public Node<T> head;                     //头指针，指向单链表的头结点
	
	//默认构造方法，构造空单链表。创建头结点，data和next值均为null
	public SinglyLinkedList(){
		this.head = new Node<T>();
	}
	
	//判断单链表是否为空
	public boolean isEmpty() {
		return this.head.next == null;
	}

	//返回单链表长度
	public int length() {
		int i = 0;
		Node<T> p = this.head.next;
		while(p != null){
			i++;
			p = p.next;
		}
		return i;
	}

	//返回第i（i>=0）个元素，若i指定序号无效，返回null
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

	//设置第i（i>=0）个元素值为x，若i指定序号无效则抛出序号越界异常
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

	//将x对象插入在序号为i的结点前
	public void insert(int i, T x) {
		if(x == null)
			return;
		Node<T> p = this.head;
		for(int j = 0;p.next != null && j < i;j++)
			p = p.next;
		p.next = new Node<T>(x,p.next);
	}

	//在单链表最后添加对象
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
	}

	//删除序号为i的结点，若操作成功，则返回被删除的对象，否则返回null
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

	//删除单链表所有元素
	public void removeAll() {
		this.head.next = null;
	}

	//返回单链表所有元素的描述字符串
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
	
	public MyIterator<T> interator(){         //返回链表所用的迭代器
		return new MyIterator<T>(this);
	}
	
	/*
	 * 下列为新增的成员方法
	 * */
	
	//由指定数组中的多个对象构造单链表
	public SinglyLinkedList(T[] element){
		this();                                         
        Node<T> rear = this.head;                         
        for (int i = 0;i < element.length;i++){          
            rear.next = new Node<T>(element[i],null);       
            rear = rear.next;                           
        }
	}
	
	//以单链表list构造新的单链表，复制单链表
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
	
	//将指定单链表list链接在当前单链表之后
	public void concat(SinglyLinkedList<T> list){
		Node<T> rear = this.head.next;
		while(rear.next != null){
			rear = rear.next;
		}
		rear.next = list.head.next;
		list.head.next = null;
	}

	//顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回null
	public T search(T key){
        if (key == null)
            return null;
        for (Node<T> p = this.head.next;p != null;p = p.next)
            if (p.data.equals(key))
                return p.data;
        return null;
    }
	
	//以查找结果判断单链表是否包含指定元素key
    public boolean contain(T key){
        return this.search(key) != null;                    
    }

    //移去首次出现的指定元素key
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
            front.next = p.next;                     //头删除、中间/尾删除
    }
	
    //将首次出现的元素x替换为y
    public void replace(T x, T y){                          
        if (x != null && y != null)
            for (Node<T> p = this.head.next;  p != null;  p = p.next)
                if (p.data.equals(x)){
                    p.data = y;
                    return;
                }
    } 
    
	//比较两条单链表是否相等
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
