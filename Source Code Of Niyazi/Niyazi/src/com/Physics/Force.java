package com.Physics;

import com.Shape.Shape;

public class Force {
	
	private double magnitudeX, magnitudeY;  //These variables keeps the magnitudes of force in 2 dimensions.

	public Force(double magnitudeX, double magnitudeY) {
		this.magnitudeX = magnitudeX;
		this.magnitudeY = magnitudeY;
	}
	
	public void setMagnitudeX(double magnitudeX) {
		this.magnitudeX = magnitudeX;
	}
	
	public double getMagnitudeX() {
		return magnitudeX;
	}
	
	public void setMagnitudeY(double magnitudeY) {
		this.magnitudeY = magnitudeY;
	}
	
	public double getMagnitudeY() {
		return magnitudeY;
	}
	
	//Calculation of the effect of force to an object.
	public void affect(Shape shape){
		double aX = magnitudeX/shape.getWeight();
		double aY = magnitudeY/shape.getWeight();
		
		shape.setSpeedX((shape.getSpeedX() + aX * 0.012)); //0.012 is the 1 loop time.
		shape.setSpeedY((shape.getSpeedY() + aY * 0.012));
	}
	
	public void add(Force f){
		magnitudeX = f.getMagnitudeX();
		magnitudeY = f.getMagnitudeY();
	}
}
