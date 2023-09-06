/**
 * Locates the name of the items being purchased and retrieves
 * it's price and name to where it is called from
 * @author arsal
 *
 */
public class ItemOrder
{
	Item item; //name of the item
	private int qty; //quantity of item
	
	public ItemOrder(Item item, int qty)
	{
		this.item = item;
		this.qty = qty;
	}
	
	/**
	 * 
	 * @return specific price of the item being purchased
	 */
	public double getPrice()
	{
		return item.priceFor(qty);
	}
	
	/**
	 * 
	 * @return specific item called
	 */
	Item getItem()
	{
		return item;
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
}
