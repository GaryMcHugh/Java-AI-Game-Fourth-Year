package ie.gmit.sw.ai.fl;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyLogic 
{
	
	private FIS fis;
	private FunctionBlock fb;
	private Variable risk;
	
	public FuzzyLogic()
	{
		
		System.out.println("Fuzzy");
		
		// Load function block
		fis = FIS.load("health.fcl", true);
		fb = fis.getFunctionBlock("Project");
		
		//JFuzzyChart.get().chart(fb);

		//JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
		//System.out.println(risk.defuzzify());
		
		/*if(risk.defuzzify() < 0.66)
		{
			System.out.println("Risk is low");
			// move goal
		}
		else if(risk.defuzzify() > 0.33 && risk.defuzzify() < 1.6){
			System.out.println("Risk is medium");
			//move
		}
		else{
			System.out.println("Risk is high!");
			//set goal
		}*/
		
	}
	
	public void setHealth(double health)
	{
		fis.setVariable("health", health);
	}
	
	public void setWeapon(double weapon)
	{
		fis.setVariable("weapon", weapon);
	}

	public void evaluateFuzzyLogic()
	{
		fis.evaluate();	
	}
	
	public Variable getRisk()
	{
		risk = fb.getVariable("risk");
		
		return risk;
		
	}
	
}// End FuzzyLogic
