package ie.gmit.sw.ai;

public class RealRunner {

	public static void main(String[] args) throws Exception {

		GameRunner gr = new GameRunner();

		while (gr.isGameOver != true) {

			gr.updateView();

		} // End while

	}// End main

}// End Class RealRunner
