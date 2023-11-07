package Main;

import java.util.Scanner;

import UI.UI;
import Characters.HQ; //should not extend character
import Map.Map;
import Scenes.*;

public class Game implements Runnable{

	private UI ui = new UI();
	private Pilot pilot = new Pilot(ui);
	private HQ hq = HQ.getInstance(ui); //singilton --> subject
	
	private Thread game;
	
	private Map map = new Map();
	
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
	
	public static String colorText( String text, int r, int g, int b ) 
	{
		return "\u001b[38;2;" + r + ";" + g + ";" + b + "m" + text + "\u001b[0m";
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
		
		ui.println("\nHQ: Here are the locations of the warships. Upon arrival at your preferred location, we will give you information about the enemy robots through our efficient AI algorithms. Your goal is to destroy the robot controlling the other soldier robots in each region. Doing so will free the location from any more threats.\n\nTo win this war, you need to reach the hidden location which, based on our AI analysis, has assumed its presence on the map but cannot be confirmed unless we defeat all these warships. \n");
		
		ui.println("          . _..::__:  ,-\"-\"._       |]       ,     _,.__              \n"
				+ "  _.___ _ _<_>`!(._`.`-.    /        _._     `_ ,_/  '  '-._.---.-.__ \n"
				+ ".{     \" \" `-==,',._\\{  \\  / {)     / _ \">_,-' `                 /-/_ \n"
				+ " \\_.:--.       `._ )`^-. \"'      , [_/(                       __,/-'  \n"
				+ "'\"'     \\         \"    _L       |-_,--'          "+colorText("\u25C9 Prominent City", 255,0,0)+" /. (|    \n"
				+ "         |        "+colorText("\u25C9 Night city", 255, 0,0)+"    _)_.\\\\._<> {}              _,' /  '   \n"
				+ "         `.         /          [_/_'` `\"(                <'}  )       \n"
				+ "          \\\\    .-. )          /   `-'\"..'  "+colorText("\u25C9 HQ", 51,204,51)+"            _)  '        \n"
				+ "            \\  (  `(          /         `:\\  > \\  ,-^.  /' '          \n"
				+ "             `._,   \"\"        | "+colorText("Sahara Desert", 255, 0, 0)+"   \\`'   \\|   ?_)  {\\          \n"
				+ "                `=.---.       `._._       ,'     \"`  |' ,- '.         \n"
				+ "                  |    `-._        |     /          `:`<_|=--._       \n"
				+ "   "+ colorText("Pacific Ocean", 255, 0, 0) +"  (        >       .     | ,          `=.__.`-'\\      \n"
				+ "                   `.     /        |     |{|              ,-.,\\     . \n"
				+ "                    |   ,'          \\   / `'            ,\"     \\      \n"
				+ "                    |  /             |_'                |  __  /      \n"
				+ "                    | |                                 '-'  `-'   \\. "+colorText("\u25C9 Hidden Location", 110, 0,4)+" \n"
				+ "                    |/                                        \"    /  \n"
				+ "                    \\.                                            '   \n"
				+ "                                                                      \n"
				+ "                     ,/           ______._.--._ _..---.---------.     \n"
				+ "__,-----\"-..?----_/ )\\    . ,-'\"             \"                  (__--/\n"
				+ "                      /__/\\/              Antarctica                            \n"
				+ "-----------------------------------------------------------------------------------------");
		
		ui.println("Now "+pilot.getName()+", please choose your location of deployment by typing its name: \n");
		ui.println("1. Sahara Desert - 10 km away\n" // let 1 km equal 1 second\
				+ "2. Prominent City - 20 km away\n"
				+ "3. Night City - 40 km away\n"
				+ "4. Pacific Ocean - 50 km away\n");
		
		
		userInput = input.nextLine();
		
		if(userInput.equalsIgnoreCase("Sahara Desert")) {
			map.setState(new SaharaDesert());
		}
		
		map.printStatus();
		
		
	}
	
	
	

}
