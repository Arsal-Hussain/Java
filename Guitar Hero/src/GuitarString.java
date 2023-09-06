public class GuitarString 
{
    private RingBuffer buffer; // ring buffer
    
    // YOUR OTHER INSTANCE VARIABLES HERE

    private double frequency;
    private double sample;
    private static final int SAMPLING_RATE = 44100;
    private int count;
    
    /** create a guitar string of the given frequency */
    /**
     * the first constructor which sets the string on a frequency
     * then initializes the RingBuffer class
     * @param frequency the freq of the pitch
     */
    public GuitarString(double frequency) {
        // YOUR CODE HERE
    	sample = SAMPLING_RATE / frequency; //sample is what gets outputted as sound, and what key is outputted
    	
    	this.frequency = frequency;
    	
    	int n = (int)(Math.ceil(sample));
    	
    	buffer = new RingBuffer(n);
    	
    	for(int i = 0; i < sample; i++)
    	{
    		buffer.enqueue(0);
    	}
    }

    /** create a guitar string with size & initial values given by the array */
    /**
     * second constructor that uses the length of array to add to RingBuffer variable
     * @param init the array which is used for RingBuffer
     */
    public GuitarString(double[] init) {
        // YOUR CODE HERE
    	int length = init.length;
    	buffer = new RingBuffer(length);
    	
    	for(int i = 0; i < length; i++)
    	{
    		buffer.enqueue(init[i]);
    	}
    }

    /** pluck the guitar string by replacing the buffer with white noise */
    /**
     * replaces the items with random values from -0.5 to 0.5
     */
    public void pluck() {
        // YOUR CODE HERE
    	for(int i = 0; i < sample; i++)
    	{
    		buffer.dequeue();
    		buffer.enqueue(Math.random() - 0.5);
    	}
    }

    /** advance the simulation one time step */
    /**
     * deletes a sample at the front of the ring buffer and
     * adds to end based on average of the top two values summed
     */
    public void tic() {
        // YOUR CODE HERE
    	double firstVal = buffer.peek();
    	buffer.dequeue();
    	double secondVal = buffer.peek();
    	double calc = 0.994 * (0.5 * (firstVal + secondVal));
    	buffer.enqueue(calc);
    	count++;
    }

    /** return the current sample */
    /**
     * returns the value of the item at the front of the ring buffer
     * @return
     */
    public double sample() {
        // YOUR CODE HERE
        return buffer.peek(); //REPLACE
    }

    /** return number of times tic was called */
    /**
     * returns the count method that is used each time tic() is called
     * @return
     */
    public int time() {
        // YOUR CODE HERE
        return count; //REPLACE
    }

    public static void main(String[] args) {
        int N = 25;
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
        /*
         * Your program should produce the following output when the main() 
         * method runs (DON'T WORRY ABOUT VERY MINOR DIFFERENCES, E.G. OFF BY 0.001):
                0   0.2000
			    1   0.4000
			    2   0.5000
			    3   0.3000
			    4  -0.2000
			    5   0.4000
			    6   0.3000
			    7   0.0000
			    8  -0.1000
			    9  -0.3000
			   10   0.2988
			   11   0.4482
			   12   0.3984
			   13   0.0498
			   14   0.0996
			   15   0.3486
			   16   0.1494
			   17  -0.0498
			   18  -0.1992
			   19  -0.0006
			   20   0.3720
			   21   0.4216
			   22   0.2232
			   23   0.0744
			   24   0.2232
         */
    }
}
