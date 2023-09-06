import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFit 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("input20.txt"));
		PriorityQueue<Disk> pDisk = new PriorityQueue<Disk>();
		
		
		int dskNum = 0;
		pDisk.add(new Disk(dskNum++));
		while(scan.hasNextInt()) 
		{
			int disk = scan.nextInt();
			Disk lowDisk = pDisk.poll();
			Integer size = disk;
			if(lowDisk.newDisk(size)) 
			{
				lowDisk.add(size);
				pDisk.add(lowDisk);
			}
			else 
			{
				pDisk.add(lowDisk);
				Disk newDisk = new Disk(dskNum++);
				newDisk.add(size);
				pDisk.add(newDisk);
			}
		}

		double gigs = 0.0;
		for(Disk disk : pDisk)
		{
			gigs += disk.getSizeGig();
		}
		System.out.println("Total size: " + gigs + " GB");
		System.out.println("Disks req'd = " + pDisk.size() + "\n");
		System.out.println("\t# Avail");
		while(!pDisk.isEmpty())
		{
			System.out.print("\t" + pDisk.poll() + "\n");
		}
	}
}