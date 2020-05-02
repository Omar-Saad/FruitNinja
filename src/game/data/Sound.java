package game.data;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	
	
	public static void playMusic(String filePath) {
		
		
		
		 
		try {
	File musicpath = new File(filePath);
	if(musicpath.exists())
		
	{

		AudioInputStream audio =  AudioSystem.getAudioInputStream(musicpath);
		Clip clip = AudioSystem.getClip();
		clip.open(audio );
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		//JOptionPane.showConfirmDialog(null, "dd");
	}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
}
}