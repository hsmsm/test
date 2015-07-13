package experiment4;

import experiment4.util.TriBinaryTree;
import experiment4.util.TriNode;

public class TriBinaryTree_ex<T> extends TriBinaryTree<T> {
	//以标明空子树的先根序列构造一棵子二叉树
    public TriBinaryTree_ex(T[] prelist){                      
        this.root = create(prelist,1,null);                    
    }
    private int i=0;
    
    private TriNode<T> create(T[] prelist, int level, TriNode<T> parent){
        TriNode<T> p = null;
        if (i < prelist.length){
            T elem = prelist[i++];
            if (elem != null){
                p = new TriNode<T>(elem, parent, null, null, level);
                p.left = create(prelist, level+1, p);
                p.right = create(prelist, level+1, p);
            }
        }
        return p;   
    }
    
    //返回两结点最近的共同祖先结点
    public TriNode<T> getAncestor(TriNode<T> node1 ,TriNode<T> node2){
    	if(node1 == null || node2 == null || root == null || node1 == root || node2 == root)
    		return null;
    	TriNode<T> parent1 = node1.parent;
    	TriNode<T> parent2 = node2.parent;
    	TriNode<T> ancestor = null;
    	while(parent1 != null && parent1.level > parent2.level){
        	parent1 = parent1.parent;
        }
        while(parent2 != null && parent1.level < parent2.level){
        	parent2 = parent2.parent;
        }	
    	while(parent1 != null && parent2 != null && parent1 != parent2){
    		parent1 = parent1.parent;
    		parent2 = parent2.parent;
    	}
    	if(parent1 == parent2)
    		ancestor = parent1;
    	return ancestor;
    }
}
