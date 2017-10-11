package com.Physics;

import com.Shape.Shape;
import com.UsefulItems.Mathmatic;


public class Physics {
	
	Gravity g = new Gravity(0);
	
	public void gravityEffect(){
		for(int i=0; i<Shape.getShapeList().size(); i++){
			if(!Shape.getShapeList().get(i).behaviour.isStable()){
				(Shape.getShapeList().get(i)).getNetForce().add(new Force(0, g.getMagnitudeY()*Shape.getShapeList().get(i).getWeight()));
				//F=ma gravitional force is equal to magnitude of gravity times weight.
			}
			
		}
	}
	
	public void forceEffect(){
		//Effect of netforce of all objects to theirselves.
		for(int i=0; i<Shape.getShapeList().size(); i++){
			Shape.getShapeList().get(i).getNetForce().affect(Shape.getShapeList().get(i));
		}
	}
	
	//Net forces are equals to 0.
	public void resetNetForce(){
		for(int i=0; i<Shape.getShapeList().size(); i++){
			Shape.getShapeList().get(i).getNetForce().setMagnitudeX(0);
			Shape.getShapeList().get(i).getNetForce().setMagnitudeY(0);
		}
	}
	
	public void setG(Gravity g) {
		this.g = g;
	}
	public Gravity getG() {
		return g;
	}
	public void setGravity(double y){
		g.setMagnitudeY(y);
		
	}
	
	public static void frictionForce(Shape s1, Shape s2){
		
		
		double fX; 
		double fY;
		Force f = new Force(0, 0);
		
		fX = Mathmatic.abs(s1.getNetForce().getMagnitudeX());
		fY = Mathmatic.abs(s1.getNetForce().getMagnitudeY());
	
		//Friction force changes according to direction of object. Opposite of the object's direction.
		//Net coefficient is equalto average of 2 objects.
		if(s1.getSpeedX()>=1){
			s1.getNetForce().add(new Force(fY*(s1.behaviour.getCoEfficientFriction()+s2.behaviour.getCoEfficientFriction())/2*-1, 0));
		}else if(s1.getSpeedX()<=-1){
			s1.getNetForce().add(new Force(fY*(s1.behaviour.getCoEfficientFriction()+s2.behaviour.getCoEfficientFriction())/2, 0));
		}

	
	}

	
}
