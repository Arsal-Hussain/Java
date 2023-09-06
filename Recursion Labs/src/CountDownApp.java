import java.util.*;

public class CountDownApp
{
    public static void main(String[] args)
    {
        CountDownTester cd = new CountDownTester();
        Scanner keyboard = new Scanner(System.in);
            
        System.out.print("Enter starting value --> ");
        int s = keyboard.nextInt();
            
        System.out.println(cd.countDown(s));
    }
}

class CountDownTester
{
	/**
	 * 
	 * @param n the value being passed that is counting down
	 * @return the next descended value
	 */
    public int countDown(int n)
    {
    	System.out.println(n); //prints out each int value
    	if(n>2) //checks to see if parameter is greater than 2
    		countDown(n-1); //will continue to recur until less than 2 or equal to 2
    	return n-(n-1); //prints final number, which is always 1
    }
}