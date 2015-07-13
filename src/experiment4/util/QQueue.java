package experiment4.util;

public interface QQueue<T>{
	boolean isEmpty();
	void enqueue(T x);
	T dequeue();
}
