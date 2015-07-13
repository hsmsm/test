package experiment4.util;

public class TriNode<T>{
    public T data;                               //�����򣬴洢����Ԫ��
    public TriNode<T> parent, left, right;       //���򣬷ֱ�ָ��ĸ��㡢����Һ��ӽ��
    public int level;                            //���Ĳ��

    //�����㣬�����ֱ�ָ��Ԫ�ء���ĸ��㡢����Һ��ӽ��
    public TriNode(T data, TriNode<T> parent, TriNode<T> left, TriNode<T> right, int level){
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.level = level;
    }
    
    //����ָ��ֵ��Ҷ�ӽ��
    public TriNode(T data){                   
        this(data, null, null, null, 0);
    }
    
    public TriNode(){
        this(null, null, null, null, 0);
    }
    
    public String toString(){
        return this.data.toString();
    }
}
