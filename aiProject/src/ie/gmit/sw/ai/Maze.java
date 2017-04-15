package ie.gmit.sw.ai;

// Creating an object of Maze will build a maze of a specified size
public class Maze implements Mazeable {
	
	private char[][] maze;
	
	public Maze(int dimension)
	{
		
		// Initialize size of array
		maze = new char[dimension][dimension];
		
		// Created the square for the maze and fills it with hedges sprites
		init();
		
		// Adds blank spaces to the array
		//buildMaze();
		
		
		//  ==================  Adding features to maze  ==================
		// 		Randomly places the other items and characters to the game
		// 			These are put in place of the hedges sprites
		//  ===============================================================
		
		// featureNumber is never used
		//int featureNumber = (int)((dimension * dimension) * 0.01);
		
		
		addFeature('\u0031', '0', 100); //1 is a sword, 0 is a hedge
		addFeature('\u0032', '0', 100); //2 is help, 0 is a hedge
		addFeature('\u0033', '0', 100); //3 is a bomb, 0 is a hedge
		addFeature('\u0034', '0', 100); //4 is a hydrogen bomb, 0 is a hedge
		
		// featureNumber is never used
		//featureNumber = (int)((dimension * dimension) * 0.01);
		
		addFeature('\u0036', '0', 100); //6 is a Black Spider, 0 is a hedge
		addFeature('\u0037', '0', 100); //7 is a Blue Spider, 0 is a hedge
		addFeature('\u0038', '0', 100); //8 is a Brown Spider, 0 is a hedge
		addFeature('\u0039', '0', 100); //9 is a Green Spider, 0 is a hedge
		addFeature('\u003A', '0', 100); //: is a Grey Spider, 0 is a hedge
		addFeature('\u003B', '0', 100); //; is a Orange Spider, 0 is a hedge
		addFeature('\u003C', '0', 100); //< is a Red Spider, 0 is a hedge
		addFeature('\u003D', '0', 100); //= is a Yellow Spider, 0 is a hedge
		
		// Adds blank spaces to the array
		buildMaze();
	}
	
	// Fill the entire maze with hedges
	public void init() {
		for (int row = 0; row < maze.length; row++){
			for (int col = 0; col < maze[row].length; col++){
				maze[row][col] = '0'; //Index 0 is a hedge...
				//System.out.print(maze[row][col]);
			}
			
			//System.out.println();
				
		}
	}

	// Add characters and objects to game by replacing them over the hedge
	// 'number is never used'
	public void addFeature(char feature, char replace, int number) {
		int counter = 0;
		while (counter < feature){
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			if (maze[row][col] == replace){
				maze[row][col] = feature;
				counter++;
			}
			
		}
	}

	// buildMaze is used to add blank spaces in which you can move around in
	// It however makes sure that borders of the maze are kept intact
	// Does not print out the borders 
	public void buildMaze() { 
		for (int row = 1; row < maze.length - 1; row++){
			for (int col = 1; col < maze[row].length - 1; col++)
			{
				int num = (int) (Math.random() * 10);
				if (num > 5 && col + 1 < maze[row].length - 1){
					maze[row][col + 1] = '\u0020'; //\u0020 = 0x20 = 32 (base 10) = SPACE
					System.out.print(maze[row][col]);
				}else{
					if (row + 1 < maze.length - 1)maze[row + 1][col] = '\u0020';
					System.out.print(maze[row][col]);
				}
			}
			
			System.out.println();
		}		
	}

	public char get(int row, int col) {
		return this.maze[row][col];
	}

	public void set(int row, int col, char c) {
		this.maze[row][col] = c;
	}

	public int size() {
		return this.maze.length;
	}
	
}// End class Maze