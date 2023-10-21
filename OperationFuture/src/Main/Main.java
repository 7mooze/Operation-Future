package Main;

import java.io.IOException;
import java.net.UnknownHostException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Input.OFSensor;

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
		
		System.out.println("          . _..::__:  ,-\"-\"._       |]       ,     _,.__              \n"
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
		
		
		
		animateText("Traveling to Sahara Desert...\r");
		//animateText("Traveling to Sahara Desert...\r");
		//Guardian g1 = new Guardian();
		
		//g1.build();
		
		//g1.getRating();
		

		
		OFSensor sensor = OFSensor.startClient("192.168.0.116", 63136);

		while(true) {
			
			double Swing= sensor.readDouble("gyroRotationX");
			if(Swing >= 10.0 | Swing <= -10.0 
					) System.out.println("Swinging motion detected!\nThe ball has been thrown\n");

			
		}
		
	}

}
