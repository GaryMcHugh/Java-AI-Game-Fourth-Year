package ie.gmit.sw.ai.maze;

import ie.gmit.sw.ai.maze.Node.Direction;

/*
 * 
 *  Nodes are used within each space in the maze. They store information
 *  about each space and are used for the search algorithms 
 * 
 */

public class Node 
{
	
	public enum Direction {North, South, East, West};
	
	// element will represent the image in the 
	// form of a character
	private char element;
	private boolean isGoal;
	private boolean visited = false;
	private Node parent;
	private Node player;
	private Direction[] paths = null;
	
	// Track current location 
	private int row;
	private int col;
	
	public Node(){}

	public Node(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public Node(int row, int col, char element)
	{
		this.row = row;
		this.col = col;
		this.element = element;
	}
	
	// ==========  Getters / Setters  ==========
	
	// Get the character
	public char getElement() 
	{	
		return element;	
	}// End getElement

	// Set the character
	public void setElement(char element) 
	{
		this.element = element;	
	}// End method setElement

	public boolean isGoalNode() 
	{
		return isGoal;
	}// End method isGoal

	public void setGoalNode(boolean goal)
	{
		this.isGoal = goal;
	}// End method setGoal

	public void setVisited(boolean b) 
	{
		this.visited = visited;
	}

	public boolean isVisited() {
		return visited;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public boolean hasDirection(Direction direction){	
		for (int i = 0; i < paths.length; i++) {
			if (paths[i] == direction) return true;
		}
		return false;
	}
	
	// Edited children method
	/*public Node[] children(Node[][] maze)
	{
		
		//System.out.println(maze.length);
		
		// Gets all four children available.
		Node[] children = new Node[4];
		
		//System.out.println(children.length);
		
		//System.out.println("Element "+ node.getElement());

		if (col - 1 >= 0 && maze[row][col - 1].getElement() != '0')
		{
			System.out.println("In West");
			
			children[0] = maze[row][col - 1]; // A West edge
		}
			

		if (col + 1 < maze[row].length && maze[row][col + 1].getElement() != '0')
		{
			System.out.println("In East");
			children[1] = maze[row][col + 1]; // An East Edge
		}
			

		if (row - 1 >= 0 && maze[row - 1][col].getElement() != '0')
		{
			System.out.println("In North");
			children[2] = maze[row - 1][col]; // A North edge
		}
			
			
		if (row + 1 < maze.length && maze[row + 1][col].getElement() != '0')
		{
			System.out.println("In South");
			children[3] = maze[row + 1][col]; // An South Edge
		}

		int counter = 0;
		for (int i = 0; i < children.length; i++) { // goes through each child
			if (children[i] != null) // if child is not empty
				counter++; // increment counter
		}

		// this makes sure the array length is correct (2, 3 or 4)
		Node[] tmp = new Node[counter]; // array with length of 2, 3 or 4
		int index = 0;
		for (int i = 0; i < children.length; i++) {// goes through each child
			if (children[i] != null) { // copy all children into tmp
				tmp[index] = children[i];
				index++;
			}
		}

		return children;
	}*/
	
	/*public Node[] children(Node[][] maze)
	{
		
		java.util.List<Node> children = new java.util.ArrayList<Node>();
				
		if (row > 0 && maze[row - 1][col].hasDirection(Direction.South)) children.add(maze[row - 1][col]); //Add North
		if (row < maze.length - 1 && maze[row + 1][col].hasDirection(Direction.North)) children.add(maze[row + 1][col]); //Add South
		if (col > 0 && maze[row][col - 1].hasDirection(Direction.East)) children.add(maze[row][col - 1]); //Add West
		if (col < maze[row].length - 1 && maze[row][col + 1].hasDirection(Direction.West)) children.add(maze[row][col + 1]); //Add East
		
		return (Node[]) children.toArray(new Node[children.size()]);
	}*/
	
	public Node[] adjacentNodes(Node[][] maze)
	{
		
		java.util.List<Node> adjacents = new java.util.ArrayList<Node>();
		
		if (row > 0)
		{
			
			if(maze[row -1][col].getElement() != '0')
			{
				adjacents.add(maze[row - 1][col]);	
				//System.out.println("Row: " + (row -1) + "\n" + "Col: " + col);
				
			}
			
		}//adjacents.add(maze[row - 1][col]); //Add North
		
		if (row < maze.length - 1) 
		{
			
			//System.out.println("Row: " + row + "\n" +"Maze Length: " +  (maze.length - 1));
			if(maze[row + 1][col].getElement() != '0')
			{
				adjacents.add(maze[row + 1][col]);
			}
			
		}//adjacents.add(maze[row + 1][col]); //Add South
		
		if (col > 0)
		{
			if(maze[row][col - 1].getElement() != '0')
			{
				adjacents.add(maze[row][col - 1]);
			}
			
		}//adjacents.add(maze[row][col - 1]); //Add West
		
		if (col < maze[row].length - 1)
		{
			
			if(maze[row][col + 1].getElement() != '0')
			{
				adjacents.add(maze[row][col + 1]);
			}
			
		}//adjacents.add(maze[row][col + 1]); //Add East*/
		
		return (Node[]) adjacents.toArray(new Node[adjacents.size()]);
	}

	public Node getPlayer() 
	{
		return player;
	}

	public void setPlayer(Node player)
	{
		this.player = player;
	}

	public int getRow() 
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public int getCol() 
	{
		return col;
	}

	public void setCol(int col)
	{
		this.col = col;
	}
	
}// End class Node
