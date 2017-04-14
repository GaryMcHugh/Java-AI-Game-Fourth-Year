package ie.gmit.sw.ai;

public class TestRunner {

	public static void main(String[] args) throws Exception
	{
		
		GameRunner gr = new GameRunner();
		
		while(gr.isGameOver() != true)
		{
			gr.updateView();
		}
		
	}

}
