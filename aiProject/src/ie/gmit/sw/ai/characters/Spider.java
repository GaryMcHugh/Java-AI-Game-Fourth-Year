package ie.gmit.sw.ai.characters;

import ie.gmit.sw.ai.maze.Node;

public class Spider extends Node
{

	private Node[][] maze;
	
	public Spider(int row, int col, char element, Node[][] maze) 
	{
		super(row, col, element);
		
		this.maze = maze;
	}

}// End class Spider
