package ie.gmit.sw.ai.traversers;

import java.util.*;

import ie.gmit.sw.ai.maze.Node;

public class BruteForceTraversator implements Traversator
{
	
	private boolean dfs = false;
	
	public BruteForceTraversator(boolean depthFirst){
		this.dfs = depthFirst;
	}
	
	// node in this case is the starting position
	// Its the place in the array
	public void traverse(Node[][] maze, Node node) 
	{
		
        long time = System.currentTimeMillis();
    	Deque<Node> queue = new LinkedList<Node>();
		
		// Put starting position into the queue
		queue.offer(node);
		
		// While queue is not empty
		while (!queue.isEmpty())
		{
			
			// Get handle of old node here first
			Node oldNode = node;
			oldNode.setElement('\u0020');
			
			node = queue.poll(); // Use this node as the new node
		
			Node newNode = node;
			newNode.setElement('5');
			
			node.setIsVisited(true);
			if (node.isGoalNode()){
			
				if(dfs == true)
				{
					
					System.out.println("=====  Spartan Found goal node at " + node.getRow() + " " + node.getCol() + " =====");
				}
					
		        time = System.currentTimeMillis() - time; //Stop the clock
				break;
			}
			
			try { //Simulate processing each expanded node				
				Thread.sleep(10);						
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Node[] children = node.adjacentNodes(maze);
			
			for (int i = 0; i < children.length; i++)
			{
				
				// If child is not null and has not been visited
				if (children[i] != null && !children[i].getIsVisited())
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

}// End BruteForceTraversator
	
	
	
