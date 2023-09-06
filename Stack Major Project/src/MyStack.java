import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * implements methods to create a look alike of Stack class
 * @author hs10066964
 *
 */
public class MyStack implements StackADT
{
	private Square[] stack; //array that acts like a stack
	private int size; //size of "stack"
	private int start; //beginning of stack
	/**
	 * constructor of the class, initializing the stack array to it's size
	 */
	MyStack()
	{
		stack = new Square[50000];
		size = 0;
		start = 0;
	}
	/**
	 * second constructor initializing variables but also
	 * sets the size of the stack array based on parameter
	 * @param initCap the size of the array
	 */
	MyStack(int initCap)
	{
		stack = new Square[initCap];
		size = 0;
		start = 0;
	}

	/**
	 * @return length of the array, which is the size of the stack
	 */
	public int size()
	{
		return stack.length;
	}

	/**
	 * locates the top value of stack and returns value without
	 * its removal from stack array
	 * @return the value of the top of stack, but if empty, returns
	 * exception
	 * @throws EmptyStackException
	 */
	public Square peek()
	{
		if(size<0)
			throw new EmptyStackException();
		return stack[size];
	}
	/**
	 * removes top value of stack and returns that top value
	 * @return top value of stack then removes it from array,
	 * throws exception if stack array is empty
	 * @throws EmptyStackException
	 */
	public Square pop()throws EmptyStackException
	{
		Square sq = stack[size];
		try
		{
			if(isEmpty())
				throw new EmptyStackException();
		}catch(NullPointerException e)
		{
			sq = stack[size];
			size--;
			return sq;
		}
		return sq;
					
			
	}
	/**
	 * checks if there is nothing inside of stack array
	 * @return true if nothing in stack, false if value located
	 */
	 public boolean isEmpty()
	 {
	        return stack.length == 0;
	    }
	/**
	 * adds item to top of stack
	 * @param item the item being added to stack array
	 */
	public void push(Square item)
	{
		if(size == stack.length)
		{
			doubleCapacity();
		}
		size++;
		stack[size] = item;
	}
	/**
	 * doubles capacity of array if the stack
	 * needs more space when adding more items
	 */
	public void doubleCapacity()
	{
		Square[] sq = new Square[stack.length*2];
		for(int i = 0; i<stack.length; i++)
		{
			sq[i] = stack[i];
		}
		stack = sq;
	}
	/**
	 * converts the stack array into a toString and prints it out
	 */
	public String toString()
	{
		String out = "[";
		for(int i = 1; i<=size;i++)
			out += stack[i] + ", ";
		return out + "]";
	}

	/**
	 * empties out the stack array one by one using for loop
	 */
	public void clear()
	{
		for(int i = 0; i < stack.length; i++)
		{
			stack[i] = null;
		}
	}

}