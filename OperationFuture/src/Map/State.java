package Map;

import Main.Pilot;

public interface State {
	//public void prev(Map map);
	public void next(Pilot currentLocation);
	public void printStatus();
	public void printGrid();
}
