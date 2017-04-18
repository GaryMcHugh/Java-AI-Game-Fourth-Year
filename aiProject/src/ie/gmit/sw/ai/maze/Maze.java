package ie.gmit.sw.ai.maze;

/*
 * 
 *  The maze is constructed of Nodes which each have a certain character
 *  to represent an image
 * 
 */

public class Maze 
{
	private Node[][] maze;
	
	// Maze will be initialized when a new instance of maze in created
	// It takes an int which is used to set the maze size
	public Maze(int mazeDimension) throws InterruptedException
	{
		
		// Set size of maze
		maze = new Node[mazeDimension][mazeDimension];
		
		// Create maze with only hedges
		init();
		
		// Add spaces to the maze
		buildMaze();
		
		int featureNumber = (int)((mazeDimension * mazeDimension) * 0.01);
		
		// ==========  Features are sent in as Escaped Unicode Which will later be changed into a true numerical form  ==========
		// ==========  and that will be used to get the image from the BufferedImage array in Sprite class             ==========
		 
		addFeature('\u0031', '0', featureNumber); //1 is a sword, 0 is a hedge
		addFeature('\u0032', '0', featureNumber); //2 is help, 0 is a hedge
		addFeature('\u0033', '0', featureNumber); //3 is a bomb, 0 is a hedge
		addFeature('\u0034', '0', featureNumber); //4 is a hydrogen bomb, 0 is a hedge
		addFeature('\u0036', '0', featureNumber); //6 is a Black Spider, 0 is a hedge
		addFeature('\u0037', '0', featureNumber); //7 is a Blue Spider, 0 is a hedge
		addFeature('\u0038', '0', featureNumber); //8 is a Brown Spider, 0 is a hedge
		addFeature('\u0039', '0', featureNumber); //9 is a Green Spider, 0 is a hedge
		addFeature('\u003A', '0', featureNumber); //: is a Grey Spider, 0 is a hedge
		addFeature('\u003B', '0', featureNumber); //; is a Orange Spider, 0 is a hedge
		addFeature('\u003C', '0', featureNumber); //< is a Red Spider, 0 is a hedge
		addFeature('\u003D', '0', featureNumber); //= is a Yellow Spider, 0 is a hedge
		
		insertGoalNode();
		
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
				
				// Need to initialize every element in array to a new node
				maze[row][col] = new Node();
				
				// Set nodes in maze to be hedges
				maze[row][col].setElement('0');
				
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
					maze[row][col + 1].setElement('\u0020');; 
					
					//System.out.print(maze[row][col + 1].getElement());
					
				}
				else
				{
					
					// Don't put a space in the borders
					if (row + 1 < maze.length - 1)
					{
						
						// Fill node in maze with a space
						maze[row + 1][col].setElement('\u0020');
						
					}// End if
					
					//System.out.print(maze[row][col + 1].getElement());
				}// End if / else
				
			}// End inner for
			
			//System.out.println();
		}// End outer for
		
	}// End method buildMaze
	
	private void insertGoalNode()
	{
		
		maze[20][70].setElement('G');
		maze[20][70].setGoal(true);
		
	}
	
	// Add items and spiders to maze
	// Random elements are selected and if they are hedges 
	// then get replaced with the item or spider
	private void addFeature(char feature, char replace, int number) 
	{
		int counter = 0;
		
		while (counter < feature)
		{
			
			// Generate random number and check that element
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			// element is a hedge 
			if (maze[row][col].getElement() == replace)
			{	
				
				// put a spider or item in that element
				maze[row][col].setElement(feature);
				
				counter++;
				
			}// End if
			
		}// End while
		
	}// End method addFeature
	
	// Print out the entire maze
	private void printFullMaze()
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
	
	// Get node from maze
	public char get(int row, int col)
	{
		// Return specific node
		return this.maze[row][col].getElement();
		
	}// End method get
	
	public void set(int row, int col, char c) 
	{
		this.maze[row][col].setElement(c);;
	}
	
	// Returns the size of the maze
	public int size()
	{
		
		return this.maze.length;
		
	}// End method size
	
}// End class Maze
