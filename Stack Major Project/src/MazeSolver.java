import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * the abstract class controlling the main algorithms for solving the maze
 * @author hs10066964
 *
 */
public abstract class MazeSolver 
{
    private Maze daze; //the maze that is being used
    public Maze mazeRunner; //maze that will be set based on constructor parameter
    private boolean solved; //turns true if maze is solved
    private boolean solveable; //if the maze has reached all possible points and has yet to be solved, turns false
    private String finalPath = "";
    private Square [][] mazeRunnerArray;

    /**
     * the abstract methods later implemented on myStack for
     * maze solving
     */
    public abstract void makeEmpty();

    public abstract void add(Square sq);

    public abstract Square remove();

    public abstract Square getNext();

    public abstract boolean isEmpty();

    /**
     * basic constructor that gets the start of the maze
     * and sets all variables to correct values
     * @param maze the cool maze
     */
    public MazeSolver(Maze maze)
    {
        mazeRunner = maze;
        mazeRunnerArray = mazeRunner.getMazeArray();
        solved = false;
        solveable = true;
    }
    
    /**
     * checks whether the maze is solved by identifying neighbors and if each position
     * around the current location has a symbol that was specified in square class
     * @param maze the cooler maze
     * @return false is there are parts to the square incomplete or if the maze is simply
     * unsolvable, true if the end has been reached
     */
    public boolean isSolved(Maze maze)
    {
    	if(mazeRunner.getFinish().getSquarePrevious() == null)
    		return false;
    	else
    	{
    		Square x = mazeRunner.getFinish().getSquarePrevious();
    		while (x.getType()!= Square.START&& x.getType()!=Square.WALL){
                x.typeSet(6);
                x = x.getSquarePrevious();
            }
            return true;
    	}
    	
    }

    /**
     * uses the algorithms for solving the maze, mainly checking
     * if the areas around are marked yet and if isSolved()
     * has returned true or not
     * @return will be null if the maze is empty, returns the maze regardless of
     * if it was solved or not
     */
    public Square step() {

        Square next = getNext();
        try {
        if(isSolved(mazeRunner))
        {
        	solveable = false;
        	solved = true;
        	getPath();
        }
    	
    	if(isEmpty()) {
            mazeRunner.solvable = false;
            return null;
        }
        if (next == mazeRunner.getFinish())
            return next;
        for (Square neighbor : mazeRunner.getNeighbors(next)) {
            if (!neighbor.isMarked() && neighbor != mazeRunner.getStart()) {
                neighbor.setSquarePrevious(next);
                if (neighbor == mazeRunner.getFinish()) {
                    return  next;
                }
                else {
                    neighbor.typeSet(4);
                    add(neighbor);
                }
            }
        }
        if (next.getType() != 1 && next.getType() !=2) 
        	next.typeSet(5);
        solveable = false;
        return next;
    	}
    	catch(NullPointerException e)
    	{
    		solved = false;
    		solveable = false;
    		return next;
    	}
    }
    
    /**
     * will continue to try to solve the maze until the finish
     * is reached or no possible locations are left
     * solveable will turn false if the finish is out of reach
     * and method will (break;) to stop recursion
     */
    public void solve()
    {
        add(mazeRunner.getStart());
        while (!isSolved(daze))
        {
            step();
            if (isEmpty() && mazeRunner.getFinish().getSquarePrevious()==null) 
            {	
            	solveable = false;
            	break;
            }
        }
        if(isSolved(mazeRunner))
        {
        solved = true;
        solveable = true;
        }
    }

    /**
     * returns the maze conclusion message, checking the booleans of isSolved(), solveable, and solved
     * to determine the final message
     * @return the message of the maze solving
     */
	public String getPath()
	{
		if(!isSolved(mazeRunner) && !solveable && !solved)
		{
			finalPath = "Unsolvable";
		}
		else if(!solved && !isSolved(mazeRunner))
		{
			finalPath = "Not solved yet...";
		}
		
		else if(isSolved(mazeRunner))
		{
			finalPath = "Solved";
		}
		return finalPath;
		
		
		
		
//extra credit attempt
//		
//		this was an attempt to get the coordinates of the array, while it does show the coordinates for 
//		most of the maze, the final part does not work		
//		/*for (int row = 0; row < mazeRunner.getNumRows(); row++) 
//        {
//            for (int col = 0; col < mazeRunner.getNumCols(); col++) 
//            {	
//                if (mazeRunnerArray[row][col].getType() == 6)
//                {
//                    finalPath += "["+Integer.toString(row) +", "+ Integer.toString(col) + "]-> here";
//                }
//            }
//        }*/
	}



}