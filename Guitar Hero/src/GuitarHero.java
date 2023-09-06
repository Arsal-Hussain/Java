import java.util.*;

public class GuitarHero
{
	public static void main(String[] args)
	{
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; //all of the keys that are playable
		int numStrings = 37; //equivalent to the number of keys
		GuitarString[] arrayofString = new GuitarString[numStrings];
		
		for(int i = 0; i < numStrings; i++)
		{
			double freq = 440 * Math.pow(2, ((i-24) / 12.0));
			arrayofString[i] = new GuitarString(freq);
		} //plays the sound based on frequency volume, higher the freq variable is higher pitch
		
		while(true) //implements the StdDraw class to get the sample and array to play sound based on frequency and keys chosen
		{
			if(StdDraw.hasNextKeyTyped())
			{
				char key = StdDraw.nextKeyTyped();
				int index = keyboard.indexOf(key);
				
				if(index == -1)
					continue;
			
				arrayofString[index].pluck();
			}
			
			double sample = 0.0;
			
			for(int i = 0; i < arrayofString.length; i++)
			{
				sample += arrayofString[i].sample();
			}
			
			StdAudio.play(sample); //will play the sound after it presses
			
			for(int i = 0; i < arrayofString.length; i++)
			{
				arrayofString[i].tic();
			}
		}
	}
	
}
