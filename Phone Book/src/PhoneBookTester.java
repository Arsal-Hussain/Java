import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookTester 
{
	public static void main(String[] args) throws IOException 
	{
		PhoneBook tester = new PhoneBook();
		Scanner scan = new Scanner(new File("White Pages.txt"));

		while(scan.hasNextLine()) 
		{
			String[] parts = scan.nextLine().split(",");
			Person tempP = new Person(parts[0] + parts[1]);
			PhoneNumber tempN = new PhoneNumber(parts[2]);
			tester.put(tempP, tempN);
		}
		System.out.println(tester);
//		
//		
//		String[] parts = scan.nextLine().split(",");
//		Person tempP = new Person(parts[0] + parts[1]);
//		PhoneNumber tempN = new PhoneNumber(parts[2]);
//		tester.put(tempP, tempN);
//		scan.nextLine();
//		parts = scan.nextLine().split(",");
//		tempP = new Person(parts[0] + parts[1]);
//		tempN = new PhoneNumber(parts[2]);
//		tester.put(tempP, tempN);
//		System.out.println(tester);
//		
		
		

	}
}