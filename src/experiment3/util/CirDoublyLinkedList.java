package experiment3.util;

public class CirDoublyLinkedList<T>implements LList<T>{
	public DLinkNode<T> head;                    //头指针

    //默认构造方法，构造空循环双链表
    public CirDoublyLinkedList(){                 
        this.head = new DLinkNode<T>();          //创建头结点，3个域值均为null
        this.head.prev = head;
        this.head.next = head;
    }
    
    //判断循环双链表是否空
    public boolean isEmpty(){                     
        return head.next == head;
    }
    
    //返回循环双链表长度
    public int length(){                                    
        int i = 0; 
        for (DLinkNode<T> p = this.head.next;  p != this.head;  p = p.next)
            i++;
        return i;
    }   
    
    
    //返回第i（≥0）个元素，若i<0或大于表长则返回null
    public T get(int i){                          
        if (i >= 0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0; p != null && j < i; j++)
                p = p.next;
            if (p != null)
                return p.data;                    //p指向第i个结点
        }
        return null;                              //当i<0或大于表长时
    }
    
    //设置第i（≥0）个元素值为x。若i<0或大于表长则抛出序号越界异常；若x==null，不操作
    public void set(int i, T x){
        if (x == null)  
        	return;                                        //不能设置元素为空对象
        DLinkNode<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        if (i >= 0 && p != null)
            p.data = x;                                    //p指向第i个结点
        else 
        	throw new IndexOutOfBoundsException(i + "");   //抛出序号越界异常
    }
    
    //将x对象插入在序号为i结点
    public void insert(int i, T x){                         
        if (x == null)  
        	return;                                              //不能插入空对象
        DLinkNode<T> p = this.head;
        for (int j = 0; p.next != this.head && j < i; j++)       //寻找插入位置
            p = p.next;                                          //循环停止时，p指向第i-1个结点
        DLinkNode<T> q = new DLinkNode<T>(x, p, p.next);         //插入在p结点之后，包括头插入、中间插入
        p.next.prev = q;
        p.next = q;
    }
    
    //在循环双链表最后添加结点
    public void append(T x){                                
        if (x == null)  
        	return;                                        //不能添加空对象
        DLinkNode<T> q = new DLinkNode<T>(x, head.prev, head); 
        head.prev.next = q;                                //插入在头结点之前，相当于尾插入
        head.prev = q;
    }
    
    //删除第i（≥0）个元素，返回被删除对象。若i<0或i大于表长，不删除，返回null
    public T remove(int i){
        if (i>=0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0; p != head && j < i; j++)             //定位到待删除结点
                p = p.next;
            if (p != head){
                T old = p.data;                            //获得原对象
                p.prev.next = p.next;                      //删除p结点自己
                p.next.prev = p.prev;
                return old;
            }
        }
        return null;                                       //当i<0或大于表长时
    }
    
    //删除循环双链表所有元素
    public void removeAll(){                               
        this.head.prev = head;
        this.head.next = head;
    }
    
    //顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回null
    public T search(T key){ 
        if (key == null)
            return null;
        for (DLinkNode<T> p = this.head.next;  p != this.head;  p = p.next)
            if (key.equals(p.data))
                return p.data;
        return null;
    }
    
    //返回循环双链表所有元素的描述字符串，循环双链表遍历算法
    public String toString(){    
        String str = "(";
        for(DLinkNode<T> p = this.head.next;  p != this.head;  p = p.next){
            str += p.data.toString();
            if (p.next != this.head) 
                str += ",";
        }
        return str+")";                               //空表返回()
    }
}
