package ie.gmit.sw.ai;

public class RealRunner {

<<<<<<< HEAD
	public static void main(String[] args) throws Exception {

		GameRunner gr = new GameRunner();

		while (gr.isGameOver != true) {

			gr.updateView();

		} // End while

	}// End main
=======
	public static void main(String[] args) throws Exception 
	{
		
		GamePlay gr = new GamePlay();
		
		while(gr.isGameOver() != true)
		{
			
			gr.updateView(); 
			
		}// End while

	}// End main 
>>>>>>> 51ec4fdf1515ec2a28f0c093bb93ea0698d03f5f

}// End Class RealRunner
