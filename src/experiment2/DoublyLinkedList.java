package experiment2;

import experiment2.util.DLinkNode;
import experiment2.util.LList;
import experiment2.util.Node;



public class DoublyLinkedList<T> implements LList<T> {
	
	public DLinkNode<T> head;                    //头指针

	//默认构造方法，构造空循环双链表
    public DoublyLinkedList(){                 
        this.head = new DLinkNode<T>();          //创建头结点，3个域值均为null
    }
    
    //判断双链表是否空
    public boolean isEmpty(){                     
        return this.head.next == null;
    }


    //返回双链表长度
	public int length() {
		int i = 0;
		DLinkNode<T> p = this.head.next;
		while(p != null){
			i++;
			p = p.next;
		}
		return i;
	}

	//返回第i（i>=0）个元素，若i指定序号无效，返回null
	public T get(int i) {
		if (i>=0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0;p != null && j < i;j++)
                p = p.next;
            if (p != null)
                return p.data;                             //p指向第i个结点
        }
        return null;  
	}

	//设置第i（≥0）个元素值为x。若i<0或大于表长则抛出序号越界异常；若x==null，不操作。
	public void set(int i, T x) {
		if (x == null)  
			return;                                           //不能设置元素为空对象
        DLinkNode<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        if (i >= 0 && p != null)
            p.data = x;                                      //p指向第i个结点
        else throw new IndexOutOfBoundsException(i + "");    //抛出序号越界异常
	}

	//将x对象插入在序号为i结点
	public void insert(int i, T x) {
		if (x == null)  
			return;                                          //不能插入空对象
        DLinkNode<T> p = this.head;
        for (int j = 0;p.next != null && j < i;j++)          //寻找插入位置
            p = p.next;                                      //循环停止时，p指向第i-1个结点
        DLinkNode<T> q = new DLinkNode<T>(x, p, p.next);     //插入在p结点之后，包括头插入、中间插入
        if(p.next != null)
        	p.next.prev = q;                                 //中间插入时执行
        p.next = q;
		
	}

	//在双链表最后添加对象
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
	}

	//删除第i（≥0）个元素，返回被删除对象。若i<0或i大于表长，不删除，返回null。
	public T remove(int i) {
		if (i >= 0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0;p != null && j < i;j++)             //定位到待删除结点
                p = p.next;
            T old = p.data;                                //获得原对象
            p.prev.next = p.next;                          //删除p结点自己
            if(p.next != null)
                p.next.prev = p.prev;
            return old;
            }
		return null;
	}

	//删除首次出现的关键字为key
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
	
	//删除双链表所有元素
	public void removeAll() {
		this.head.next = null;
	}

	//顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回null
	public T search(T key) {
		if (key == null)
            return null;
        for (DLinkNode<T> p = this.head.next;  p != null;  p = p.next)
            if (key.equals(p.data))
                return p.data;
        return null;
	}
	
	//返回双链表所有元素的描述字符串
	public String toString(){    
		String str = "(";
		DLinkNode<T> p = this.head.next;
		while(p != null){
			str += p.data.toString();
			if(p.next != null)
				str += ",";
			p = p.next;
		}
		return str + ")";                               //空表返回()
    }
}
