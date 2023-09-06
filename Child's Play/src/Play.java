import java.util.*;
import java.io.*;
/**
 * Implements a search algorithm to indicate the number of dominos
 * that fall
 * @author Arsal Hussain
 *
 */
public class Play
{
	private static int vertices;
	private static ArrayList<Integer> arr[]; //adjacency matrix
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(new File("play.dat"));
		int num = scan.nextInt();
		while(num-- != 0)
		{
			vertices = scan.nextInt();
			int e = scan.nextInt();
			arr = new ArrayList[vertices]; 
			for(int i = 0; i < vertices; i++)
			{
				arr[i] = new ArrayList<>();
			}
			for(int i = 0; i < e; i++)
			{
				int u = scan.nextInt();
				int v = scan.nextInt();
				arr[u].add(v);
			}
			Stack<Integer> s = new Stack<>();
		    boolean[] visited = new boolean[vertices];
			System.out.println(search(vertices, visited, s));
		}
	}
	/**
	 * Search that goes through each domino and checks if they
	 * are fallen when visited while using dfs search to push them
	 * onto the stack
	 * @param v - the amount of domino tiles
	 * @param visited - each visited portion of each domino
	 * @param s - the stack
	 * @return
	 */
	public static int search(int v, boolean[] visited, Stack<Integer> s)
	{
		for(int i = 0; i < v; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				dfs(i, visited, s);
			}
		}
		Arrays.fill(visited, false);
		int ans = 0;
		while(!s.isEmpty())
		{
			int u = s.pop();
			if(!visited[u])
			{
				ans++;
				visited[u] = true;
				dfs(u, visited, s);
			}
		}
		return ans-1;
	}
	/**
	 * DFS search that goes through the dominos in an iterative and checks if they are not
	 * visited whilst setting the value to true and pushing them onto the stack.
	 * @param amount - the amount
	 * @param visited - dominoes visited val
	 * @param s - the stack
	 */
	public static void dfs(int amount, boolean[] visited, Stack<Integer> s)
	{
			for(Integer v: arr[amount])
			{
				if(!visited[v])
				{
					visited[v] = true;
					dfs(v, visited, s);
				}
			}
			s.push(amount);
	}
}