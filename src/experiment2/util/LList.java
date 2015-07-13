package experiment2.util;

public interface LList<T>{
  boolean isEmpty();          //判断线性表是否空
  int length();               //返回线性表长度
  T get(int i);               //返回第i(i>=0)个元素
  void set(int i,T x);        //设置第i个元素值为x
  void insert(int i,T x);     //插入x作为第i个元素
  void append(T x);           //在线性表最后插入x元素
  T remove(int i);            //删除第i个元素并返回被删除对象
  void removeAll();           //删除线性表所以元素
  T search(T key);            //查找，返回首次出现的关键字为key的元素
}
