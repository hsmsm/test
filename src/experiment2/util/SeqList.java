package experiment2.util;


public class SeqList<T> implements LList<T>{
    protected Object[] element;          //对象数组，私有成员
    protected int len;                   //顺序表长度，记载元素个数
   
   //默认构造方法，创建默认容量的空表
   public SeqList(){
	   this(64);
   }
   
   //构造方法，创造容量为size的空表
   public SeqList(int size){
	   this.element = new Object[size];
	   this.len = 0;
   }
   
   //深拷贝构造方法
   public SeqList(SeqList<T> list){
	   this.len = list.len;
	   this.element = new Object[list.element.length];
	   for(int i = 0;i < list.element.length;i++)
		   this.element[i] = list.element[i];
   }
   
   //判断顺序表是否空，若空返回true
   public boolean isEmpty(){
	   return this.len == 0;
   }
   
   //返回顺序表长度
   public int length(){
	   return this.len;
   }
   
   //返回第i(i>=0)个元素，若i指定序号无效则返回null
   public T get(int i){
	   if(i >= 0 && i < this.len)
		   return (T)this.element[i];
	   return null;
   }
   
   //设置第i(i>=0)个元素值为x，若i指定序号无效则抛出序号越界异常
   public void set(int i,T x){
	   if(x == null)
		   return;
	   if(i >= 0 && i < this.len)
		   this.element[i] = x;
	   else
		   throw new IndexOutOfBoundsException(i + "");
   }
   
   //返回顺序表所有元素的描述字符串
   public String toString(){
	   String str = "(";
	   if(this.len > 0)
		   str += this.element[0].toString();
	   for(int i = 1;i < this.len;i++)
		   str += "," + this.element[i].toString();
	   return str + ")";
   }
   
   
   //插入x作为第i个元素
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
   
   //在线性表最后插入x元素
   public void append(T x){
	   insert(this.len,x);
   }  
   
   //删除第i个元素并返回被删除对象
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
   
   //删除首次出现的关键字为key
   public void remove(T key){
	   if(this.len != 0 && key != null)
		   this.remove(this.indexOf(key));
   }
   
   //删除线性表所有元素
   public void removeAll(){
	   this.len = 0;
   }    
   
   
   //顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回-1
   public int indexOf(T key){
	   if(key != null)
		   for(int i = 0;i < this.len;i++)
			   if(this.element[i].equals(key))
				   return i;
	   return -1;
   }
   
   //查找，返回首次出现的关键字为key的元素
   public T search(T key){
	   int find = this.indexOf(key);
	   return find == -1 ? null : (T)this.element[find];
   }           
   
   //判断顺序表是否包含关键字为key元素
   public boolean contain(T key){
	   return this.indexOf(key) >= 0;
   }
 }
