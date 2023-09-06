import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameTree
{
	/**
	 * Will you need to create an inner class?
	 */
		//TODO?
	private class TreeNode
	{
		String data;
		TreeNode left;
		TreeNode right;
		public TreeNode(String data)
		{
			this.data = data;
		}
		
		public TreeNode(String data, TreeNode left, TreeNode right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	/**
	 * Will you need any instance variables?
	 */
		//TODO?
	private TreeNode temp; //temporarily stores the treeNode for the next
	private TreeNode root; //start of the tree
	private Scanner scan; //inputs the yes or no answer
	private String treeFile; //reads the txt files
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName)
	{
		treeFile = fileName;
		try
		{
			scan = new Scanner(new File(treeFile));
		} catch (FileNotFoundException s)
		{
			System.out.println("File does Not Exist Please Try Again: ");
		}
		temp = createTree();
		root = temp;
		scan.close();
	}

	/**
	 * initializes a new tree based on the root of the txt file
	 * @return
	 */
	private TreeNode createTree()
	{
		String word = scan.nextLine().trim();
		if(!isQuestion(word))
		{
			return new TreeNode(word);
		}
		else
		{
			TreeNode left = createTree();
			TreeNode right = createTree();
			return new TreeNode(word, left, right);
		}
	}
	
	/**
	 * checks if the line contains a question mark in it and would
	 * label it as a question and if it not it's an answer
	 * @param word
	 * @return
	 */
	private boolean isQuestion(String word)
	{
		if(word.charAt(word.length() - 1) == '?')
			return true;
		return false;
	}
	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		// TODO
		String temp = root.data;
		root.data = newQ;
		root.right = new TreeNode(temp);
		root.left = new TreeNode(newA);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		// TODO
		if(isQuestion(getCurrent()))
			return false;
		return true; // replace
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		// TODO

		return root.data;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		// TODO
		if(yesOrNo == Choice.Yes)
			root = root.left;
		else
			root = root.right;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		// TODO
		root = temp;
	}

	@Override
	public String toString()
	{
		// TODO

		return toString(temp);
	}
	
	private String toString(TreeNode root)
	{
		if(!isQuestion(root.data))
			return "- " + root.data;
		else if(root == temp)
			return "- " + toString(root.right) + '\n' + root.data + '\n' + "- " + toString(root.left);
		return toString(root.right) + '\n' + root.data + '\n' + "- " + toString(root.left);
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		// TODO
		PrintWriter file = null;
		try {
			file = new PrintWriter(treeFile);
		}
		catch (IOException exc)
		{
			System.out.println("Could not create file: " + treeFile);
		}
		file.println(printOrder());
		file.close();
	}
	
	private String printOrder()
	{
		return printOrder(temp);
	}
	
	private String printOrder(TreeNode root)
	{
		if(!isQuestion(root.data))
			return root.data;
		else
			return root.data + "\n" + printOrder(root.left) + "\n" + printOrder(root.right);
	}
}
