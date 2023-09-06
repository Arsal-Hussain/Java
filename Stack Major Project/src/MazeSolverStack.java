/**
 * implements the abstract class MazeSolver
 * overriding the abstract methods for operations based
 * on myStack
 * @author hs10066964
 *
 */
public class MazeSolverStack extends MazeSolver 
{
    private MyStack workList; //uses the myStack code to make use of the maze



    /**
     * empties the stack
     */
    public void makeEmpty() {
        workList = new MyStack();
    }


    /**
     * checks if the stack is empty and returns true if it is
     */
    public boolean isEmpty() {
        return workList.isEmpty();
    }

    /**
     * pushes the square onto stack
     */
    public void add(Square sq) {
        workList.push(sq);
    }

    /**
     * pops the square from stack
     */
    public Square remove() {
        return workList.pop();
    }

    /**
     * returns next square using pop() method
     */
    public Square getNext() {
        return workList.pop();
    }

    /**
     * constructor to call super maze
     * @param maze
     */
    public MazeSolverStack(Maze maze)
    {
        super(maze);
        workList = new MyStack();
        add(maze.getStart());
    }
}