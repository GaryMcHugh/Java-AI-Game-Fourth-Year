package ie.gmit.sw.ai.characters;

import ie.gmit.sw.ai.maze.*;


/*
 * 
 *  Player is a node
 * 
 */
public class Player extends Node 
{
	
	private Node[][] maze;
	private String name;
	private int row, col;
	
	private Traversator t;

	public Player(int currentRow, int currentCol, char c, Node[][] maze, String name) throws Exception 
	{
		super(currentRow, currentCol, c, name);
		
		this.maze = maze;
		this.name = name;
		this.row = currentRow;
		this.col = currentCol;
		
		t = new BruteForceTraversator(true);
		t.traverse(maze, maze[row][col]);
		//t = new IDDFSTraversator();
		//t.traverse(maze, maze[row][col]);
		//t = new RecursiveDFSTraversator();
		//t.traverse(maze, maze[row][col]);
		
		// When traversing through maze the spartan never actually swaps into a new cell
		
	}

	private double hasSword;
	private double hasBomb;
	
	/*public void playerTraverse()
	{
		t.traverse(maze, maze[row][col]);
		
	}*/
	
	//  ==========  Getters / Setters  ==========
	
	public double getHasSword()
	{
		return hasSword;
	}
	
	public void setHasSword(double hasSword)
	{
		this.hasSword = hasSword;
	}
	
	public double getHasBomb() 
	{
		return hasBomb;
	}
	
	public void setHasBomb(double hasBomb) 
	{
		this.hasBomb = hasBomb;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

}// End class Player
