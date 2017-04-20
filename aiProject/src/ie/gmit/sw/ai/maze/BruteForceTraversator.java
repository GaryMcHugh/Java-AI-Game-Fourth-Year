package ie.gmit.sw.ai.maze;

import java.util.*;

import ie.gmit.sw.ai.characters.Player;
import ie.gmit.sw.ai.characters.Spider;

public class BruteForceTraversator implements Traversator
{
	
	private boolean dfs = false;
	
	// Pass in player (Will need an initialized player)
	public BruteForceTraversator(boolean depthFirst) throws Exception
	{
		this.dfs = depthFirst;
		
		//System.out.println(player.getRow() + " " + player.getCol() + " " + player.getElement());
		
	}
	
	/*public BruteForceTraversator(boolean depthFirst, Spider spider) throws Exception
	{
		this.dfs = depthFirst;
		this.spider = spider;
		
		
	}*/
	
	// node in this case is the starting position
	// Its the place in the array
	public void traverse(Node[][] maze, Node node)
	{
		
        long time = System.currentTimeMillis();
    	int visitCount = 0;
    	
		Deque<Node> queue = new LinkedList<Node>();
		
		// Put starting position into the queue
		queue.offer(node);
		
		//System.out.println("Queue Size: " + queue.size());
		
		// While queue is not empty
		while (!queue.isEmpty())
		{
			
			node = queue.poll();
			node.setVisited(true);
			
			visitCount++;
			
			System.out.println(node.getName() + " Path " + node.getRow() + " " + node.getCol() + " " + node.getElement());
			
			// ======================  Updates character in maze  ======================
			//player.setRow(node.getRow());
			//player.setCol(node.getCol());
			
			//spider.setRow(node.getRow());
			//spider.setCol(node.getCol());
			
			if (node.isGoalNode())
			{
				
		        time = System.currentTimeMillis() - time; //Stop the clock
		        
		        //TraversatorStats.printStats(node, time, visitCount);
		        System.out.println("Found goal node at " +  node.getRow() + " " + node.getCol() + " " + node.getElement() + " "+  node.isVisited());
		        
				break;
				
			}
			
			//Simulate processing each expanded node	
			try { 		
				
				Thread.sleep(10);	
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			//Node[] children = node.children(maze);
			
			Node[] children = node.adjacentNodes(maze);
			
			//System.out.println("Children: " + children[0].getRow() + " " + children[0].getCol());
			
			//System.out.println(node.getName() + " Path " + node.getRow() + " " + node.getCol() + " " + node.getElement());
			
			for (int i = 0; i < children.length; i++)
			{
				
				// If child is not null and has not been visited
				if (children[i] != null && !children[i].isVisited())
				{
					children[i].setParent(node);
					
					if (dfs){
						queue.addFirst(children[i]);
					}else{
						queue.addLast(children[i]);
					}
				}									
			}			
			
		}// End while
		
	}// End traverse
	
}// End class BruteForceTraversator



