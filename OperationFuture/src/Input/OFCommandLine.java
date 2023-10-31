package Input;

import Graphics.*;

public class OFCommandLine implements Runnable
{
	OFAnimationTimeline timeline;
	OFSignal frameDone;
	OFScene currScene;
	
	public OFCommandLine( OFAnimationTimeline timeline, OFSignal signal, OFScene startingScene ) 
	{
		this.timeline = timeline;
		this.frameDone = signal;
		this.currScene = startingScene;
		Thread commandLine = new Thread(this);
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
	
	private static void printAt( String data, int x, int y )
	{
		System.out.print("\033[38;2;0;255;0m\033["+y+";"+x+"H"+data+"\033[0m"); //TODO: implement Colors here. maybe add as attribute for OFAnimatable?
	}

	public void render()
	{
		for( OFAnimatable anim : getScene().sObjects ) 
		{
			printAt( anim.data, anim.x, anim.y );
		}
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
				Thread.sleep(42); // we assume all updates are done within the 42 ms otherwise we need another OFSignal to signal when updates are done to all data within scene
				clearScreen();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
