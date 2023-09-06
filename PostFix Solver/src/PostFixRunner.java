public class PostFixRunner
{
	public static void main ( String[] args )
	{
		//Add test cases
		//the test cases said from the pdf
		PostFix app = new PostFix();
		app.setExpression("2 7 + 1 2 + +");
		app.solve();
		System.out.println(app);
		
		app.setExpression("1 2 3 4 + + +");
		app.solve();
		System.out.println(app);
		
		app.setExpression("9 3 * 8 / 4 +");
		app.solve();
		System.out.println(app);
		
		app.setExpression("3 3 + 7 * 9 2 / +");
		app.solve();
		System.out.println(app);
		
		app.setExpression("9 3 / 2 * 7 9 * + 4 -");
		app.solve();
		System.out.println(app);
		
		app.setExpression("5 5 + 2 * 4 / 9 +");
		app.solve();
		System.out.println(app);
	}
}