import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import com.Physics.Motion;
import com.Shape.Circle;
import com.Shape.Img;
import com.Shape.Line;
import com.Shape.Rectangle;
import com.Shape.Shape;
import com.Shape.Square;
import com.Substructure.Player;
import com.Substructure.Screen;
import com.Substructure.ScreenFactory;
import com.InformationTools.Text;
import com.Physics.Force;
import com.Physics.Gravity;

public class Screen1 extends Screen {

	Rectangle meal = new Rectangle(400, -10, 10, 10, this);
	Rectangle rect = new Rectangle(0, 300, 50, 50,this);
	Rectangle floor  = new Rectangle(0, 520, 2400, 80, this);
	Rectangle barrier1 = new Rectangle(-10, 0, 10, 600, this);
	Rectangle barrier2 = new Rectangle(2400, 0, 10, 600, this);
	Rectangle barrier3 = new Rectangle(-10, -10, 2410, 10, this);
	Rectangle warning = new Rectangle(200, 100, 400, 100, this);
	Player player = new Player(rect, this);
	Img background, floorImg;
	private int score = 0;
	Text scoreKeeper = new Text(score+"", 0, 75, this);
	String infoKeeper = "";
	Text info = new Text("best", 250, 140, this);
	private boolean initialValue = true;
	private int best = 0;
	
	
	
	

	public Screen1(ScreenFactory screenFactory) {
		super(screenFactory);
	}

	@Override
	public void setup() {
		playSound("music.mp3");
		setGravity(15);
		warning.setColor(Color.green);
		score = 0;
		floor.behaviour.solid(true);
		floor.behaviour.stable(true);
		floor.behaviour.setInvisible(true);
		rect.behaviour.solid(true);
		rect.setColor(Color.BLUE);
		floor.setImpulsePercentage(80);
		background = new Img("background.png", 0, 0, this);
		floorImg = new Img("floor.png", 0, 520, this);
		Shape.getShapeList().placeBack(background);
		rect.setSpeedLimitX(5);
		meal.setColor(Color.red);
		meal.behaviour.stable(true);
		scoreKeeper.setSize(75);
		
		floor.behaviour.setCoEfficientFriction(0);
		rect.behaviour.setCoEfficientFriction(0);
		
		barrier1.behaviour.stable(true);
		barrier2.behaviour.stable(true);
		barrier3.behaviour.stable(true);
		
		barrier1.behaviour.solid(true);
		barrier2.behaviour.solid(true);
		barrier3.behaviour.solid(true);
		
		rect.setImpulsePercentage(100);
		barrier1.setImpulsePercentage(100);
		barrier2.setImpulsePercentage(100);
		barrier3.setImpulsePercentage(100);
		
		barrier1.behaviour.setCoEfficientFriction(0);
		barrier2.behaviour.setCoEfficientFriction(0);
		barrier3.behaviour.setCoEfficientFriction(0);
		floor.setImpulsePercentage(80);
		//meal.behaviour.setStableInScreen(true);
		scoreKeeper.behaviour.setStableInScreen(true);
		warning.behaviour.solid(false);
		warning.behaviour.stable(true);
		warning.behaviour.setStableInScreen(true);
		info.behaviour.setStableInScreen(true);
		
		File f = new File("score.txt");
		if(f.exists() && !f.isDirectory()) { 
			try {
				Scanner sc = new Scanner(f);
				 while (sc.hasNextLine()) {
			            best = Integer.parseInt(sc.nextLine());
			        }
			        sc.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				if(f.createNewFile())
					System.out.println("File was created.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		infoKeeper = "Best Score: " + best;
		info.setText(infoKeeper);
		
	}
	
	private int step = 200;
	private int randomY = (int)(Math.random()*470);
	
	
	
	
	@Override
	public void action() {
		if(isKeyPressed(KeyEvent.VK_SPACE) && initialValue){
			rect.setPositionX(0);
			meal.setPositionX(400);
			warning.setColor(Color.green);
			infoKeeper = "Best Score: " + best;
			info.setText(infoKeeper);
			rect.setSpeedX(2);
			initialValue = false;
			meal.setPositionY(randomY);
			warning.hide();
			warning.setColor(Color.red);
			info.hide();
			
		}
		//System.out.println("Bilgehan");
		player.motion.eightDirection(20, 10);
		if(isKeyPressed(KeyEvent.VK_SPACE)){
			rect.setSpeedY(-5);
		}
		if(meal.getPositionX()<0 || meal.getPositionX()>600){
			gameOver();
		}
		if(rect.intersect(meal)){
			meal.setPositionX(rect.getPositionX()+step);
			randomY = (int)(Math.random()*470);
			meal.setPositionY(randomY);
			score++;
			scoreKeeper.setText(score+"");
			if(meal.getPositionX()<0 || meal.getPositionX()>600){
				meal.setPositionX(meal.getOldPositionX());
				step*=-1;
				
			}
			
		}
		
		
		player.focus();
		
		
			
		
	}
	
	public void gameOver(){
		
		for(int i =0; i<Shape.getShapeList().size(); i++){
			Shape.getShapeList().get(i).behaviour.solid(false);
			
		}
		
			best = score > best ? score : best;
			infoKeeper = "Best Score: " + best + " Score: " + score;
			info.setText(infoKeeper);
			warning.show();
			info.show();
			
			File f = new File("score.txt");
			try {
				PrintWriter printer = new PrintWriter(f);
				printer.println(best);
				printer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
	
			
		
		
	}

	
	

}
