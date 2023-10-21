package Main;

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
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		animateText("Traveling to Sahara Desert...\r");
		//animateText("Traveling to Sahara Desert...\r");
		//Guardian g1 = new Guardian();
		
		//g1.build();
		
		//g1.getRating();

	}

}
