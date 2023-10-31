package Graphics;

public class testHPBar extends OFAnimatable 
{
	public testHPBar(OFAnimationTimeline timeline) 
	{
		super(timeline);
		data = "█████████████████████████████████";
		x = 3;
		y = 0;
	}

	@Override
	public synchronized void update( OFEvent e ) 
	{
		if( e.origin == this ) 
		{
			data = e.payload;
		}
	}
}
