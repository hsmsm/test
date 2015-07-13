package experiment2;

import experiment2.util.SeqList;

public class SortedSeqList<T extends Comparable<T>> extends SeqList<T>{
   //默认构造方法，调用父类构造方法
   public SortedSeqList(){
	   super();
   }
   
   //构造方法，将element数组中所有对象插入构造排序的顺序表，直接插入排序
   public SortedSeqList(T[] element){
	   super();
	   if(element != null)
		   for(int i = 0;i < element.length;i++)
			   this.insert(element[i]);
   }
   
   //深拷贝构造方法，复制顺序表
   public SortedSeqList(SortedSeqList<T> list){
	   super(list);
   }
   
   //覆盖父类的set()方法，设置第i(i>=0)个元素值为x，若x不按顺序则抛出错误参数异常
   public void set(int i,T x){
	   if(x == null)
		   return;
	   if(this.get(i-1).compareTo(x) <= 0 && this.get(i+1).compareTo(x) >= 0)
		   super.set(i,x);
	   else 
		   throw new IllegalArgumentException("Wrong Argument");
   }
   
   //重载insert()方法,插入元素x到顺序表中
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
		   while(i < this.len && ((T)this.element[i]).compareTo(x) < 0){       //寻找插入位置
			   i++;
		   }
		   for(int j = this.len-1;j >= i;j--)
			   this.element[j+1] = this.element[j];
		   this.element[i] = x;
	   }	   
	   this.len++;
   }
   
   //插入x作为第i个元素，本类不支持该方法
   public void insert(int i,T x){
	   throw new UnsupportedOperationException("insert(int i,T x)");
   }     
   
   //在线性表最后插入x元素，本类不支持该方法
   public void append(T x){
	   throw new UnsupportedOperationException("append(T x)");
   }  
 }
