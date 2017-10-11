package com.Physics;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.Shape.Shape;
import com.Substructure.Player;
import com.UsefulItems.Mathmatic;

public class Motion {
	
	private  Player player = null;
	
	
	public Motion(Player player) {
		this.player = player;
	}
	
	//This method controls the all motions of the game
	public static void activateMotion(){
		Shape shape, shape2;
		int x, y;
		
		//It resets the intersecting objects for every object.
		for(int i=0; i<Shape.getShapeList().size(); i++){
			for(int l=0; l<Shape.getShapeList().get(i).getIntersectingShapes().size(); l++){
				Shape.getShapeList().get(i).getIntersectingShapes().remove(0);
			}
			
		}
		//Control for all shape.
		for(int i=0; i<Shape.getShapeList().size(); i++){
			shape = Shape.getShapeList().get(i);
			
			if(!shape.behaviour.isStable() && shape.isVisibility()){
				
				x = shape.getPositionX();
				y = shape.getPositionY();
				
				//It will be combined in a method.
				
				//For x dimensipon
				//This code provides with recognise the crashing of objects.
				exitX:
				for(int k=1; k<=Mathmatic.abs((int)shape.getSpeedX()); k++){
					for(int j = 0; j<Shape.getShapeList().size(); j++){
						shape2 = Shape.getShapeList().get(j);
						if(shape2.behaviour.isSolid() && shape.behaviour.isSolid() && shape!=shape2){
							shape.setPositionX((int) (x + k*(shape.getSpeedX()/Mathmatic.abs(shape.getSpeedX()))));
							if(shape.intersect(shape2) && shape2.intersect(shape)){
								shape.setPositionX((int) (x + (k-1)*(shape.getSpeedX()/Mathmatic.abs(shape.getSpeedX()))));
								boolean control = true;
								for(int l=0; l<shape.getIntersectingShapes().size(); l++){
									
									if(shape.getIntersectingShapes().get(l) == shape2 ){
										control = false;
									}	
								}
								
								//These are physicial calculations.
								if(control){
									shape.getIntersectingShapes().add(shape2);
									shape2.getIntersectingShapes().add(shape);
								}
								
								//Impulse of every objects to other objects.
								if(shape.behaviour.isStable()){
									shape2.setSpeedX(shape2.getSpeedX()*-1*shape.getImpulsePercentage()/100);
								}else if(shape2.behaviour.isStable()){
									shape.setSpeedX(shape.getSpeedX()*-1*shape2.getImpulsePercentage()/100);
								}else{
									double v1 = shape.getSpeedX();
									double v2 = shape2.getSpeedX();
									double m1 = shape.getWeight();
									double m2 = shape2.getWeight();
									
									//Momentum saves
									shape.setSpeedX((v1*(m1-m2)+2*m2*v2)/(m1+m2));
									shape2.setSpeedX((v2*(m2-m1)+2*m1*v1)/(m1+m2));
								}
								break exitX;
							}
						}
					}
				}
				
				//For y dimension.
				exitY:
				for(int k=1; k<=Mathmatic.abs((int)shape.getSpeedY()); k++){
					for(int j = 0; j<Shape.getShapeList().size(); j++){
						shape2 = Shape.getShapeList().get(j);
						if(shape2.behaviour.isSolid() && shape.behaviour.isSolid() && shape!=shape2){
							shape.setPositionY((int) (y + k*(shape.getSpeedY()/Mathmatic.abs(shape.getSpeedY()))));
							if(shape.intersect(shape2) && shape2.intersect(shape)){
								shape.setPositionY((int) (y + (k-1)*(shape.getSpeedY()/Mathmatic.abs(shape.getSpeedY()))));
								boolean control = true;
								for(int l=0; l<shape.getIntersectingShapes().size(); l++){
									
									if(shape.getIntersectingShapes().get(l) == shape2){
										control = false;
									}
								}
								if(control){
									shape.getIntersectingShapes().add(shape2);
									shape2.getIntersectingShapes().add(shape);
								}
								
								
								if(shape.behaviour.isStable()){
									shape2.setSpeedY(shape2.getSpeedY()*-1*(shape.getImpulsePercentage()/100));
								}else if(shape2.behaviour.isStable()){
									shape.setSpeedY(shape.getSpeedY()*-1.0*(shape2.getImpulsePercentage()/100));
								}else{
									double v1 = shape.getSpeedY();
									double v2 = shape2.getSpeedY();
									double m1 = shape.getWeight();
									double m2 = shape2.getWeight();
								
									shape.setSpeedY((v1*(m1-m2)+2*m2*v2)/(m1+m2));
									shape2.setSpeedY((v2*(m2-m1)+2*m1*v1)/(m1+m2));
								}
								
								Physics.frictionForce(shape, shape2);
								Physics.frictionForce(shape2, shape);
								
								
								shape.setSpeedY(shape.getSpeedY()*shape.getImpulsePercentage()/100*shape2.getImpulsePercentage()/100);
								shape2.setSpeedY(shape2.getSpeedY()*shape.getImpulsePercentage()/100*shape2.getImpulsePercentage()/100);
								
								
								break exitY;
							}
						}
					}
				}
			}
		}
		
	}
	
		
	//eight direction is the one of the motion properite of player's objects. 
	//It runs with force effect.
	//Normal control
	public void eightDirection(double force, double jump){
		eightDirection(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, force, jump);
	}
	
	//Manual control eight direction.
	public void eightDirection(int up, int down, int left, int right, double force, double jump){
		if(player.getScreen().isKeyPressed(left))
			new Force(-1*force, 0).affect(player.getShape());
		if(player.getScreen().isKeyPressed(right))
			new Force(force, 0).affect(player.getShape());
		if(player.getScreen().isKeyPressed(up)){

			player.getShape().setPositionY(player.getShape().getPositionY()+1);
			boolean control = false;
			for(int i=0; i<Shape.getShapeList().size(); i++){

				System.out.println("Bilgehan");
				if(player.getShape().intersect(Shape.getShapeList().get(i)) && player.getShape()!=Shape.getShapeList().get(i)){
					control = true;
					break;
				}
			}
			if(player.getShape().getCrashingLine().getDegree() == 0 && control){
				player.getShape().setPositionY(player.getShape().getPositionY()-1);
				player.getShape().setSpeedY(-1*jump);
			}
		}
		if(player.getScreen().isKeyPressed(down)){}
		
		
	}
	
	public void platform(){
		
	}
	
	private static int getDistance(int gap1, int gap2){
		
		return (int) (Mathmatic.abs((int)(gap1*1.0/(Math.min(gap1, gap2)))));
	}
	
	//Unit vectors are computed.
	private static int getWayX(Shape r){
		
		return (int)((r.getOldPositionX()-r.getPositionX())/(Mathmatic.abs(r.getOldPositionX()-r.getPositionX())));
		
	}
	
	private static int getWayY(Shape r){
		
		return (int)((r.getOldPositionY()-r.getPositionY())/(Mathmatic.abs(r.getOldPositionY()-r.getPositionY())));
		
	}


}
