package Graphics;

public class OFAnimatable implements OFObserver
{
	OFAnimationTimeline timeline;
	public String data;
	public int x,y; //Starting pos CANNOT change (const)
	
	public OFAnimatable( OFAnimationTimeline timeline ) 
	{
		this.timeline = timeline;
		timeline.registerObserver( this );
	}

	@Override
	public void update( OFEvent e ) {}
}