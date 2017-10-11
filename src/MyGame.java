import com.Substructure.Game;
import com.Substructure.Player;

public class MyGame {
	
	private static Game game;
	
	public static void main(String[] args) {
		game = new Game(800, 600, "Bilgehan");
		game.getScreenFactory().showScreen(new MyScreen(game.getScreenFactory()));
		
		 
	}
	
	

}
