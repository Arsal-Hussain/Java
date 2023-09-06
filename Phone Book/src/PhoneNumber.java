public class PhoneNumber
{
	private String pNumber;
	public PhoneNumber(String pNumber)
	{
		this.pNumber = pNumber;
	}
	
	@Override
	public boolean equals(Object obj)
	{
			PhoneNumber temp = (PhoneNumber) obj;
			return pNumber == (temp.pNumber);
	}
	@Override
	public int hashCode()
	{
		//Might need to change
		int hash = 11;
		for(int i = 0; i < pNumber.length(); i++)
		{
			hash = hash*31 + pNumber.charAt(i);
		}
		return hash;
	}
	@Override
	public String toString()
	{
		return "" + pNumber;
	}
}