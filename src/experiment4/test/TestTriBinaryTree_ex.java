package experiment4.test;

import experiment4.TriBinaryTree_ex;
import experiment4.util.TriNode;

public class TestTriBinaryTree_ex {

	public static void main(String[] args) {
		String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        TriBinaryTree_ex<String> bitree = new TriBinaryTree_ex<String>(prelist);
        System.out.println("以标明空子树的先根序列构造一棵子二叉树：");
        bitree.preOrder();
        bitree.inOrder();
        bitree.postOrder();
        
        TriNode<String> d = bitree.searchNode("D");
        TriNode<String> g = bitree.searchNode("G");
        TriNode<String> e = bitree.searchNode("E");
        TriNode<String> f = bitree.searchNode("F");
        TriNode<String> h = bitree.searchNode("H");

        System.out.println("结点E和F最近的共同祖先结点是  " + bitree.getAncestor(e,f).toString());
        System.out.println("结点D和G最近的共同祖先结点是  " + bitree.getAncestor(d,g).toString());
        System.out.println("结点E和H最近的共同祖先结点是  " + bitree.getAncestor(e,h).toString());
        System.out.println("结点F和H最近的共同祖先结点是  " + bitree.getAncestor(f,h).toString());
        System.out.println("结点D和F最近的共同祖先结点是  " + bitree.getAncestor(d,f).toString());
	}

}
