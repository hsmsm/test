package experiment2;

import experiment2.util.LList;
import experiment2.util.Node;

public class CircSinglyLinkedList<T> implements LList<T> {
	public Node<T> head;                                //头指针，指向循环单链表的头结点
	
	//默认构造方法，构造空循环单链表
	public CircSinglyLinkedList(){                      
        this.head = new Node<T>();                      //创建头结点
        this.head.next = this.head; 
    }
	
	//判断循环单链表是否空 	
	public boolean isEmpty() {
		return this.head.next == this.head;
	}

	//返回循环单链表长度
	public int length() {
		int i=0; 
        for (Node<T> p = this.head.next;p != this.head;p = p.next)
            i++;
        return i;
	}

	//返回第i（≥0）个元素，若i<0或大于表长则返回null
	public T get(int i) {
		if (i>=0)
        {
            Node<T> p=this.head.next;
            for (int j = 0;p != this.head && j<i;j++)
                p = p.next;
            if (p != this.head)
                return p.data;                             //p指向第i个结点
        }
        return null;                                       //当i<0或大于表长时
	}

	//设置第i（≥0）个元素值为x。若i<0或大于表长则抛出序号越界异常；若x==null，不操作。
	public void set(int i, T x) {
		if (x == null)  
			return;                                          //不能设置空对象
        Node<T> p = this.head.next;
        for (int j = 0;p != this.head && j<i;j++)
            p = p.next;
        if (i >= 0 && p != this.head)
            p.data = x;                                      //p指向第i个结点
        else throw new IndexOutOfBoundsException(i + "");    //抛出序号越界异常
	}

	//将x对象插入在序号为i的结点前
	public void insert(int i, T x) {
		if(x == null)
			return;
		Node<T> p = this.head;
		for(int j = 0;p.next != this.head && j < i;j++)
			p = p.next;
		p.next = new Node<T>(x,p.next);
	}

	//在循环单链表最后添加对象
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
	}

	//删除序号为i的结点，若操作成功，则返回被删除的对象，否则返回null
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

	//删除循环单链表所有元素
	public void removeAll() {
		this.head.next = this.head;
	}

	//顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回null
	public T search(T key) {
		if (key == null)
            return null;
        for (Node<T> p = this.head.next;p != this.head;p = p.next)
            if (p.data.equals(key))
                return p.data;
        return null;
	}

	//返回循环单链表所有元素的描述字符串
	public String toString(){
        String str = "(";
        Node<T> p = this.head.next;
        while(p != this.head){                         //遍历单链表的循环条件改变了
            str += p.data.toString();
            if(p.next != this.head) 
                str += ",";                           //不是最后一个结点时后加分隔符
            p = p.next;
        }
        return str + ")";                              //空表返回()
    }
}
