package experiment4.util;

public interface TriBinaryTTree<T> {
	//boolean isEmpty();                                      //�ж϶������Ƿ��	
    //int count();                                            //���ض������Ľ�����
    //int height();                                           //���ض������ĸ߶�
    void preOrder();                                          //�ȸ��������������
    void inOrder();                                           //�и��������������
    void postOrder();                                         //����������������
    //void levelOrder();                                      //����α���������
    //TriNode<T> searchNode(T key);                             //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ��
    //void insertRoot(T x);                                   //����Ԫ��x��Ϊ�����
    //TriNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild); //����xԪ����Ϊp������/�Һ���
    //void removeChild(BinaryNode<T> p, boolean leftChild);   //ɾ��p�������������
    //void removeAll();
}
