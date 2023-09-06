import java.util.Objects;

public class Person 
{
	private String name;
	public Person(String name)
	{
		this.name = name;
	}
	@Override
	public int hashCode()
	{
		return (name.length()) % 10;
	}
	@Override
	public boolean equals(Object obj)
	{
		Person temp = (Person) obj;
		if(temp.name == name)
		{
			return true;
		}
		return false;
	}
	@Override
	public String toString()
	{
		return name;
	}
}
