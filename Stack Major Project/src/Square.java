import java.awt.Point;
/**
 * implements a maze and uses types to depict if there is
 * empty, wall, exit, start, working, explored, or final path
 * @author hs10066964
 *
 */
public class Square 
{
    public static final int SPACE = 0; //empty space
    public static final int WALL = 1; //wall
    public static final int START = 2; //start
    public static final int EXIT = 3; //exit
    public static final int WORKLIST = 4; //still working to solve
    public static final int EXPLORED = 5; //already seen this part of maze
    public static final int FINALPATH = 6; //on the exit of the path

    Point location; //using rows and cols, the current location in the maze
    public int squareType; //type of square based on the final ints going through it
    public int finalType; //the end type of the square regardless of solved or not
    private Square squarePrevious; //the previous depiction of the square

    /**
     * basic constructor initialized using rows and columns
     * @param typeInt -  current type of square
     * @param Row the row of the square in maze
     * @param Column the column of the square in maze
     */
    public Square(int typeInt, int row, int column)
    {
        squareType = typeInt;
        location = new Point(row, column);
        finalType = typeInt;
        squarePrevious = null;
    }

    /**
     * uses switch cases to identify the type throughout the maze
     */
    public String toString()
    {
        switch(squareType)
        {
            case SPACE:
                return "_";
            case WALL:
                return "#";
            case START:
                return "S";
            case EXIT:
                return "E";
            case WORKLIST:
                return "o";
            case EXPLORED:
                return ".";
            case FINALPATH:
                return "x";
            default:
                return "~";

        }
    }

    /**
     * 
     * @return the current type of the square
     */
    public int getType()
    {
        return squareType;
    }

    /**
     * sets the type to whatever the parameter says
     * @param newType the new type being called
     */
    public void typeSet(int newType)
    {
        squareType = newType;
    }

    /**
     * defaults the type to original when user presses reset
     * called from reset()
     */
    public void resetType()
    {
        squareType = finalType;
    }

    /**
     * 
     * @return the amount of rows in the square
     */
    public int getRow()
    {
        int X = (int) location.getX();
        return X;
    }

    /**
     * 
     * @return the amount of columns in the square
     */
    public int getCol()
    {
        int Y = (int) location.getY();
        return Y;
    }

    /**
     * checks if location of square has a type yet and if it is the
     * current working on, have seen, or a wall
     * @return if it is a wall, working on, or have seen it's true
     */
    public boolean isMarked()
    {
        if(squareType == 4 || squareType == 5 || squareType == WALL)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * sets the square to it's previous version when called upon
     * @param sq the desired version of the square, which is
     * its previous look
     */
    public void setSquarePrevious(Square sq)
    {
        squarePrevious = sq;
    }

    /**
     * 
     * @return the previous square version
     */
	public Square getSquarePrevious()
	{
		return squarePrevious;
	}
}