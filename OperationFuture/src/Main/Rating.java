package Main;

public abstract class Rating {
	
	int ATK, DEF, SPD, ENE; //attack, defense, speed, and Energy
	
	public int sum() {
		return ATK + DEF + SPD + ENE;
	}

}
