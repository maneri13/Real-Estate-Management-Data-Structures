public class CircularVector 
{
	private Vector data;
	private int first;
	private int count;

	public CircularVector()
	{
		count = 0;
		first = 0;
		data = new Vector(5);
	}

	public int size()
	{
		return count;
	}

	public void AddFirst(Object element)
	{

		data.addFirst(element);
	}

	public void AddLast(Object element)
	{
		data.addLast(element);

	}

	public Object GetFirst()
	{
		return data.getFirst();

	}

	public Object GetLast()
	{
		return data.getLast();

	}

	public void RemoveFirst()
	{
		if(count > 0)
		{
			first = (first+1)%data.size();
			count--;
		}
	}

	public void RemoveLast()
	{
		// add your code
	}

	public void print()
	{
		System.out.print("[");
		for(int i=0;i<count;i++)
		{
			int index = (first + i) % data.size();
			System.out.print(data.get(index) + " ");
		}
		System.out.println("]");
	}
}