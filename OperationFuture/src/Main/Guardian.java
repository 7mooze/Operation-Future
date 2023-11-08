package Main;

import java.util.Scanner;
import UI.UI;

public class Guardian {

	private Rating rating;
	private UI ui;
	
	public Guardian() {
		
		rating = new Rating(0, 0, 0, 0); //rating is initially set to zero 
		ui = new UI();

	}
	
	
	public void build() {		
		Scanner scan = new Scanner(System.in);
		
		int select; //user input
		
		
		ui.println("Current Overall Rating: "+rating.sum()+ "/1000");
		
		
		ui.println("Choose your WEAPON by typing the number (Shows how much damage you deal to the enemy):\n"
				+ "1. Pistol (50 ATK)\n"
				+ "2. Dual Heated Swords (100 ATK)\n"
				+ "3. Assault Rifle (150 ATK)\n"
				+ "4. Laser Sniper Rifle (250 ATK)\n"
				+ "5. Rail gun (300 ATK)\n"
				+ "6. RPG (400 ATK)\n"
				+ "7. Nuclear Cannon (500 ATK)\n");
		
		ui.print("Select Your Weapon by typing the number: ");
		select = scan.nextInt();
		
		
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
		
		ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");
		
		ui.println("\nHere are the list of available armor\n"
				+ "1. Light Armor (100 DEF)\n"
				+ "2. Light Medium Armor (200 DEF)\n"
				+ "3. Medium Armor (300 DEF)\n"
				+ "4. Medium Heavy Armor (400 DEF)\n"
				+ "5. Ultimate Armor (500 DEF)\n");
		
		ui.print("Select Your Armor by typing the number: ");
		select = scan.nextInt();
		
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
	
	ui.println("\nCurrent Overall Rating: "+rating.sum()+ "/1000");
	
	ui.println("\nHere are the list of available armor\n"
			+ "1. Light Armor (100 DEF)\n"
			+ "2. Light Medium Armor (200 DEF)\n"
			+ "3. Medium Armor (300 DEF)\n"
			+ "4. Medium Heavy Armor (400 DEF)\n"
			+ "5. Ultimate Armor (500 DEF)\n");
	
	ui.print("Select Your Armor by typing the number: ");
	select = scan.nextInt();
	
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


			
		scan.close();
	}
	
	public void getRating() {
		ui.println("\nYour rating is: "+this.rating.sum());
	}
	
}
