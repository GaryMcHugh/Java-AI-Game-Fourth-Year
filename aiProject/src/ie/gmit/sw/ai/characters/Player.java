package ie.gmit.sw.ai.characters;

import ie.gmit.sw.ai.neuralnetwork.Decision;

/*
 * 
 *  Class has information about the state of the player
 * 
 */

public class Player
{
	
	private String name;
	private int row, col;
	
	private Decision decision;
	
	// Player state for AI Decisions
	private double health = 1;
	private double weaponLevel = 0;
	private double bomb = 0;
	private double hydrogrenBomb = 0;
	
	public Player()
	{
		decision = new Decision();
	}
	
	public void playerDecision()
	{
		
		try 
		{
			decision.action(health, weaponLevel, bomb, hydrogrenBomb);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	// ===============  Getters / Setters ===============
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getRow()
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public int getCol() 
	{
		return col;
	}

	public void setCol(int col) 
	{
		this.col = col;
	}
	
	public double getHealth()
	{
		return health;
	}
	
	public void setHealth(double health) 
	{
		this.health = health;
	}

	public double getWeaponLevel()
	{
		return weaponLevel;
	}

	public void setWeaponLevel(double weaponLevel) 
	{
		this.weaponLevel = weaponLevel;
	}

	public double getBomb() {
		return bomb;
	}

	public void setBomb(double bomb) {
		this.bomb = bomb;
	}

	public double getHydrogrenBomb() {
		return hydrogrenBomb;
	}

	public void setHydrogrenBomb(double hydrogrenBomb) {
		this.hydrogrenBomb = hydrogrenBomb;
	}

}// End class Player
