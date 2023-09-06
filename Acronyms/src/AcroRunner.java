import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		//add test cases
		Scanner scan = new Scanner(new File("acro.dat"));
		Acronyms acro = new Acronyms();
		int num = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < num; i++)
		{
			acro.putEntry(scan.nextLine());
		}
		System.out.println("\n====    MAP CONTENTS    ====\n\n");
		System.out.println(acro);
		System.out.println("\n");
		System.out.println("\n====    READ LINES    ====\n\n");
		while(scan.hasNext())
		{
			String sent = scan.nextLine();
			System.out.println(acro.convert(sent));
		}
	}
}