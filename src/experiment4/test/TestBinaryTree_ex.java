package experiment4.test;

import experiment4.BinaryTree_ex;

public class TestBinaryTree_ex {

	public static void main(String[] args) {
		System.out.print("��һ�ö�������\n");
		String[] prelist1 = {"A","B","D","H",null,null,null,"E",null,null,"C","F",null,null,"G",null,null};
		BinaryTree_ex<String> bitree1 = new BinaryTree_ex<String>(prelist1);
		bitree1.preOrder();
		bitree1.inOrder();
		bitree1.postOrder();
		bitree1.postOrderTraverse();
		System.out.print("��  " + bitree1.countLeaf() + " ��Ҷ�ӽ�㣺");
        bitree1.leaf();
        System.out.println("\n�Ƿ���ȫ��������  " + bitree1.isCompleteBinaryTree());
        System.out.println("G���Ĳ���� " + bitree1.getLevel("G"));
        
        System.out.println("\n�ڶ��ö������������ȸ����и����й��죩");
        String[] prelist2 = {"A","B","D","G","C","E","F","H"};
        String[] inlist2 = {"D","G","B","A","E","C","H","F"};
        System.out.println("�ȸ����У�  A B D G C E F H");
        System.out.println("�и����У�  D G B A E C H F");
        BinaryTree_ex<String> bitree2 = new BinaryTree_ex<String>(prelist2,inlist2);
		bitree2.preOrder();
		bitree2.inOrder();
		bitree2.postOrder();
		bitree2.postOrderTraverse();
		System.out.print("��  " + bitree2.countLeaf() + " ��Ҷ�ӽ�㣺");
        bitree2.leaf();
        System.out.println("\n�Ƿ���ȫ��������  " + bitree2.isCompleteBinaryTree());
        System.out.println("G���Ĳ���� " + bitree2.getLevel("G"));
        
		System.out.print("\n�����ö������������Ƶڶ��ö�������\n");
		BinaryTree_ex<String> bitree3 = new BinaryTree_ex<String>(bitree2);
		bitree3.preOrder();
		bitree3.inOrder();
		bitree3.postOrder();
		
		System.out.println("\n��������ڶ��ö������Ƿ���ȣ�" + bitree3.equals(bitree2));
		
		System.out.println("\n�������ö�������ÿ��������������������������");
		bitree3.exchange();
		bitree3.preOrder();
		bitree3.inOrder();
		bitree3.postOrder();

		System.out.println("\n��������ڶ��ö������Ƿ���ȣ�" + bitree3.equals(bitree2));
		
		System.out.print("\n���Ŀö�������\n");
		Integer[] prelist4 = {1,7,4,12,9};
		Integer[] inlist4 = {4,7,1,12,9};
		BinaryTree_ex<Integer> bitree4 = new BinaryTree_ex<Integer>(prelist4,inlist4);
		bitree4.preOrder();
		bitree4.inOrder();
		bitree4.postOrder();
		System.out.print("ֵ����5�Ľ�㣺");
		bitree4.greaterThan(new Integer(5));

	}
}
