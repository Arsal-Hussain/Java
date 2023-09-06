//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		//add test cases
		Scanner input = new Scanner(new File("mathsetdata.dat"));
		while(input.hasNextLine())
		{//reads dat file and stores each line into temp which is used as param for each
			String temps = input.nextLine();
			String temps2 = input.nextLine();
			MathSet app = new MathSet(temps, temps2);
			System.out.println(app);
			System.out.println();
		}
	}
}
