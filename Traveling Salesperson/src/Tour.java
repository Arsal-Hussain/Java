public class Tour 
{
	/**
	 * implements the initialization of nodes to show points
	 * @author arsal
	 *
	 */
	private class Node
	{
		public Point p; //the point variable
		public Node next; //the next node variable
		
		/**
		 * constructor that initializes a point and the next point
		 * @param p
		 */
		public Node(Point p)
		{
			this.p = p;
			this.next = null;
		}
	}
	public Node head; //start of the node
	private int size; //size of the node
	/** create an empty tour */
	public Tour()
	{
		//TODO
		head = null;
		size = 0;
	}
	
	/**
	 * second constructor that initializes four point tour
	 * to test the methods
	 */
	/** create a four-point tour, for debugging */
	public Tour(Point a, Point b, Point c, Point d)
	{
		//TODO
		head = new Node(a);
		Node node = head;
		node.next = new Node(b);
		node.next = new Node(c);
		node.next = new Node(d);
	}
	
	/**
	 * print statement that shows the coordinates in the final result
	 * of the tour
	 */
	/** print tour (one point per line) to std output */
	public void show()
	{
		//TODO
		Node temp = head;
		while(temp!=null)
		{
			System.out.println(temp.p);
			temp = temp.next;
		}
	}
	
	/**
	 * draws out the tour with the stddraw and sets the nodes
	 * to new points
	 */
	/** draw the tour using StdDraw */
	public void draw()
	{
		//TODO
		Node node = head;
		while(node.next != null)
		{
			node.p.drawTo(node.next.p);
			node = node.next;
		}
		node.p.drawTo(head.p);
	}
	
	/**
	 * size of the tour
	 */
	/** return number of nodes in the tour */
	public int size()
	{
		//TODO
		
		return size;
	}
	
	/**
	 * loops through the node to calculate the distance between nodes
	 */
	/** return the total distance "traveled", from start to all nodes and back to start */
	public double distance()
	{
		//TODO
		double distance = 0.0;
		Node node = head;
		while(node.next != null)
		{
			distance += node.p.distanceTo(node.next.p);
			node = node.next;
		}
		distance += node.p.distanceTo(head.p);
		return distance;
	}
	
	/**
	 * determines the closest points from the previous point
	 */
	/** insert p using nearest neighbor heuristic */
    public void insertNearest(Point p) 
    {
        //TODO
    	double nearDist = 0.0;
    	Node store = new Node(p);
    	Node nextNode = head;
    	Node nearNode = nextNode;
    	
    	while(nextNode != null)
    	{
    		double dist = nextNode.p.distanceTo(store.p);
    		if(dist < nearDist || nearDist == 0.0)
    		{
    			nearNode = nextNode;
    			nearDist = dist;
    		}
    	
    		nextNode = nextNode.next;
    	}
    		if(nearNode != null)
    		{
    			Node end = nearNode.next;
    			nearNode.next = store;
    			store.next = end;
    		}
    		else
    			head = store;
    		size++;
    	
    }

    /**
     * smallest distance on tour between each node and stores it
     */
	/** insert p using smallest increase heuristic */
    public void insertSmallest(Point p) 
    {
    	//TODO
    	if(size == 0)
    	{
    		head = new Node(p);
    		head.next = null;
    	}
    	else
    	{
    		double smallDist = Double.MAX_VALUE;
    		int smallNode = -1;
    		int nextNode = 0;
    		Node store = head;
    		Node point = new Node(p);
    		while(store != null)
    		{
    			Node storeNext = store.next;
    			point.next = storeNext;
    			store.next = point;
    			double distance = this.distance();
    			if(distance < smallDist)
    			{
    				smallNode = nextNode;
    				smallDist = distance;
    			}
    			store.next = storeNext;
    			nextNode++;
    			store = store.next;
    		}
    		store = this.head;
    		Node tempNext = store.next;
    		while(smallNode != 0)
    		{
    			store = store.next;
    			tempNext = store.next;
    			smallNode--;
    		}
    		point.next = tempNext;
    		store.next = point;
    	}
    	size++;
    }
    
    public static void main(String[] args)
    {
    	Point a = new Point(100.0, 100.0);
    	Point b = new Point(500.0, 100.0);
    	Point c = new Point(500.0, 500.0);
    	Point d = new Point(100.0, 500.0);
    	Tour squareTour = new Tour(a, b, c, d);
    	squareTour.show();
    	System.out.println(squareTour.distance());
    	StdDraw.setXscale(0, 600);
    	StdDraw.setYscale(0, 600);
    	squareTour.draw();
    }
}