package ie.gmit.sw.ai.characters;

import ie.gmit.sw.ai.maze.Maze;

/*
 * 
 *  Class is no longer in use
 * 
 */

public abstract class Character
{

	protected int rowPos;
	protected int colPos;
	protected char element;
	private boolean isAlive;
	private Maze maze;
	
	public Character(int row, int col, char element, Maze maze)
	{
		this.rowPos = row;
		this.colPos = col;
		this.element = element;
		this.maze = maze;
		
	}// End constructor Character
	
	public void putInMaze(int row, int col, char c)
	{
		maze.set(row, col, c);
	}// End setPlayerInMaze
	
	//  ==========  Getters / Setters  ==========
	
	public int getRowPos() 
	{
		return rowPos;
	}
	
	public void setRowPos(int rowPos)
	{
		this.rowPos = rowPos;
	}
	
	public int getColPos()
	{
		return colPos;
	}
	
	public void setColPos(int colPos) 
	{
		this.colPos = colPos;
	}
	
	public boolean isAlive()
	{
		return isAlive;
	}
	
	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	
}// End class Character
