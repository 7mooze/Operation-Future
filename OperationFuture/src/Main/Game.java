package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import UI.UI;
import Characters.HQ; //should not extend character
import Grids.grid_boxes;
import Sahara_grid.SaharaGrid;
import Scenes.*;

public class Game implements Runnable{

	private UI ui = new UI();
	private Pilot pilot = new Pilot(ui);
	private HQ hq = HQ.getInstance(ui); //singilton --> subject
	private Guardian g = new Guardian();
	
	private Thread game;
	
	//private Map map1 = new Map();
	
	public Game() {
		
		game = new Thread (this);
	}
	
	public void startGame() {
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
	
	private String filter(String input) 
	{
	
		String Clean_text = input;
		
		Clean_text = Clean_text.trim();
		Clean_text = Clean_text.replaceAll("[ \t]+", " ");
		Clean_text = input.toLowerCase();
		 
		return Clean_text;
	}
	
	
	private ArrayList<String> parse(String input)
	{
		
		String[] parsedText = input.split(" ");
		ArrayList<String> Parsed_Text = new ArrayList<String>(Arrays.asList(parsedText));
		return Parsed_Text;
	}
	
	private void gridLoop(ArrayList<String> input) {
		
		int size = input.size();
		String firstWord = input.get(0);
		
		
		if(size < 1 || size > 4) {
			ui.println("\nyou can only enter 1 to 4 words. try again");
		}else if(size == 2 && firstWord.equals("move")) {
			pilot.move(input);
		}else if (size == 1 && firstWord.equals("show")) {
			pilot.show(input);
		}else if ((size == 2 || size == 3) && firstWord.equals("use")) {
			pilot.use(input);
		}else {
			
			ui.println("\nInvalid Command\n");
		}
				
	}
	
	@Override
	public void run() 
	{
		
		//Scanner input = new Scanner(System.in);  //takes user input
		String name = null;
		String userInput = null;
		String Clean_text = null;
		ArrayList<String> Parsed_text = null;
		
		boolean isReady = false; boolean isFinal = false;
		
		String introString = "In the year 2050, the world grapples with food shortages, poverty, and the looming threat of global conflict over dwindling resources. A unified global organization, known as \"The Nexus,\" emerged, founded by an enigmatic figure. It brokered peace among nations and enforced equitable resource distribution. However, this newfound unity is put to the test when five colossal alien warships appear on the global stage.\n"
				+ "\n"
				+ "These alien vessels release massive robots that descend upon densely populated regions, causing widespread devastation and fracturing The Nexus. Mr. Victor Steele, a former UN general operating undercover, is chosen by the surviving committee members to combat these behemoth invaders. The committee establishes a secret HQ known only to a select few. Victor Steele plans to assemble the world's brightest minds and engineers for \"OPERATION FUTURE\" - a mission to secure humanity's survival.\n"
				+ "\n"
				+ "While the destruction of these giant robots continued for months, the General, in hiding, searches for the right lieutenant. Ultimately, you, the player, are chosen. You are led to a covert base where a formidable robot, \"Guardian,\" created by The Nexus's top minds, awaits. The General appoints you as the pilot of this mechanical giant, declaring,\n"
				+ "\n"
				+ "Victor: Pilot, with this Guardian, we'll finally stand up against the alien menace and reclaim our world!\n"
				+ "\n";
		
		try 
		{
			animateText(introString);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		ui.println("Welcome Pilot!");
		ui.print("Enter your name: "); name = ui.nextLine(); pilot.setName(name);
		
		ui.println("\nVictor: Now, "+pilot.getName()+"! You will continue fighting against these mysterious robots, and free the humans from their invasion until we find any info about who is their puppetmaster. This HQ will help you with your missions assisting you with important information.\n");
		
		
		ui.println("\nHQ: Here are the locations of the warships. Upon arrival at your preferred location, we will give you information about the enemy robots through our efficient AI algorithms. Your goal is to destroy the robot controlling the other soldier robots in each region. Doing so will free the location from any more threats.\n\nTo win this war, you need to reach the hidden location which, based on our AI analysis, has assumed its presence on the map but cannot be confirmed unless we defeat all these warships. \n");
			
		pilot.printStatus();
		
		
		while (!isReady) 
		{
			ui.print("HQ: Are you ready " + pilot.getName() + "? "); userInput = ui.nextLine();
			
			if(userInput.equalsIgnoreCase("yes")) 
			{
				isReady = true;
			}
			else if(userInput.equalsIgnoreCase("no"))
			{
				ui.println("\nVictor: YOU HAVE TO BE READY, "+pilot.getName().toUpperCase()+"!\n");
			}
			else 
			{
				ui.println("\nInvalid Command\n");
			}
		}
				
		ui.println("");
		
		pilot.nextLocation();
		
		pilot.printStatus();
		pilot.setGrid(SaharaGrid.grid.get(grid_boxes.LEFT.getGridIndex())); //inital player location in the grid
			
		ui.println("\nHQ: "+pilot.getName()+", based on this info, you can now customize your Guardian options and we will deliver the options to you through air service. Your guardian’s maximum potential is determined by the Overall Rating value, choose your items wisely to reach a high Overall Rating in order to operate your guardian. The maximum Overall Rating you can reach is 1000.\n");
		
		g.buildRobot();
		
		while (!isFinal) 
		{
			ui.print("\nHQ: Have you finalized your decision? "); userInput = ui.nextLine();
			
			if(userInput.equalsIgnoreCase("yes")) 
			{
				isFinal = true;
			}
			else if(userInput.equalsIgnoreCase("no"))
			{
				g.reset(); g.buildRobot();
			}
			else 
			{
				ui.println("\nInvalid Command\n");
			}
		}
		
		ui.println("\nHQ: Guardian Accessories CONFIRMED. Delivering items now…\n");
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		ui.println(pilot.getName()+": Received items \n");
		
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		ui.println("\nHQ: OK "+pilot.getName()+", Here is our AI’s analysis of your Guardian’s surroundings. You are free to choose how to move around, you are on your own now. Good luck.\n");
		
		pilot.printGrid();
		
		
		ui.println("\nHere are the available commands");
		ui.println("1. Move Up\n"
				+ "2. Move Left\n"
				+ "3. Move Right\n"
				+ "4. Move Down\n"
				 +"5. Show\n");
		
		
		for (boolean loop_again = true; loop_again !=false; ) {
			
			userInput = ui.nextLine();
			Clean_text = filter(userInput);
			Parsed_text = parse (Clean_text);
				
			gridLoop (Parsed_text);
			
		}
		
		
//		int step = Integer.parseInt(Parsed_text.get(2));
		
		//ui.println("step size = " + step);
		
//		ui.println(" ");
//		pilot.nextLocation();
//		pilot.printStatus();
//		
//		ui.println(" ");
//		
//		pilot.nextLocation();
//		pilot.printStatus();
		
		
		
	}
}
