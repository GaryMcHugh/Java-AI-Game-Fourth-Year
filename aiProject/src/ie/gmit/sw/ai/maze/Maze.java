package ie.gmit.sw.ai.maze;

import ie.gmit.sw.ai.characters.Spider;

/*
 * 
 *  The maze is constructed of Nodes which each have a certain character
 *  to represent an image
 * 
 */

// ================================= IMPORTANT  ================================
// **** When maze is built every node should have it's position initialized **** 
// =============================================================================

public class Maze 
{
	private Node[][] maze;
	
	private final int Num_Of_Enemies = 15;
	// Represents the player
	//private Node playerStart;
	
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
		 
		/*addFeature('\u0031', '0', featureNumber); //1 is a sword, 0 is a hedge
		addFeature('\u0032', '0', featureNumber); //2 is help, 0 is a hedge
		addFeature('\u0033', '0', featureNumber); //3 is a bomb, 0 is a hedge
		addFeature('\u0034', '0', featureNumber); //4 is a hydrogen bomb, 0 is a hedge
*/		
		addFeature('\u0036', '0', featureNumber, "Black");  //6 is a Black Spider, 0 is a hedge
		addFeature('\u0037', '0', featureNumber, "Blue");   //7 is a Blue Spider, 0 is a hedge
		addFeature('\u0038', '0', featureNumber, "Brown");  //8 is a Brown Spider, 0 is a hedge
		addFeature('\u0039', '0', featureNumber, "Green");  //9 is a Green Spider, 0 is a hedge
		addFeature('\u003A', '0', featureNumber, "Grey");   //: is a Grey Spider, 0 is a hedge
		addFeature('\u003B', '0', featureNumber, "Orange"); //; is a Orange Spider, 0 is a hedge
		addFeature('\u003C', '0', featureNumber, "Red");    //< is a Red Spider, 0 is a hedge
		addFeature('\u003D', '0', featureNumber, "Yellow"); //= is a Yellow Spider, 0 is a hedge
		
		insertGoalNode();
		
		//insertPlayer();
		
		// ==========  FOR TESTING PURPOSES  ==========
		// Print out the entire maze including borders
		//printFullMaze();
		
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
				maze[row][col] = new Node(row, col, '0');
				
				// Set nodes in maze to be hedges
				//maze[row][col].setElement('0');
				
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
		
		// randomly generate number and make sure it's equal  to a space
		// then insert into maze
		
		maze[10][10].setElement('G');
		maze[10][10].setGoalNode(true);
		
	}
	
	/*private void insertPlayer()
	{
		
		playerStart = new Node();
		setPlayerStart(playerStart);
		
	}*/
	
	// Add items and spiders to maze
	// Random elements are selected and if they are hedges 
	// then get replaced with the item or spider
	private void addFeature(char feature, char replace, int number, String name) // Could pass in name or enum then use that as case statement in spider class
	{
		int counter = 0;
		
		while (counter < Num_Of_Enemies)
		{
		
			// Generate random number and check that element
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			// element is a hedge 
			if (maze[row][col].getElement() == replace)
			{	
				
				/*if(row % 2 == 0)
				{
					// put a spider or item in that element
					maze[row][col].setElement(feature);
					maze[row][col] = new Spider(row, col, 'B', maze, null);
					
				}
				else{
					
					// put a spider or item in that element
					maze[row][col].setElement(feature);
					maze[row][col] = new Spider(row, col, 'K', maze, null);
					
				}*/
				
				if(feature >= '\u0036')
				{
					
					maze[row][col] = new Spider(row, col, feature, maze, null, (name + counter));// Unique spider name
					
					//maze[row][col].setElement(feature); // Old code
				}
				
				counter++;
				
			}// End if
			
		}// End while
		
	}// End method addFeature
	
	// Print out the entire maze
	/*private void printFullMaze()
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
*/	
	// Get node from maze
	public char get(int row, int col)
	{
		
		//System.out.println("Maze position" + this.maze[row][col].getElement());
		// Return specific node
		return this.maze[row][col].getElement();
		
	}// End method get
	
	public void set(int row, int col, char c) 
	{
		this.maze[row][col].setElement(c);
		
	}
	
	// Returns the size of the maze
	public int size()
	{
		
		return this.maze.length;
		
	}// End method size

	public Node[][] getMaze() {
		return maze;
	}

	public void setMaze(Node[][] maze) {
		this.maze = maze;
	}

	/*public Node getPlayerStart()
	{
		return playerStart;
	}

	public void setPlayerStart(Node playerStart)
	{
		this.playerStart = playerStart;
		this.maze[5][5].setElement('5');
		this.maze[5][5] = this.playerStart;
	}*/
	
}// End class Maze
