package Graphics;

import Input.OFSignal;

public class OFCommandLine implements Runnable
{
	OFAnimationTimeline timeline;
	OFSignal frameDone;
	OFScene currScene;
	Thread commandLine;
	
	public OFCommandLine( OFAnimationTimeline timeline, OFSignal signal, OFScene startingScene ) 
	{
		this.timeline = timeline;
		this.frameDone = signal;
		this.currScene = startingScene;
		commandLine = new Thread(this);
		commandLine.start();
	}
	
	public static void clearScreen() 
	{
		System.out.print("\033[?25l\033[H\033[0K"); //Sets cursor pos to 0,0 and clears
	}
	
	public synchronized void setScene( OFScene scene ) 
	{
		currScene = scene;
	}
	
	public synchronized OFScene getScene() 
	{
		return currScene;
	}
	
	private static void printAt( OFAnimatable obj )
	{
		System.out.print("\033[" + obj.y + ";" + obj.x + "H" + obj.data);
	}

	public void render()
	{
		for( OFAnimatable anim : getScene().sObjects ) 
		{
			printAt( anim );
		}
	}
	
	public Thread getThread() 
	{
		return commandLine;
	}

	@Override
	public void run() 
	{
		while(true) 
		{
			try 
			{
				render();
				frameDone.signal();
				Thread.sleep(42);
				clearScreen();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
