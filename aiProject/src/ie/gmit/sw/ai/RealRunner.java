package ie.gmit.sw.ai;

public class RealRunner {

	public static void main(String[] args) throws Exception {

		GamePlay gr = new GamePlay();

		while (gr.isGameOver != true) {

			gr.updateView();

		} // End while

	}// End main


}// End Class RealRunner
