public class Dictionary 
{
	private Vector data;
	
	public Dictionary()
	{
		data = new Vector(100);
	}

	public void add(Object key,Object value)
	{
		int i = findPosition(key);
		if (i != -1) {
			data.set(i, new DictionaryPair(key, value));
		}
		data.addLast(new DictionaryPair(key, value));
	}
	
	public int findPosition(Object key)
	{
		for (int i = 0; i < data.size(); i++) {
			DictionaryPair temp =(DictionaryPair) data.get(i);
			if (temp.getKey()== key) {
				return i;
			}
		}
		return -1;
	}
	
	public Object find(Object key)
	{
		int i  = findPosition(key);										// complexity N
		if (i== -1) {return null;}
		DictionaryPair temp =(DictionaryPair) data.get(i);
		return temp.getValue();
	}
}