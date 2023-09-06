import java.util.*;

public class PalindromeApp
{
    public static void main(String[] args)
    {
        PalindromeTester p = new PalindromeTester();
        Scanner keyboard = new Scanner(System.in);
        String ans;

        do
        {
            System.out.print("Enter a word --> ");
            String str = keyboard.nextLine();

            if(p.palindrome(str, str.length()-1) == true)
                System.out.println("This is a palindrome");
            else
                System.out.println("This is not a palindrome");

            System.out.println();
            System.out.print("Continue[Y/N]? ");
            ans = keyboard.nextLine();
            System.out.println();
       }
       while(ans.equalsIgnoreCase("y"));
    }
}

class PalindromeTester
{
   /** 
    * @param str the string to test
    * @param strLength the length of str
    * @return true if str is a palindrome; false otherwise
    */
    public boolean palindrome(String str, int strLength)
    {
    	if(strLength <= 0) //checks if length of str is less than 0 once being passed through recursion
    		return true;
    	else if(str.charAt(0) == str.charAt(strLength)) //second if statement checks if current char matches it's opposite and will continue to next char
    		return palindrome(str.substring(1,strLength), strLength-2);
    	else
    		return false; //will return false if word is not spelled sameway backwards once recurred
    }
}
