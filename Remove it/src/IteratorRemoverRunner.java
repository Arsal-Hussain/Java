import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorRemoverRunner
{
	public static void main ( String[] args )
	{
		IteratorRemover app = new IteratorRemover("a b c a b c a", "a");
		app.setTest("a b c a b c a", "a");
		app.remove();
		System.out.println("Iterator Remover(a b c a b c a, a) turns into "+app.toString());
		
		app = new IteratorRemover("a b c d e f g h i j x x x x", "x");
		app.setTest("a b c d e f g h i j x x x x", "x");
		app.remove();
		System.out.println("Iterator Remover(a b c d e f g h i j x x x x, x) turns into "+app.toString());
		
		app = new IteratorRemover("1 2 3 4 5 6 a b c a b c", "b");
		app.setTest("1 2 3 4 5 6 a b c a b c", "b");
		app.remove();
		System.out.println("Iterator Remover(1 2 3 4 5 6 a b c a b c, b) turns into "+app.toString());
		
		//these are the ones the pdf gave
		
		app = new IteratorRemover("w 4 5 s 7 l 2 h", "s");
		app.setTest("w 4 5 s 7 l 2 h", "s");
		app.remove();
		System.out.println("Iterator Remover(w, 4, 5, s, 7, l, 2, h) turns into " + app.toString());
		
		app = new IteratorRemover("9 8 7 6 5 4 3 2 1", "3");
		app.setTest("9 8 7 6 5 4 3 2 1", "3");
		app.remove();
		System.out.println("Iterator Remover(9, 8, 7, 6, 5, 4, 3, 2, 1) turns into " + app.toString());
		
	}
}