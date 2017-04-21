package ie.gmit.sw.ai.maze;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
 * 
 *  This class is for the sprites in the game. It holds information about the sprites 
 *  and will allow them to animate
 * 
 */
public class Sprite 
{
	//The name of this sprite
	private String name; 
	
	//The set of image frames to animate
	private BufferedImage[] frames; 
	
	//Initial starting index in array
 	private int index = 0; 
 	
	public Sprite(String name, String... images) throws Exception
	{
		
		this.name = name;
		
		//Initialize the starting index to zero
		this.index = 0; 
		
		//Initialize the image frames
		this.frames = new BufferedImage[images.length]; 
		
		for (int i = 0; i < images.length; i++)
		{
			 //Read in each image as a BufferedImage
			frames[i] = ImageIO.read(new java.io.File(images[i]));
		}
		
	}// End constructor Sprite
	
	//Returns the next image frame
	public BufferedImage getNext()
	{
		
		int idx = index;
		
		if (index < frames.length - 1)
		{
			index++;
		}
		else
		{
			//Circle back to the start of the array
			index = 0; 
		}
		
		return frames[idx]; 
		
	}// End method BufferedImage
	
	public String getName()
	{
		return this.name;
	}// End method getName

}// End class Sprite
