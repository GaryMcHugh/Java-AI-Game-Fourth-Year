package ie.gmit.sw.ai.maze;

/*
 * 
 *  The maze class will be constructed of Nodes which will each be given a certain char
 *  to represent an image
 * 
 */

public class Maze 
{
	private Node[][] maze;
	private Node nodeHedge, nodeSpace;
	
	// Maze will be initialized when a new instance of maze in created
	// It takes an int which is used to set the maze size
	public Maze(int mazeDimension)
	{
		
		// Set size of maze
		maze = new Node[mazeDimension][mazeDimension];
		
		
		nodeHedge = new Node();
		nodeSpace = new Node();
		
		// set the character '0' to be a hedge
		nodeHedge.setElement('0');
		
		// set the escaped unicode character '\u0020' to be a space
		nodeSpace.setElement('\u0020');
		
		// Create maze with only hedges
		init();
		
		buildMaze();
		
		// ==========  FOR TESTING PURPOSES  ==========
		// Print out the entire maze including borders
		printFullMaze();
		
	}// End constructor Maze
	
	// Create the whole maze first filling it with only hedges
	private void init()
	{
		
		// Loop through the whole array
		for (int row = 0; row < maze.length; row++)
		{
			
			for (int col = 0; col < maze[row].length; col++)
			{
				
				// Set nodes in maze to be hedges AKA '0'
				maze[row][col] = nodeHedge; 
				
				// Print out the character at that node
				//System.out.print(maze[row][col].getElement());
				
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
					maze[row][col + 1] = nodeSpace; 
					
					//System.out.print(maze[row][col + 1].getElement());
					
				}
				else
				{
					
					// Don't put a space in the borders
					if (row + 1 < maze.length - 1)
					{
						
						// Fill node in maze with a space
						maze[row + 1][col] = nodeSpace;
						
					}
					
					//System.out.print(maze[row][col + 1].getElement());
				}// End if / else
				
			}// End inner for
			
			//System.out.println();
		}// End outer for
		
	}// End method buildMaze
	
	// Print out the entire maze
	private void printFullMaze()
	{
		
		System.out.println("\n\n");
		
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
