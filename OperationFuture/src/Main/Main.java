package Main;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import Graphics.*;
import Input.*;
import UI.*;

public class Main 
{

	public static void animateText( String text ) throws InterruptedException 
	{
		for( int i=0; i<text.length(); i++ ) 
		{
			System.out.print( text.charAt(i) );
			Thread.sleep(100);
		}
	}
	
	public static String colorText( String text, int r, int g, int b ) 
	{
		return "\u001b[38;2;" + r + ";" + g + ";" + b + "m" + text + "\u001b[0m";
	}
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException, ParseException
	{
		OFSignal frameDone = new OFSignal();
		OFAnimationTimeline animator = OFAnimationTimeline.getTimeline( frameDone );
		
		OFScene intro = new OFScene();
		OFCenter intro_title = new OFCenter( "████████████████████ OPERATION FUTURE ████████████████████" );
		OFText intro_text = new OFText( "", 1, 3 );
		
		intro.addObjects( new OFAnimatable[] { intro_title, intro_text } );
		OFCommandLine game = new OFCommandLine( animator, frameDone, intro );
		
		String introString = "In the year 2050, the world grapples with food shortages, poverty, and the looming threat of global conflict over dwindling resources. A unified global organization, known as \"The Nexus,\" emerged, founded by an enigmatic figure. It brokered peace among nations and enforced equitable resource distribution. However, this newfound unity is put to the test when five colossal alien warships appear on the global stage.\n"
				+ "\n"
				+ "These alien vessels release massive robots that descend upon densely populated regions, causing widespread devastation and fracturing The Nexus. Mr. Victor Steele, a former UN general operating undercover, is chosen by the surviving committee members to combat these behemoth invaders. The committee establishes a secret HQ known only to a select few. Victor Steele plans to assemble the world's brightest minds and engineers for \"OPERATION FUTURE\" - a mission to secure humanity's survival.\n"
				+ "\n"
				+ "While the destruction of these giant robots continued for months, the General, in hiding, searches for the right lieutenant. Ultimately, you, the player, are chosen. You are led to a covert base where a formidable robot, \"Guardian,\" created by The Nexus's top minds, awaits. The General appoints you as the pilot of this mechanical giant, declaring,\n"
				+ "\n"
				+ "Victor: Pilot, with this Guardian, we'll finally stand up against the alien menace and reclaim our world!\n"
				+ "";
		
		/*for( int i=0; i<introString.length(); i++ )
		{
			OFEvent writeChar = new OFEvent( intro_text, "", intro_text.data + introString.charAt(i) );
			animator.sendEvent( writeChar );
			Thread.sleep( 50 );
		}*/
		
		
		Scanner sysin = new Scanner( System.in );
		String test = sysin.nextLine();
	}

}
