import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class implements the logical layout of the maze
 * and stores references of squares in maze
 * @author hs10066964
 *
 */
public class Maze
{
	private int numCols; //number of columns in the maze
	private int numRows; //number of rows in the maze
	private Square[][] mazeArray; //creates the maze
	private Square start; //beginning look before solve attempted
	private Square finish; //end result regardless of solved or not
	public boolean solvable; //checks if maze is solve then gets turned to true

	/**
	 * Utilization of the Scanner to upload the maze by name, the numCols and numRows will generate the maze
	 * based on the first two numbers in the file, keeps reading file to identify the start and finish of maze
	 * if the file cannot be located, the catch will intercept and tell user that the file cannot be found
	 * @param fName the file name in question that will be used if found
	 * @return false if file is not located, true if file is found and maze is generated
	 */
	public boolean loadMaze(String fName)
	{
	        try
	        {
	            Scanner MAZE = new Scanner(new File(fName));
	            numRows = MAZE.nextInt();
	            numCols = MAZE.nextInt();
	            mazeArray = new Square[numRows][numCols];
	            for (int row=0; row < numRows; row++)
	            {
	                for (int col=0; col<numCols; col++)
	                {
	                    mazeArray[row][col] = new Square(MAZE.nextInt(), row, col);
	                    if (mazeArray[row][col].toString() == "S"){start = mazeArray[row][col];
	                    }
	                    if (mazeArray[row][col].toString() == "E"){ finish = mazeArray[row][col];
	                    }
	                }
	            }
	            System.out.println(mazeArray.length);
	            reset(); //this is to keep the default maze before solve attempt
	            return true;
	        } 
	        catch (FileNotFoundException e) 
	        {
	            return false;
	        }
	}

	/**
	 * Checks surrounding neighbors around the square based on
	 * up, down, left, and right of current location, each if
	 * statement will look for a neighbor based on local variable
	 * numCols and numRows and creates those in method
	 * @param sq the square to check for
	 * @return the list of neighbors around the square
	 */
	public ArrayList<Square> getNeighbors(Square sq)
	{
		int rowVal = sq.getRow();
		int colVal = sq.getCol();
		ArrayList<Square> neighbors = new ArrayList<Square>();
		if (!(colVal == 0) && sq.getType() != 1)
			neighbors.add(mazeArray[rowVal][colVal - 1]);
		if (!(rowVal == numRows - 1) && sq.getType() != 1)
			neighbors.add(mazeArray[rowVal + 1][colVal]);
		if (!(colVal == numCols - 1) && sq.getType() != 1)
			neighbors.add(mazeArray[rowVal][colVal + 1]);
		if (!(rowVal == 0) && sq.getType() != 1)
			neighbors.add(mazeArray[rowVal - 1][colVal]);
		return neighbors;
	}

	/**
	 * locates the starting spot of the maze
	 * when initialized by user
	 * @return the start of the square
	 */
	public Square getStart()
	{
		return start;
	}

	/**
	 * finds end spot of the maze when user has either solved
	 * it or the maze is unsolvable
	 * @return the end of the square
	 */
	public Square getFinish()
	{
		return finish;
	}

	/**
	 * puts the maze back to original state if the user
	 * presses the reset button, as well as resets the type
	 */
	public void reset()
	{
		for (int r = 0; r < numRows; r++)
		{
			for (int c = 0; c < numCols; c++) //nested for loop is to go through array and change each position back to original
			{
				mazeArray[r][c].resetType();
				mazeArray[r][c].setSquarePrevious(null);
			}
		}
	}

	/**
	 * print the toString to the maze
	 * @return the maze as a string
	 */
	public String toString()
	{
		String str = "";
		for (int r = 0; r < numRows; r++)
		{
			for (int c = 0; c < numCols; c++)
			{
				str += mazeArray[r][c].toString();
			}
			str += "\n";
		}

		return str;
	}

	/**
	 * the number of columns based on file
	 * @return the number of columns
	 */
	public int getNumCols()
	{
		return numCols;
	}

	/**
	 * the number of rows based on file
	 * @return number of rows
	 */
	public int getNumRows()
	{
		return numRows;
	}

	/**
	 * the current state of the maze
	 * @return the maze as array
	 */
	public Square[][] getMazeArray()
	{
		return mazeArray;
	}
}