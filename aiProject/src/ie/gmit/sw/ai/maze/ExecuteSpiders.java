package ie.gmit.sw.ai.maze;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ie.gmit.sw.ai.traversers.*;

public class ExecuteSpiders 
{

	private ExecutorService executor = Executors.newFixedThreadPool(1);
	private Traversator t;
	
	public ExecuteSpiders(int row, int col, String name, Node[][] maze)
	{
		
		executor.submit(() -> {
			
			System.out.println("===== " + name + " Spider in maze and Searching =====");
			
			while(true)
			{
				
				// Depending on name of spider a different algorithm is used
				if(name.equals("Black"))
				{
					// Breath First search
					t = new BruteForceTraversator(false);	
				}
				else if(name.equals("Blue"))
				{	
					t = new IDDFSTraversator();
				}
				else if(name.equals("Yellow"))
				{
					t = new RecursiveDFSTraversator();
				}
				else if(name.equals("Green"))
				{
					
					t = new DepthLimitedDFSTraversator(2);
				}
				
				try 
				{
					t.traverse(maze, maze[row][col]);
					
				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("\n***************  " + name + " Spider"+ ": " + " found goal" + "  ***************");
				break;
				
			}// End while
		
		});// End executor
		
	}// End constructor 
	
}// End ExecuteSpiders
