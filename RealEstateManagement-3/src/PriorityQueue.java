import java.util.Comparator;

public class PriorityQueue {


	public class PriorityPair implements Comparable {
		public Object element;
		public Comparable priority;

		public PriorityPair(Object element, Comparable priority) {
			this.element = element;
			this.priority = priority;
		}

		public int compareTo(Object o) {
			PriorityPair p2 = (PriorityPair) o;
			return ((Comparable) priority).compareTo(p2.priority);
		}
		
		public String tosString() {
			return element.getClass().toString();
		}

		public Object getElement() {
			return element;
		}

		public Comparable getPriority() {
			return priority;
		}
		
		
		
	}

	private LinkedList data;

	public PriorityQueue() {
		data = new LinkedList();
	}

	public void push(Object o, int priority) {
		PriorityPair p =  new PriorityPair(o, priority);
		data.addSorted(p);
	}

	public Object pop() {
		
		Object temp = data.getLast();
		data.setLast(null);
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
	
	public Object get(int i) {
		return data.get(i);
	}
}
