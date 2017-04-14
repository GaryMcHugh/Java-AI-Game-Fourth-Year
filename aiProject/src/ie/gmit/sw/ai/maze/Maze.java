package ie.gmit.sw.ai.maze;


public class Maze implements MazeGenerator{
	
	private char[][] maze;
	
	public Maze(int dimension){
		
		maze = new char[dimension][dimension];
		init();
		buildMaze();
		
		// First value represents the position in the array
		int featureNumber = (int)((dimension * dimension) * 0.01);
		addFeature('\u0031', '0', featureNumber); //1 is a sword, 0 is a hedge
		addFeature('\u0032', '0', featureNumber); //2 is help, 0 is a hedge
		addFeature('\u0033', '0', featureNumber); //3 is a bomb, 0 is a hedge
		addFeature('\u0034', '0', featureNumber); //4 is a hydrogen bomb, 0 is a hedge
		
		//==============================================
		//remove an add feature line to remove that type of block/spider
		featureNumber = (int)((dimension * dimension) * 0.01);
		addFeature('\u0036', '0', featureNumber); //6 is a Black Spider, 0 is a hedge
		addFeature('\u0037', '0', featureNumber); //7 is a Blue Spider, 0 is a hedge
		addFeature('\u0038', '0', featureNumber); //8 is a Brown Spider, 0 is a hedge
		addFeature('\u0039', '0', featureNumber); //9 is a Green Spider, 0 is a hedge
		addFeature('\u003A', '0', featureNumber); //: is a Grey Spider, 0 is a hedge
		addFeature('\u003B', '0', featureNumber); //; is a Orange Spider, 0 is a hedge
		addFeature('\u003C', '0', featureNumber); //< is a Red Spider, 0 is a hedge
		addFeature('\u003D', '0', featureNumber); //= is a Yellow Spider, 0 is a hedge
	}
	
	
	// Fill the entire maze with hedges
	public void init()
	{
		
		for (int row = 0; row < maze.length; row++)
		{
			for (int col = 0; col < maze[row].length; col++)
			{
				maze[row][col] = '0'; //Index 0 is a hedge...
			}
		}
	}
	
	// Add characters and objects to game by replacing them over the hedge
	public void addFeature(char feature, char replace, int number)
	{
		int counter = 0;
		
		while (counter < feature)
		{
			int row = (int) (maze.length * Math.random());
			int col = (int) (maze[0].length * Math.random());
			
			if (maze[row][col] == replace)
			{
				maze[row][col] = feature;
				counter++;
			}
		}
	}
	
	// buildMaze is used to add blank spaces in which you can move around in
	// It however makes sure that borders of the maze are kept intact
	public void buildMaze(){ 
		
		// Keep borders
		for (int row = 1; row < maze.length - 1; row++){
			
			// Keep borders
			for (int col = 1; col < maze[row].length - 1; col++){
				
				// Generate random number
				int num = (int) (Math.random() * 10);
				
				// Add blank space to move around
				if (num > 5 && col + 1 < maze[row].length - 1)
				{
					maze[row][col + 1] = '\u0020'; //\u0020 = 0x20 = 32 (base 10) = SPACE
				}else
				{
					// Add blank space to move around
					if (row + 1 < maze.length - 1)maze[row + 1][col] = '\u0020';
				}
			}
		}		
	}
	
	public char[][] getMaze(){
		return this.maze;
	}
	
	public char get(int row, int col){
		return this.maze[row][col];
	}
	
	public void set(int row, int col, char c){
		this.maze[row][col] = c;
	}
	
	public int size(){
		return this.maze.length;
	}
	
	/*public String toString(){
		StringBuffer sb = new StringBuffer();
		for (int row = 0; row < maze.length; row++){
			for (int col = 0; col < maze[row].length; col++){
				sb.append(maze[row][col]);
				if (col < maze[row].length - 1) sb.append(",");
			}
			sb.append("\n");
		}
		return sb.toString();
	}*/

}// End class maze