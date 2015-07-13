package experiment4.util;

public class BinaryTree<T> implements BinaryTTree<T>{
	public BinaryNode<T> root;           //����㣬���ṹΪ��������

	//����ն�����
    public BinaryTree(){                          
        this.root = null;
    }
    
    //�Ա������������ȸ����й��������
    public BinaryTree(T[] prelist){                    
        this.root = create(prelist);
    }
    
    private int i=0;
    
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p = null;
        if (i<prelist.length){
            T elem = prelist[i];
            i++;
            if (elem != null)                         //����elem!="^"����ΪT��һ����String
            {
                p = new BinaryNode<T>(elem);          //����Ҷ�ӽ��
                p.left = create(prelist);             //����p��������
                p.right = create(prelist);            //����p��������
            }
        }
        return p;
    }
    
    //�ж϶������Ƿ��
    public boolean isEmpty(){                     
        return this.root == null;
    }
    
    //���ض������Ľ�����
    public int count(){                          
        return count(root);
    }
    
    //������p���Ϊ���������Ľ�����
    public int count(BinaryNode<T> p){            
        if (p == null)
            return 0;
        return 1 + count(p.left) + count(p.right);
    }
    
    //���ض������ĸ߶�
    public int height(){                          
        return height(root);
    }
    
    //������p���Ϊ���������߶ȣ�����������
    public int height(BinaryNode<T> p){           
        if (p == null)
            return 0;
        int lh = height(p.left);                       //�����������ĸ߶�
        int rh = height(p.right);                      //�����������ĸ߶�
        return (lh >= rh) ? lh + 1 : rh + 1;           //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }
    
    //�ȸ��������������
    public void preOrder(){                       
        System.out.print("�ȸ����������  ");
        preOrder(root);                          
        System.out.println();
    }  
    
    //�ȸ����������p���Ϊ�����Ӷ��������ݹ鷽��
    public void preOrder(BinaryNode<T> p){        
        if (p != null){                               
            System.out.print(p.data.toString() + " ");  
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
    public void inOrder(BinaryNode<T> p){         
        if (p != null){
            inOrder(p.left);                     
            System.out.print(p.data.toString() + " ");
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
    public void postOrder(BinaryNode<T> p){       
        if (p != null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data.toString() + " ");
        }
    }
   
    //����α���������
    public void levelOrder(){                     
        System.out.print("��α�����  ");
        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //����һ���ն���
        BinaryNode<T> p = this.root;
        while (p != null){
            System.out.print(p.data + " ");      //���ʵ�ǰ���
            if (p.left != null)    
                que.enqueue(p.left);             //p�����ӽ�����
            if (p.right != null)
                que.enqueue(p.right);            //p���Һ��ӽ�����
            p = que.dequeue();                   //pָ����ӽ�㣬�����пշ���null
        }
        System.out.println();
    }   

    //���Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ��
    public BinaryNode<T> searchNode(T key){          
        return searchNode(root, key);
    }
    
    //����pΪ���������в��Ҳ������״γ��ֵĹؼ���ΪkeyԪ�ؽ�㣬��δ�ҵ�����null���ȸ��������
    public BinaryNode<T> searchNode(BinaryNode<T> p, T key){
        if (p == null || key == null)
            return null;
        if (p.data.equals(key)) 
            return p;                                  //���ҳɹ��������ҵ����
        BinaryNode<T> find = searchNode(p.left, key);  //���������в��ң��ݹ����
        if (find == null)                              //������������δ�ҵ�
            find = searchNode(p.right, key);           //��������������в��ң��ݹ����
        return find;                                   //���ز��ҽ��
    }
	
    //����node���ĸ�ĸ��㣬��������δ�ҵ���nodeΪ�����򷵻�null
    public BinaryNode<T> getParent(BinaryNode<T> node){
        if (root == null || node == null || node == root)
            return null; 
        return getParent(root, node);
    }
    
    //����pΪ���������в��Ҳ�����node���ĸ�ĸ���
    public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node){
        if (p == null)
            return null;
        if (p.left == node || p.right == node) 
            return p;
        BinaryNode<T> find = getParent(p.left, node);
        if (find == null)
            find = getParent(p.right, node);
        return find;
    }


    //����Ԫ��x��Ϊ����㣬ԭ�������Ϊ������
    public void insertRoot(T x){
        this.root = new BinaryNode<T>(x, this.root, null);
    }
    
    //����Ԫ��x��Ϊp���ĺ��ӣ����ز����㡣��p==null�����׳��ն����쳣
    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild){
        if (x == null)
            return null;
        if (leftChild){
            p.left = new BinaryNode<T>(x,p.left,null);  //����x�����Ϊp�����ӣ�pԭ���ӳ�Ϊx������
            return p.left;                              //���ز�����
        }
        p.right = new BinaryNode<T>(x,null,p.right);    //����x�����Ϊp���Һ��ӣ�pԭ�Һ��ӳ�Ϊx���Һ���
        return p.right;
    }    

    //ɾ��p�����������������p==null�����׳��ն����쳣
    public void removeChild(BinaryNode<T> p, boolean leftChild){
    	if(p != null)
        	if (leftChild)
        		p.left = null;
        	else 
        		p.right = null;
    }

	//ɾ��������
	public void removeAll() {
		this.root = null;
	}
}
