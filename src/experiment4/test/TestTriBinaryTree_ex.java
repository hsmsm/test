package experiment4.test;

import experiment4.TriBinaryTree_ex;
import experiment4.util.TriNode;

public class TestTriBinaryTree_ex {

	public static void main(String[] args) {
		String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        TriBinaryTree_ex<String> bitree = new TriBinaryTree_ex<String>(prelist);
        System.out.println("�Ա������������ȸ����й���һ���Ӷ�������");
        bitree.preOrder();
        bitree.inOrder();
        bitree.postOrder();
        
        TriNode<String> d = bitree.searchNode("D");
        TriNode<String> g = bitree.searchNode("G");
        TriNode<String> e = bitree.searchNode("E");
        TriNode<String> f = bitree.searchNode("F");
        TriNode<String> h = bitree.searchNode("H");

        System.out.println("���E��F����Ĺ�ͬ���Ƚ����  " + bitree.getAncestor(e,f).toString());
        System.out.println("���D��G����Ĺ�ͬ���Ƚ����  " + bitree.getAncestor(d,g).toString());
        System.out.println("���E��H����Ĺ�ͬ���Ƚ����  " + bitree.getAncestor(e,h).toString());
        System.out.println("���F��H����Ĺ�ͬ���Ƚ����  " + bitree.getAncestor(f,h).toString());
        System.out.println("���D��F����Ĺ�ͬ���Ƚ����  " + bitree.getAncestor(d,f).toString());
	}

}
