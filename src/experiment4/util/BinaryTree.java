package experiment4.util;

public class BinaryTree<T> implements BinaryTTree<T>{
	public BinaryNode<T> root;           //根结点，结点结构为二叉链表

	//构造空二叉树
    public BinaryTree(){                          
        this.root = null;
    }
    
    //以标明空子树的先根序列构造二叉树
    public BinaryTree(T[] prelist){                    
        this.root = create(prelist);
    }
    
    private int i=0;
    
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p = null;
        if (i<prelist.length){
            T elem = prelist[i];
            i++;
            if (elem != null)                         //不能elem!="^"，因为T不一定是String
            {
                p = new BinaryNode<T>(elem);          //创建叶子结点
                p.left = create(prelist);             //创建p的左子树
                p.right = create(prelist);            //创建p的右子树
            }
        }
        return p;
    }
    
    //判断二叉树是否空
    public boolean isEmpty(){                     
        return this.root == null;
    }
    
    //返回二叉树的结点个数
    public int count(){                          
        return count(root);
    }
    
    //返回以p结点为根的子树的结点个数
    public int count(BinaryNode<T> p){            
        if (p == null)
            return 0;
        return 1 + count(p.left) + count(p.right);
    }
    
    //返回二叉树的高度
    public int height(){                          
        return height(root);
    }
    
    //返回以p结点为根的子树高度，后根次序遍历
    public int height(BinaryNode<T> p){           
        if (p == null)
            return 0;
        int lh = height(p.left);                       //返回左子树的高度
        int rh = height(p.right);                      //返回右子树的高度
        return (lh >= rh) ? lh + 1 : rh + 1;           //当前子树高度为较高子树的高度加1
    }
    
    //先根次序遍历二叉树
    public void preOrder(){                       
        System.out.print("先根次序遍历：  ");
        preOrder(root);                          
        System.out.println();
    }  
    
    //先根次序遍历以p结点为根的子二叉树，递归方法
    public void preOrder(BinaryNode<T> p){        
        if (p != null){                               
            System.out.print(p.data.toString() + " ");  
            preOrder(p.left);                     
            preOrder(p.right);                    
        }
    }
    
    //中根次序遍历二叉树
    public void inOrder(){                        
        System.out.print("中根次序遍历：  ");
        inOrder(root);
        System.out.println();
    }    
    
    //中根次序遍历以p结点为根的子二叉树，递归方法
    public void inOrder(BinaryNode<T> p){         
        if (p != null){
            inOrder(p.left);                     
            System.out.print(p.data.toString() + " ");
            inOrder(p.right);                    
        }
    }

    //后根次序遍历二叉树
    public void postOrder(){                      
        System.out.print("后根次序遍历：  ");
        postOrder(root);
        System.out.println();
    }
    
    //后根次序遍历以p结点为根的子二叉树，递归方法
    public void postOrder(BinaryNode<T> p){       
        if (p != null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data.toString() + " ");
        }
    }
   
    //按层次遍历二叉树
    public void levelOrder(){                     
        System.out.print("层次遍历：  ");
        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //创建一个空队列
        BinaryNode<T> p = this.root;
        while (p != null){
            System.out.print(p.data + " ");      //访问当前结点
            if (p.left != null)    
                que.enqueue(p.left);             //p的左孩子结点入队
            if (p.right != null)
                que.enqueue(p.right);            //p的右孩子结点入队
            p = que.dequeue();                   //p指向出队结点，若队列空返回null
        }
        System.out.println();
    }   

    //查找并返回首次出现的关键字为key元素结点
    public BinaryNode<T> searchNode(T key){          
        return searchNode(root, key);
    }
    
    //在以p为根的子树中查找并返回首次出现的关键字为key元素结点，若未找到返回null，先根次序遍历
    public BinaryNode<T> searchNode(BinaryNode<T> p, T key){
        if (p == null || key == null)
            return null;
        if (p.data.equals(key)) 
            return p;                                  //查找成功，返回找到结点
        BinaryNode<T> find = searchNode(p.left, key);  //在左子树中查找，递归调用
        if (find == null)                              //若在左子树中未找到
            find = searchNode(p.right, key);           //则继续在右子树中查找，递归调用
        return find;                                   //返回查找结果
    }
	
    //返回node结点的父母结点，若空树、未找到或node为根，则返回null
    public BinaryNode<T> getParent(BinaryNode<T> node){
        if (root == null || node == null || node == root)
            return null; 
        return getParent(root, node);
    }
    
    //在以p为根的子树中查找并返回node结点的父母结点
    public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node){
        if (p == null)
            return null;
        if (p.left == node || p.right == node) 
            return p;
        BinaryNode<T> find = getParent(p.left, node);
        if (find == null)
            find = getParent(p.right, node);
        return find;
    }


    //插入元素x作为根结点，原根结点作为其左孩子
    public void insertRoot(T x){
        this.root = new BinaryNode<T>(x, this.root, null);
    }
    
    //插入元素x作为p结点的孩子，返回插入结点。若p==null，将抛出空对象异常
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild){
        if (x == null)
            return null;
        if (leftChild){
            p.left = new BinaryNode<T>(x,p.left,null);  //插入x结点作为p的左孩子，p原左孩子成为x的左孩子
            return p.left;                              //返回插入结点
        }
        p.right = new BinaryNode<T>(x,null,p.right);    //插入x结点作为p的右孩子，p原右孩子成为x的右孩子
        return p.right;
    }    

    //删除p结点的左或右子树，若p==null，将抛出空对象异常
    public void removeChild(BinaryNode<T> p, boolean leftChild){
    	if(p != null)
        	if (leftChild)
        		p.left = null;
        	else 
        		p.right = null;
    }

	//删除二叉树
	public void removeAll() {
		this.root = null;
	}
}
