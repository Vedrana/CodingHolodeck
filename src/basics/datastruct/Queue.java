package basics.datastruct;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	
	private List<T> queue;
	
	public Queue() {
		queue = new ArrayList<T>();
	}
	
	public void add(T value) {
		queue.add(value);
	}
	
	public T poll() {
		if (queue.size() > 0) {
			return queue.remove(0);
		} else {
			return null;
		}
	}
	
	public void print() {
		for (T elem : queue) {
			System.out.println(elem.toString());
		}
	}
	
	public static void main (String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.poll();
		q.print();		
	}

}
