//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
		UniquesDupes app = new UniquesDupes();
		
		System.out.println("Original List : a b c d e f g h a b c d e f g h i j k");
		System.out.println("Uniques : " + app.getUniques("a b c d e f g h a b c d e f g h i j k"));
		System.out.println("Dupes : " + app.getDupes("a b c d e f g h a b c d e f g h i j k") + "\n");
		
		System.out.println("Original List : one two three one two three six seven one two");
		System.out.println("Uniques : " + app.getUniques("one two three one two three six seven one two"));
		System.out.println("Dupes : " + app.getDupes("one two three one two three six seven one two") + "\n");
		
		System.out.println("Original List : 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6");
		System.out.println("Uniques : " + app.getUniques("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"));
		System.out.println("Dupes : " + app.getDupes("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6") + "\n");

		//uh these are the examples... not much to document

	}
}