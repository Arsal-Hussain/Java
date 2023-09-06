import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacer
{
	private ArrayList<Integer> list;
	private int toRemove, replaceWith;
	
	/**
	 * Instantiates the parameters with the variables from this class
	 * @param line the list of ints 
	 * @param rem the int that is being removed
	 * @param rep the int that is replaced the removed int
	 */
	public IteratorReplacer(String line, String rem, String rep)
	{
		toRemove = Integer.parseInt(rem);
		replaceWith = Integer.parseInt(rep);
		list = new ArrayList<Integer>();
		
	}

	/**
	 * places all ints inside a string array one by one through the parsing of the list
	 * @param line the list of ints
	 * @param rem  int that is being removed
	 * @param rep  int that is replacing the removed
	 */
	public void setEmAll(String line, String rem, String rep)
	{
		String [] splitter = line.split(" ");
		for(int i = 0; i<splitter.length; i++)
		{
			int num = Integer.parseInt(splitter[i]);
			list.add(num);
		}
	}

	/**
	 * Replaces each int that matches the int/String by going thru the
	 * list and checking if they are equal to each other, once
	 * found to be equal it gets replaced by replaceWith
	 */
	public void replace()
	{
		ListIterator <Integer> here = list.listIterator();
		while(here.hasNext())
		{
			int num = here.next();
			if(num == toRemove)
			{
				here.set(replaceWith);
			}
		}
	}

	//prints out the new list with the replaced int
	public String toString()
	{
		return list.toString()+"\n\n";
	}
}