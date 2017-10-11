package com.Substructure;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.Physics.Force;
import com.Physics.Motion;
import com.Shape.Img;
import com.Shape.Shape;

import javafx.scene.image.Image;

public class GameThread extends JPanel implements Runnable {
	
	
	private final Game game; //Game object is defined.
	
	public GameThread(Game game) {
		//Game communication is setted.
		this.game = game;
		setFocusable(true);
	}
	
	//This method call action method from screen every 10 milliseconds.
	@Override
	public void run() {
		while(true){
			try {
				
				if(game.getScreenFactory().getCurrentScreen() != null){
					loop();
					Thread.sleep(10); //stop program 10 milliseconds.
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Paint methods show all components on the panel (Screen)
	@Override
	public void paint(Graphics g) {
		
	
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(game.getScreenFactory().getCurrentScreen() != null)
			Shape.showAll(g2d);
		
		
		repaint();
	}
	
	private void loop(){
		
		
		
		game.getScreenFactory().getCurrentScreen().getPhysics().gravityEffect();
		Motion.activateMotion();//Updating frame.
		game.getScreenFactory().getCurrentScreen().getPhysics().forceEffect();
		game.getScreenFactory().getCurrentScreen().action(); // calling action method.
		game.getScreenFactory().getCurrentScreen().getPhysics().forceEffect();
		game.getScreenFactory().getCurrentScreen().getPhysics().resetNetForce();
		
	}

}
