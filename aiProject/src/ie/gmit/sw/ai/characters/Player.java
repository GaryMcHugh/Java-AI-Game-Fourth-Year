package ie.gmit.sw.ai.characters;

import ie.gmit.sw.ai.maze.Node;


/*
 * 
 *  Player is a node
 * 
 */
public class Player extends Node 
{
	
	private Node[][] maze;

	public Player(int currentRow, int currentCol, char c, Node[][] maze) 
	{
		super(currentRow, currentCol, c);
		
		this.maze = maze;
	}

	private double hasSword;
	private double hasBomb;
	
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

}// End class Player
