package experiment4.test;

import experiment4.BinaryTree_ex;

public class TestBinaryTree_ex {

	public static void main(String[] args) {
		System.out.print("第一棵二叉树：\n");
		String[] prelist1 = {"A","B","D","H",null,null,null,"E",null,null,"C","F",null,null,"G",null,null};
		BinaryTree_ex<String> bitree1 = new BinaryTree_ex<String>(prelist1);
		bitree1.preOrder();
		bitree1.inOrder();
		bitree1.postOrder();
		bitree1.postOrderTraverse();
		System.out.print("有  " + bitree1.countLeaf() + " 个叶子结点：");
        bitree1.leaf();
        System.out.println("\n是否完全二叉树？  " + bitree1.isCompleteBinaryTree());
        System.out.println("G结点的层次是 " + bitree1.getLevel("G"));
        
        System.out.println("\n第二棵二叉树：（以先根和中根序列构造）");
        String[] prelist2 = {"A","B","D","G","C","E","F","H"};
        String[] inlist2 = {"D","G","B","A","E","C","H","F"};
        System.out.println("先根序列：  A B D G C E F H");
        System.out.println("中根序列：  D G B A E C H F");
        BinaryTree_ex<String> bitree2 = new BinaryTree_ex<String>(prelist2,inlist2);
		bitree2.preOrder();
		bitree2.inOrder();
		bitree2.postOrder();
		bitree2.postOrderTraverse();
		System.out.print("有  " + bitree2.countLeaf() + " 个叶子结点：");
        bitree2.leaf();
        System.out.println("\n是否完全二叉树？  " + bitree2.isCompleteBinaryTree());
        System.out.println("G结点的层次是 " + bitree2.getLevel("G"));
        
		System.out.print("\n第三棵二叉树：（复制第二棵二叉树）\n");
		BinaryTree_ex<String> bitree3 = new BinaryTree_ex<String>(bitree2);
		bitree3.preOrder();
		bitree3.inOrder();
		bitree3.postOrder();
		
		System.out.println("\n第三棵与第二棵二叉树是否相等？" + bitree3.equals(bitree2));
		
		System.out.println("\n将第三棵二叉树的每个结点的左子树与右子树交换：");
		bitree3.exchange();
		bitree3.preOrder();
		bitree3.inOrder();
		bitree3.postOrder();

		System.out.println("\n第三棵与第二棵二叉树是否相等？" + bitree3.equals(bitree2));
		
		System.out.print("\n第四棵二叉树：\n");
		Integer[] prelist4 = {1,7,4,12,9};
		Integer[] inlist4 = {4,7,1,12,9};
		BinaryTree_ex<Integer> bitree4 = new BinaryTree_ex<Integer>(prelist4,inlist4);
		bitree4.preOrder();
		bitree4.inOrder();
		bitree4.postOrder();
		System.out.print("值大于5的结点：");
		bitree4.greaterThan(new Integer(5));

	}
}
