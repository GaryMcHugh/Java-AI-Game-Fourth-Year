package ie.gmit.sw.ai.traverse;

import ie.gmit.sw.ai.Node;
import ie.gmit.sw.ai.maze.*;
import java.util.*;

public class BruteForceTraversator implements Traversator
{
	
	private boolean dfs = false;
	
	public BruteForceTraversator(boolean depthFirst){
		this.dfs = depthFirst;
		//SoundEffects.init();
	}
	
	public void traverse(char[][] maze, Node node) {
        long time = System.currentTimeMillis();
    	int visitCount = 0;
    	
		Deque<Node> queue = new LinkedList<Node>();
		queue.offer(node);
		
		while (!queue.isEmpty()){
			node = queue.poll();
			node.setVisited(true);
			visitCount++;
			
			if (node.isGoalNode()){
		        time = System.currentTimeMillis() - time; //Stop the clock
		        //traversatorStats.printStats(node, time, visitCount);
				break;
			}
			
			try { //Simulate processing each expanded node				
				Thread.sleep(10);						
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			/*Node[] children = node.children(maze);
			for (int i = 0; i < children.length; i++) {
				if (children[i] != null && !children[i].isVisited()){
					children[i].setParent(node);
					if (dfs){
						queue.addFirst(children[i]);
					}else{
						queue.addLast(children[i]);
					}
				}									
			}		*/	
		}
	}
}