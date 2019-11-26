public class Vector
{
	private Object data[];
	private int count;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}

	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		return data[index];
	}

	public void set(int index, Object obj)
	{
		data[index] = obj;
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == obj) return true;
		}
		return false;
	}
	
	public void addFirst(Object item)
	{
		// Exercise 4//
		for (int i = count - 1; i >= 0 ; i--) {
			if (i < data.length - 1) {
				data[i+1] = data[i];
			}				
					}
		data[0] = item;
		if (count < data.length) {
			count++;
		}
	}

	public void addLast(Object o)
	{
		data[count] = o;
		count++;
	}
	
	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

	public Object getFirst()
	{
		// Exercise 2
		
		return data[0];
	}

	public Object getLast()
	{
		// Exercise 2
		
		return data[(count-1)];
	}

	public void removeLast()
	{
		// Exercise 5
		data[count-1] = null;
	} 

	public void removeFirst()
	{
		// Exercise 5
		data[0] = null;
	}
	//Exercise 3
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(data[i]);
		}
		
	}
	
	// Exercise 6
	public void reverse() {
		int mid = count /2;
		Object temp;
		for (int i = 0; i < mid; i++) {
			temp = data[i];
			data[i] = data[count - i -1];
			data[count - i - 1] = temp;
		}
	}
	
	//Exercise 7
	public Vector doubleVector(Vector v) {
		Vector doubleVector = new Vector(v.size()*2);
		for (int i = v.size()-1; i >= 0; i--) {
			doubleVector.addLast(v.get(i));
			doubleVector.addLast(v.get(i));			
		}
		return doubleVector;
	}
	//Exercise 8
	public Vector interleave(Vector v1, Vector v2) {
		Vector interleaveVector = new Vector(v1.size()+v2.size());
		int i =0;
		int minSize = (v1.size() <= v2.size() ? v1.size(): v2.size());		//Get shorter size so that initial loop does not go out of bounds
		int maxSize = (v1.size() >= v2.size() ? v1.size(): v2.size());
		while (i<minSize) {
			interleaveVector.addLast(v1.get(i));
			interleaveVector.addLast(v2.get(i));
			i++;
		}
		while(i<maxSize) {													// 2nd loop work in case two vectors are of different sizes
			interleaveVector.addLast((v1.size() >= v2.size() ? v1.get(i): v2.get(i)));
		}
		
		return interleaveVector;
	}
	//Exercise 9
	public void extendCapacity(Vector v) {
		Vector temp = new Vector(v.size()*2);
		for (int i = v.size()-1; i >= 0; i--) {
			temp.addLast(v.get(i));
		}
		v = temp;
	}
}