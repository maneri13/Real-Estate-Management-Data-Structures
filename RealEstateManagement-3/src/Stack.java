
public class Stack {
	
	private Vector data;

	public Stack(int capacity) {
		data = new Vector(capacity);
	}

	public void push(Object o) {
		data.addLast(o);
	}

	public Object pop() {
		Object temp = data.getLast();
		data.removeLast();
		return temp;
	}

	public Object top() {
		return data.getLast();
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		return data.size() == 0 ? true : false;
	}
}
