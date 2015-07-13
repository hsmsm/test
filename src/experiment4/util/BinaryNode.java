package experiment4.util;

public class BinaryNode<T> {
    public T data;                               //�����򣬴洢����Ԫ��
    public BinaryNode<T> left, right;            //���򣬷ֱ�ָ�����Һ��ӽ��

    //�����㣬�����ֱ�ָ��Ԫ�غ����Һ��ӽ��
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public BinaryNode(T data){                    //����ָ��ֵ��Ҷ�ӽ��
        this(data, null, null);
    }
    
    public BinaryNode(){
        this(null, null, null);
    }
    
    public boolean isLeaf(){                      //�ж��Ƿ�Ҷ�ӽ��
        return this.left==null && this.right==null;
    }
}
