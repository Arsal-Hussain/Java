import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * will implement all paths in passage
 * @author Arsal Hussain
 *
 */
public class Scooby
{
	static int len;
    static String res = "no";
    static int check;
	static Set<Character> t = new TreeSet<Character>();
    static ArrayList<String> list = new ArrayList<String>();
    @SuppressWarnings({ "unchecked" })
	public static void main(String args[]) throws FileNotFoundException
    {
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(new File("scooby.dat"));
        int num = scan.nextInt();
        scan.nextLine();
        LinkedList<String> paths[];
    	for (int i = 0; i < num; i++)
        {

            String word = scan.nextLine();
            String[] array = word.split(" ");
            String finalDest = scan.nextLine();
            
            paths = new LinkedList[array.length];
            addEdge(array, paths);
            check = 0;
            DFS(paths, finalDest.substring(0, 1), finalDest.substring(1), 0);
            if(check == 0)
            {
                System.out.println(res);
            }
        }
    }
    /**
     * DFS method that will go through each path as an iterative
     * and will check if there is edge for destination
     * @param tPaths - the paths of the secret passage
     * @param r - the room
     * @param f - the destination to look for
     * @param i - the iterator
     */
    public static void DFS(LinkedList<String> tPaths[], String room, String dest, int i)
    {
        if (i >= tPaths.length)
        {
            res = "no";
            System.out.println(res);
            check = 1;
            return;
        }
        if (tPaths[i].toString().substring(2, 3).equals(dest)||tPaths[i].toString().substring(1, 2).equals(dest))
        {
            res = "yes";
            return;
        } else
        {
            for (int k = 0; k < tPaths.length; k++)
            {
                if (tPaths[k].toString().contains(room))
                    DFS(tPaths, tPaths[k].toString().substring(2, 3), dest, i+=1);
            }

        }
        return;
    }
    /**
     * Adds each edge to the linked list
     * @param array - the array
     * @param paths - the secret passages
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addEdge(String[] array, LinkedList[] paths)
    {
        for (int j = 0; j < array.length; j++)
        {
        	paths[j] = new LinkedList();
        	paths[j].add(array[j]);

        }
    }
}