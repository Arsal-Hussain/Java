//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		//more test cases
		Scanner input = new Scanner(new File("oddeven.dat"));
		while(input.hasNextLine())
		{ //reads dat file and stores each line into temp which is used as param
			String temps = input.nextLine();
			OddEvenSets app = new OddEvenSets(temps);
			System.out.println(app);
		}
	}
}