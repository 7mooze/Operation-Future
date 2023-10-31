package Graphics;

import java.util.ArrayList;

public class OFScene 
{
	public ArrayList<OFAnimatable> sObjects;

	public OFScene() 
	{
		sObjects = new ArrayList <OFAnimatable>();
	}
	
	public void addObject( OFAnimatable obj ) 
	{
		sObjects.add(obj);
	}
}
