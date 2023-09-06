import java.awt.Font;
import java.awt.Color;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	

	GemType type;
	int points;
	
	/**
	 * constructor that will determine the amount of points
	 * that the gem will be worth as well as the color based on
	 * the 1/3 chance for each color
	 */
	public Gem()
	{
		int randGem = (int)(Math.random() * 3) + 1;
		points = ((int)(Math.random()*11))*5;
		
		if(randGem == 1)
		{
			type = GemType.GREEN;
		}
		else if(randGem == 2)
		{
			type = GemType.BLUE;
		}
		else
		{
			type = GemType.ORANGE;
		}
	}
	
	/**
	 * second constructor that initializes the variables to
	 * the param sets
	 * @param type
	 * @param points
	 */
	public Gem(GemType type, int points)
	{
		this.type = type;
		this.points = points;
	}
	
	/**
	 * awesome toString
	 */
	@Override
	public String toString()
	{
		return "Color: " + type.name() + "| value: " + points;
	}
	
	/**
	 * returns the type of gym
	 * @return
	 */
	public GemType getType()
	{
		return type;
	}
	
	/**
	 * returns the number of points available to earn
	 * @return
	 */
	public int getPoints()
	{
		return points;
	}
	
	/**
	 * draws the gem based on the param which is the coordinates
	 * @param x
	 * @param y
	 */
	public void draw(double x, double y)
	{
		StdDraw.setPenColor(Color.white);
		StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		if(type == GemType.BLUE)
			StdDraw.picture(x, y, "gem_blue.png");
		else if(type == GemType.GREEN)
			StdDraw.picture(x, y, "gem_green.png");
		else
			StdDraw.picture(x, y, "gem_orange.png");
		StdDraw.text(x, y, points + "");
	}
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
