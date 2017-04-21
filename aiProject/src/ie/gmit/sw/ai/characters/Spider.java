package ie.gmit.sw.ai.characters;

import ie.gmit.sw.ai.maze.Node;

/*
 * 
 * The different spiders included are
 * 	Black   - '6'
 *  Blue    - '7'
 *  Yellow  - '='
 *  Green   - '9'
 * 
 */

public class Spider 
{

	private Node[][] maze;
	
	private String name;
	
	public Spider(int row, int col, char element, Node[][] maze, String name) 
	{
		
		this.maze = maze;
		this.name = name;
		
	}// End constructor Spider
	
	public Node[][] getMaze() 
	{
		return maze;
	}

	public void setMaze(Node[][] maze) 
	{
		this.maze = maze;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}// End class Spider
