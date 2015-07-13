package experiment2;

import experiment2.util.Node;

public class MyIterator<T> extends SinglyLinkedList<T>{
	public Node<T> pointer;
	
	public MyIterator(T[] element){
		super(element);
	}
	
	public MyIterator(SinglyLinkedList<T> list){
		super(list);
	}
	
	public boolean hasNext() {
		return pointer.next != null;
	}
	
	public T next() {
		pointer = pointer.next;
		return pointer.data;
	}
	
	public void remove() {
		super.remove(pointer.data);
	}
	
	public int indexOf(Object obj){
		if (obj == null) 
			return -1;
		pointer = this.head;
		int sum = 0;
		while (hasNext()){
		   if (obj.equals(next())) 
			   return sum;
		   sum++;
		}
		return -1;
	}
	
	public boolean equals(Object obj){
		if (obj instanceof MyIterator){
			MyIterator<T> list=(MyIterator<T>) obj;
			if (this.length()!=list.length()) 
				return false;
			pointer = this.head;
			list.pointer = list.head;
			while(this.hasNext()){
				if (this.next().equals(list.next()) == false) 
					return false;
			}
			return true;
		}
		return false;
	}
}

