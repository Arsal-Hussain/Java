import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;

	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();
	}

	public PartList(String fileName)
	{
		this();
		try
		{
			//add code here to read from the file
			//and add Parts to the map
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNext())
			{
				Part p = new Part(scan.nextLine());
				if(partsMap.get(p) == null)
					partsMap.put(p, 0);
				partsMap.put(p, partsMap.get(p) + 1);
			}
		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
			//what if i wanted to
		}
	}

	public String toString()
	{
		String output="";
		for(Part parts : partsMap.keySet())
			output += parts + " - " + partsMap.get(parts) + "\n";
		return output;
	}
}