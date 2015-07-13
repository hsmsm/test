package experiment4.test;

import experiment4.ThreadBinaryTree;

public class TestThreadBinaryTree {

	public static void main(String[] args) {
		String[] prelist = {"A","B","D",null,null,"E","G",null,null,null,"C","F",null,"H",null,null,"K"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    
        System.out.println("���첢������һ�ö�������");
        tbitree.inOrder_prev();
        System.out.println("����B���Һ���X��");
        tbitree.insertChild(tbitree.root.left, "X", false);
        tbitree.inOrder_prev();
        System.out.println("����C������Y��");
        tbitree.insertChild(tbitree.root.right, "Y", true);
        tbitree.inOrder_prev();
        System.out.println("��������O��");
        tbitree.insertRoot("O");
        tbitree.inOrder_prev();

	}

}
