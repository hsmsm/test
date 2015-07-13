package experiment2.util;


public class SeqList<T> implements LList<T>{
    protected Object[] element;          //�������飬˽�г�Ա
    protected int len;                   //˳����ȣ�����Ԫ�ظ���
   
   //Ĭ�Ϲ��췽��������Ĭ�������Ŀձ�
   public SeqList(){
	   this(64);
   }
   
   //���췽������������Ϊsize�Ŀձ�
   public SeqList(int size){
	   this.element = new Object[size];
	   this.len = 0;
   }
   
   //������췽��
   public SeqList(SeqList<T> list){
	   this.len = list.len;
	   this.element = new Object[list.element.length];
	   for(int i = 0;i < list.element.length;i++)
		   this.element[i] = list.element[i];
   }
   
   //�ж�˳����Ƿ�գ����շ���true
   public boolean isEmpty(){
	   return this.len == 0;
   }
   
   //����˳�����
   public int length(){
	   return this.len;
   }
   
   //���ص�i(i>=0)��Ԫ�أ���iָ�������Ч�򷵻�null
   public T get(int i){
	   if(i >= 0 && i < this.len)
		   return (T)this.element[i];
	   return null;
   }
   
   //���õ�i(i>=0)��Ԫ��ֵΪx����iָ�������Ч���׳����Խ���쳣
   public void set(int i,T x){
	   if(x == null)
		   return;
	   if(i >= 0 && i < this.len)
		   this.element[i] = x;
	   else
		   throw new IndexOutOfBoundsException(i + "");
   }
   
   //����˳�������Ԫ�ص������ַ���
   public String toString(){
	   String str = "(";
	   if(this.len > 0)
		   str += this.element[0].toString();
	   for(int i = 1;i < this.len;i++)
		   str += "," + this.element[i].toString();
	   return str + ")";
   }
   
   
   //����x��Ϊ��i��Ԫ��
   public void insert(int i,T x){
	   if(x == null)
		   return;
	   if(this.len == element.length){
		   Object[] temp = this.element;
	       this.element = new Object[temp.length * 2];
	       for(int j = 0;j < temp.length;j++)
	    	   this.element[j] = temp[j];
	   }
	   if(i < 0)
		   i = 0;
	   if(i > this.len)
		   i = this.len;
	   for(int j = this.len - 1;j >= i;j--)
		   this.element[j+1] = this.element[j];
	   this.element[i] = x;
	   this.len++;
   }     
   
   //�����Ա�������xԪ��
   public void append(T x){
	   insert(this.len,x);
   }  
   
   //ɾ����i��Ԫ�ز����ر�ɾ������
   public T remove(int i){
	   if(this.len == 0 || i < 0 || i >= this.len)
		   return null;
	   T old = (T)this.element[i];
	   for(int j = i;j < this.len - 1;j++)
		   this.element[j] = this.element[j+1];
	   this.element[this.len-1] = null;
	   this.len--;
	   return old;
   }    
   
   //ɾ���״γ��ֵĹؼ���Ϊkey
   public void remove(T key){
	   if(this.len != 0 && key != null)
		   this.remove(this.indexOf(key));
   }
   
   //ɾ�����Ա�����Ԫ��
   public void removeAll(){
	   this.len = 0;
   }    
   
   
   //˳����ҹؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����-1
   public int indexOf(T key){
	   if(key != null)
		   for(int i = 0;i < this.len;i++)
			   if(this.element[i].equals(key))
				   return i;
	   return -1;
   }
   
   //���ң������״γ��ֵĹؼ���Ϊkey��Ԫ��
   public T search(T key){
	   int find = this.indexOf(key);
	   return find == -1 ? null : (T)this.element[find];
   }           
   
   //�ж�˳����Ƿ�����ؼ���ΪkeyԪ��
   public boolean contain(T key){
	   return this.indexOf(key) >= 0;
   }
 }
