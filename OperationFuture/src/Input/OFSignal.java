package Input;

public class OFSignal 
{
	private int currState = 0;
	
	public synchronized void await() 
	{
		while( currState == 0 ) 
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		currState = 0;
	}
	
	public synchronized void signal() 
	{
		currState = 1;
		notify();
	}
}
