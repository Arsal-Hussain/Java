public class GemList 
{
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
	
	/**
	 * node class which utilizes the containment of a gem
	 * and reference to the next gem
	 * @author arsal
	 *
	 */
	private class Node
	{
		public Gem gem;
		public Node next;
		
		/**
		 * initialized as null until used and called
		 */
		public Node()
		{
			gem = null;
			next = null;
		}
		
		/**
		 * initializes the gem to what the param specifies
		 * @param gem
		 */
		public Node(Gem gem)
		{
			this.gem = gem;
			next = null;
		}
	}
	
	private int size; //numbers of gems
	private Node head;//the first gem
	private Node tail;//the next/last gem
	
	/**
	 * first constructor that initializes the instance variables
	 */
	public GemList()
	{
		int size = 0;
		tail = null;
		head = null;
	}
	
	/**
	 * inserts the gem before the index specified in param
	 * @param gem
	 * @param index
	 */
	public void insertBefore(Gem gem, int index)
	{
		Node store = tail;
		if(index == 0 || size == 0) //first checks if index exists or if there is anything in gem
		{
			tail = new Node(gem); //the end gem will end up being the one being called from param
			if(size != 0)
				tail.next = store;
			else
				head = tail;
			size++;
		}
	
		else if(index >= size) //if the index is larger than the size it will make the gem after the first gem
		{
			head.next = new Node(gem);
			store = head.next;
			head = store;
			size++;
		}
		else
		{
			for(int i = 0; i < index-1; i++) //goes through entire gem list to the spot specified to place and shifts the rest down
				store = store.next;
			Node store2 = store.next;
			store.next = new Node(gem);
			store.next.next = store2;
			size++;
		}
	}
	
	/**
	 * returns amount of gems in list
	 * @return
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * awesome toString
	 */
	@Override
	public String toString()
	{
		String str = "[";
		Node store = tail;
		for(int i = 0; i < size; i++)
		{
			str += store.gem.toString() + " ";
			store = store.next;
		}
		str += "]";
		return str;
	}
	
	/**
	 * draws the gem in the list based on the param, which is the
	 * y coordinate
	 * @param y
	 */
	public void draw(double y)
	{
		int count = 0;
		Node store = this.tail;
		while(store != null)
		{
			store.gem.draw(GemGame.indexToX(count), y);
			store = store.next;
			count++;
		}
	}
	
	/**
	 * keeps track of the score between player one and player two
	 * calculating if the colors next to each other are the same then to multiply
	 * and if they aren't they would be valued less and decrement the score
	 * @return
	 */
	public int score()
	{
		int score = 0;
		Node store = tail;
		if(this.size == 0)
			return 0;
		GemType storeType = tail.gem.getType();
		int count = 0;
		int tmpScr = 0;
		for(int i = 0; i < size(); i++)
		{
			Gem storeGem = store.gem;
			if(storeGem.getType() == storeType)
			{
				count++;
				tmpScr += storeGem.getPoints();
			}
			else
			{
				storeType = store.gem.getType();
				score += tmpScr * count;
				count = 1;
				tmpScr = storeGem.getPoints();
			}
			store = store.next;
		}
		score += tmpScr * count;
		return score;
	}
}
