package ie.gmit.sw.ai.characters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ie.gmit.sw.ai.maze.BruteForceTraversator;
import ie.gmit.sw.ai.maze.IDDFSTraversator;
import ie.gmit.sw.ai.maze.Node;
import ie.gmit.sw.ai.maze.Traversator;

public class Spider extends Node
{

	private Node[][] maze;
	private ExecutorService executor = Executors.newFixedThreadPool(1);
	private Player player;
	private String name = "spider";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Spider(int row, int col, char element, Node[][] maze, Player player) 
	{
		super(row, col, element);
		
		this.maze = maze;
		this.player = player;
		
		executor.submit(() -> {
			
			
			while(true){
				
				System.out.println(row + " " + col);
				//Traversator t = new IDDFSTraversator();
				Traversator t = new BruteForceTraversator(true, player);
				System.out.println("Spider");
				t.traverse(maze, maze[row][col]);
				
				
			}
			
			
		});
	}
	

}// End class Spider
