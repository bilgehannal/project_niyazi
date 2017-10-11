package com.Substructure;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.Shape.Shape;



public class Game {
	
	
	private final JFrame window = new JFrame();  // JFrame is defined.
	private final ScreenFactory screenFactory; // Screen Factory is defined.
	private final GameThread gameThread; //Game Factory is defined.
	private final KeyboardListener keyboardListener; //Keyboardlistener is defined.
	private final MousePadListener mousePadListener; //Mouse listener is defined.
	private int windowX, windowY; //values of size are defined.
	private int backgroundX, backgroundY;
	private int cameraPositionX, cameraPositionY;
	
	
	public Game(int windowX, int windowY, String title) {
		//Size is setted.
		this.windowX = windowX;
		this.windowY = windowY;
		
		setBackground(windowX, windowY);
		
		//Frame settings are done.
		window.setSize(windowX, windowY);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);	
		
		//Communication is setted between classes.
		screenFactory = new ScreenFactory(this);
		gameThread = new GameThread(this);
		keyboardListener = new KeyboardListener();
		mousePadListener = new MousePadListener();
		
		window.add(gameThread);
		window.addKeyListener(keyboardListener);
		window.addMouseListener(mousePadListener);
		
		new Thread(gameThread).start(); //Thread is started.
		
		cameraPositionX = 0;
		cameraPositionY = 0;
	}
	
	//Encapsulation methods.
	public MousePadListener getMousePadListener(){
		return mousePadListener;
	}
	
	public KeyboardListener getKeyboardListener(){
		return keyboardListener;
	}
	
	public JFrame getWindow(){
		return window;
	}
	
	public ScreenFactory getScreenFactory(){
		return screenFactory;
	}
	
	public int getWindowX() {
		return windowX;
	}
	
	public int getWindowY() {
		return windowY;
	}

	public GameThread getGameThread() {
		return gameThread;
	}
	
	public void setBackground(int backgroundX, int backgroundY) {
		this.backgroundX = backgroundX;
		this.backgroundY = backgroundY;
	}
	
	public int getBackgroundX() {
		return backgroundX;
	}
	
	public int getBackgroundY() {
		return backgroundY;
	}
	
	public void moveCameraY(int cameraY) {
		int newPositionY = cameraPositionY + cameraY;
		
		//All shapes moves the opposite of camera. Camera looks like moving.
		if(!(newPositionY < 0) && !(newPositionY+windowY>backgroundY)){
			for(int i=0; i<Shape.getShapeList().size(); i++){
				Shape.getShapeList().get(i).setPositionY(Shape.getShapeList().get(i).getPositionY()-cameraY);
			}
			cameraPositionY = newPositionY;
		}
		
	}
	
	public void moveCameraX(int cameraX) {
		int newPositionX = cameraPositionX + cameraX;
		
		//All shapes moves the opposite of camera. Camera looks like moving.
		if(!(newPositionX < 0) && !(newPositionX+windowX>backgroundX)){
			for(int i=0; i<Shape.getShapeList().size(); i++){
				if(!Shape.getShapeList().get(i).behaviour.isStableInScreen())
				Shape.getShapeList().get(i).setPositionX(Shape.getShapeList().get(i).getPositionX()-cameraX);
			}
			cameraPositionX = newPositionX;
		}
		
	}
	

	public void showScreen(Screen screen){
		getScreenFactory().showScreen(screen);
	}
	
	

}
