package UI;

import Graphics.OFAnimatable;

public class OFCenter extends OFAnimatable 
{
	int rowSize = 158;
	
	public OFCenter(String text) 
	{
		this.x = rowSize/2 - text.length()/2;
		this.data = text;
	}
}
