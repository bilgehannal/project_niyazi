package com.Substructure;
import javax.swing.JFrame;

public class Game {
	
	
	private final JFrame window = new JFrame();  // JFrame is defined.
	private final ScreenFactory screenFactory; // Screen Factory is defined.
	private final GameThread gameThread; //Game Factory is defined.
	private final KeyboardListener keyboardListener; //Keyboardlistener is defined.
	private final MousePadListener mousePadListener; //Mouse listener is defined.
	private int windowX, windowY; //values of size are defined.
	
	public Game(int windowX, int windowY, String title) {
		//Size is setted.
		this.windowX = windowX;
		this.windowY = windowY;
		
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
	

}
