package ie.gmit.sw.ai.neuralnetwork.activator;

import ie.gmit.sw.ai.neuralnetwork.activator.Activator.ActivationFunction;

public class ActivatorFactory {
	private static ActivatorFactory fact = new ActivatorFactory();
	
	private ActivatorFactory(){
	}
	
	public static ActivatorFactory getInstance(){
		return fact;
	}
	
	public Activator getActivator(Activator.ActivationFunction function){
		if (function == ActivationFunction.HyperbolicTangent){
			return new HyperbolicTangentActivator();			
		}else{
			return new SigmoidActivator();		
		}		
	}
}