package Input;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class OFCommandLine 
{	
	public void renderFrame() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		String hpBar = "█";
		int time = 60;
		File musicPath = new File("testAudio.wav");
		if(musicPath.exists()) 
		{
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
		}
		
		while(true) 
		{
			System.out.print("\033[?25l\033[H\033[0K");
			System.out.print("\033[38;2;0;255;0m\033[0;0H"+ hpBar +"\033[0m");
			System.out.print("\033[38;2;255;0;0m\033[0;117H"+ time +"\033[0m");
			Thread.sleep(42);
			hpBar += "█";
			time--;
		}
	}
}
