package Graphics;

public class OFEvent 
{
	Object origin;
	String topic;
	String payload;
	
	public OFEvent( Object origin, String topic, String payload )
	{
		this.origin = origin;
		this.topic = topic;
		this.payload = payload;
	}
}
