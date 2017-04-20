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
	private String name;
	
	// Track current location 
	private int row;
	private int col;
	
	public Node(){}

	public Node(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public Node(int row, int col, char element, String name)
	{
		this.row = row;
		this.col = col;
		this.element = element;
		this.name = name;
		
		// If it's the goal node set the boolean to true
		if(name.equals("Goal Node"))
		{
			
			setGoalNode(true);
			
		}
		
	}// End constructor Node
	
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

	// ==========  Dumbass =========
	// parameter was boolean visited
	public void setVisited(boolean b) 
	{
		this.visited = b;
	}

	public boolean isVisited() {
		return visited;
	}
	
	public boolean hasDirection(Direction direction){	
		for (int i = 0; i < paths.length; i++) {
			if (paths[i] == direction) return true;
		}
		return false;
	}
	
	public Node[] children(Node[][] maze)
	{
		
		java.util.List<Node> children = new java.util.ArrayList<Node>();
				
		if (row > 0 && maze[row - 1][col].hasDirection(Direction.South)) children.add(maze[row - 1][col]); //Add North
		if (row < maze.length - 1 && maze[row + 1][col].hasDirection(Direction.North)) children.add(maze[row + 1][col]); //Add South
		if (col > 0 && maze[row][col - 1].hasDirection(Direction.East)) children.add(maze[row][col - 1]); //Add West
		if (col < maze[row].length - 1 && maze[row][col + 1].hasDirection(Direction.West)) children.add(maze[row][col + 1]); //Add East
		
		return (Node[]) children.toArray(new Node[children.size()]);
	}
	
	// ======================================
	// DETERMINES WHAT THE SPARTAN WILL AVOID
	// ======================================
	//   If spartan is to avoid spiders that
	//      behavior must be set here
	// ======================================
	public Node[] adjacentNodes(Node[][] maze)
	{
		
		// List contains directions which player can go
		java.util.List<Node> adjacents = new java.util.ArrayList<Node>();
		
		// If there is a north path
		if (row > 0)
		{
			
			// If it isn't a hedge
			if(maze[row -1][col].getElement() != '0')
			{
				
				// Add this node to list
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

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	// The current node becomes the Parent node 
	public Node getParent()
	{
		return parent;
	}

	public void setParent(Node parent)
	{
		this.parent = parent;
	}

	public void swapPosition(Node[][] maze, Node newPosition, Node oldPosition)
	{	
		
		// If the new position is a hedge
		if(maze[newPosition.getRow()][newPosition.getCol()].getElement() == '0' || maze[newPosition.getRow()][newPosition.getCol()].getElement() == 'G')
		{
			// need if to check if's the spartan who's changing the elements in the maze
			maze[newPosition.getRow()][newPosition.getCol()].setElement('5');
			maze[oldPosition.getRow()][oldPosition.getCol()].setElement('\u0020');
			//System.out.println("Current node " + oldPosition.getElement() + "   " + "Parent node " + newPosition.getElement());
		}
		
	}
	
}// End class Node
