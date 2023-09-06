import java.util.*;

public class IntegerCalculator
{
	private int operand1;
	private int operand2;
	private int result;

	public IntegerCalculator()
	{
		mainMenu();
	}

	public void mainMenu()
	{
		int ans = 0;

		do
		{
			ans = getInfo();

			if(ans == 1)
               add();
			if(ans == 2)
               subtract();
			if(ans == 3)
               multiply();
			if(ans == 4)
			   divide();

			System.out.println();
		}
		while(ans != 5);
	}

	// Postcondition:Retrieves calculator input from the user.
	//   Asks the user to select from a menu which operation they wish
	//   to perform 1) add 2) subtract 3) multiply 4) divide.
	//   It then asks the user to enter in two operands. If either of
	//   the two operands are not valid integers it displays an error
	//   message and asks the user for the information again.
	//   The method returns an integer representing operation selected
	//   by the user
	public int getInfo()
	{
		int run = 0;
		Scanner scan = new Scanner(System.in);
		try //this will perform normal command so long as user inputs a number between 1 thru 5 and will pass return to mainMenu
		{
		System.out.print("1)Add 2)Subtract3)Multiply 4)Divide 5)Quit -->");
		run = scan.nextInt();
		if(run == 5) //ends code if 5 is inputed
			return run;
		System.out.print("\nOperator 1 -->");
		operand1 = scan.nextInt();
		System.out.print("Operator 2 -->");
		operand2 = scan.nextInt();
		System.out.println();
		return run;
		}
		catch(Exception e) //if thou inputs tomfoolery, thou will be given message that we don't accept such mockery here (also the operands end up resetting to avoid repeats)
		{
			System.out.println("\nNot a valid number, try again.");
			operand1 = 0;
			operand2 = 0;
			run = 0;
		}
		return run; //if try has failed, it just returns 0 which isn't accepted by mainMenu method
	}

	public void add()
	{
		result = operand1 + operand2;
		System.out.println(operand1 + " + " + operand2 + " = " + result);
	}

	public void subtract()
	{
		result = operand1 - operand2;
		System.out.println(operand1 + " - " + operand2 + " = " + result);
	}

	public void multiply()
	{
		result = operand1 * operand2;
		System.out.println(operand1 + " * " + operand2 + " = " + result);

	}

	// Precondition:  two valid operands
	// Postcondition: performs the division operation on the two
	//    operands and displays the results. If a division by zero
	//    error occurs it displays an error message and does not
	//    display any results.
	public void divide() throws ArithmeticException
	{
		try //this is like normal as to all the other methods are doing
		{
		result = operand1 / operand2;
		System.out.println(operand1 + " / " + operand2 + " = " + result);
		}
		catch(ArithmeticException e) //this exception checks to see if the user is dividing by zero and will "catch" it to avoid breaking code
		{
			System.out.println("Error: You cannot divide by zero!");
		}
	}

	public static void main(String[] args)
	{
		IntegerCalculator app = new IntegerCalculator();
	}
}