import java.util.*;

public class Melody 
{
	private Queue<Note> notes; //stores the keys
	
	/**
	 * main constructor initializing the melody based on song
	 * @param song song chosen from file
	 */
	public Melody(Queue<Note> song)
	{
		this.notes = new LinkedList<Note>(song);
	}
	
	/**
	 * allocates the total time of the song using the getDuration method from note and totaling it
	 * @return the total length of the song, accounting for tempo change
	 */
	public double getTotalDuration()
	{
		Queue<Note> tempo = new LinkedList<Note>(notes);
		double total = 0;
		while(!tempo.isEmpty())
		{
			Note temp = tempo.poll();
			if(temp.isRepeat())
				total += temp.getDuration()*2;
			else
				total += tempo.poll().getDuration();
		}
		return total;
	}

	/**
	 * prints the notes of song
	 */
	public String toString()
	{
		Queue<Note> tempo = new LinkedList<Note>(notes);
		String str = "";
		while(!tempo.isEmpty())
		{
			str += tempo.poll().toString() + "\n";
		}
		
		return str;
	}
	
	/**
	 * changes speed of song using temp Queue that is dequeued and sets the duration based on param0
	 * @param tempo the new speed of the song, affecting duration
	 */
	public void changeTempo(double tempo)
	{
		Queue<Note> tempoQ = new LinkedList<Note>(notes);
		while(!tempoQ.isEmpty())
		{
			Note temp = tempoQ.poll();
			temp.setDuration(temp.getDuration() * tempo);
		}
	}

	/**
	 * reverses the keys of the song to perform backwards
	 */
	public void reverse()
	{
		Queue<Note> tempNotes = new LinkedList<Note>(notes);
		Queue<Note> secondTemp = new LinkedList<Note>();
		while(!tempNotes.isEmpty())
		{
			secondTemp.offer(tempNotes.poll());
		}
	}

	/**
	 * returns the notes of the song being played
	 * @return
	 */
	public Queue<Note> getNotes()
	{
		return notes;
	}

	/**
	 * adds notes based on melody chosen
	 * @param other the melody of the song
	 */
	public void append(Melody other)
	{
		Queue<Note> tempNotes = other.getNotes();
		while(!tempNotes.isEmpty()) 
		{
			notes.offer(tempNotes.poll());
		}
	}
	
	/**
	 * simply plays the song when prompted using methods from Note and prints end of song once there is nothing
	 * left to poll from
	 */
	public void play()
	{
		try
		{
			Queue<Note> notesTemp = new LinkedList<Note>(notes);
			while(!notes.isEmpty())
			{
				Note temp = notesTemp.poll();
				temp.play();
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("End of song");
		}
	}
}
