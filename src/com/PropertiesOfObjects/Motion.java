package com.PropertiesOfObjects;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.Shape.Shape;
import com.Substructure.Player;

public class Motion {
	
	private  Player player = null;
	
	
	public Motion(Player player) {
		this.player = player;
		
	}
	
	
	public static void activateMotion(){
		Shape shape;
		int x, y;
		for(int i=0; i<Shape.getShapeList().size(); i++){
			shape = Shape.getShapeList().get(i);
			
			if(!shape.behaviour.isStable()){
				x = shape.getPositionX()+shape.getSpeedX();
				y = shape.getPositionY()+shape.getSpeedY();
				
				shape.setPositionX(x);
				shape.setPositionY(y);
			}
		}
		
	}
	
	public static void crashControl(){
		Shape r, r2;
		for(int i=0; i<Shape.getShapeList().size()-1; i++){
			for(int j = i+1; j<Shape.getShapeList().size(); j++){
				r = Shape.getShapeList().get(i);
				r2 = Shape.getShapeList().get(j);
				if(r2.crash(r) && r.behaviour.isSolid() && r2.behaviour.isSolid()){
					r2.setPositionX(r2.getOldPositionX());
					r2.setPositionY(r2.getOldPositionY());
					r.setPositionX(r.getOldPositionX());
					r.setPositionY(r.getOldPositionY());
				}
			}
		}
	}
	
	public void eightDirection(){
		
		
		if(player.getScreen().isKeyReleased(KeyEvent.VK_LEFT))
			player.getShape().setSpeedX(0);
		if(player.getScreen().isKeyReleased(KeyEvent.VK_RIGHT))
			player.getShape().setSpeedX(0);
		if(player.getScreen().isKeyReleased(KeyEvent.VK_UP))
			player.getShape().setSpeedY(0);
		if(player.getScreen().isKeyReleased(KeyEvent.VK_DOWN))
			player.getShape().setSpeedY(0);
		if(player.getScreen().isKeyPressed(KeyEvent.VK_LEFT))
			player.getShape().setSpeedX(-5);
		if(player.getScreen().isKeyPressed(KeyEvent.VK_RIGHT))
			player.getShape().setSpeedX(5);
		if(player.getScreen().isKeyPressed(KeyEvent.VK_UP))
			player.getShape().setSpeedY(-5);
		if(player.getScreen().isKeyPressed(KeyEvent.VK_DOWN))
			player.getShape().setSpeedY(5);
		
		
	}
	
	public void eightDirection(int up, int down, int left, int right){
		if(player.getScreen().isKeyReleased(left))
			player.getShape().setSpeedX(0);
		if(player.getScreen().isKeyReleased(right))
			player.getShape().setSpeedX(0);
		if(player.getScreen().isKeyReleased(up))
			player.getShape().setSpeedY(0);
		if(player.getScreen().isKeyReleased(down))
			player.getShape().setSpeedY(0);
		if(player.getScreen().isKeyPressed(left))
			player.getShape().setSpeedX(-5);
		if(player.getScreen().isKeyPressed(right))
			player.getShape().setSpeedX(5);
		if(player.getScreen().isKeyPressed(up))
			player.getShape().setSpeedY(-5);
		if(player.getScreen().isKeyPressed(down))
			player.getShape().setSpeedY(5);
		
	}
	
	public void platform(){
		
	}
	
	


}
