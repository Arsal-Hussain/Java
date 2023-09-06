import java.util.ArrayList;

public class Disk implements Comparable<Disk> 
{
	private int totalSizeGigs;
	private int numDisks;					
	private int usedSize;
	private Integer remSizeKB;	
	private ArrayList<Integer> files;
	/**
	 * contructor initializing all variables
	 */
	public Disk()
	{
		totalSizeGigs = 0;
		numDisks = 0;
		usedSize = 1000000;
		remSizeKB = 1000000;
		files = new ArrayList<Integer>();
		
	}
	
	/**
	 * second constructor based on param
	 * @param diskNum
	 */
	public Disk(int diskNum) 
	{
		totalSizeGigs = 0;
		remSizeKB = 1000000;
		files = new ArrayList<Integer>();
		numDisks = diskNum;
		usedSize = 1000000 - remSizeKB;
	}
	/**
	 * creates a new disk with a capacity based on param
	 * @param capacity
	 * @return false if not created if the cap is larger than disk
	 */
	public boolean newDisk(Integer capacity)
	{
		return remSizeKB - capacity >= 0;
	}
	public int add(Integer other) 
	{
		files.add(other);
		remSizeKB -= other;
		usedSize = 1000000 - remSizeKB;
		totalSizeGigs += other;
		return remSizeKB;
	}
	
	/**
	 * return size of gigs
	 * @return
	 */
	public double getSizeGig()
	{
		return (double) totalSizeGigs / 1000000;
	}
	/**
	 * return remaining size left in disk
	 * @return
	 */
	public int getRemSize()
	{
		return remSizeKB;
	}
	/**
	 * return size of used in disk
	 * @return
	 */
	public int getUsedSize() 
	{
		return usedSize;
	}
	/**
	 * checks if param remaining size is equal to that of instance variable
	 */
	@Override
	public boolean equals(Object other)
	{
		return remSizeKB.equals(((Disk) other).remSizeKB);
	}
	/**
	 * compares values of instance variable to param
	 */
	@Override
	public int compareTo(Disk obj)
	{
		if(remSizeKB == obj.remSizeKB)
		{
			return 0;
		}
		else if (remSizeKB > obj.remSizeKB)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	/**
	 * simple toString
	 */
	@Override
	public String toString () 
	{
		String output = "";
		output += numDisks + " " + remSizeKB + ": ";
		for(Integer file : files)
		{
			output += file + " ";
		}
		return output;
	}
}