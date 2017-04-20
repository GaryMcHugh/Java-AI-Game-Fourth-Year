package ie.gmit.sw.ai.maze;

import ie.gmit.sw.ai.characters.Spider;
import ie.gmit.sw.ai.characters.Player;

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
	
	// ============  CONTANTS  ============
	private final int Num_Of_Enemies = 50;
	
	// ============  Variables  ============
	private Node[][] maze;
	private Player player;
	private boolean isPlayer = false;
	
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
		
		int featureNumber = (int)((mazeDimension * mazeDimension) * 0.01);
		
		// ==========  Features are sent in as Escaped Unicode Which will later be changed into a true numerical form  ==========
		// ==========  and that will be used to get the image from the BufferedImage array in Sprite class             ==========
		 
		addFeature('\u0031', '0', featureNumber, "Sword"); //1 is a sword, 0 is a hedge
		addFeature('\u0032', '0', featureNumber, "Help-Hedge"); //2 is help, 0 is a hedge
		addFeature('\u0033', '0', featureNumber, "Bomb"); //3 is a bomb, 0 is a hedge
		addFeature('\u0034', '0', featureNumber, "Hydrogen Bomb"); //4 is a hydrogen bomb, 0 is a hedge
	
		addFeature('\u0036', '0', featureNumber, "Black");  //6 is a Black Spider, 0 is a hedge
		addFeature('\u0037', '0', featureNumber, "Blue");   //7 is a Blue Spider, 0 is a hedge
		addFeature('\u0038', '0', featureNumber, "Brown");  //8 is a Brown Spider, 0 is a hedge
		addFeature('\u0039', '0', featureNumber, "Green");  //9 is a Green Spider, 0 is a hedge
		addFeature('\u003A', '0', featureNumber, "Grey");   //: is a Grey Spider, 0 is a hedge
		addFeature('\u003B', '0', featureNumber, "Orange"); //; is a Orange Spider, 0 is a hedge
		addFeature('\u003C', '0', featureNumber, "Red");    //< is a Red Spider, 0 is a hedge
		addFeature('\u003D', '0', featureNumber, "Yellow"); //= is a Yellow Spider, 0 is a hedge
		
		//printFullMaze();
		
		// Place goal node for player to search for
		insertGoalNode();
		
		addFeature('5', '0', featureNumber, "Spartan");  //5 is the Spartan, 0 is a hedge
		
		// =================  NOTE  =================
		// Player starts searching immediately after 
		//    the node is set to a place in maze 
		// ==========================================
		//addPlayer(5, 5);
		
		
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
				maze[row][col] = new Node(row, col, '0', "Hedge");
				
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
		
		// randomly generate number and make sure it's equal to a space
		// then insert into maze
		//maze[10][10].setElement('G');
		//maze[10][10].setGoalNode(true);
		//maze[10][10] = new Node(10, 10, 'G', "Goal Node");
		
		// ====================  NOTE  ====================
		//       Don't have goal node equal to 7,7
		//     randomly gives out of bounds exception 
		// ================================================
		
		maze[10][10] = new Node(10, 10, 'G', "Goal Node");
		
	}
	
	/*private void addPlayer(int row, int col)
	{
		
		try 
		{
			player = new Player(row, col, '5', maze, "Spartan");
			maze[row][col] = player;
			
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		player.playerTraverse();
		
	}// End method addPlayer*/
	
	// Add items and spiders to maze
	// Random elements are selected and if they are hedges 
	// then get replaced with the item or spider
	private void addFeature(char feature, char replace, int number, String name) throws Exception // Could pass in name or enum then use that as case statement in spider class
	{
		
		int counter = 0;
		
		// Add Player
		/*if(name.equals("Spartan"))
		{
			// Hard code position of Spartan for now
			maze[5][5] = new Player(5, 5, '5', maze, name);
		}*/
		
		// Add items and spiders
		while (counter < Num_Of_Enemies)
		{
			
			// Generate random number and check that element
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			// element is a hedge 
			if (maze[row][col].getElement() == replace)
			{	
				
				if(feature <= '\u0034')
				{
					
					maze[row][col] = new Node(row, col, feature, name);
					
				}
				else if(feature == '5')
				{
					// Hard code position of Spartan for now
					maze[5][5] = new Player(5, 5, '5', maze, name);
				}
				
				else if(feature >= '\u0036')// If it's a Spider (>= 6)
				{
					
					// ====================================  NOTE  =====================================
					// Each node is being filled by a spider BUT spiders are not searching for goal node
					// This may be due to each spider being put into a new BruteForceTraverser meaning 
					// they could be navigating in their own maze and not all in the same maze
					// =================================================================================
					maze[row][col] = new Spider(row, col, feature, maze, null, (name + "_" + counter));// Unique spider name
					
					//maze[row][col].setElement(feature); // Old code
				}
				
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
	
}// End class Maze
