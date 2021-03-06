package ie.gmit.sw.ai.traversers;

import ie.gmit.sw.ai.maze.*;
public class DepthLimitedDFSTraversator implements Traversator{
	private Node[][] maze;
	private int limit;
	private boolean keepRunning = true;
	private long time = System.currentTimeMillis();
	public DepthLimitedDFSTraversator(int limit){
		this.limit = limit;
	}
	
	public void traverse(Node[][] maze, Node node) {
		this.maze = maze;
		dfs(node, 1);
	}
	
	private void dfs(Node node, int depth){
		if (!keepRunning || depth > limit) return;
		
		node.setIsVisited(true);	
		if (node.isGoalNode()){
	        time = System.currentTimeMillis() - time; //Stop the clock
	        keepRunning = false;
			return;
		}
		
		try { //Simulate processing each expanded node
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Node[] children = node.adjacentNodes(maze);
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null && !children[i].getIsVisited()){
				children[i].setParent(node);
				dfs(children[i], depth + 1);
			}
		}
	}
}