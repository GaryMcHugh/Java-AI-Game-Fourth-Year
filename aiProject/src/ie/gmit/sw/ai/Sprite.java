package ie.gmit.sw.ai;

import javax.imageio.*;
import java.awt.image.*;

public class Sprite 
{
	//The name of this sprite
	private String name; 
	
	//The set of image frames to animate
	private BufferedImage[] frames; 
	
	//Initial starting index in array
 	private int index = 0; 
 	
// 	private double lifeForce = 500;
 	
	public Sprite(String name, String... images) throws Exception
	{
		this.name = name;
		
		//Initialize the starting index to zero
		this.index = 0; 
		
		//Initialize the image frames
		this.frames = new BufferedImage[images.length]; 
		
		//Read in each image as a BufferedImage
		for (int i = 0; i < images.length; i++)
		{
			frames[i] = ImageIO.read(new java.io.File(images[i])); 
		}
	}
	
//	public double engage(double weapon, double anger){
//		NeuralNetwork nn = NeuralNetworkFactory.getInstance().getNetwork("engage");
//		double [] inputs= {weapon, anger};
//		double result = nn.process(inputs);
//		lifeForce += result;
//		
//		FIS fis = FuzzyLogicFactory.getInstance().getFIS("engage");
//		double result = fis.evaluate(weapon, anger);
//		lifeForce += result;
//	}
//	
//	public boolean isAlive(){
//		return lifeForce > 0;
//	}
	
	// Used in GameView's paintComponent method
	// Returns the next image frame
	public BufferedImage getNext()
	{ 
		//move them here
		int idx = index;
		if (index < frames.length - 1){
			index++;
		}else{
			index = 0; //Circle back to the start of the array
		}
		return frames[idx]; 
	}
	
	public String getName()
	{
		return this.name;
	}
}// End class Sprite
