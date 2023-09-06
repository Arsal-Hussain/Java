import java.util.*;

public class EmployeeDatabaseLinear
{
	/**
	 * entry class utilized to initialize the employee name and id
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
	 * constructor initializing hashTable and other variables
	 */
	public EmployeeDatabaseLinear()
	{
		hashTable = new Entry[13];
		getCollide = 0;
		numCollide = 0;
		size = 0;
	}
	
	/**
	 * second constructor that does same as first but sets size as the param
	 * @param size
	 */
	public EmployeeDatabaseLinear(int size)
	{
		hashTable = new Entry[size];
		getCollide = 0;
		numCollide = 0;
		this.size = size;
	}
	
	/**
	 * the hashcode that will multiple the keys then add key and mod div by length of hashtable
	 * @param key
	 * @return
	 */
	public int hashCode(int key)
	{
		return (key * key + key) % hashTable.length;
	}
	
	/**
	 * essentially adds the employee to hashtable linear but checks if value at key exists
	 * @param key
	 * @param value
	 */
	public void put(int key, Employee value)
	{
		int val = hashCode(key);
		try
		{
			while(hashTable[val] != null)
			{
				val++;
				numCollide++;
			}
			hashTable[val] = new Entry(key, value);
		}
		catch(Exception e)
		{
			
		}
	}
	
	/**
	 * simple get method, returns the name of the employee located at key, null if no employee
	 * @param key
	 * @return
	 */
	public Employee get(int key)
	{
		int val = hashCode(key);
		try
		{
			while(hashTable[val] == null || hashTable[val].id != key)
			{
				getCollide++;
				val++;
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
	 * resets the getCollide counters
	 */
	public void reset()
	{
		getCollide = 0;
	}
	
	/**
	 * toString returns the hashTable
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
