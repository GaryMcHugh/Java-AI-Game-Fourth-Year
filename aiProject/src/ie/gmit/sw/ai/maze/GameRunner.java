package ie.gmit.sw.ai.maze;

import ie.gmit.sw.ai.characters.Player;
import ie.gmit.sw.ai.fl.FuzzyLogic;
import ie.gmit.sw.ai.traversers.*;

/*
 * 
 *  This class is be used for starting the game
 * 
 */
public class GameRunner //implements KeyListener
{
	
	// =============== Constants  ===============
	
	private static final int MAZE_DIMENSION = 100;
	private static final int IMAGE_COUNT = 14;
	
	// =============== Variables  ===============
	
	private Maze maze;
	private int currentRow, currentCol;
	
	// Main method to start the game 
	public static void main(String[] args) throws Exception 
	{
		
		// Start game
		new GameRunner();
		
	}// End method main
	
	public GameRunner() throws Exception
	{
		
		System.out.println("Maze being built\n");
		
		new FuzzyLogic();
		
		printNN();
		
		// Initialize size of maze
		maze = new Maze(MAZE_DIMENSION);
		
    	// Insert goal node in random position
		setGoalNode();
		
		setFeatures();
		
		setSpiders();
		
		// ***********  PLACE PLAYER INTO THE MAZE HERE  ***********
		setPlayerInMaze();
		
		maze.printFullMaze();
		
	}// End constructor GameRunner
	
	private void setGoalNode()
	{
		
		// Generate random number and set the goal node at that location
		int row = (int) (MAZE_DIMENSION * Math.random());
		int col = (int) (MAZE_DIMENSION * Math.random());
		
		maze.getMaze()[row][col] = new Node("Goal", 'G', row, col);
		maze.getMaze()[row][col].setGoalNode(true);
		
		System.out.println("\n*****  Goal Node Set  *****\n");
		
	}
	
	private void printNN()
	{
		
		System.out.println("\n\n-----------Nerual Network Stats ----------");
		new Player();
	}
	
	private void setPlayerInMaze()
	{
		
		System.out.println("\n*****  Spartan Set and Searching *****\n");
		
		// Generate random number and check that element
		int currentRow = (int) (MAZE_DIMENSION * Math.random());
		int currentCol = (int) (MAZE_DIMENSION * Math.random());
		
		// Place player into maze at these coordinates
		maze.getMaze()[currentRow][currentCol] = new Node("Player", '5', 1, 1);
		
		Traversator t  = new BruteForceTraversator(true);	
		t.traverse(maze.getMaze(), maze.getMaze()[98][98]);
		
	}
	
	private void setFeatures()
	{
		maze.addFeature('\u0031', '0', "Sword"); //1 is a sword, 0 is a hedge
		maze.addFeature('\u0032', '0',  "Help-Hedge"); //2 is help, 0 is a hedge
		maze.addFeature('\u0033', '0', "Bomb"); //3 is a bomb, 0 is a hedge
		maze.addFeature('\u0034', '0', "Hydrogen Bomb"); //4 is a hydrogen bomb, 0 is a hedge
		
	}
	
	private void setSpiders() throws Exception
	{
		maze.addSpiders('\u0036', '0', "Black");
		maze.addSpiders('\u0036', '0', "Blue");
		maze.addSpiders('\u0036', '0', "Yellow");
		maze.addSpiders('\u0036', '0', "Green");
	}
		
}// End class GameRunner