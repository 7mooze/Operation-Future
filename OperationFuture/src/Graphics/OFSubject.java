package Graphics;

public interface OFSubject 
{
	public void registerObserver( OFObserver o );
	public void removeObsever( OFObserver o );
	public void sendEvent( OFEvent e );
}
