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
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException, ParseException 
	{
		
		animateText("Traveling to Sahara Desert...\r");
		//animateText("Traveling to Sahara Desert...\r");
		//Guardian g1 = new Guardian();
		
		//g1.build();
		
		//g1.getRating();
		

		
		OFSensor sensor = OFSensor.startClient("192.168.0.119", 57829);

		while(true) {
			
			double Swing= sensor.readDouble("gyroRotationX");
			if(Swing >= 10.0 | Swing <= -10.0 
					) System.out.println("Swinging motion detected!\nThe ball has been thrown\n");

			
		}
		
	}

}
