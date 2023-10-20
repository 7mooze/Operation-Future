package Main;

import java.util.Scanner;

public class Guardian {

	Rating rating;
	
	public Guardian() {
		
		rating = new Rating(0, 0, 0, 0); //rating is initially set to zero 
	}
	
	public void build() {
		
		int ATK, DEF, SPD, ENE; //attack, defense, speed, and Energy
		
		Scanner scan = new Scanner(System.in);
		
		int select; //user input
		
		System.out.println("Here are the list of available weapons\n"
				+ "1. Pistol (50 ATK)\n"
				+ "2. Dual Heated Swords (100 ATK)\n"
				+ "3. Assault Rifle (150 ATK)\n"
				+ "4. Laser Sniper Rifle (250 ATK)\n"
				+ "5. Rail gun (300 ATK)\n"
				+ "6. RPG (400 ATK)\n"
				+ "7. Nuclear Cannon (500 ATK)\n");
		
		System.out.print("Select Your Weapon by typing the number:");
		select = scan.nextInt();
		
		
		switch (select) {
		
		case 1: 
			ATK = 50;
			break;
		case 2:
			ATK = 100;
			break;
		case 3:
			ATK = 150;
			break;
		case 4:
			ATK = 250;
			break;
		case 5:
			ATK = 300;
			break;
		case 6:
			ATK = 400;
			break;
		case 7:
			ATK = 500;
			break;
		default:
			ATK = 0;
			break;
		}
		
		
		System.out.println("\nHere are the list of available armor\n"
				+ "1. Light Armor (100 DEF)\n"
				+ "2. Light Medium Armor (200 DEF)\n"
				+ "3. Medium Armor (300 DEF)\n"
				+ "4. Medium Heavy Armor (400 DEF)\n"
				+ "5. Ultimate Armor (500 DEF)\n");
		
		System.out.print("Select Your Armor by typing the number:");
		select = scan.nextInt();
		
	switch (select) {
		
		case 1: 
			DEF = 100;
			break;
		case 2:
			DEF = 200;
			break;
		case 3:
			DEF = 300;
			break;
		case 4:
			DEF = 400;
			break;
		case 5:
			DEF = 500;
			break;
		default:
			DEF = 0;
			break;
		}
			
		scan.close();
		rating.setRating(ATK, DEF, 0, 0);
		
	}
	
	public void getRating() {
		System.out.println("\nYour rating is: "+this.rating.sum());
	}
	

}
