package Main;

public class Rating {
	
	int ATK, DEF, SPD, ENE; //attack, defense, speed, and Energy
	

	public Rating(int ATK, int DEF, int SPD, int ENE) {
		this.ATK = ATK;
		this.DEF = DEF;
		this.SPD = SPD;
		this.ENE = ENE;
	}
	
	public void setRating(int ATK, int DEF, int SPD, int ENE) {
		this.ATK = ATK;
		this.DEF = DEF;
		this.SPD = SPD;
		this.ENE = ENE;
	}
	
	public int sum() {
		return ATK + DEF + SPD + ENE;
	}
	

}
