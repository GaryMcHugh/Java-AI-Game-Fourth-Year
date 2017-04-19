package ie.gmit.sw.ai.nn;

import ie.gmit.sw.ai.nn.activator.Activator;

public class GameRunner {
	private double[][] data = { // Health, Sword, Gun, Enemies
			{ 2, 0, 0, 0 }, { 2, 0, 0, 1 }, { 2, 0, 1, 1 }, { 2, 0, 1, 2 }, { 2, 1, 0, 2 }, { 2, 1, 0, 1 },
			{ 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 }, { 1, 0, 1, 2 }, { 1, 1, 0, 2 }, { 1, 1, 0, 1 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 2 }, { 0, 1, 0, 2 }, { 0, 1, 0, 1 } };

	private double[][] expected = { // Panic, Attack, Hide, Run
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 1.0 }, { 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 },
			{ 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 1.0, 0.0, 0.0 },
			{ 0.0, 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 } };

	public void panic() {
		System.out.println("Panic!!");
	}

	public void attack() {
		System.out.println("attack!!");
	}

	public void hide() {
		System.out.println("hide!");
	}

	public void runAway() {
		System.out.println("run away!!");
	}

	public void action(double health, double sword, double gun, double enemies) throws Exception {
		double[] params = {health, sword, gun, enemies};
		
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);

		Trainator trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.01, 10000);

		double[] result = nn.process(params);
		
		for (double val : result){
			System.out.println(val);
		}
		System.out.println("==> " + (Utils.getMaxIndex(result) + 1));

		//we want the output with the highest value
		int choice = (Utils.getMaxIndex(result) + 1);

		switch (choice) {
		case 1:
			panic();
			break;
		case 2:
			attack();
			break;
		case 3:
			hide();
			break;
		default:
			runAway();
		}
	}

	public static void main(String[] args) throws Exception {
		double health = Double.parseDouble(args[0]);
		double sword = Double.parseDouble(args[1]);
		double gun = Double.parseDouble(args[2]);
		double enemies = Double.parseDouble(args[3]);
		
		//run, run configurations, arguements tab, fill in arguements, apply and run
		new GameRunner().action(health, sword, gun, enemies);
	}
}
