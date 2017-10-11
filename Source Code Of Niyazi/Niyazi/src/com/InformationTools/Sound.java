package com.InformationTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sound extends Thread {
	
	private String s; // This string keeps the name of the sound.
	
	
	public Sound(String url) {
		s = url;
	}

	
	
	@Override
	public void run() {
		super.run();
		try {
			new Player(new FileInputStream(s)).play(); // the music loaded to player and it plays.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
