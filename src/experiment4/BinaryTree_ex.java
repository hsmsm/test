package experiment4;

import experiment4.util.BinaryNode;
import experiment4.util.BinaryTree;
import experiment4.util.LinkedQueue;
import experiment4.util.LinkedStack;


public class BinaryTree_ex<T extends Comparable<T>> extends BinaryTree<T> {
	//以标明空子树的先根序列构造二叉树
	public BinaryTree_ex(T[] prelist){
		super(prelist);
	}
	
    //以先根和中根序列构造二叉树
    public BinaryTree_ex(T[] prelist, T[] inlist){       
        this.root = create(prelist, inlist, 0, 0, prelist.length);
    }

    private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart, int inStart, int n){
        if (n <= 0)
            return null;
        T elem = prelist[preStart];                          //根结点值
        BinaryNode<T> p = new BinaryNode<T>(elem);           //创建叶子结点
        int i = 0;
        while (i < n && !elem.equals(inlist[inStart+i]))     //在中根序列中查找根值所在位置
            i++;
        p.left = create(prelist, inlist, preStart+1, inStart, i);             //创建左子树
        p.right = create(prelist, inlist, preStart+i+1, inStart+i+1, n-1-i);  //创建右子树
        return p;
    }
    
    //构造方法，深拷贝
  	public BinaryTree_ex(BinaryTree<T> bitree){      
  	        this.root = copy(bitree.root);
  	}

  	//复制以p根的子二叉树，返回新建子二叉树的根结点
  	private BinaryNode<T> copy(BinaryNode<T> p){
  		if (p == null)
  	    	return null;
  		BinaryNode<T> q = new BinaryNode<T>(p.data);
  		q.left = copy(p.left);                   //复制左子树，递归调用
  	    q.right = copy(p.right);                 //复制右子树，递归调用
  	    return q;                                //返回建立子树的根结点
  	}
  	 
	
	 //遍历输出叶子结点
	 public void leaf(){                           
	 	leaf(root);
	 }
	 
	 //输出以p结点为根的子树的所有叶子结点，先根次序遍历算法
	 public void leaf(BinaryNode<T> p){
		 if(p !=null){
			 if (p.isLeaf())   
				 System.out.print(p.data.toString() + " ");
			 leaf(p.left);
			 leaf(p.right);
	     }
	 }
	 
	 //返回二叉树的叶子结点数
	 public int countLeaf(){                      
		 return countLeaf(root);
	 }
	 
     //返回以p结点为根的子树的叶子结点个数
	 private int countLeaf(BinaryNode<T> p){       
	    if (p == null)
	        return 0;
	    if (p.isLeaf()) 
	        return 1;
	    return countLeaf(p.left) + countLeaf(p.right);
	 }
	 
	 //输出值大于k的结点
	 public void greaterThan(T k){
		 greaterThan(root,k);
	 }
	 
	 //输出以p结点为根的子树中值大于k的结点
	 public void greaterThan(BinaryNode<T> p,T k){
		 if(p !=null){
			 if (p.data.compareTo(k) > 0)   
				 System.out.print(p.data.toString() + " ");
			 greaterThan(p.left,k);
			 greaterThan(p.right,k);
	     }
	 }
	 
	 //将每个结点的左子树与右子树交换
	 public void exchange(){
		 exchange(root);
	 }
	 
	 //将以p结点为根的子树的每个结点的左子树与右子树交换
	 public void exchange(BinaryNode<T> p){
		 if(p != null){
			 BinaryNode<T> item = p.left;
			 p.left = p.right;
			 p.right = item;
			 exchange(p.left);
			 exchange(p.right);
		 }		 
	 }
	 
	 //比较两棵二叉树是否相等 
	 public boolean equals(Object obj){             
	 	return obj == this || obj instanceof BinaryTree && equals(this.root, ((BinaryTree<T>)obj).root);
	 }
	    
	 //判断以p和q结点为根的两棵子树是否相等，递归方法
	 public boolean equals(BinaryNode<T> p, BinaryNode<T> q){
	 	return p==null && q==null || p!=null && q!=null && p.data.equals(q.data) &&
	               equals(p.left, q.left) && equals(p.right, q.right);
	 }
	 
	 //返回结点所在层次，若空树或未查找到x返回-1
	 public int getLevel(T x){
	 	return getLevel(root, 1, x);                     //令根结点的层次为1
	  }
	 
	 //在以p结点（层次为i）为根的子树中，求x结点所在的层次
	 public int getLevel(BinaryNode<T> p, int i, T x){
	 	if (p == null)                                  //空树或查找不成功
	 		return -1;
	 	if (p.data.equals(x)) 
	    	return i;                                   //查找成功
		int level = getLevel(p.left, i+1, x);           //在左子树查找
	    if (level == -1)
	    	level = getLevel(p.right, i+1, x);          //继续在右子树中查找
	    return level; 
	 }	 
	 
	 //判断是否完全二叉树
	 public boolean isCompleteBinaryTree(){               
	    if (this.root == null)
	        return true;
	    LinkedQueue<BinaryNode<T>> que = new LinkedQueue<BinaryNode<T>>();
	    que.enqueue(root);                               //根结点入队
	    BinaryNode<T> p = null;
	    while (!que.isEmpty()){
	        p = que.dequeue();                           //p指向出队结点
	        if (p.left != null ){                        //p的非空孩子结点入队
	            que.enqueue(p.left);
	            if (p.right != null)
	                que.enqueue(p.right);
	            else 									 //发现空子树，须检测队列中是否都是叶子结点
	            	break;                              
	        }
	        else
	            if (p.right != null)  
	                return false;                        //p的左子树空而右子树不空，确定不是
	            else 									 //p是叶子，须检测队列中是否都是叶子结点
	            	break;                               
	    }
	    while (!que.isEmpty()){                          //检测队列中是否都是叶子结点
	        p = que.dequeue();
	        if (!p.isLeaf())                             //发现非叶子，确定不是
	            return false;
	    }
	    return true;
	 }
	 
	 //后根次序遍历二叉树的非递归算法
	 public void postOrderTraverse(){                       
		 System.out.print("后根次序遍历（非递归）：  ");
		 LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
		 BinaryNode<T> p = this.root, front = null;
		 while (p != null || !stack.isEmpty())                //p非空或栈非空时
	     	if (p != null){
	        	stack.push(p);                                //p结点入栈
	        	p = p.left;                                   //进入左子树
	        }
	        else{                                             //p为空且栈非空时
	        	p = stack.get();                              //从左子树返回p结点，p结点不出栈
	        	if (p.right != null && p.right != front){     //p有右孩子，且右孩子没被访问过
	            	p = p.right;                              //进入右子树
	            	stack.push(p);
	            	p = p.left;                               //向左走
	        	} 
	            else{
	            	p = stack.pop();                           //从右子树返回p结点，p结点出栈
	            	System.out.print(p.data + " ");
	            	front = p;                                 //front是p在后根遍历次序下的前驱结点
	            	p = null; 
	            }
	        }
	        System.out.println();
	    }    
   
}
