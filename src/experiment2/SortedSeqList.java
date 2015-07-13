package experiment2;

import experiment2.util.SeqList;

public class SortedSeqList<T extends Comparable<T>> extends SeqList<T>{
   //Ĭ�Ϲ��췽�������ø��๹�췽��
   public SortedSeqList(){
	   super();
   }
   
   //���췽������element���������ж�����빹�������˳���ֱ�Ӳ�������
   public SortedSeqList(T[] element){
	   super();
	   if(element != null)
		   for(int i = 0;i < element.length;i++)
			   this.insert(element[i]);
   }
   
   //������췽��������˳���
   public SortedSeqList(SortedSeqList<T> list){
	   super(list);
   }
   
   //���Ǹ����set()���������õ�i(i>=0)��Ԫ��ֵΪx����x����˳�����׳���������쳣
   public void set(int i,T x){
	   if(x == null)
		   return;
	   if(this.get(i-1).compareTo(x) <= 0 && this.get(i+1).compareTo(x) >= 0)
		   super.set(i,x);
	   else 
		   throw new IllegalArgumentException("Wrong Argument");
   }
   
   //����insert()����,����Ԫ��x��˳�����
   public void insert(T x){
	   if(x == null)
		   return;
	   if(this.len == element.length){
		   Object[] temp = this.element;
	       this.element = new Object[temp.length * 2];
	       for(int i = 0;i < temp.length;i++)
	    	   this.element[i] = temp[i];
	   }
	   if(this.len == 0)
		   this.element[0] = x;
	   else{
		   int i = 0;
		   while(i < this.len && ((T)this.element[i]).compareTo(x) < 0){       //Ѱ�Ҳ���λ��
			   i++;
		   }
		   for(int j = this.len-1;j >= i;j--)
			   this.element[j+1] = this.element[j];
		   this.element[i] = x;
	   }	   
	   this.len++;
   }
   
   //����x��Ϊ��i��Ԫ�أ����಻֧�ָ÷���
   public void insert(int i,T x){
	   throw new UnsupportedOperationException("insert(int i,T x)");
   }     
   
   //�����Ա�������xԪ�أ����಻֧�ָ÷���
   public void append(T x){
	   throw new UnsupportedOperationException("append(T x)");
   }  
 }
