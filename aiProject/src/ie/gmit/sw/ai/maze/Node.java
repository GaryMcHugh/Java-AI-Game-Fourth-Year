package ie.gmit.sw.ai.maze;

/*
 * 
 *  Nodes are used within each space in the maze. They store information
 *  about each space and are used for the search algorithms 
 * 
 */

public class Node 
{
	
	// ============  Variables  ============
	
	// Node information
	private String name;
	
	// Track current location 
	private int row;
	private int col;
	
	// Sprite
	private char element;
	
	private boolean isGoal;
	private boolean isVisited = false;
	
	private Node parent;
	private Node player;
	
	public Node(String name, char element, int row, int col)
	{
		this.name = name;
		this.element = element;
		this.row = row;
		this.col = col;
		
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
			if(maze[row -1][col].getElement() != '0'  && maze[row -1][col].getElement() != '\u0031' &&  maze[row -1][col].getElement() != '5')
			{
				// Add north node to list
				adjacents.add(maze[row - 1][col]);	
			}
			
		}
		
		// If there is a south path
		if (row < maze.length - 1) 
		{
			
			if(maze[row + 1][col].getElement() != '0' && maze[row + 1][col].getElement() != '\u0031' && maze[row + 1][col].getElement() != '5')
			{
				// Add south node to list
				adjacents.add(maze[row + 1][col]);
			}
			
		}
		
		// If there is a west path 
		if (col > 0)
		{
			if(maze[row][col - 1].getElement() != '0' && maze[row][col - 1].getElement() != '\u0031' && maze[row][col - 1].getElement() != '5')
			{
				// Add west node to list
				adjacents.add(maze[row][col - 1]);
			}
			
		}
		
		// If there is an east path
		if (col < maze[row].length - 1)
		{
			
			if(maze[row][col + 1].getElement() != '0' && maze[row][col + 1].getElement() != '\u0031' && maze[row][col + 1].getElement() != '5')
			{
				// Add east node to list
				adjacents.add(maze[row][col + 1]);
			}
			
		}
		
		return (Node[]) adjacents.toArray(new Node[adjacents.size()]);
	}

	// ===============  Getters / Setters  ===============
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
	
	public char getElement() 
	{	
		return element;	
	}
	
	public void setElement(char element) 
	{
		this.element = element;	
	}

	public boolean isGoalNode() 
	{
		return isGoal;
	}

	public void setGoalNode(boolean goal)
	{
		this.isGoal = goal;
	}
	
	public void setIsVisited(boolean isVisited) 
	{
		this.isVisited = isVisited;
	}

	public boolean getIsVisited() 
	{
		return isVisited;
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
	
	public Node getPlayer() 
	{
		return player;
	}

	public void setPlayer(Node player)
	{
		this.player = player;
	}
	
}// End class Node
