package experiment3;

import experiment3.util.CirDoublyLinkedList;
import experiment3.util.QQueue;

public class CirDLinkedQueue<T> implements QQueue<T>{
    //使用循环双链表存储队列元素
	protected CirDoublyLinkedList<T> list;              
    
	//构造空队列
    public CirDLinkedQueue(){                             
        this.list = new CirDoublyLinkedList<T>(); 
    }
    
    //判断队列是否空，若空返回true
    public boolean isEmpty(){                          
        return list.isEmpty();
    }

    //元素x入队，空对象不能入队，若操作成功返回true
    public void enqueue(T x){                          
        list.append(x);            //在循环双链表最后插入x元素结点
    } 

    //出队，返回队头元素，若队列空返回null
    public T dequeue(){                               
        return list.remove(0);     //取得队头元素并删除队头结点，头删除
    } 

    //返回队列中各元素的字符串描述
    public String toString(){                          
        return list.toString();
    }
}
