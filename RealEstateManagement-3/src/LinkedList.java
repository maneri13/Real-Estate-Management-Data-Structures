

public class LinkedList {

	private class ListElement {
		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Comparable el) {
			this(el, null);
		}

		public Comparable first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Comparable value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
		
		public String toString() {
			return el1 + " test";
		}
	}

	private ListElement head;
	private int count;

	public LinkedList() {
		head = null;
	}

	public void addFirst(Comparable o) {
		head = new ListElement(o, head);
		count++;
	}

	public Comparable getFirst() {
		return head.first();
	}

	public Comparable get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}

	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;
	}

	public int size() {

		return count;
	}

	public void set(Comparable o, int index) {
		ListElement temp = head;
		while (index > 1) {
			temp = temp.rest();
			index--;
		}
		temp.el1 = o;
	}

	public ListElement getLast() {
		ListElement last = head;
		while (last.rest() != null) {
			last = last.rest();
		}
		return last;
	}

	public void setLast(Comparable o) {
		ListElement last = getLast();
		last.setFirst(o);
	}

	public Boolean search(Comparable o) {
		ListElement searchElement = head;
		while (searchElement != null) {
			if (o.equals(searchElement.first())) {
				return true;
			}
			searchElement = searchElement.rest();
		}
		return false;
	}

	/*
	 * public void fropple() { ListElement fropple = head; int i=1,size = size();
	 * Comparable temp; while(i < size()) { temp = fropple.el1; fropple.el1 =
	 * fropple.el2; fropple.el2 = temp; i+=2; fropple = fropple.rest().rest();
	 * 
	 * }
	 */
	// }

	public void addSorted(Comparable o)

	{	
		// an empty list , add element in front
		if (head == null)
			head = new ListElement(o, null);
		else if (head.first().compareTo(o) < 0)
		{
			// we have to add the element in front
			head = new ListElement(o, head);
		}
		else
		{
			// we have to find the first element which is bigger
			ListElement d = head;
			while ((d.rest() != null) &&
					(d.rest().first().compareTo(o) > 0))
			{
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o, next));
		}
		count++;
	}

}
