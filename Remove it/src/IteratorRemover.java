import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;

	/**
	 * both lines of code instantiate the parameters to be the variables from this class
	 * @param line the list of words
	 * @param rem the exact word that requires removing
	 */
	public IteratorRemover(String line, String rem)
	{
		list = new ArrayList<String>(); 
		toRemove = rem;
	}

	/**
	 * splits up the array to be contained in a string and added to array
	 * @param line the list of words
	 * @param rem exact word being removed
	 */
	public void setTest(String line, String rem)
	{
		String [] stringArray = line.split(" ");
		for(int i = 0; i<stringArray.length; i++)
		{
			list.add(stringArray[i]);
		}
	}

	/**
	 * looks thru each word in the list and checks if it matches the removing
	 * one, used by the Iterator method hasNext() to loop until match found or
	 * length of list reached
	 */
	public void remove()
	{
		ListIterator<String>here = list.listIterator();
		while(here.hasNext())
		{
			String word = here.next();
			if(word.equals(toRemove))
			{
				here.remove();
			}
		}
		
	}

	/**
	 * will print out the new list once the word is found and removed
	 */
	public String toString()
	{
		return list.toString()+"\n";
	}
}