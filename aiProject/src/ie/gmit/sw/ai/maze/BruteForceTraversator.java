package ie.gmit.sw.ai.maze;

import java.util.*;

public class BruteForceTraversator implements Traversator
{
	
	private boolean dfs = false;
	
	public BruteForceTraversator(boolean depthFirst)
	{
		this.dfs = depthFirst;
	}
	
	// node in this case is the starting position
	// Its the place in the array
	public void traverse(Node[][] maze, Node node) 
	{
		
		System.out.println("Node Stats: " + node.getRow() + " " + node.getCol() + " " + node.getElement());
		
        long time = System.currentTimeMillis();
    	int visitCount = 0;
    	
		Deque<Node> queue = new LinkedList<Node>();
		
		// Put starting position into the queue
		queue.offer(node);
		
		System.out.println("Queue Size: " + queue.size());
		
		// While queue is not empty
		while (!queue.isEmpty())
		{
			
			node = queue.poll();
			node.setVisited(true);
			
			System.out.println("Node Stats: " + node.getRow() + " " + node.getCol() + " " + node.getElement() + node.isVisited());
			visitCount++;
			
			//System.out.println("Node Path: " + node.getRow() + " " + node.getCol() + " " + node.getElement());
			
			if (node.isGoalNode()){
		        time = System.currentTimeMillis() - time; //Stop the clock
		        //TraversatorStats.printStats(node, time, visitCount);
				break;
			}
			
			try { //Simulate processing each expanded node				
				Thread.sleep(10);						
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Node[] children = node.children(maze);
			
			Node[] children = node.adjacentNodes(maze);
			
			//System.out.println("Children: " + children[0].getRow() + " " + children[0].getCol());
			
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
		}
	}
}