import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * This class tests my huffmancoding by taking a file given from the sample txt files and
 * compresses it and then expands it
 * @author Arsal Hussain
 *
 */
public class Test 
{
    @SuppressWarnings("static-access")
	public static void main(String[] args)
    {
        String txtFileName = "happy hip hop"; //Enter in file name you want here (DONT put .txt after it)
        HuffmanTree h = new HuffmanTree(txtFileName + ".code");
        HuffmanCompressor c = new HuffmanCompressor();
        c.compress("" + txtFileName + ".txt");
        c.expand("" + txtFileName + ".code", "" + txtFileName + ".short", "" + txtFileName + ".new");
       // h.display();
        
    }

}
