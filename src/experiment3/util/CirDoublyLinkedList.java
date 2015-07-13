package experiment3.util;

public class CirDoublyLinkedList<T>implements LList<T>{
	public DLinkNode<T> head;                    //ͷָ��

    //Ĭ�Ϲ��췽���������ѭ��˫����
    public CirDoublyLinkedList(){                 
        this.head = new DLinkNode<T>();          //����ͷ��㣬3����ֵ��Ϊnull
        this.head.prev = head;
        this.head.next = head;
    }
    
    //�ж�ѭ��˫�����Ƿ��
    public boolean isEmpty(){                     
        return head.next == head;
    }
    
    //����ѭ��˫������
    public int length(){                                    
        int i = 0; 
        for (DLinkNode<T> p = this.head.next;  p != this.head;  p = p.next)
            i++;
        return i;
    }   
    
    
    //���ص�i����0����Ԫ�أ���i<0����ڱ��򷵻�null
    public T get(int i){                          
        if (i >= 0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0; p != null && j < i; j++)
                p = p.next;
            if (p != null)
                return p.data;                    //pָ���i�����
        }
        return null;                              //��i<0����ڱ�ʱ
    }
    
    //���õ�i����0����Ԫ��ֵΪx����i<0����ڱ����׳����Խ���쳣����x==null��������
    public void set(int i, T x){
        if (x == null)  
        	return;                                        //��������Ԫ��Ϊ�ն���
        DLinkNode<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++)
            p = p.next;
        if (i >= 0 && p != null)
            p.data = x;                                    //pָ���i�����
        else 
        	throw new IndexOutOfBoundsException(i + "");   //�׳����Խ���쳣
    }
    
    //��x������������Ϊi���
    public void insert(int i, T x){                         
        if (x == null)  
        	return;                                              //���ܲ���ն���
        DLinkNode<T> p = this.head;
        for (int j = 0; p.next != this.head && j < i; j++)       //Ѱ�Ҳ���λ��
            p = p.next;                                          //ѭ��ֹͣʱ��pָ���i-1�����
        DLinkNode<T> q = new DLinkNode<T>(x, p, p.next);         //������p���֮�󣬰���ͷ���롢�м����
        p.next.prev = q;
        p.next = q;
    }
    
    //��ѭ��˫���������ӽ��
    public void append(T x){                                
        if (x == null)  
        	return;                                        //������ӿն���
        DLinkNode<T> q = new DLinkNode<T>(x, head.prev, head); 
        head.prev.next = q;                                //������ͷ���֮ǰ���൱��β����
        head.prev = q;
    }
    
    //ɾ����i����0����Ԫ�أ����ر�ɾ��������i<0��i���ڱ�����ɾ��������null
    public T remove(int i){
        if (i>=0){
            DLinkNode<T> p = this.head.next;
            for (int j = 0; p != head && j < i; j++)             //��λ����ɾ�����
                p = p.next;
            if (p != head){
                T old = p.data;                            //���ԭ����
                p.prev.next = p.next;                      //ɾ��p����Լ�
                p.next.prev = p.prev;
                return old;
            }
        }
        return null;                                       //��i<0����ڱ�ʱ
    }
    
    //ɾ��ѭ��˫��������Ԫ��
    public void removeAll(){                               
        this.head.prev = head;
        this.head.next = head;
    }
    
    //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
    public T search(T key){ 
        if (key == null)
            return null;
        for (DLinkNode<T> p = this.head.next;  p != this.head;  p = p.next)
            if (key.equals(p.data))
                return p.data;
        return null;
    }
    
    //����ѭ��˫��������Ԫ�ص������ַ�����ѭ��˫��������㷨
    public String toString(){    
        String str = "(";
        for(DLinkNode<T> p = this.head.next;  p != this.head;  p = p.next){
            str += p.data.toString();
            if (p.next != this.head) 
                str += ",";
        }
        return str+")";                               //�ձ���()
    }
}
