package Input;

import java.io.IOException;

import Graphics.OFAnimatable;

public class OFInputManager extends OFAnimatable
{
	public void read() throws IOException 
	{
		int text;
		while( (text = System.in.read()) != -1 ) 
		{
			data += (char) text;
		}
	}
}
