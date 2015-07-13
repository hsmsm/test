package experiment4.test;

import experiment4.ThreadBinaryTree;

public class TestThreadBinaryTree {

	public static void main(String[] args) {
		String[] prelist = {"A","B","D",null,null,"E","G",null,null,null,"C","F",null,"H",null,null,"K"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    
        System.out.println("构造并线索化一棵二叉树：");
        tbitree.inOrder_prev();
        System.out.println("插入B的右孩子X：");
        tbitree.insertChild(tbitree.root.left, "X", false);
        tbitree.inOrder_prev();
        System.out.println("插入C的左孩子Y：");
        tbitree.insertChild(tbitree.root.right, "Y", true);
        tbitree.inOrder_prev();
        System.out.println("插入根结点O：");
        tbitree.insertRoot("O");
        tbitree.inOrder_prev();

	}

}
