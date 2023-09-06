import java.util.*;
/**
 * THis class finds the shortes path from a four digit prime number by changing
 * a single digit at a time.
 * @author Arsal Hussain
 *
 */
public class TrailofPrimes
{

	private static Queue<Integer> eachPrime;
	private static Integer l;
	private static Integer f;
	private static Stack<Integer> stack = new Stack<Integer>();
	private static Queue<Stack<Integer>> trailOfPrimes;
	private static Queue<Stack<Integer>> paths;
	private static int d = 999999999;
	private static Stack<Integer> tempStack;
	public static void main(String args[])
	{
		f = 1033;
		l = 1051;
		eachPrime = primes(f);
		Queue<Stack<Integer>> solution = getPrimePaths();
		System.out.println(solution);
		System.out.println(solution.peek().size() - 2);
		f = 1033;
		l = 1033;
		eachPrime = primes(f);
		solution = getPrimePaths();
		System.out.println(solution);
		System.out.println(solution.peek().size() - 2);
	}
	/**
	 * Gets a queue of integers using the Sieve of eratos prime mathematical way
	 * to generate the prime numbers while subquentally checking for each length of the string
	 * to match up with 4 and comparing both strings to see if the nums are different by
	 * 1 digit
	 * @param n - the 4 digit prime number
	 * @return the queue of 4 digit primes from the first to the last
	 */
	public static Queue<Integer> primes(Integer n)
	{
		Integer number;
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> primes = new LinkedList<Integer>();
        for (int i = 2; i <= l; i++)
        {
            queue.add(i);
        }
        do
        {
        	number = queue.poll();
        	
        	if(number.toString().length() == 4 && compareStrings(number.toString(), n.toString()))
        	{
        		primes.add(number);
        	}
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                int temp = queue.poll();
                if (temp % number != 0)
                {
                    queue.add(temp);
                }
            }
        } while (!queue.isEmpty());
        
        
		return primes;

	}
	/**
	 * Compare strings methods that checks each index and checks to see if there are 3 or more
	 * digits that are different thus having a 1 digit difference (similar to wordchain)
	 * @param n - the first number as a string
	 * @param n2 - the second number as a string
	 * @return - whether the compared strings are different by a 1 digit difference
	 */
	public static boolean compareStrings(String n, String n2)
	{
		int count = 0;
		for (int i = 0; i < n.length(); i++)
		{
			if (n.charAt(i) == n2.charAt(i))
			{
				count++;
			}
		}
		if (count >= 3)
		{
			return true;
		}
		return false;
	}
	/**
	 * Generates a linked list of stack integers and adds the starting prime
	 * number and each prime then after while adding it to the stack and 
	 * calls the addToQueue method
	 * @return the paths of the prime
	 */
	public static Queue<Stack<Integer>> getPrimePaths()
	{
		trailOfPrimes = new LinkedList<Stack<Integer>>();;
		while(!eachPrime.isEmpty())
		{
			stack = new Stack<Integer>();
			stack.push(f); 	stack.push(eachPrime.poll());
			trailOfPrimes.add(stack);
		}
		addToQueue(trailOfPrimes);
		return paths;

	}
	/**
	 * AddToQueue method that is very similar to word chain in that it loops through the trail of
	 * primes and gets each current prime and compares it to the prime we currently have while
	 * making sure the depth of such prime is applicable
	 * @param trailOfPrimes - the queue of stack integers containing the path of primes
	 */
	public static void addToQueue(Queue<Stack<Integer>> trailOfPrimes)
	{
		while (!trailOfPrimes.isEmpty())
		{
			Stack<Integer> currPrime = trailOfPrimes.remove();
			Integer last = currPrime.peek();
			if (last.equals(l) && currPrime.size() < d)
			{
				paths = new LinkedList<Stack<Integer>>();
					d = currPrime.size();
					paths.add(currPrime);
			} 
			else
			{
				if (currPrime.size() + 1<= d)
				{
					Queue<Integer> d = primes(currPrime.peek());
					for (Integer temp : d)
					{
						tempStack = new Stack<Integer>();
						tempStack.addAll(currPrime);
						tempStack.push(temp);
						trailOfPrimes.add(tempStack);
					}
				}
			}

		}
	}

}