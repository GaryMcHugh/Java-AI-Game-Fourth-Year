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
	private int row, col;
	private String name;
	
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
		
		// Swap into new position 
		
		//t = new IDDFSTraversator();
		//t.traverse(maze, maze[row][col]);
		//t = new RecursiveDFSTraversator();
		//t.traverse(maze, maze[row][col]);
		
	}

}// End class Player
