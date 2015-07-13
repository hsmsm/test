package experiment4.util;

public class TriBinaryTree<T>  implements TriBinaryTTree<T> {
	public TriNode<T> root;

	//����ն�����
	public TriBinaryTree(){
		this.root = null;
	}
	
	//�ȸ��������������
    public void preOrder(){                       
        System.out.print("�ȸ����������  ");
        preOrder(root);                          
        System.out.println();
    }  
    
    //�ȸ����������p���Ϊ�����Ӷ��������ݹ鷽��
    public void preOrder(TriNode<T> p){        
        if (p != null){                               
            System.out.print(p.level + p.data.toString() + " ");  
            preOrder(p.left);                     
            preOrder(p.right);                    
        }
    }
    
    //�и��������������
    public void inOrder(){                        
        System.out.print("�и����������  ");
        inOrder(root);
        System.out.println();
    }    
    
    //�и����������p���Ϊ�����Ӷ��������ݹ鷽��
    public void inOrder(TriNode<T> p){         
        if (p != null){
            inOrder(p.left);                     
            System.out.print(p.level + p.data.toString() + " ");
            inOrder(p.right);                    
        }
    }

    //����������������
    public void postOrder(){                      
        System.out.print("������������  ");
        postOrder(root);
        System.out.println();
    }
    
    //������������p���Ϊ�����Ӷ��������ݹ鷽��
    public void postOrder(TriNode<T> p){       
        if (p != null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.level + p.data.toString() + " ");
        }
    }
    
    //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ��
    public TriNode<T> searchNode(T key){          
        return searchNode(root, key);
    }
    
    //����pΪ���������в��Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ�㣬��δ�ҵ�����null���ȸ��������
    public TriNode<T> searchNode(TriNode<T> p, T key){
        if (p == null || key == null)
            return null;
        if (p.data.equals(key)) 
            return p;                                //���ҳɹ��������ҵ����
        TriNode<T> find = searchNode(p.left, key);   //���������в��ң��ݹ����
        if (find == null)                            //������������δ�ҵ�
            find = searchNode(p.right, key);         //��������������в��ң��ݹ����
        return find;                                 //���ز��ҽ��
    }
	

}
