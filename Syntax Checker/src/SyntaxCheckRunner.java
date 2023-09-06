public class SyntaxCheckRunner
{
	public static void main ( String[] args )
	{
		//add test cases
		//these are all the test cases from the pdf
		SyntaxChecker app = new SyntaxChecker();
		app.setExpression("(abc(*def)");
		System.out.println(app);

		app.setExpression("[{}]");
		System.out.println(app);
		
		app.setExpression("[");
		System.out.println(app);
		
		app.setExpression("[{<()>}]");
		System.out.println(app);
		
		app.setExpression("{<html[value=4]*(12)>{$x}}");
		System.out.println(app);
		
		app.setExpression("[one]<two>{three}(four)");
		System.out.println(app);
		
		app.setExpression("car(cdr(a) (b)))");
		System.out.println(app);
		
		app.setExpression("car(cdr(a) (b))");
		System.out.println(app);
	}
}