/**
 * This class analyzes the names of each item in the grocery cart
 * and stores the items being purchased
 * @author hs10066964
 */

import java.util.ArrayList;

public class Catalog
{
	private String name; //the item
	private ArrayList<Item> list; //stores the item that is purchased
	public Catalog(String name)
	{
		this.name = name;
		list = new ArrayList<Item>();
	}
	
	/**
	 * Adds item to cart
	 * @param item adds the item purchased to cart
	 */
	public void add(Item item)
	{
		list.add(item); //adds each purchased item
	}
	
	/**
	 * 
	 * @return	the size of the arraylist based on the items purchased
	 */
	public int size()
	{
		return list.size();
	}
	
	/**
	 * 
	 * @param index	gets the value where item is located
	 * @return	specific location index of item
	 */
	public Item get(int index)
	{
		return list.get(index);
	}
	
	/**
	 * 
	 * @return	name of the item
	 */
	public String getName()
	{
		return name;
	}
}
