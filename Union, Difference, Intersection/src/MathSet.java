//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet()
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
	}

	public MathSet(String o, String t)
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
		for(String myInt : o.split(" "))
			one.add(Integer.valueOf(myInt));
		for(String myInt : t.split(" "))
			two.add(Integer.valueOf(myInt));
	}

	public Set<Integer> union() //for union, all that is required is to add both Sets into one single Set and it automatically takes away duplicates
	{
		Set<Integer> union = new TreeSet<Integer>();
		union.addAll(one);
		union.addAll(two);
		return union;
	}

	public Set<Integer> intersection() //doing addAll then retainAll will look at both Sets and determine which numbers are in both Sets
	{
		Set<Integer> intersection = new TreeSet<Integer>();
		intersection.addAll(one);
		intersection.retainAll(two);
		return intersection;
	}

	public Set<Integer> differenceAMinusB() //any number featured in A while also being in B is removed and the remaining A numbers are left
	{
		Set<Integer> diffA = new TreeSet<Integer>();
		diffA.addAll(one);
		diffA.removeAll(two);
		return diffA;
	}

	public Set<Integer> differenceBMinusA() //any number featured in B while also being in A is removed and the remaining B numbers are left
	{
		Set<Integer> diffB = new TreeSet<Integer>();
		diffB.addAll(two);
		diffB.removeAll(one);
		return diffB;
	}
	
	public Set<Integer> symmetricDifference() //using two previous methods, a third Set is included which piles both of the Sets from the previous two
	{		
		Set<Integer> symDiff = new TreeSet<Integer>();
		Set<Integer> diffB = new TreeSet<Integer>();
		diffB.addAll(two);
		diffB.removeAll(one);
		Set<Integer> diffA = new TreeSet<Integer>();
		diffA.addAll(one);
		diffA.removeAll(two);
		symDiff.addAll(diffA);
		symDiff.addAll(diffB);
		return symDiff;
	}	
	
	//returns the statement like an AMAZING king
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n\nunion - " + union() + 
				"\nintersection - " + intersection() + "\ndifference A-B - " + differenceAMinusB() +
				"\ndifference B-A - " + differenceBMinusA() + "\nsymmetric difference - " + symmetricDifference();
	}
}