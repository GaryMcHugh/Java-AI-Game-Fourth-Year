package ie.gmit.sw.ai;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import org.omg.CosNaming.IstringHelper;

import ie.gmit.sw.ai.traversers.BruteForceTraversator;
import ie.gmit.sw.ai.traversers.Node;
import ie.gmit.sw.ai.traversers.Traversator;

public class GameRunner implements KeyListener
{
	
	// Initialize size of maze / Number of rows and columns
	private static final int MAZE_DIMENSION = 100;
	
	// Initialize size of Sprite array
	private static final int IMAGE_COUNT = 14;
	
	private GameView view;
	private Mazeable maze;
	private Node node;
	
	// Keep track of current position in the maze / array
	private int currentRow;
	private int currentCol;
	
	// Set game state
	public  boolean isGameOver = false;
	
	public GameRunner() throws Exception {
		
		// Create maze of the size initialized in Maze_Dimension
		maze = new Maze(MAZE_DIMENSION);
		
		// Pass in copy of maze to the game view
		view = new GameView(maze);

		// Store the sprite which have been loaded in from resources folder
		Sprite[] sprites = getSprites();
		
		// Set the sprites in the game view
		view.setSprites(sprites);

		// Position player in the maze
		// Initialize node to starting position
		placePlayer();
		
		/*Traversator t = new BruteForceTraversator(true);
		t.traverse(maze, node);*/

		// Set the physical size of the game screen. Not to do with the number of rows and columns
		Dimension d = new Dimension(GameView.DEFAULT_VIEW_SIZE, GameView.DEFAULT_VIEW_SIZE);
		
		// Methods are tied to the JPanel component
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		//  =========================  Code for setting up the Window  =========================
		
		// Draws the game view frame
		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addKeyListener(this);
		
		// Set the layout type
		f.getContentPane().setLayout(new FlowLayout());
		
		// Attach the game view to the JFrame
		f.add(view);
		
		// Doesn't have any affect on the size. This is due to the method pack() doing the required work
		//f.setSize(800, 800); 
		
		 // Set the position the window will open at. Should be near center of screen
		f.setLocation(500, 100);
		
		// Fits the frame to the game view size
		f.pack(); 
		
		f.setVisible(true);
		
		//  ====================================================================================
		
	}

	private void placePlayer() throws InterruptedException 
	{
		
		// Random starting position
		currentRow = (int) (MAZE_DIMENSION * Math.random());
		currentCol = (int) (MAZE_DIMENSION * Math.random());
		
		// A Spartan warrior is at index 5
		maze.set(currentRow, currentCol, '5'); 
		
		// Initialize node to Spartans starting position
		//node = new Node(currentRow, currentCol);
		updateView();
	
		Thread.sleep(1000);
	}

	// This is the place where the characters will be controlled and moved around the maze
	public void updateView() throws InterruptedException 
	{

		Random rand = new Random();

		int n = rand.nextInt(4) + 1;

		if (n == 1) {
			if (isValidMove(currentRow, currentCol + 1))
				currentCol++;
		} else if (n == 2) {
			if (isValidMove(currentRow, currentCol - 1))
				currentCol--;
		} else if (n == 3) {
			if (isValidMove(currentRow - 1, currentCol))
				currentRow--;
		} else if (n == 4) {
			if (isValidMove(currentRow + 1, currentCol))
				currentRow++;
		}

		view.setCurrentRow(currentRow);
		view.setCurrentCol(currentCol);
		
		// Pass in maze and players starting position
		// maze[][] and maze.set();
		// maze.set is an element of the char array
		
		
		Thread.sleep(1000);
		
	}

	public void keyPressed(KeyEvent e) 
	{
		
		if (e.getKeyCode() == KeyEvent.VK_Z) 
		{
			view.toggleZoom();
		}

		try {
			updateView();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	private boolean isValidMove(int row, int col) {
		if (row <= maze.size() - 1 && col <= maze.size() - 1 && maze.get(row, col) == ' ') {
			maze.set(currentRow, currentCol, '\u0020');
			maze.set(row, col, '5');
			return true;
		} else {
			return false; // Can't move
		}
	}

	private Sprite[] getSprites() throws Exception 
	{
		
		// Read in the images from the resources directory as sprites. Note that each
		// sprite will be referenced by its index in the array, e.g. a 3 implies a Bomb...
		// Ideally, the array should dynamically created from the images...
		Sprite[] sprites = new Sprite[IMAGE_COUNT];
		sprites[0] = new Sprite("Hedge", "resources/hedge.png");
		sprites[1] = new Sprite("Sword", "resources/sword.png");
		sprites[2] = new Sprite("Help", "resources/help.png");
		sprites[3] = new Sprite("Bomb", "resources/bomb.png");
		sprites[4] = new Sprite("Hydrogen Bomb", "resources/h_bomb.png");
		sprites[5] = new Sprite("Spartan Warrior", "resources/spartan_1.png", "resources/spartan_2.png");
		sprites[6] = new Sprite("Black Spider", "resources/black_spider_1.png", "resources/black_spider_2.png");
		sprites[7] = new Sprite("Blue Spider", "resources/blue_spider_1.png", "resources/blue_spider_2.png");
		sprites[8] = new Sprite("Brown Spider", "resources/brown_spider_1.png", "resources/brown_spider_2.png");
		sprites[9] = new Sprite("Green Spider", "resources/green_spider_1.png", "resources/green_spider_2.png");
		sprites[10] = new Sprite("Grey Spider", "resources/grey_spider_1.png", "resources/grey_spider_2.png");
		sprites[11] = new Sprite("Orange Spider", "resources/orange_spider_1.png", "resources/orange_spider_2.png");
		sprites[12] = new Sprite("Red Spider", "resources/red_spider_1.png", "resources/red_spider_2.png");
		sprites[13] = new Sprite("Yellow Spider", "resources/yellow_spider_1.png", "resources/yellow_spider_2.png");
		return sprites;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	
	// =========  Ignore ========= 
	public void keyReleased(KeyEvent e) {} 
	public void keyTyped(KeyEvent e) {} 

}// End class GameRunner