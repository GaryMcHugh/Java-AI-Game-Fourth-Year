package ie.gmit.sw.ai.maze;

/*
 * 
 *  Nodes are used within each space in the maze. They store information
 *  about each space and are used for the search algorithms 
 * 
 */

public class Node 
{
	// element will represent the image in the 
	// form of a character
	private char element;
	
	// ==========  Getters / Setters  ==========
	
	// Get the character
	public char getElement() 
	{
		
		return element;
		
	}// End getElement

	// Set the character
	public void setElement(char element) 
	{
		
		this.element = element;
		
	}// End method setElement
	
}// End class Node
