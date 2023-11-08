package Scenes;

import java.util.ArrayList;

import Characters.Alien;
import Characters.BossAlien;
import Characters.SoldierAlien;
import Main.Rating;

public class SaharaDesert extends Location {
	
	
	public SaharaDesert() {
		name = "Sahara Desert";
		description = "something\n";
		
		aliens = new ArrayList<Alien>();
		
		Rating SoldierRating = new Rating(250, 250, 250, 250);
		Rating BossRating = new Rating(500, 200, 0, 300);

		
		SoldierAlien a1 = new  SoldierAlien("Soldier Alien 1", SoldierRating);
		SoldierAlien a2 = new  SoldierAlien("Soldier Alien 2", SoldierRating);
		BossAlien b1 = new 	BossAlien("Boss Alien", BossRating);
		
		
		aliens.add(a1);
		aliens.add(a2);
		aliens.add(b1);
		
	}	
}
