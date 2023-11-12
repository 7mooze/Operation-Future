package Main;

import java.util.Scanner;
import UI.UI;

public class Guardian {

	private Rating rating;
	private UI ui;
	
	int select; //user input
	private boolean ratingNotExceeded = true; //rating should not exceed 1000

	public Guardian() {
		
		rating = new Rating(0, 0, 0, 0); //rating is initially set to zero 
		ui = new UI();

	}
	
	public void reset() 
	{
		rating.setRating(0, 0, 0, 0);
	}
	
	public void buildRobot() {		
			addWeapons();
			addArmor();		
			addThrusters();
			addEnergy();
			getRating();
	}
	
	private void addWeapons() {
		
		ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");
		
		ui.println("Here are the list of available WEAPONS (Shows how much damage you deal to the enemy):\n"
				+ "1. Pistol (50 ATK)\n"
				+ "2. Dual Heated Swords (100 ATK)\n"
				+ "3. Assault Rifle (150 ATK)\n"
				+ "4. Laser Sniper Rifle (250 ATK)\n"
				+ "5. Rail gun (300 ATK)\n"
				+ "6. RPG (400 ATK)\n"
				+ "7. Nuclear Cannon (500 ATK)\n");
		
		ui.print("Select Your WEAPON by typing the number: ");
		select = ui.nextInt();
		
		
		switch (select) {
		
		case 1: 
			rating.setATK(50);
			break;
		case 2:
			rating.setATK(100);
			break;
		case 3:
			rating.setATK(150);
			break;
		case 4:
			rating.setATK(250);
			break;
		case 5:
			rating.setATK(300);
			break;
		case 6:
			rating.setATK(400);
			break;
		case 7:
			rating.setATK(500);
			break;
		default:
			rating.setATK(0);
			break;
		}
				
	}
	
	private void addArmor() {
		
		ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");
		
		ui.println("\nHere are the list of available ARMOR (Reduces ATK damage from enemy by DEF amount)\n"
				+ "1. Light Armor (100 DEF)\n"
				+ "2. Light Medium Armor (250 DEF)\n"
				+ "3. Medium Armor (300 DEF)\n"
				+ "4. Medium Heavy Armor (400 DEF)\n"
				+ "5. Ultimate Armor (500 DEF)\n");
		
		ui.print("Select Your ARMOR by typing the number: ");
		select = ui.nextInt();
		
	switch (select) {
		
		case 1: 
			rating.setDEF(100);
			break;
		case 2:
			rating.setDEF(250);
			break;
		case 3:
			rating.setDEF(300);
			break;
		case 4:
			rating.setDEF(400);
			break;
		case 5:
			rating.setDEF(500);
			break;
		default:
			rating.setDEF(0);
			break;
		}
	
	if(rating.sum()>1000) {
		ratingNotExceeded = false;
	}
			
	}

	private void addThrusters() {
		
		ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");
		
		ui.println("\nHere are the list of available THRUSTERS (determines if you get to attack the enemy first or not):\n"
				+ "1. Wheel Thruster (100 SPD)\n"
				+ "2. Hover Thruster (250 SPD)\n"
				+ "3. Sky Thruster (300 SPD)\n"
				+ "4. Sound Breaker Thruster (400 SPD)\n"
				+ "5. Light Exceed Thruster (500 SPD)\n");
		
		ui.print("Select Your THRUSTER by typing the number: ");
		select = ui.nextInt();
		
		switch (select) {
			
			case 1: 
				rating.setSPD(100);
				break;
			case 2:
				rating.setSPD(250);
				break;
			case 3:
				rating.setSPD(300);
				break;
			case 4:
				rating.setSPD(400);
				break;
			case 5:
				rating.setSPD(500);
				break;
			default:
				rating.setSPD(0);
				break;
			}
		
		if(rating.sum()>1000) {
			ratingNotExceeded = false;
		}
		
	}
	
	private void addEnergy() {
		
		ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");

		
		ui.println("\nHere are the list of available ENERGY CELLS (shows how long you last in battle, 100 ENE=1 min):\n"
				+ "1. Single Cell (100 ENE)\n"
				+ "2. Dual Cell (250 ENE)\n"
				+ "3. Triple Cell (300 ENE)\n"
				+ "4. Quadra Cell (400 ENE)\n"
				+ "5. Lifeforce Cell (500 ENE)\n");
		
		ui.print("Select Your THRUSTER by typing the number: ");
		select = ui.nextInt();
		
		switch (select) {
			
			case 1: 
				rating.setENE(100);
				break;
			case 2:
				rating.setENE(250);
				break;
			case 3:
				rating.setENE(300);
				break;
			case 4:
				rating.setENE(400);
				break;
			case 5:
				rating.setENE(500);
				break;
			default:
				rating.setENE(0);
				break;
			}
		
		if(rating.sum()>1000) {
			ratingNotExceeded = false;
		}
	}
	
	public void getRating() {
		ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");
	}
	
}
