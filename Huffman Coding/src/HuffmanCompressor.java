import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This class implements the actual use of the compression and expansion methods for the passed files
 * we do this by reading the file and taking the characters of it and storing it into the frequency table
 * and writing to the file and encoding it.
 * @author Arsal Hussain
 *
 */
public class HuffmanCompressor
{
	/**
	 * Reads the file name and generates a character frequency table of all the ascii values, so the size would be a standard
	 * 256 char ASCII alphabet. Then we use that to construct the huffman tree. Then I generate the .code file to mantain
	 * the list of character codes used. Then I write the encoding tree to the file and encode the file to a .short
	 * @param fileName - the file to compress
	 */
    public static void compress(String fileName)
    {
        Scanner scan = null;
        try 
        {
        	scan = new Scanner(new File(fileName)); //Storing the file
        } catch (FileNotFoundException e)
        {
        }
        scan.useDelimiter("");
        //System.out.println(scan);
        int[] ascii = new int[256];
        while (scan.hasNext())
        {
        	
        	//System.out.println(scan.nextLine());
        	//System.out.println(scan.next().charAt(0));
        	ascii[scan.next().charAt(0)] += 1;
        }
        //System.out.println(Arrays.toString(ascii));
        String cFile = "" + fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf('.')) + ".code";
        HuffmanTree t = new HuffmanTree(ascii);
        t.write(cFile);
        t.encode(fileName, cFile);
        t.display();
    }
    /**
     * Takes in the compressed file and decodes it which expands the file
     * into the new file name given
     * @param cFile - the codeFile
     * @param comFile - the compressedFile
     * @param nFile - the new file name
     */
    public static void expand(String cFile, String comFile, String nFile)
    {
        HuffmanTree t = new HuffmanTree(cFile);
        t.decode(new BitInputStream(comFile), nFile);
    }
}
