package Map;

public interface State {
	public void prev(Map map);
	public void next(Map map);
	public void printStatus();
}
