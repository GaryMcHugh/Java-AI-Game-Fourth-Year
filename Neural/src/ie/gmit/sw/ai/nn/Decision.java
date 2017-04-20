package ie.gmit.sw.ai.nn;

import ie.gmit.sw.ai.nn.activator.Activator;

public class Decision {
private NeuralNetwork nn;
	
	public Decision() {
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);

		Trainator trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.01, 10000);
	}
	
	/*
	    1 Health (2 is Good Health, 1 is Okay Health, 0 is Needs Health)
	    2 Sword (1 is Yes, 0 is No)
	    3 Bomb (1 is Yes, 0 is No)
	    4 Hydrogen Bomb (1 is Yes, 0 is No)
	*/

	private double[][] data = { // Health, Sword, Gun, Enemies
	            // No Sword, No Bomb
	            { 2, 0, 0, 0 }, { 2, 0, 0, 1 }, // good health with hBomb
	            { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, // okay health with hBomb
	            { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, // needs health with hBomb
	
	            // Sword, No Bomb
	            { 2, 0, 0, 0 }, { 2, 1, 0, 0 }, // good health with sword
	            { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, // okay health with sword
	            { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, // needs health with sword
	
	            // No Sword, Bomb
	            { 2, 0, 0, 0 }, { 2, 0, 1, 0 }, // good health with bomb
	            { 1, 0, 0, 0 }, { 1, 0, 1, 0 }, // okay health with bomb
	            { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, // needs health with bomb
	
	            // Sword, Bomb
	            { 2, 0, 0, 0 }, { 2, 1, 1, 0 }, // full health, enemies covered
	            { 1, 0, 0, 0 }, { 1, 1, 1, 0 }, // minior injuries, enemies covered
	            { 0, 0, 0, 0 }, { 0, 1, 1, 0 }, // serious injuries, enemies covered 
            };

	private double[][] expected = { // Panic, Attack, Hide, Run
	            // No Sword, No Bomb
	            { 1, 0, 0, 0}, { 1, 0, 0, 0 }, { 0, 0, 1, 0 }, // full health, enemies covered
	            { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, // minior injuries, enemies covered
	            { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, // serious injuries, enemies covered
	
	            // Sword, No Bomb
	            { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, // full health, enemies covered
	            { 1, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, // minior injuries, enemies covered
	            { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, // serious injuries, enemies covered
	
	            // No Sword, Bomb
	            { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, // full health, enemies covered
	            { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, // minior injuries, enemies covered
	            { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, // serious injuries, enemies covered
	
	            // Sword, Bomb
	            { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, // full health, enemies covered
	            { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, // minior injuries, enemies covered
	            { 1, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 } // serious injuries, enemies covered 
            };

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

	public void action(double health, double sword, double bomb, double hBomb) throws Exception {
		double[] params = {health, sword, bomb, hBomb};
		
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);

		Trainator trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.01, 10000);

		double[] result = nn.process(params);
		
		for (double val : result){
			System.out.println(val);
		}
		
		//System.out.println("==> " + (Utils.getMaxIndex(result) + 1));

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
		double bomb = Double.parseDouble(args[2]);
		double hBomb = Double.parseDouble(args[3]);
		
		//run, run configurations, arguements tab, fill in arguements, apply and run
		new GameRunner().action(health, sword, bomb, hBomb);
	}
}
