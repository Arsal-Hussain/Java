import java.util.*;

public class PostFix //my postfix
{
	private Stack<Double> stack;
	private String expression;

	/**
	 * constructor instiating stack object
	 */
	public PostFix()
	{
		stack = new Stack<Double>();
	}

	/**
	 * sets the expression with local variable
	 * @param exp the expression called from runner
	 */
	public PostFix(String exp)
	{
		stack = new Stack<Double>();
		setExpression(exp);
	}

	/**
	 * setting the expression
	 * @param exp the expression called from runner
	 */
	public void setExpression(String exp)
	{
		this.expression = exp;
	}

	/**
	 * this gets called from other methods when a math symbol is found,
	 * will do the math on the param based on the symbol indicated
	 * @param one the first val
	 * @param two second val
	 * @param op the symbol identified
	 * @return the answer based on operation
	 */
	public double calc(double one, double two, char op)
	{
		double answer = 0.0;
		switch(op)
		{
			case'+':
			answer = one + two;
			break;
			
			case'-':
			answer = one - two;
			break;
			
			case'/':			
			answer = two / one;
			break;
			
			case'*':
			answer = one * two;
			break;
			
		}
		return answer;
	}

	/**
	 * loops through the expression locating for operation
	 * symbol and will call calc to do the math, pops the stack
	 * of the two previous values
	 */
	public void solve()
	{
		String[] val = this.expression.split(" ");
		for(int i = 0; i < val.length; i++)
		{
			if(val[i].equals("+") || val[i].equals("-") || val[i].equals("*") || val[i].equals("/"))
			{
				double answer = calc(stack.pop(), stack.pop(), val[i].charAt(0));
				stack.push(answer);
			}
			else
				stack.push(Double.parseDouble(val[i]));
		}
	}

	//add a toString
	//this is the cool toString
	public String toString()
	{
		return this.expression + " = " + Double.toString(stack.pop());
	}
}