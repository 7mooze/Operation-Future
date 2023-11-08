package Main;

public class Rating {
	
	int ATK, DEF, SPD, ENE; //attack, defense, speed, and Energy
	

	public Rating(int ATK, int DEF, int SPD, int ENE) {
		this.ATK = ATK;
		this.DEF = DEF;
		this.SPD = SPD;
		this.ENE = ENE;
	}
	
	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public int getSPD() {
		return SPD;
	}

	public void setSPD(int sPD) {
		SPD = sPD;
	}

	public int getENE() {
		return ENE;
	}

	public void setENE(int eNE) {
		ENE = eNE;
	}

	public String printRating() {
		return "(ATK: "+ATK+", DEF: "+DEF+", SPD: "+SPD+", ENE: "+ENE+")";	
	}
	
	public int sum() {
		return ATK + DEF + SPD + ENE;
	}
	

}
