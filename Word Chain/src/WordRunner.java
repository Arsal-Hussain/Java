import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordRunner
{
	public static void main(String[] args) throws IOException
	{
		int size = 16;
		WordChain wow = new WordChain("dictionary.txt");
		Scanner scan = new Scanner(new File("input.txt"));
		for (int i = 0; i < size; i++)
		{
			wow.setStartEnd(scan.next(), scan.next());
			System.out.println(wow.toString());
		}

	}
}
