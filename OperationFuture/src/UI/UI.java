package UI;

import java.util.Scanner;

public class UI
{
	private static Scanner sysin;
	
	public UI() 
	{
		sysin = new Scanner(System.in);
	}

	public synchronized void print(String s) 
	{
		System.out.print(s);
	}
	
	public synchronized void println(String s) 
	{
		System.out.println(s);
	}

	public synchronized void print(char charAt) 
	{
		System.out.print(charAt);
		
	}
	
	public synchronized String nextLine() 
	{
		System.out.print("\033[38;2;0;255;0m");
		String temp = sysin.nextLine();
		System.out.print("\u001b[0m");
		return temp;
	}
	
	public synchronized String colorText( String text, int r, int g, int b ) 
	{
		return "\u001b[38;2;" + r + ";" + g + ";" + b + "m" + text + "\u001b[0m";
	}

	public synchronized void animateText(String text, int time) throws InterruptedException 
	{
		for( int i=0; i<text.length(); i++ ) 
		{
			System.out.print( text.charAt(i) );
			Thread.sleep(time*500); 
		}
	}

}
