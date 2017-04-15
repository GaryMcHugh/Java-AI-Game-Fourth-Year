package ie.gmit.sw.ai.maze;

/*
 * 
 * The maze class will be constructed on Nodes
 * 
 */

public class Maze 
{
	private Node[][] maze;
	
	// Maze will be initialized when a new instance of maze in created
	// It takes an int which is used to set the maze size
	public Maze(int mazeDimension)
	{
		
		// Set size of maze
		maze = new Node[mazeDimension][mazeDimension];
		
	}// End constructor Maze
	
	// Get node from maze
	public char get(int row, int col)
	{
		// Return specific node
		return this.maze[row][col].getElement();
		
	}// End method get
	
	// Returns the size of the maze
	public int size()
	{
		
		return this.maze.length;
		
	}// End method size
	
}// End class Maze
