package ie.gmit.sw.ai.runner;

import ie.gmit.sw.ai.GamePlay;

public class Runner {

	public static void main(String[] args) throws Exception 
	{
		
		GamePlay gr = new GamePlay();
		
		while(gr.isGameOver() != true)
		{
			
			gr.updateView(); 
			
		}// End while

	}

}
