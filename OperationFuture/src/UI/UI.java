package UI;

public class UI {
	
	public synchronized void print(String s) {
		System.out.print(s);
	}
	
	public synchronized void println(String s) {
		System.out.println(s);
	}

	public synchronized void print(char charAt) {
		System.out.print(charAt);
		
	}
	
	public String colorText( String text, int r, int g, int b ) 
	{
		return "\u001b[38;2;" + r + ";" + g + ";" + b + "m" + text + "\u001b[0m";
	}

}
