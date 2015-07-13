package experiment4;

import experiment4.util.ThreadNode;

public class ThreadBinaryTree<T>{                
    public ThreadNode<T> root;

    //�������������������
    public ThreadBinaryTree(){                   
        this.root = null;
    }

    //�ж����������������Ƿ��
    public boolean isEmpty(){                     
        return root == null;
    }

    //�Ա������������ȸ����й������������������������
    public ThreadBinaryTree(T[] prelist){         
        this.root = create(prelist);
        inorderThread(this.root);
    }
    
    //�Ա������������ȸ����д�������
    private int i=0;
    private ThreadNode<T> create(T[] prelist){
        ThreadNode<T> p = null;
        if (i<prelist.length){
            T elem = prelist[i++];
            if (elem != null){
                p = new ThreadNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }

    //������������p���Ϊ����������p��ǰ�������front
    private ThreadNode<T> front=null;
    private void inorderThread(ThreadNode<T> p){
        if (p != null){
            inorderThread(p.left);                  //����������p��������
            if (p.left == null){                    //��p��������Ϊ��
                p.ltag = 1;                         //�������������
                p.left = front;                     //����p.leftΪָ��ǰ��front������
            }
            if (p.right==null)                      //��p��������Ϊ��
                p.rtag = 1;                         //�������������
            if (front != null && front.rtag == 1) 
                front.right = p;                    //����ǰ��front.rightΪָ����p������
            front = p;
            inorderThread(p.right);                 //����������p��������
        }
    }
  
    //����p���и������µ�ǰ�����
    public ThreadNode<T> inPrev(ThreadNode<T> p){ 
        if (p.ltag == 1)                           //��������Ϊ��
            p = p.left;                            //p.left����ָ��pǰ����������
        else{                                      //���������ǿ�
            p = p.left;                            //����������
            while (p.rtag == 0)                    //�ҵ����ұߵ�������
                p = p.right;
        }
        return p;
    }

    //����p���и������µĺ�̽��
    public ThreadNode<T> inNext(ThreadNode<T> p){ 
        if (p.rtag == 1)                             //��������Ϊ��
            p = p.right;                             //p.right����ָ���̽�������
        else{
            p = p.right;                             //���������ǿգ�����������
            while (p.ltag == 0)                      //�ҵ�����ߵĺ�����
                p = p.left;
        }
        return p;
    }
    
    //�и�������������������������ǵݹ��㷨
    public void inOrder_prev(){                   
        System.out.print("�и������������ǰ������  ");
        ThreadNode<T> p = this.root;
        String str = "";
        while (p != null && p.rtag == 0)              //Ѱ�Ҹ������ұߵĺ�����
            p = p.right; 
        while (p != null){
            str = p.data.toString() + " " + str;
            p = inPrev(p);                            //����p���и������µ�ǰ�����
        }  
        System.out.println(str);
    }    
    
    //������Ϊ�����
    public void insertRoot(T x){                  
        if (this.root == null)
            this.root = new ThreadNode<T>(x, null,1, null,1);
        else{
            ThreadNode<T> p = this.root;
            while (p != null && p.rtag == 0)         //Ѱ��ԭ�������ұ�������p���������ʽ��
                p = p.right;
            this.root = new ThreadNode<T>(x, this.root,0, null,1);
            p.right = this.root;                   //�޸�p�ĺ������
        }
    }
    
    //����x��Ϊp���ĺ��ӽ�㣬��leftChildΪtrue���������ӣ���������Һ��ӣ����ز���ĺ��ӽ��
    public ThreadNode<T> insertChild(ThreadNode<T> p, T x, boolean leftChild){
        ThreadNode<T> q = null;
        if (leftChild){                            //��������
            q = new ThreadNode<T>(x, p.left, p.ltag, p,1);
            p.left = q;
            p.ltag = 0;
            if (q.ltag == 0){
                ThreadNode<T> pred = inPrev(q);    //prev��q���и������µ�ǰ��
                pred.right = q;                    //�޸�ǰ�����prev�ĺ������
            }
        }
        else{                                      //�����Һ���
            q = new ThreadNode<T>(x, p,1,p.right, p.rtag);
            p.right = q;
            p.rtag = 0;
            if (q.rtag == 0){
                ThreadNode<T> succ = inNext(q);    //succ��q���и������µĺ��
                succ.left = q;                     //�޸ĺ�̽��succ��ǰ������
            }
        }
        return q;
    }
    
}
