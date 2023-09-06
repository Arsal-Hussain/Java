import java.io.*;
import java.util.*;
/**
 * This class is the tree that is used to encode and decode the text file into
 * a compressed file
 * @author Arsal Hussain
 *
 */
public class HuffmanTree 
{

    private Node head;
    /**
     * Construct a huffman tree with the passed count of characters and offers them to the priority queue
     * with the index of the count.
     * @param count - the arr of ints 
     */
    public HuffmanTree(int[] count)
    {
        PriorityQueue<Node> huffTree = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) //loop through the vals
        {
            if (count[i] == 0) //if the count at the index is 0 we continue to offer
            {
            	continue;
            }
            huffTree.offer(new Node(count[i], i)); //add the new node with the index and the value
        }
        huffTree.offer(new Node(1, 256));  //add the node at index 1 with the char 256
        while (huffTree.size() > 1) //loop through the pQueue
        {
            Node l = huffTree.poll();
            Node r = huffTree.poll();
            Node nNode = new Node(l.val + r.val, -1); //create the sub nodes
            nNode.left = l; //left node
            nNode.right = r; //right node
            huffTree.offer(nNode); //add the nodes back to pQueue
        }
        head = huffTree.remove();
    }
    /**
     * Secondary constructor that constructs the tree from the given file
     * @param codeFile - the file to read
     */
    public HuffmanTree(String codeFile) 
    {
        Scanner input = null;
        try 
        {
            input = new Scanner(new File(codeFile)); //load in the file
        } catch (FileNotFoundException e) 
        {
        }

        head = new Node(0, -1);
        while (input.hasNextLine()) //loop through the file
        {
            int n = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            Node node = head;
            for (char c : code.toCharArray()) //split the input to a line of chars
            {
                if (c == '0') 
                {
                    if (node.left == null)
                    {
                        node.left = new Node(0, -1); //create new node if the left node doesnt exist
                    }
                    node = node.left; //else set the node to the left node
                } else
                {
                    if (node.right == null)
                    {
                        node.right = new Node(0, -1); //create new right node if null
                    }
                    node = node.right; //else set the node to right node
                }
            }
            node.charVal = n; //set the nodes char val to the integer version of the input
        }
    }
    /**
     * Creates a new output to a file and and gets the decoded message into the passed file
     * to print to
     * @param in - the bitinputstream of the message
     * @param outFile - the file to print to
     */
    public void decode(BitInputStream in, String outFile) 
    {
        PrintWriter writer = null;
        try 
        {
            writer = new PrintWriter(new FileOutputStream(outFile)); //read the file
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        LabelAscii256: while (true) //java label that continues on the while statement and breaks once the char hits 256
        	//then closes the output
        {
            int first = in.readBit(); //reads  the first bit
            Node node = first == 0 ? head.left : head.right; //ternary to set the node to left or right depending on val
            while (true) //loop through
            {
                if (node.left == null && node.right == null) //if both null
                {
                    if (node.charVal == 256) //if hit the max
                    {
                    	break LabelAscii256; //break the while loop and close the scanner and writer
                    }
                    writer.print((char)node.charVal); //print the char version of the nodes charVal which is the int ascii value
                    break;
                }
                node = in.readBit() == 0 ? node.left : node.right; //ternary to change the readbit to either the left or right node
            }
        }
        in.close(); //closes the scanner
        writer.close(); //closes the printwriter
    }
    /**
     * Writes the encoded tree into a file recursively
     * @param fileName - the file to output to
     */
    public void write(String fileName) 
    {
        PrintWriter writer = null;
        try 
        {
            writer = new PrintWriter(new FileOutputStream(fileName)); //read the file
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        write(writer, head, ""); //add each node to the printwriter
        writer.close(); //close the writer once done
    }
    /**
     * Write helper method that recursively changes it to binary
     * @param writer - the file to write to
     * @param node - the node
     * @param binary - the binary string representation
     */
    public void write(PrintWriter writer, Node node, String binary) 
    {
        if (node.right == null && node.left == null)  //if both null
        {
            writer.println(node.charVal); //prints the nodes char val
            writer.println(binary); //prints the binary
        } else 
        {
            write(writer, node.left, binary + "0"); //recursively
            write(writer, node.right, binary + "1");
        }
    }
    /**
     * Encodes the actual file to a binary representation of the chars
     * assigns each char a binary and with the bitoutputstream. Also I use
     * a delimiter to split the file into chars
     * @param inputFile - file to encode
     * @param codeFile - file to output of the encoded version
     */
    public void encode(String inputFile, String codeFile)
    {
        HashMap<Integer, String> charToBinary = new HashMap<>(); //hashmap to map the character vals to the string
        Scanner input = null;
        try 
        {
            input = new Scanner(new File(codeFile)); //read the file
        } catch (FileNotFoundException e) 
        {
        }

        while (input.hasNextLine()) 
        {
        	//System.out.println(input.nextLine());
            int n = Integer.parseInt(input.nextLine()); //turns it into the charval
            //System.out.println(n);
            String code = input.nextLine(); //read each string of the binary to the file
            //System.out.println(code);
            charToBinary.put(n, code);
        }
        BitOutputStream out = new BitOutputStream("" + inputFile.substring(inputFile.lastIndexOf("/") + 1, inputFile.lastIndexOf('.')) + ".short");
        try {
            input = new Scanner(new File(inputFile)); //file to encode
        } catch (FileNotFoundException e) {
        }
        input.useDelimiter(""); //split the file into a bunch of chars
        while (input.hasNext()) 
        {
            for (char c : charToBinary.get((int) input.next().charAt(0)).toCharArray()) 
            {
                out.writeBit(Character.getNumericValue(c)); //write the bits to the ascii val of the chars
            }
        }
        for (char c : charToBinary.get(256).toCharArray())
        {
            out.writeBit(Character.getNumericValue(c)); //write the final bit to cha val
        }
        out.close(); //close the scanner
    }
    
    public void display()
    {
    	TreePrinter.printTree(head);
    }

}
/**
 * This class creates the Node object for the tree that is being created
 * @author Rayyan Waris
 *
 */
class Node implements Comparable<Node>
{
    int val;
    int charVal;
    Node left, right;
    /**
     * Initalizes the value of the node and its char value
     * @param val - the nodes value
     * @param charVal - the char value of the node
     */
    public Node(int val, int charVal) 
    {
        this.val = val;
        this.charVal = charVal;
    }
    /**
     * Compares the value of the node subtracted by the
     * object value
     * @param the obj to check
     * @return val subtracted from obj value
     */
    @Override
    public int compareTo(Node obj) 
    {
        return val - obj.val;
    }
    /**
     * Returns the char value of the node
     * @return string of char value
     */
    @Override
    public String toString() 
    {
        if (charVal == -1) 
        {
        	return val + "";
        }
        return (char) charVal + "";
    }
}