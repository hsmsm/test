package experiment3;

import experiment3.util.CirDoublyLinkedList;
import experiment3.util.QQueue;

public class CirDLinkedQueue<T> implements QQueue<T>{
    //ʹ��ѭ��˫����洢����Ԫ��
	protected CirDoublyLinkedList<T> list;              
    
	//����ն���
    public CirDLinkedQueue(){                             
        this.list = new CirDoublyLinkedList<T>(); 
    }
    
    //�ж϶����Ƿ�գ����շ���true
    public boolean isEmpty(){                          
        return list.isEmpty();
    }

    //Ԫ��x��ӣ��ն�������ӣ��������ɹ�����true
    public void enqueue(T x){                          
        list.append(x);            //��ѭ��˫����������xԪ�ؽ��
    } 

    //���ӣ����ض�ͷԪ�أ������пշ���null
    public T dequeue(){                               
        return list.remove(0);     //ȡ�ö�ͷԪ�ز�ɾ����ͷ��㣬ͷɾ��
    } 

    //���ض����и�Ԫ�ص��ַ�������
    public String toString(){                          
        return list.toString();
    }
}
