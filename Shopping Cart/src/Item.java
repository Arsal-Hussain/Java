/**
 * This class analyzes the items purchased and price of purchase
 * @author arsal
 *
 */
public class Item
{
	private String Name; //name of the item
	private double price, bulkPrice; //price and bulk price of item
	private int bulkQty; //quantity of item
	private boolean hasBulk = false; //checks if item has bulk price
	private Object item; //the item
	
	/**
	 * Initializes the value of the price and name
	 * @param name of item
	 * @param price of item
	 */
	public Item(String name, double price)
	{
		this.Name = name;
		this.price = price;
	}
	
	/**
	 * Initializes value of name, price, bulk quantity, and bulk price
	 * @param Name of item
	 * @param price of item
	 * @param bulkQty quantity of item
	 * @param bulkPrice price in bulk if greater than 10
	 */
	public Item(String Name, double price, int bulkQty, double bulkPrice)
	{
		this.Name = Name;
		this.price = price;
		this.bulkQty = bulkQty;
		this.bulkPrice = bulkPrice;
		hasBulk = true;
	}
	
	/**
	 * Calculates cost of item based on quantity and checks if
	 * item has bulk price available
	 * @param quantity amount of item
	 * @return price of item
	 */
	public double priceFor(int quantity)
	{
		if(quantity < 0)
		{
			throw new IllegalArgumentException("Error");
		}
		else if(quantity >= 10)
		{
			if(hasBulk)
			return bulkPrice*quantity;
			
			return price*quantity;
		}
		else 
			return price*quantity;
		}
	
	/**
	 * checks if item is equal to item
	 */
	@Override
	public boolean equals(Object obj)
	{
		ItemOrder item =(ItemOrder)obj;
		return this.item == item.item;
	}
	
	/**
	 * Passes name and price of item that appears on runner
	 * as well as bulk price if available
	 */
	@Override
	public String toString() 
	{
		String str = "";
		str += Name+", $"+price;
		if(hasBulk)
		{
			str += " || buy in bulk! "+bulkQty+" for "+bulkPrice+" each";
		}
		return str;
	}
}
