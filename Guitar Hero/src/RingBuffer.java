public class RingBuffer 
{
    private double[] data;          // items in the buffer
    private int      first;         // index for the next dequeue or peek
    private int      last;          // index for the next enqueue
    private int      size;          // number of items in the buffer

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
    	data = new double[capacity];
    	first = 0;
    	last = 0;
    	size = 0;
    }

    /** return number of items currently in the buffer */
    /**
     * return the size of the ring buffer
     * @return
     */
    public int size() {
        // YOUR CODE HERE
        return size; //REPLACE
    }

    /** is the buffer empty (size equals zero)? */
    /**
     * checks if the buffer is empty and returns true if it is
     * @return
     */
    public boolean isEmpty() {
        // YOUR CODE HERE
    	
        return (size==0); //REPLACE
    }

    /** is the buffer full (size equals array capacity)? */
    /**
     * checks if buffer is full and returns true if it is
     * @return
     */
    public boolean isFull() {
        // YOUR CODE HERE

        return (size==data.length); //REPLACE
    }

    /** add item x to the end */
    /**
     * like the add() method, enqueue will add item based on parameter
     * to the ring buffer array
     * @param x
     */
    public void enqueue(double x) {
        // YOUR CODE HERE
    	
    	if(isFull())
    		throw new RuntimeException("Ring buffer overflow");
    	data[last] = x;
    	last++;
    	size++;
    	if(last >= data.length)
    		last = 0;
    }

    /** delete and return item from the front */
    /**
     * like the remove() method, dequeue will remove an item but first checks if isEmpty() returns true
     * or not then returns the item that got removed
     * @return
     */
    public double dequeue() {
        // YOUR CODE HERE

    	if(isEmpty())
    		throw new RuntimeException("Ring buffer underflow");
    	double temp = data[first];
    	first++;
    	
    	if(first >= data.length)
    		first = 0;
    	
    	size--;
    	
        return temp; //REPLACE
    }

    /** return (but do not delete) item from the front *
     * returns the front item in the array (ring buffer)
     * @return
     */

    public double peek() {
        // YOUR CODE HERE
    	if(isEmpty())
    	{
    		throw new RuntimeException("Ring buffer underflow");
    	}
    	
        return data[first]; //REPLACE
    }

    /** a simple test of the constructor and methods in RingBuffer */
    public static void main(String[] args) {
        int N = 100;
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
        
        /*
         * Your program should produce the following output:
         * 
         *  Size after wrap-around is 100
			5050.0
         */
    }
}
