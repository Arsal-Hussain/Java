import java.util.*;
import java.io.*;
/**
 * This class implements the best solution for solving a binary maze at the given starting point and the ending point
 * following only the 1s.
 * @author Arsal Hussain
 *
 */
public class BinaryMaze
{
	private static int[][] possLocations = {{0,1} , {1, 0}, {-1 , 0}, {0, -1}}; //possible neighbors of the nodes
	private static int[][] maze;
	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(new File("maze2.txt"));
		int r = scan.nextInt(); //9 (maze2)
		int c = scan.nextInt(); //10 (maze2)
		System.out.print(r);
		System.out.println(" " + c);
		maze = new int[r][c];
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				maze[i][j] = scan.nextInt();
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		Location sourceNode = new Location(scan.nextInt(), scan.nextInt());
		Location destNode = new Location(scan.nextInt(), scan.nextInt());
		System.out.println(sourceNode);
		System.out.println(destNode);
		System.out.println("\n\n" + bfsMaze(sourceNode, destNode, maze));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * Bredth first search of binary maze that iterates through it checking each visited noded and getting each neigbors of the node in the rows
	 * whilst checking if they are a valid position.
	 * @param start - the start position
	 * @param end - the destination
	 * @param maze - the actual maze
	 * @return
	 */
	public static int bfsMaze(Location start, Location end, int maze[][])
	{
		int height = maze.length;
		int width = maze[0].length;
		boolean[][] visited = new boolean[height][width];
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				visited[i][j] = false;
			}
		}
		Queue q = new LinkedList();
		Area a = new Area(start, 0);
		q.add(a);
		ArrayList<Integer> f = new ArrayList<Integer>();
		System.out.println();
		while(!q.isEmpty())
		{
			Area curr =  (Area) q.poll();
			Location ar = curr.p;
			for(int i = 0; i < 4; i++)
			{
				int row = ar.x + possLocations[i][0];
				int col = ar.y + possLocations[i][1];
//				System.out.println(row + " ");
//				System.out.print(col + " ");
				f.add(row);
				try
				{
					while(row < width && row >= 0 && col < height && col >= 0 && maze[row][col] == 1 && !visited[row][col])
					{
						visited[row][col] = true;
						Area next = new Area(new Location(row, col), curr.distance+1);
						q.add(next);
						//System.out.println("x");
					}
				} catch (Exception e)
				{
				}
			}
		}
		if(f.get(f.size()-3) == 1)
		{
			return -1;
		}
		return f.get(f.size()-3) + 2;
	}
}
/**
 * Location class that defines the actual position in the maze with the
 * x and y coordinates
 * @author Michael
 *
 */
class Location
{
	int x, y;
	/**
	 * Basic constructor that initalizes a location
	 * @param x - the x index
	 * @param y - the y index
	 */
	public Location(int x, int y)
	{
		this.x  = x;
		this.y = y;
	}
	/**
	 * toString that prints out the x and y coordinate
	 * @return x and y coords
	 */
	public String toString()
	{
		return x + " " + y;
	}
}
/**
 * Area class that defines the distance of each node and its location
 * @author Michael
 *
 */
class Area
{
	int distance;
	Location p;
	/**
	 * Basic constructor that initalizes a location
	 *@param Location - x and y index
	 * @param distance - the distance
	 */
	public Area(Location p, int distance)
	{
		this.p = p;
		this.distance = distance;
	}
	/**
	 * toSTring that prints out the location and
	 * its distance
	 * @return location and distance
	 */
	public String toString()
	{
		return p.toString() + " " + distance;
	}
}