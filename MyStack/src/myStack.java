import java.util.EmptyStackException;
import java.util.*;
public class myStack 
{
	private int[] stack;
	private int size;
	private int start;
	myStack()
	{
		stack = new int[50000];
		size = 0;
		start = 0;
	}
	/**
	 * constructor for myStack and initiating variables
	 * @param initCap
	 */
	myStack(int initCap)
	{
		stack = new int[initCap];
		size = 0;
		start = 0;
	}

	/**
	 * finds size of stack
	 * @return the length of the stack...
	 */
	public int size()
	{
		return stack.length;
	}

	/**
	 * looks at the top of the stack and returns that
	 * @return the top element of stack
	 * @throws EmptyStackException if there is not any in stack
	 */
	public int peek()
	{
		if(size<0)
			throw new EmptyStackException();
		return stack[size];
	}
	/**
	 * removes the top of the stack and returns its value
	 * @return the top element of stack after removal
	 * @throws EmptyStackException if there is nothing in stack
	 */
	public int pop() throws EmptyStackException
	{
			if(size==0)
				throw new EmptyStackException();
			int i = stack[size];
			size--;
			return i;
	}
	/**
	 * checks if the stack is empty
	 * @return true if empty, false if not
	 */
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		return false;
	}
	/**
	 * adds value to top of stack
	 * @param item the item being added
	 */
	public void push(int item)
	{
		if(size == stack.length)
		{
			doubleCapacity();
		}
		size++;
		stack[size] = item;
	}
	/**
	 * doubles the size of array
	 */
	public void doubleCapacity()
	{
		int [] i = new int[stack.length*2];
		for(int b = 0; b<stack.length;b++)
		{
			i[b] = stack[b];
		}
		stack = i;
	}
	/**
	 * returns the toString being printed
	 */
	public String toString()
	{
		String out = "[";
		for(int i = 1; i<=size;i++)
			out += stack[i] + ", ";
		return out + "]";
	}

}