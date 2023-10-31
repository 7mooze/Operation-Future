package Graphics;

import java.util.ArrayList;

import Input.OFSignal;

public class OFAnimationTimeline implements OFSubject, Runnable
{
	ArrayList<OFObserver> dObjects;
	ArrayList<OFEvent> eventQueue;
	OFSignal signal;
	Thread animationTimeline;
	
	public OFAnimationTimeline( OFSignal signal ) 
	{
		dObjects = new ArrayList <OFObserver>();
		eventQueue = new ArrayList <OFEvent>();
		this.signal = signal;
		animationTimeline = new Thread(this);
		animationTimeline.start();
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
			signal.await();
			submitEvents();
		}
	}
	
}
