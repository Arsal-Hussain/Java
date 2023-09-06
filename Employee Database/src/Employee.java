public class Employee
{
	private String name;
	
	/**
	 * constructor initializing employee with a name
	 * @param name
	 */
	public Employee(String name)
	{
		this.name = name;
	}
	
	/**
	 * name of employee returned in toString
	 */
	@Override
	public String toString()
	{
		return name;
	}
}
