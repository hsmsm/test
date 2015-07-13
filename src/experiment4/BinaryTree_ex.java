package experiment4;

import experiment4.util.BinaryNode;
import experiment4.util.BinaryTree;
import experiment4.util.LinkedQueue;
import experiment4.util.LinkedStack;


public class BinaryTree_ex<T extends Comparable<T>> extends BinaryTree<T> {
	//�Ա������������ȸ����й��������
	public BinaryTree_ex(T[] prelist){
		super(prelist);
	}
	
    //���ȸ����и����й��������
    public BinaryTree_ex(T[] prelist, T[] inlist){       
        this.root = create(prelist, inlist, 0, 0, prelist.length);
    }

    private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart, int inStart, int n){
        if (n <= 0)
            return null;
        T elem = prelist[preStart];                          //�����ֵ
        BinaryNode<T> p = new BinaryNode<T>(elem);           //����Ҷ�ӽ��
        int i = 0;
        while (i < n && !elem.equals(inlist[inStart+i]))     //���и������в��Ҹ�ֵ����λ��
            i++;
        p.left = create(prelist, inlist, preStart+1, inStart, i);             //����������
        p.right = create(prelist, inlist, preStart+i+1, inStart+i+1, n-1-i);  //����������
        return p;
    }
    
    //���췽�������
  	public BinaryTree_ex(BinaryTree<T> bitree){      
  	        this.root = copy(bitree.root);
  	}

  	//������p�����Ӷ������������½��Ӷ������ĸ����
  	private BinaryNode<T> copy(BinaryNode<T> p){
  		if (p == null)
  	    	return null;
  		BinaryNode<T> q = new BinaryNode<T>(p.data);
  		q.left = copy(p.left);                   //�������������ݹ����
  	    q.right = copy(p.right);                 //�������������ݹ����
  	    return q;                                //���ؽ��������ĸ����
  	}
  	 
	
	 //�������Ҷ�ӽ��
	 public void leaf(){                           
	 	leaf(root);
	 }
	 
	 //�����p���Ϊ��������������Ҷ�ӽ�㣬�ȸ���������㷨
	 public void leaf(BinaryNode<T> p){
		 if(p !=null){
			 if (p.isLeaf())   
				 System.out.print(p.data.toString() + " ");
			 leaf(p.left);
			 leaf(p.right);
	     }
	 }
	 
	 //���ض�������Ҷ�ӽ����
	 public int countLeaf(){                      
		 return countLeaf(root);
	 }
	 
     //������p���Ϊ����������Ҷ�ӽ�����
	 private int countLeaf(BinaryNode<T> p){       
	    if (p == null)
	        return 0;
	    if (p.isLeaf()) 
	        return 1;
	    return countLeaf(p.left) + countLeaf(p.right);
	 }
	 
	 //���ֵ����k�Ľ��
	 public void greaterThan(T k){
		 greaterThan(root,k);
	 }
	 
	 //�����p���Ϊ����������ֵ����k�Ľ��
	 public void greaterThan(BinaryNode<T> p,T k){
		 if(p !=null){
			 if (p.data.compareTo(k) > 0)   
				 System.out.print(p.data.toString() + " ");
			 greaterThan(p.left,k);
			 greaterThan(p.right,k);
	     }
	 }
	 
	 //��ÿ������������������������
	 public void exchange(){
		 exchange(root);
	 }
	 
	 //����p���Ϊ����������ÿ������������������������
	 public void exchange(BinaryNode<T> p){
		 if(p != null){
			 BinaryNode<T> item = p.left;
			 p.left = p.right;
			 p.right = item;
			 exchange(p.left);
			 exchange(p.right);
		 }		 
	 }
	 
	 //�Ƚ����ö������Ƿ���� 
	 public boolean equals(Object obj){             
	 	return obj == this || obj instanceof BinaryTree && equals(this.root, ((BinaryTree<T>)obj).root);
	 }
	    
	 //�ж���p��q���Ϊ�������������Ƿ���ȣ��ݹ鷽��
	 public boolean equals(BinaryNode<T> p, BinaryNode<T> q){
	 	return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
	               equals(p.left, q.left) && equals(p.right, q.right);
	 }
	 
	 //���ؽ�����ڲ�Σ���������δ���ҵ�x����-1
	 public int getLevel(T x){
	 	return getLevel(root, 1, x);                     //������Ĳ��Ϊ1
	  }
	 
	 //����p��㣨���Ϊi��Ϊ���������У���x������ڵĲ��
	 public int getLevel(BinaryNode<T> p, int i, T x){
	 	if (p == null)                                  //��������Ҳ��ɹ�
	 		return -1;
	 	if (p.data.equals(x)) 
	    	return i;                                   //���ҳɹ�
		int level = getLevel(p.left, i+1, x);           //������������
	    if (level == -1)
	    	level = getLevel(p.right, i+1, x);          //�������������в���
	    return level; 
	 }	 
	 
	 //�ж��Ƿ���ȫ������
	 public boolean isCompleteBinaryTree(){               
	    if (this.root == null)
	        return true;
	    LinkedQueue<BinaryNode<T>> que = new LinkedQueue<BinaryNode<T>>();
	    que.enqueue(root);                               //��������
	    BinaryNode<T> p = null;
	    while (!que.isEmpty()){
	        p = que.dequeue();                           //pָ����ӽ��
	        if (p.left != null ){                        //p�ķǿպ��ӽ�����
	            que.enqueue(p.left);
	            if (p.right != null)
	                que.enqueue(p.right);
	            else 									 //���ֿ�����������������Ƿ���Ҷ�ӽ��
	            	break;                              
	        }
	        else
	            if (p.right != null)  
	                return false;                        //p���������ն����������գ�ȷ������
	            else 									 //p��Ҷ�ӣ�����������Ƿ���Ҷ�ӽ��
	            	break;                               
	    }
	    while (!que.isEmpty()){                          //���������Ƿ���Ҷ�ӽ��
	        p = que.dequeue();
	        if (!p.isLeaf())                             //���ַ�Ҷ�ӣ�ȷ������
	            return false;
	    }
	    return true;
	 }
	 
	 //�����������������ķǵݹ��㷨
	 public void postOrderTraverse(){                       
		 System.out.print("�������������ǵݹ飩��  ");
		 LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
		 BinaryNode<T> p = this.root, front = null;
		 while (p != null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
	     	if (p != null){
	        	stack.push(p);                                //p�����ջ
	        	p = p.left;                                   //����������
	        }
	        else{                                             //pΪ����ջ�ǿ�ʱ
	        	p = stack.get();                              //������������p��㣬p��㲻��ջ
	        	if (p.right != null && p.right != front){     //p���Һ��ӣ����Һ���û�����ʹ�
	            	p = p.right;                              //����������
	            	stack.push(p);
	            	p = p.left;                               //������
	        	} 
	            else{
	            	p = stack.pop();                           //������������p��㣬p����ջ
	            	System.out.print(p.data + " ");
	            	front = p;                                 //front��p�ں�����������µ�ǰ�����
	            	p = null; 
	            }
	        }
	        System.out.println();
	    }    
   
}
