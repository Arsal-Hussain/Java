import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class Acronyms
{
	private Map<String,String> acronymTable;

	public Acronyms()
	{
		acronymTable = new TreeMap<String, String>();
	}

	public void putEntry(String entry)
	{
		String[] acro = entry.split(" - ");
		String key = acro[0];
		String value = acro[1];
		acronymTable.put(key, value);
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output = "";
		while(chop.hasNext()) {
			String word = chop.next();
			if(acronymTable.containsKey(word))
				output += acronymTable.get(word) + " ";
			else if(acronymTable.containsKey(word.replace(".", "")))
				output += acronymTable.get(word.replace(".", "")) + ". ";
			else
				output += word + " ";
		}
		return output;
	}

	public String toString()
	{
		return acronymTable.toString().replaceAll(",", "\n");
	}
}