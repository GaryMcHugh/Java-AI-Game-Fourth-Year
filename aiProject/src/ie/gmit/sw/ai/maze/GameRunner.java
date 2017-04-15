package ie.gmit.sw.ai.maze;

/*
 * 
 *  This class will be used for starting the game
 * 
 */
public class GameRunner 
{
	
	// =============== Constants  ===============
	
	private static final int MAZE_DIMENSION = 100;
	
	// =============== Variables  ===============
	
	private Maze maze;
	private GameView view;
	
	// Main method to start the game 
	public static void main(String[] args) throws Exception 
	{
		
		// Start game
		new GameRunner();
		
	}// End method main
	
	public GameRunner() throws Exception
	{
		
		// Initialize size of maze
		maze = new Maze(MAZE_DIMENSION);
		
		// Pass a copy of the initialized maze into the game view 
		view = new GameView(maze);
		
	}// End constructor GameRunner
	
}// End class GameRunner
