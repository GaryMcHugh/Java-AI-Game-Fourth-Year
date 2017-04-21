package ie.gmit.sw.ai.traversers;

import ie.gmit.sw.ai.maze.Node;

public interface Traversator {
	public void traverse(Node[][] maze, Node start);
}
