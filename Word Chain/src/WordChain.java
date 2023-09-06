import java.io.File;
import java.io.*;
import java.util.*;

public class WordChain
{
	private static int DICTIONARYSIZE = 127141;
	private HashSet<String> dictionary;
	String start;
	String end;
	/**
	 * constructor that initializes variables and recieves the words
	 * from dictionary
	 * @param dict the dictionary from .txt file
	 * @throws IOException
	 */
	public WordChain(String dict) throws IOException
	{
		dictionary = new HashSet<String>();
		Scanner scan = new Scanner(new File(dict));
		for (int i = 0; i < DICTIONARYSIZE; i++)
			dictionary.add(scan.nextLine().toLowerCase());
	}
	/**
	 * sets the start and end words based on parameter
	 * @param start
	 * @param end
	 */
	public void setStartEnd(String start, String end)
	{
		this.start = start;
		this.end = end;
	}
	/**
	 * Builds word ladder by changing letter each time.
	 * Need to keep track of each horizontal slice of paths.
	 * @return queue if possible or null when not possible
	 */
	public Queue<Stack<String>> buildLadder()
	{
		// start and end must be in the dictionary and lengths must be same to move on
		if (!dictionary.contains(start) || !dictionary.contains(end) || start.length() != end.length())
		{
			return null;
		}  
		// Assign keys to the objects, and assigns each path a key
		Map<String, List<String>> parent = new HashMap<>();
		//links start to end, first word in path
		Queue<String> queue = new LinkedList<>();
		//Vists paths in current level
		Set<String> lvlVisited = new HashSet<>();
		//If the entire level is visited add it to visited
		Set<String> visited = new HashSet<>();
		//queue of all stacks with the shortest amount of paths
		Queue<Stack<String>> result = new LinkedList<>();
		//Add starting word
		parent.put(start, null);
		queue.offer(start);
		visited.add(start);
		//flag if path is found
		boolean foundDestination = false;
		while (!queue.isEmpty())
		{
			//get either the starting word or a word of a new path, queue gets refilled at end 
			String word = queue.poll();
			// Double for loops to traverse all modified combinations
			for (int i = 0; i < word.length(); i++)
			{
				char wordArray[] = word.toCharArray();
				for (char ch = 'a'; ch <= 'z'; ch++)
				{
					//If character modified is the same as original word don't bother checking
					if (wordArray[i] == ch)
						continue;
					//Modifying the word using char Array
					wordArray[i] = ch;
					String newWord = new String(wordArray);

					// if modified word doesn't equal end word or was visited
					// moves to next modified word
					if (!end.equals(newWord) && (!dictionary.contains(newWord) || visited.contains(newWord)))
					{
						continue;
					}
					
					//Creating parentList to fill into parent map
					List<String> parentList = parent.get(newWord);
					//if parents list is empty, add the list to the map and the modified word as a key
					if (parentList == null)
					{
						parentList = new ArrayList<>();
						parent.put(newWord, parentList);
					}
					//add starting word or word of new path
					parentList.add(word);
					//add the modified word to a level visited
					lvlVisited.add(newWord);
					//if the modified word equals to the end word set destination to true
					if (end.equals(newWord))
					{
						foundDestination = true;
						break;
					}
					
				}
			}
			//checks if queue is full then loop another time until queue empties
			if (!queue.isEmpty()) {
				continue;
			}	
			// break loop is foundDestination is true
			if (foundDestination)
			{
				break;
			}
			//if destination not found, add all words in level visited to queue and set it marked as visited
			//The queue with all the branching nodes will be traversed one by one in the beginning of the loop
			for (String word2 : lvlVisited)
			{
				queue.offer(word2);
				visited.add(word2);
				
			}
			//Clear levelVisited for next solution 
			lvlVisited.clear();
		}
		
		// If path can't be found to start from end return null
		if (!foundDestination)
			return null;
		else // Fill result with a stack of shortest paths.
			setParent(parent, start, new Stack<>(), end, result);
		//the list is added backwards to forwards so reversed
		for(Stack<String> item: result)
			Collections.reverse(item);
		

		return result;
	}
	/**
	 * Fills result list with words of shortest path
	 * @param parent
	 * @param startWord
	 * @param path
	 * @param currentWord
	 * @param result
	 */
	private void setParent(Map<String, List<String>> parent, String startWord, Stack<String> path, String currentWord,
			Queue<Stack<String>> result)
	{
		path.add(currentWord);
		//Exit condition: if current word meets starting word
		if (startWord.equals(currentWord))
		{
			Stack<String> temp = new Stack<String>();
			temp.addAll(path);
			result.add(temp);
			path.remove(path.size() - 1);
			return;
		}
		//where p is the end word iterating backwards to the first word(only one path this way), using the object mapped to the Maps key to find path
		for (String p : parent.get(currentWord))
		{
			setParent(parent, startWord, path, p, result);
		}
		path.remove(path.size() - 1);

	}
	/**
	 * prints if ladder is found and its toString or no ladder with only start and end words
	 */
	public String toString()
	{
		//buildLadder() returns all shortest paths, only need one (peek())
		if (buildLadder() != null)
			return "Found a ladder! >>> " + buildLadder().peek().toString();
		return "No ladder between " + start + " and " + end;
	}

}
