package ie.gmit.sw.ai;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import org.omg.CosNaming.IstringHelper;

import ie.gmit.sw.ai.maze.Maze;
import ie.gmit.sw.ai.maze.MazeGenerator;

public class GamePlay implements KeyListener
{
	
	private static final int MAZE_DIMENSION = 100; // Set size of maze
	private static final int IMAGE_COUNT = 14; // Number of images
	private GameView view; 
	private MazeGenerator model;
	private Player player;
	private Node node;
	private int currentRow;
	private int currentCol;
	private boolean isGameOver;
	
	public GamePlay() throws Exception {
		
		// Set game state
		isGameOver = false;
		
		// Build the maze to a set dimension
		model = new Maze(MAZE_DIMENSION);
		
		// 
		view = new GameView(model);

		// Initialize sprites 
		Sprite[] sprites = getSprites();
		view.setSprites(sprites);

		// Place player into the maze
		placePlayer();

		Dimension d = new Dimension(GameView.DEFAULT_VIEW_SIZE, GameView.DEFAULT_VIEW_SIZE);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		// GUI 
		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addKeyListener(this);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);
		f.setSize(1000, 1000);
		f.setLocation(100, 100);
		f.pack();
		f.setVisible(true);
		
	}// End constructor GamePlay()

	// Start player in a random position in the maze
	private void placePlayer() throws InterruptedException 
	{
		currentRow = (int) (MAZE_DIMENSION * Math.random());
		currentCol = (int) (MAZE_DIMENSION * Math.random());
		// Need this code for each character
		model.set(currentRow, currentCol, '5'); // A Spartan warrior is at index 5
		updateView();
	}

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

	public void keyReleased(KeyEvent e) {
	} // Ignore

	public void keyTyped(KeyEvent e) {
	} // Ignore
	
	// 
	private boolean isValidMove(int row, int col) 
	{
		// If the block is a blank space then the spartan can move
		if (row <= model.size() - 1 && col <= model.size() - 1 && model.get(row, col) == ' ') 
		{
			model.set(currentRow, currentCol, '\u0020');
			
			// The number 5 is the spartan
			model.set(row, col, '5');
			return true;
		} else {
			return false; // Can't move
		}
	}

	private Sprite[] getSprites() throws Exception 
	{
		
		// Read in the images from the resources directory as sprites. Note that
		// each
		// sprite will be referenced by its index in the array, e.g. a 3 implies
		// a Bomb...
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

}