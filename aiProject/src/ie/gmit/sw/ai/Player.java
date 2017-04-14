package ie.gmit.sw.ai;

import ie.gmit.sw.ai.maze.MazeGenerator;
import ie.gmit.sw.ai.traverse.Traversator;

public class Player implements Traversator
{
	
	private MazeGenerator maze;
	private Node node;

	public Player(MazeGenerator model, Node node)
	{
		
		this.maze = model;
		this.node = node;
		
	}

	public void traverse(char[][] maze, Node start) 
	{
		
		
	}
	
	
}// End class Player
