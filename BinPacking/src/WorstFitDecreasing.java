import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorstFitDecreasing 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("input20.txt"));
		PriorityQueue<Disk> pDisk = new PriorityQueue<Disk>();
		ArrayList<Integer> pDisk2 = new ArrayList<Integer>();
		double gigs = 0.0;
		int dskNum = 0;
		while(scan.hasNextInt()) 
		{
			pDisk2.add(scan.nextInt());
		}
		Collections.sort(pDisk2);
		pDisk.add(new Disk(dskNum++));
		for(int i = pDisk2.size()-1; i >= 0; i--) 
		{
			int size = pDisk2.get(i);
			Disk lowDisk = pDisk.poll();

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
		for(Disk disk : pDisk) 
		{
			gigs += disk.getSizeGig();
		}
		System.out.println("Total size: " + gigs + " GB");
		System.out.println("pDisk req'd = " + pDisk.size() + "\n");
		System.out.println("\t# Avail");
		while(!pDisk.isEmpty()) 
		{
			System.out.print("\t" + pDisk.poll() + "\n");
		}
	}
}