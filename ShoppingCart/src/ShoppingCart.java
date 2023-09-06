/**
 * stores the items purchased and adds to cart along with price
 */
import java.util.ArrayList;

public class ShoppingCart 
{
	private ArrayList<ItemOrder> list; //eventually stores items to "cart"

	public ShoppingCart()
	{
		list = new ArrayList<ItemOrder>();

	}

/**
 * adds purchase to cart when called upon
 * @param newOrder the item that is purchased
 */
	public void add(ItemOrder newOrder)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals(newOrder))
			{
				list.remove(i);
				break;
			}
		}
		list.add(newOrder);
	}

/**
 * Calculates the total price based on all the items in cart
 * @return price of items in total
 */
	public double getTotal()
	{
		double total = 0.0;

		for(int i = 0; i <= list.size()-1; i++)
		{
			total+= list.get(i).getPrice();
		}

		return total;
	}

}