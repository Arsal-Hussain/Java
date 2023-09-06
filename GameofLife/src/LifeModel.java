import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid; //the grid of the game
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		/* 
		 * student code here 
		 */
		for (int i = 0; i < SIZE; i++) //first for loop analyzes the first dimension of the array
		{
			for (int e = 0; e < SIZE; e++) //second for loop analyzes the second dimension of the array
			{	//both for loop and first nested for loop will check for position
				int count = 0;
				for (int a = 0; a < 9; a++) 
				{
					if((e-1)+a%3 >= 0 && (e-1) + a%3<SIZE && (i-1) + a/3 >= 0 && (i-1) + a/3 < SIZE && a != 4 && grid[(i-1)+a/3][(e-1)+a%3].isAliveNow())
					{
						count++; //adds count if cell has two or three neighbors
					}
				}
				System.out.println();
				grid[i][e].setAliveNext(count == 2 && grid[i][e].isAliveNow()|| count == 3); //will keep alive if either statement returns true and then creates 'birth' of new cell
			}
		}
					
		for(int i = 0;i<SIZE;i++) //this nested for loop checks the boolean statement and returns true if grid position is still alive and not dead from not occupied cell
		{
			for (int e = 0; e < SIZE; e++) 
			{
			grid[e][i].setAliveNow(grid[e][i].isAliveNext());
			}
		}
    }
	
}

