import java.util.*;

public class SyntaxChecker
{
	private String exp; //the expression being checked
	private Stack<Character> symbols; //each of the symbols that are used for syntax
	ArrayList<Character> list; //the list that will contain the string as char

	/**
	 * constructor of the class
	 */
	public SyntaxChecker()
	{
		symbols = new Stack<Character>();
	}

	/**
	 * sets the local variable with the parameter variable
	 * @param s the string being used from runner
	 */
	public SyntaxChecker(String s)
	{
		setExpression(s);
	}
	
	/**
	 * sets the local variables with parameter as well as adds each letter from param to list as a char
	 * @param s the string of the runner
	 */
	public void setExpression(String s)
	{
		symbols = new Stack<Character>();
		list = new ArrayList<Character>();
		exp = s;
		for(int i = 0; i < s.length(); i++)
		{
			list.add(s.charAt(i));
		}
	}

	/**
	 * checks if there is a syntax being used and will push it on symbols
	 * then will keep searching for the ending syntax if it is there
	 * @return true if the beginning and ending syntax are found and there is no syntax disruption
	 * and false if any of the things I just said are not true
	 */
	public boolean checkExpression()
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i)=='['||list.get(i)=='{'||list.get(i)=='('|| list.get(i)=='<')
			{
				symbols.push(list.get(i));
			}
			else if(list.get(i)=='}'||list.get(i)=='>'||list.get(i)==')'||list.get(i)==']')
			{
				if(!symbols.isEmpty()) 
				{
					if((symbols.peek()=='['&&list.get(i)==']')|| (symbols.peek()=='('&&list.get(i)==')')||(symbols.peek()=='{'&&list.get(i)=='}')|| (symbols.peek()=='<'&&list.get(i)=='>'))
					{
						char a = symbols.pop();
					}
				}
				else
					return false;
			}
		}
		if(symbols.isEmpty())
			return true;
		return false;
	}

	//write a toString
	/**
	 * well, here's my toString
	 */
	public String toString()
	{
		if(checkExpression())
			return exp + " is correct.";
		return exp + " is incorrect.";
	}
}