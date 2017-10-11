import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import com.PropertiesOfObjects.Motion;
import com.Shape.Circle;
import com.Shape.Line;
import com.Shape.Rectangle;
import com.Shape.Shape;
import com.Shape.Square;
import com.Substructure.Player;
import com.Substructure.Screen;
import com.Substructure.ScreenFactory;

public class MyScreen extends Screen {
	
	Rectangle floor = new Rectangle(0, 500, 800, 100);
	Rectangle barrier1 = new Rectangle(425, 300, 25, 200);
	Rectangle barrier2 = new Rectangle(100, 300, 25, 200);
	Rectangle barrier3 = new Rectangle(750, 300, 25, 200);
	Line stick1 = new Line(225, 250, 300, 250);
	Line stick2 = new Line(565, 250, 640, 250);
	Rectangle rect = new Rectangle(50, 50, 50, 50);

	Rectangle rect2 = new Rectangle(150, 50, 50, 50);
	Player player = new Player(rect, this);
	Player player2 = new Player(rect2, this);
	

	public MyScreen(ScreenFactory screenFactory) {
		super(screenFactory);
	}

	@Override
	public void setup() {

		stick1.behaviour.solid(true);
		stick2.behaviour.solid(true);
		
		barrier1.behaviour.solid(true);
		barrier2.behaviour.solid(true);
		barrier3.behaviour.solid(true);
		barrier1.behaviour.stable(true);
		barrier2.behaviour.stable(true);
		barrier3.behaviour.stable(true);
		
		floor.behaviour.solid(true);
		floor.behaviour.stable(true);
		
		rect.behaviour.solid(true);
		rect.setColor(Color.BLUE);
		
		rect2.behaviour.solid(true);
		rect2.setColor(Color.red);
	}

	@Override
	public void action() {
		
		player.motion.eightDirection();
		player2.motion.eightDirection(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
		
	}

	
	

}
