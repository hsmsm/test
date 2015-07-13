package experiment4.util;

public class TriBinaryTree<T>  implements TriBinaryTTree<T> {
	public TriNode<T> root;

	//构造空二叉树
	public TriBinaryTree(){
		this.root = null;
	}
	
	//先根次序遍历二叉树
    public void preOrder(){                       
        System.out.print("先根次序遍历：  ");
        preOrder(root);                          
        System.out.println();
    }  
    
    //先根次序遍历以p结点为根的子二叉树，递归方法
    public void preOrder(TriNode<T> p){        
        if (p != null){                               
            System.out.print(p.level + p.data.toString() + " ");  
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
    public void inOrder(TriNode<T> p){         
        if (p != null){
            inOrder(p.left);                     
            System.out.print(p.level + p.data.toString() + " ");
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
    public void postOrder(TriNode<T> p){       
        if (p != null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.level + p.data.toString() + " ");
        }
    }
    
    //查找并返回首次出现的关键字为key元素结点
    public TriNode<T> searchNode(T key){          
        return searchNode(root, key);
    }
    
    //在以p为根的子树中查找并返回首次出现的关键字为key元素结点，若未找到返回null，先根次序遍历
    public TriNode<T> searchNode(TriNode<T> p, T key){
        if (p == null || key == null)
            return null;
        if (p.data.equals(key)) 
            return p;                                //查找成功，返回找到结点
        TriNode<T> find = searchNode(p.left, key);   //在左子树中查找，递归调用
        if (find == null)                            //若在左子树中未找到
            find = searchNode(p.right, key);         //则继续在右子树中查找，递归调用
        return find;                                 //返回查找结果
    }
	

}
