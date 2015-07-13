package experiment2.util;

public interface LList<T>{
  boolean isEmpty();          //�ж����Ա��Ƿ��
  int length();               //�������Ա���
  T get(int i);               //���ص�i(i>=0)��Ԫ��
  void set(int i,T x);        //���õ�i��Ԫ��ֵΪx
  void insert(int i,T x);     //����x��Ϊ��i��Ԫ��
  void append(T x);           //�����Ա�������xԪ��
  T remove(int i);            //ɾ����i��Ԫ�ز����ر�ɾ������
  void removeAll();           //ɾ�����Ա�����Ԫ��
  T search(T key);            //���ң������״γ��ֵĹؼ���Ϊkey��Ԫ��
}
