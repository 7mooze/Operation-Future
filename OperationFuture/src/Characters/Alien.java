package Characters;

import Main.Rating;

public class Alien extends Character {
	
	Rating rating;
	String name;
		
	public Alien(String name,Rating rating) {
		this.rating = rating;
		this.name = name;
	}

	
	public String printAlien() {
		return name + " "+this.rating.printRating();
	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}

}
