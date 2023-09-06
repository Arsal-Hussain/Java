
public class PhoneBook implements IMap
{
	class Entry
	{
		public Person person;
		public PhoneNumber pNumber;
		public Entry next;
		public Entry(Person person, PhoneNumber pNumber)
		{
			this.person = person;
			this.pNumber = pNumber;
			this.next = null;
		}
		@Override
		public String toString()
		{
			return "" + person + ": " + pNumber;
		}
	}
	private Entry[] hashTable;
	public int size;
	/**
	 * constructor which sets bucket size
	 */
	public PhoneBook()
	{
		size = 0;
		hashTable = new Entry[10];
	}
	
	/**
	 * second constructor that sets the size to the param
	 * @param size
	 */
	public PhoneBook(int size)
	{
		hashTable = new Entry[size];
		this.size = size;
	}
	
	/**
	 * inserts the person and the phone number into a bucket,
	 * checks first if it is null at the bucket space, then
	 * places them in bucket
	 */
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry ent = new Entry(person, phone);
		Entry temp1 = hashTable[temp];
		if(temp1 != null)
		{
			while(temp1.next != null)
			{
				if(temp1.person.equals(temp1.next.person))
				{
					//temp1 = hashTable[temp-1];
					return temp1.pNumber; //returns the previous value if the current and next value are equal
				}
				temp1 = temp1.next;
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

	/**
	 * returns the phone number associated with the person
	 * name
	 */
	@Override
	public PhoneNumber get(Person person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry temp1 = hashTable[temp];
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

	/**
	 * returns size of bucket
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * removes the phone number based on the person called
	 */
	@Override
	public PhoneNumber remove(Person person)
	{
		// TODO Auto-generated method stub
		int temp = person.hashCode();
		Entry temp1 = hashTable[temp];
		if(temp1.equals(person))
		{
			PhoneNumber back = temp1.pNumber;
			hashTable[temp] = temp1.next;
			size--;
			return back;
		}

		else
		{
			if(temp1.next.equals(person))
			{
				PhoneNumber back = temp1.pNumber;
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
			s += "Bucket " + i + ": ";
			while(hashTable[i] != null)
			{
				s += hashTable[i] + ", ";
				hashTable[i] = hashTable[i].next;
			}
			s = s.substring(0, s.length()-2);
			s += "\n";
		}
		return s;
	}
}
