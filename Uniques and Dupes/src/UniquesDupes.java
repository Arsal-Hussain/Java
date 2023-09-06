//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class UniquesDupes
{
	/**
	 * Because Sets work in such an easy fashion, simply adding each into a Set
	 *  never has duplicates involved
	 * @param input the string of words being using
	 * @return the set once it's been unique
	 */
	public static Set<String> getUniques(String input)
	{
		Set<String> uniques = new TreeSet<String>();

		//add code
		ArrayList<String> stuff = new ArrayList<String>(Arrays.asList(input.split(" "))); //puts param into ArrayList and disregards all spaces
		for(int i = 0; i < stuff.size(); i++)
		{
			uniques.add(stuff.get(i)); //adds each arraylist index to the Set
		}
		return uniques; //returns Set
	}
	
	/**
	 * A lot of this code is deriven from the getUniques, only accounting for which numbers are seen twice
	 * @param input the string of words being used
	 * @return the set of all copied words/letters
	 */
	public static Set<String> getDupes(String input)
	{
		//add code
		Set<String> dupes = new TreeSet<String>();
		Set<String> uniques = new TreeSet<String>();
		ArrayList<String> stuff = new ArrayList<String>(Arrays.asList(input.split(" ")));
		for(int i = 0; i < stuff.size(); i++)
		{
			
			if(!uniques.add(stuff.get(i))) //this if statement checks that if the set did not add from the ArrayList, this was a duplicate and will get copied
			{
				dupes.add(stuff.get(i));
			}
		}
		return dupes;
	}
}