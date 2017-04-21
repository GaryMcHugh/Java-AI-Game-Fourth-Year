package ie.gmit.sw.ai.maze;

/*
 * 
 *  The maze is constructed of Nodes which each have a certain character
 *  to represent an image
 * 
 */

public class Maze 
{
	
	// ============  CONTANTS  ============
	private final int Num_Of_Enemies = 1;
	private final int Num_Of_Features = 3;
	
	// ============  Variables  ============
	private Node[][] maze;
	
	// Maze will be initialized when a new instance of maze in created
	// It takes an int which is used to set the maze size
	public Maze(int mazeDimension) throws Exception
	{
		
		// Set size of maze
		maze = new Node[mazeDimension][mazeDimension];
		
		// Create maze with only hedges
		init();
		
		// Add spaces to the maze
		buildMaze();
		 
	}// End constructor Maze
	
	// ====================  Helper Methods  ====================
	
	// Create the whole maze first filling it with only hedges
	private void init()
	{
		
		// Loop through the whole array
		for (int row = 0; row < maze.length; row++)
		{
			
			for (int col = 0; col < maze[row].length; col++)
			{
				
				maze[row][col] = new Node("Hedge", '0', row, col);
				
			}// End inner for
			
			//System.out.println();
			
		}// End outer for
		
	}// End method init
	
	// buildMaze adds spaces in the maze for the Spartan to move around in
	private void buildMaze()
	{
		
		// Avoid looping through the top and bottom borders
		for (int row = 1; row < maze.length - 1; row++)
		{
			
			// // Avoid looping through the left and right borders
			for (int col = 1; col < maze[row].length - 1; col++)
			{
				
				// Generate random number
				int num = (int) (Math.random() * 10);
				
				// Make sure a space is not being placed in the border
				if (num > 5 && col + 1 < maze[row].length - 1)
				{
					
					// Fill node in maze with a space
					//maze[row][col + 1].setElement('\u0020');
					maze[row][col] = new Node("Space", '\u0020', row, col);
					
				}
				else
				{
					
					// Don't put a space in the borders
					if (row + 1 < maze.length - 1)
					{
						
						maze[row + 1][col] = new Node("Space", '\u0020', row, col);
						
					}// End if
					
				}// End if / else
				
			}// End inner for
			
		}// End outer for
		
	}// End method buildMaze
	
	// Add items and spiders to maze
	// Random elements are selected and if they are hedges 
	// then get replaced with the item or spider
	public void addSpiders(char element, char replace, String name) throws Exception 
	{
		
		int counter = 0;
		
		// Add items and spiders
		while (counter < Num_Of_Enemies)
		{
			
			// Generate random number and check that element
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			// element is a hedge 
			if (maze[row][col].getElement() == replace)
			{	
				/*
				if(element <= '\u0034')
				{
					
					maze[row][col] = new Node(name, element, row, col);
					
				}*/
				
				if(element >= '\u0036')// If it's a Spider (>= 6)
				{
					
					maze[row][col] = new Node(name, element, row, col);
					
					new ExecuteSpiders(row, col, name, maze);
				}
				
				counter++;
				
			}// End if
			
		}// End while
		
	}// End method addFeature
	
	public void addFeature(char element, char replace, String name)
	{
		
		int counter = 0;
		
		// Add items and spiders
		while (counter < Num_Of_Features)
		{
			
			// Generate random number and check that element
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			// element is a hedge 
			if (maze[row][col].getElement() == replace)
			{	
				
				if(element <= '\u0034')
				{
					
					maze[row][col] = new Node(name, element, row, col);
					
				}
				
				counter++;
				
			}// End if
			
		}// End while
		
	}// End addFeature
	
	// Print out the entire maze
	public void printFullMaze()
	{
		
		// Loop through the whole array
		for (int row = 0; row < maze.length; row++)
		{
			
			for (int col = 0; col < maze[row].length; col++)
			{
				
				// Print out the character at that node
				System.out.print(maze[row][col].getElement());
				
			}// End inner for
			
			System.out.println();
			
		}// End outer for
		
	}// End method printFullMaze

	// ====================  Getters / Setters  ====================
	
	public Node[][] getMaze()
	{
		return maze;
	}

	public void setMaze(Node[][] maze)
	{
		this.maze = maze;
	}
	
	// Get element from specified node from maze
	public char get(int row, int col)
	{
		return this.maze[row][col].getElement();
		
	}// End method get
	
	public void set(int row, int col, char c) 
	{
		this.maze[row][col].setElement(c);
	}
	
	public int size()
	{
		return this.maze.length;
		
	}// End method size
	
}// End class Maze
