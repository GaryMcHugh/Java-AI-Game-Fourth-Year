package ie.gmit.sw.ai.fl;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class HealthRunner {
	public static void main(String[] args) {
		FIS fis = FIS.load("health.fcl", true);
		FunctionBlock fb = fis.getFunctionBlock("Project");
		//JFuzzyChart.get().chart(fb);
		fis.setVariable("health", 10);
		fis.setVariable("weapon", 0.9);
		fis.evaluate();

		Variable tip = fb.getVariable("risk");
		//JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
		System.out.println(tip.defuzzify());
		
		if(tip.defuzzify() < 0.66){
			System.out.println("Risk is low");
		}
		else if(tip.defuzzify() > 0.33 && tip.defuzzify() < 1.6){
			System.out.println("Risk is medium");
		}
		else{
			System.out.println("Risk is high!");
		}
	}
}
