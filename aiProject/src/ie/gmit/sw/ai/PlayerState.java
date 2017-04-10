package ie.gmit.sw.ai;

public class PlayerState 
{
	
	// Variables for player
	private double health;
	private double weaponLevel;
	private double bombs;
	private double hydrogenBombs;
	
	public PlayerState(double health, double weaponLevel, double bombs, double hydrogenBombs)
	{
		
		this.health = health;
		this.weaponLevel = weaponLevel;
		this.bombs = bombs;
		this.hydrogenBombs = hydrogenBombs;
		
	}// End constructor PlayerState

	// Getters and Setters
	
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getWeaponLevel() {
		return weaponLevel;
	}

	public void setWeaponLevel(double weaponLevel) {
		this.weaponLevel = weaponLevel;
	}

	public double getBombs() {
		return bombs;
	}

	public void setBombs(double bombs) {
		this.bombs = bombs;
	}

	public double getHydrogenBombs() {
		return hydrogenBombs;
	}

	public void setHydrogenBombs(double hydrogenBombs) {
		this.hydrogenBombs = hydrogenBombs;
	}

}// End PlayerState
