import com.Substructure.Game;

public class GameClass {
	
	public static void main(String[] args) {
		
		Game game = new Game(800, 600, "Test Game");
		game.setBackground(2400, 600);
		Screen1 screen = new Screen1(game.getScreenFactory());
		game.showScreen(screen);
		
	}
		
		

}
