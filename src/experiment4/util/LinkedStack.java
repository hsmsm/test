package experiment4.util;

public class LinkedStack <T> implements SStack<T>{         
    private Node<T> top;                                   //ջ�����
    
    //�����ջ
    public LinkedStack(){                                   
        this.top = null; 
    }
    
    //�ж�ջ�Ƿ�գ����շ���true
    public boolean isEmpty(){                             
        return this.top == null;
    }
    
    //Ԫ��x��ջ���ն�������ջ
    public void push(T x){                                  
        if (x != null)
            this.top = new Node<T>(x, this.top);              //ͷ���룬x�����Ϊ�µ�ջ�����
    } 
    
    //��ջ������ջ��Ԫ�أ���ջ�շ���null
    public T pop(){
        if (this.top == null)
            return null;
        T temp = this.top.data;                            //ȡջ�����Ԫ��
        this.top = this.top.next;                          //ɾ��ջ�����
        return temp;
    }
    
    //ȡջ��Ԫ�أ�δ��ջ����ջ�շ���null
    public T get(){
        return this.top == null ? null : this.top.data;
    }
    
    //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)�����㷨ͬ����ͷ���ĵ�����
    public String toString(){
        String str = "(";
        for (Node<T> p = this.top;  p != null;  p = p.next){ 
        	str += p.data.toString();
            if (p.next != null) 
                str += ", ";                               //�������һ�����ʱ��ӷָ���
        }
        return str + ")";                                    //�ձ���()
    }
}

