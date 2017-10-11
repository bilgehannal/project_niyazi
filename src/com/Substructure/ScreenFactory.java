package com.Substructure;

public class ScreenFactory {
	
	private final Game game;
	private Screen screen;
	
	public ScreenFactory(Game game){
		this.game = game;
	}
	
	public void showScreen(Screen screen){
		this.screen = screen;
		this.screen.displayUpdate();
		this.screen.setup(); //this row runs setup methods one time.
		
	}
	
	//Encapsulation methods.
	public Screen getCurrentScreen(){
		return screen;
	}

	public Game getGame(){
		return game;
	}
	

}
