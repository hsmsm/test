package experiment4.util;

public interface SStack<T> {
	boolean isEmpty();					//�ж��Ƿ��ջ
	void push(T x);						//Ԫ��x��ջ
	T pop();							//��ջ�����ص�ǰջ��Ԫ��
	T get();							//ȡջ��Ԫ�أ�δ��ջ
}
