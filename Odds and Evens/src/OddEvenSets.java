//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets()
	{
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
	}

	/**
	 * Reads the list of numbers and decides if odd  based on if statement
	 * @param line the string of words being used
	 */
	public OddEvenSets(String line)
	{
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ArrayList<String> strings = new ArrayList<String>(Arrays.asList(line.split(" "))); //puts param into ArrayList and disregards all spaces
		for(String dents : strings)
		{
			ints.add(Integer.valueOf(dents)); //just using for loop to put each value into the Integer ArrayList
		}
		Iterator<Integer> stuff = ints.iterator();
		for(;stuff.hasNext();)
		{
			int temp = stuff.next();
			if(temp % 2 ==0) //checks if even and will add if it does and will add to odds if false
				evens.add(temp);
			else
				odds.add(temp);
		}
		
	}
	//prints out the statement like a king
	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}