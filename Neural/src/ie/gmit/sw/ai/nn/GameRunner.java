package ie.gmit.sw.ai.nn;

import ie.gmit.sw.ai.nn.activator.Activator;

public class GameRunner {

    //1 Health (2 is Good Health, 1 is Okay Health, 0 is Needs Health)
    //2 Sword (1 is Yes, 0 is No)
    //3 Bomb (1 is Yes, 0 is No)
    //4 Hydrogen Bomb (1 is Yes, 0 is No)

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

	public void action(double health, double sword, double bomb, double hBomb) throws Exception {
		double[] params = {health, sword, bomb, hBomb};
		
		NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);

		Trainator trainer = new BackpropagationTrainer(nn);
		trainer.train(data, expected, 0.01, 10000);

		double[] result = nn.process(params);
		
		for (double val : result){
			System.out.println(val);
		}

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
		Decision combatNet = new Decision();

        combatNet.action(0.5, 1, 1, 0.5);
        combatNet.action(0, 1, 1, 0);
        combatNet.action(0, 1, 1, 0);
        combatNet.action(0, 1, 1, 0);
        
        combatNet.action(0.5, 0, 0, 0.5);
        combatNet.action(0.5, 0, 0, 0.5);
        combatNet.action(0.5, 0, 0, 0.5);
        combatNet.action(0.5, 0, 0, 0.5);
        combatNet.action(0, 0, 1, 1);
        
        combatNet.action(0, 0, 1, 1);
        combatNet.action(0, 0, 1, 1);
        combatNet.action(0, 0, 1, 1);
        
        combatNet.action(0, 1, 0, 0);
        combatNet.action(0, 1, 0, 0);
        combatNet.action(0, 1, 0, 0);
        combatNet.action(0, 1, 0, 0);
	}
}
