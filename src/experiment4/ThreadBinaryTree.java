package experiment4;

import experiment4.util.ThreadNode;

public class ThreadBinaryTree<T>{                
    public ThreadNode<T> root;

    //构造空中序线索二叉树
    public ThreadBinaryTree(){                   
        this.root = null;
    }

    //判断中序线索二叉树是否空
    public boolean isEmpty(){                     
        return root == null;
    }

    //以标明空子树的先根序列构造二叉树并进行中序线索化
    public ThreadBinaryTree(T[] prelist){         
        this.root = create(prelist);
        inorderThread(this.root);
    }
    
    //以标明空子树的先根序列创建子树
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

    //中序线索化以p结点为根的子树，p的前驱结点是front
    private ThreadNode<T> front=null;
    private void inorderThread(ThreadNode<T> p){
        if (p != null){
            inorderThread(p.left);                  //中序线索化p的左子树
            if (p.left == null){                    //若p的左子树为空
                p.ltag = 1;                         //设置左线索标记
                p.left = front;                     //设置p.left为指向前驱front的线索
            }
            if (p.right==null)                      //若p的右子树为空
                p.rtag = 1;                         //设置右线索标记
            if (front != null && front.rtag == 1) 
                front.right = p;                    //设置前驱front.right为指向后继p的线索
            front = p;
            inorderThread(p.right);                 //中序线索化p的右子树
        }
    }
  
    //返回p在中根次序下的前驱结点
    public ThreadNode<T> inPrev(ThreadNode<T> p){ 
        if (p.ltag == 1)                           //若左子树为空
            p = p.left;                            //p.left就是指向p前驱结点的线索
        else{                                      //若左子树非空
            p = p.left;                            //进入左子树
            while (p.rtag == 0)                    //找到最右边的子孙结点
                p = p.right;
        }
        return p;
    }

    //返回p在中根次序下的后继结点
    public ThreadNode<T> inNext(ThreadNode<T> p){ 
        if (p.rtag == 1)                             //若右子树为空
            p = p.right;                             //p.right就是指向后继结点的线索
        else{
            p = p.right;                             //若右子树非空，进入右子树
            while (p.ltag == 0)                      //找到最左边的后代结点
                p = p.left;
        }
        return p;
    }
    
    //中根次序遍历中序线索二叉树，非递归算法
    public void inOrder_prev(){                   
        System.out.print("中根次序遍历（求前驱）：  ");
        ThreadNode<T> p = this.root;
        String str = "";
        while (p != null && p.rtag == 0)              //寻找根的最右边的后代结点
            p = p.right; 
        while (p != null){
            str = p.data.toString() + " " + str;
            p = inPrev(p);                            //返回p在中根次序下的前驱结点
        }  
        System.out.println(str);
    }    
    
    //插入作为根结点
    public void insertRoot(T x){                  
        if (this.root == null)
            this.root = new ThreadNode<T>(x, null,1, null,1);
        else{
            ThreadNode<T> p = this.root;
            while (p != null && p.rtag == 0)         //寻找原根的最右边子孙结点p，即最后访问结点
                p = p.right;
            this.root = new ThreadNode<T>(x, this.root,0, null,1);
            p.right = this.root;                   //修改p的后继线索
        }
    }
    
    //插入x作为p结点的孩子结点，若leftChild为true，插入左孩子，否则插入右孩子，返回插入的孩子结点
    public ThreadNode<T> insertChild(ThreadNode<T> p, T x, boolean leftChild){
        ThreadNode<T> q = null;
        if (leftChild){                            //插入左孩子
            q = new ThreadNode<T>(x, p.left, p.ltag, p,1);
            p.left = q;
            p.ltag = 0;
            if (q.ltag == 0){
                ThreadNode<T> pred = inPrev(q);    //prev是q在中根次序下的前驱
                pred.right = q;                    //修改前驱结点prev的后继线索
            }
        }
        else{                                      //插入右孩子
            q = new ThreadNode<T>(x, p,1,p.right, p.rtag);
            p.right = q;
            p.rtag = 0;
            if (q.rtag == 0){
                ThreadNode<T> succ = inNext(q);    //succ是q在中根次序下的后继
                succ.left = q;                     //修改后继结点succ的前驱线索
            }
        }
        return q;
    }
    
}
