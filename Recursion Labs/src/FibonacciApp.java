import java.util.*;

public class FibonacciApp
{
    public static void main(String[] args)
    {
        FibonacciTester f = new FibonacciTester();
        Scanner keyboard = new Scanner(System.in);
           
        System.out.print("Enter number -->");
        int n = keyboard.nextInt();
        int result = f.fibonacci(n);
        System.out.println("Fibonacci("+n+") = " + result);
    }
}

class FibonacciTester
{
	/**
	 * 
	 * @param n the initial value passed to determine fibonacci sequence
	 * @return number of fibonacci sequence associated with param
	 */
    public int fibonacci(int n)
    {
        if(n > 2) //checks if param is greater than 2
        	return fibonacci(n-1) + fibonacci(n-2); //will continue to recur the entire Fibonacci sequence until param is less than or equal to 2
        else
        	return 1; //when the param is less than or equal to 2
    }
}
