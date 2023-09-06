import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorReplacerRunner
{
	public static void main ( String[] args )
	{
		IteratorReplacer app = new IteratorReplacer("1 2 3 1 2 4 ", "1", "5");
		app.setEmAll("1 2 3 1 2 4 ", "1", "5");
		app.replace();
		System.out.println("IteratorReplacer(1 2 3 1 2 4, 1, 5) turns into " +app.toString());
		
		app = new IteratorReplacer("1 2 3 4 5 6 7 8 9 10 -1 -1 -1 ", "-1", "42");
		app.setEmAll("1 2 3 4 5 6 7 8 9 10 -1 -1 -1 ", "-1", "42");
		app.replace();
		System.out.println("IteratorReplacer(1 2 3 4 5 6 7 8 9 10 -1 -1 -1, -1, 42) turns into " +app.toString());
		
		app = new IteratorReplacer("3 1 4 1 5 9 33 72 -3 2 3 6 ", "3", "0");
		app.setEmAll("3 1 4 1 5 9 33 72 -3 2 3 6 ", "3", "0");
		app.replace();
		System.out.println("IteratorReplacer(3 1 4 1 5 9 33 72 -3 2 3 6, 3, 0) turns into " +app.toString());
		
		//those were the examples given from the problem
		
		app = new IteratorReplacer("9 8 7 6 5 4 3 2 1", "8", "0");
		app.setEmAll("9 8 7 6 5 4 3 2 1", "8", "0");
		app.replace();
		System.out.println("IteratorReplacer(9 8 7 6 5 4 3 2 1, 8, 0) turns into " + app.toString());
		
		app = new IteratorReplacer("2 4 6 3 2 1 4 8 5", "4", "9");
		app.setEmAll("2 4 6 3 2 1 4 8 5", "4", "9");
		app.replace();
		System.out.println("IteratorReplacer(2 4 6 3 2 1 4 8 5, 4, 9) turns into " + app.toString());
	}
}