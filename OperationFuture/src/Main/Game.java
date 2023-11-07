package Main;

import java.util.Scanner;

import UI.UI;
import Characters.HQ; //should not extend character

public class Game implements Runnable{

	private UI ui = new UI();
	private Pilot pilot = new Pilot(ui);
	private HQ hq = HQ.getInstance(ui); //singilton --> subject
	
	private Thread game;
	
	public Game() {
		
		game = new Thread (this);
		game.start();
	}

	
	public void animateText( String text ) throws InterruptedException 
	{
		for( int i=0; i<text.length(); i++ ) 
		{
			ui.print( text.charAt(i) );
			Thread.sleep(0); // 50 is good
		}
	}
	
	
	@Override
	public void run() {
		
		Scanner input = new Scanner(System.in);  //takes user input
		String name;
		String userInput;
		boolean isReady = false;
		
		String introString = "In the year 2050, the world grapples with food shortages, poverty, and the looming threat of global conflict over dwindling resources. A unified global organization, known as \"The Nexus,\" emerged, founded by an enigmatic figure. It brokered peace among nations and enforced equitable resource distribution. However, this newfound unity is put to the test when five colossal alien warships appear on the global stage.\n"
				+ "\n"
				+ "These alien vessels release massive robots that descend upon densely populated regions, causing widespread devastation and fracturing The Nexus. Mr. Victor Steele, a former UN general operating undercover, is chosen by the surviving committee members to combat these behemoth invaders. The committee establishes a secret HQ known only to a select few. Victor Steele plans to assemble the world's brightest minds and engineers for \"OPERATION FUTURE\" - a mission to secure humanity's survival.\n"
				+ "\n"
				+ "While the destruction of these giant robots continued for months, the General, in hiding, searches for the right lieutenant. Ultimately, you, the player, are chosen. You are led to a covert base where a formidable robot, \"Guardian,\" created by The Nexus's top minds, awaits. The General appoints you as the pilot of this mechanical giant, declaring,\n"
				+ "\n"
				+ "Victor: Pilot, with this Guardian, we'll finally stand up against the alien menace and reclaim our world!\n"
				+ "\n";
		
		try {
			animateText(introString);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ui.println("Welcome Pilot!");
		ui.print("Enter your name: "); name = input.nextLine(); pilot.setName(name);
		
		ui.println("\nVictor: Now, "+pilot.getName()+"! You will continue fighting against these mysterious robots, and free the humans from their invasion until we find any info about who is their puppetmaster. This HQ will help you with your missions assisting you with important information.\n");
		
		while (!isReady) {
			ui.print("Are you ready? "); userInput = input.nextLine();
			
			if(userInput.equalsIgnoreCase("yes")) {
				isReady = true;
			}else if(userInput.equalsIgnoreCase("no")){
				ui.println("\nVictor: YOU HAVE TO BE READY, "+pilot.getName().toUpperCase()+"!\n");
			}else {
				ui.println("\nInvalid Command\n");
			}
		}
		
		
	}
	
	
	

}
