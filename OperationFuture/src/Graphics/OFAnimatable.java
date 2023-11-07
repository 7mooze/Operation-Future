package Graphics;

public class OFAnimatable implements OFObserver
{
	OFAnimationTimeline timeline;
	public String data;
	public int x,y; //Starting pos CANNOT change (const)
	
	public OFAnimatable() 
	{
		this.timeline = OFAnimationTimeline.getTimeline();
		timeline.registerObserver( this );
	}

	@Override
	public void update( OFEvent e ) 
	{
		if( e.origin == this ) 
		{
			data = e.payload;
		}
	}
}