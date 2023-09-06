
public class MyHashTable<K, V> 
{
	class Entry<K, V>
	{
		K person;
		V pNumber;
		Entry<K, V> next;
		public Entry(K person, V pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
		}
		@Override
		public String toString()
		{
			return "" + person + ": " + pNumber;
		}
	}
	private Entry<K, V>[] hashTable;
	public int size;
	public MyHashTable()
	{
		size = 0;
		hashTable = new Entry[53];
	}
	public MyHashTable(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	
	public V put(K person, V phone)
	{
		// TODO Auto-generated method stub
		try
		{
		int temp = person.hashCode();
		Entry<K, V> ent = new Entry<K, V>(person, phone);
		Entry<K, V> temp1 = hashTable[temp];
		if(temp1 != null)
		{
			while(temp1 != null)
			{
				if(temp1.person.equals(person))
				{
					return temp1.pNumber;
				}
			}
			temp1.next = ent;
			
		}
		else
		{
			hashTable[temp] = ent;
		}
		size++;
		return phone;
		}
		catch(Exception e)
		{
			
		}
		return phone;
	}

	public V get(K person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry<K, V> temp1 = hashTable[temp];
		while(temp1 != null)
		{
			if(temp1.person.equals(person))
			{
				return temp1.pNumber;
			}
			temp1 = temp1.next;
		}
		return null;
	}

	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}

	public V remove(K person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry<K, V> temp1 = hashTable[temp];
		if(temp1.equals(person))
		{
			V back = temp1.pNumber;
			hashTable[temp] = temp1.next;
			size--;
			return back;
		}

		else
		{
			if(temp1.next.equals(person))
			{
				V back = temp1.pNumber;
				hashTable[temp] = temp1.next;
				size--;
				return back;
			}
		}
		return remove(person);
	}
	@Override 
	public String toString()
	{
		String s = "";
		for (int i = 0; i < hashTable.length; i++) 
		{
			s += i + ":" + hashTable[i] + "\n";
		}
		return s;
	}
}
