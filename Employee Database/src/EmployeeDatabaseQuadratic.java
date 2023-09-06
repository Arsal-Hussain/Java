import java.util.*;

public class EmployeeDatabaseQuadratic
{
	/**
	 * initializes employee and id
	 * @author arsal
	 *
	 */
	private class Entry
	{
		int id;
		Employee employee;
		
		public Entry(int id, Employee employee)
		{
			this.id = id;
			this.employee = employee;
		}
		
		@Override
		public String toString()
		{
			return "ID: " + id + "- " + employee;
		}
	}
	
	private Entry[] hashTable;
	public int getCollide;
	public int numCollide;
	private int size;
	
	/**
	 * constructor initializing all variables
	 */
	public EmployeeDatabaseQuadratic()
	{
		hashTable = new Entry[13];
		getCollide = 0;
		numCollide = 0;
		size = 0;
	}
	
	/**
	 * second constructor similar to first but sets size to that of param
	 * @param size
	 */
	public EmployeeDatabaseQuadratic(int size)
	{
		hashTable = new Entry[size];
		getCollide = 0;
		numCollide = 0;
		this.size = size;
	}
	
	/**
	 * same hashcode as that of the linear employee database
	 * @param key
	 * @return
	 */
	public int hashCode(int key)
	{
		return (key * key + key) % hashTable.length;
	}
	
	/**
	 * all of put method is similar to linear probing only that a count is
	 * implemented to multiply the index by the count quadratically and place it at
	 * its new index placement
	 * @param key
	 * @param value
	 */
	public void put(int key, Employee value)
	{
		int val = hashCode(key);
		int count = 1;
		try
		{
			while(hashTable[val] != null)
			{
				val += count*count;
				count++;
				numCollide++;
			}
			hashTable[val] = new Entry(key, value);
		}
		catch(Exception e)
		{
			
		}
	}
	
	/**
	 * similarities with the get method in linear probing but this multiplies
	 * the index by the count quadratically to find the key's actual value
	 * @param key
	 * @return
	 */
	public Employee get(int key)
	{
		int val = hashCode(key);
		int count = 1;
		try
		{
			while(hashTable[val] == null || hashTable[val].id != key)
			{
				getCollide++;
				val += count*count;
				count++;
				if(val == hashTable.length)
				{
					return null;
				}
			}
			return hashTable[val].employee;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	/**
	 * resets number of probes
	 */
	public void reset()
	{
		getCollide = 0;
	}
	
	/**
	 * simple toString printing out hashTable
	 */
	@Override
	public String toString()
	{
		String output = "";
		for(Entry a : hashTable)
		{
			output += a + "\n";
		}
		return output;
	}
}
