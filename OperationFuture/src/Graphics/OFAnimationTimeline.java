package Graphics;

import java.util.ArrayList;
import Input.OFSignal;

public class OFAnimationTimeline implements OFSubject, Runnable
{
	private static OFAnimationTimeline _instance;
	private static ArrayList<OFObserver> dObjects;
	private static ArrayList<OFEvent> eventQueue;
	private OFSignal frameDone;
	private Thread animationTimeline;
	
	private OFAnimationTimeline( OFSignal frameDone ) 
	{
		dObjects = new ArrayList <OFObserver>();
		eventQueue = new ArrayList <OFEvent>();
		this.frameDone = frameDone;
		animationTimeline = new Thread(this);
		animationTimeline.start();
	}
	
	public static synchronized OFAnimationTimeline getTimeline( OFSignal frameDone )
	{
		if( _instance == null ) 
		{
			_instance = new OFAnimationTimeline( frameDone );
		}
	
		return _instance;
	}
	
	public static synchronized OFAnimationTimeline getTimeline() 
	{
		return _instance;
	}
	
	@Override
	public synchronized void registerObserver( OFObserver o ) 
	{
		dObjects.add(o);
	}

	@Override
	public synchronized void removeObsever( OFObserver o ) 
	{
		dObjects.remove(o);
	}

	@Override
	public synchronized void sendEvent( OFEvent e ) 
	{
		eventQueue.add(e);
	}
	
	public synchronized void submitEvents() 
	{
		for( int i=0; i<eventQueue.size(); i++ ) 
		{
			for(int k=0; k<dObjects.size(); k++) 
			{
				dObjects.get(k).update( eventQueue.get(i) );
			}
			
			eventQueue.remove(i);
		}
	}

	@Override
	public void run() 
	{
		while(true) 
		{
			frameDone.await();
			submitEvents();
		}
	}
	
}
