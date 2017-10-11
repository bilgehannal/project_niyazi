package com.PropertiesOfObjects;

public class AbstractVector {

	private int x,y;
	
	public AbstractVector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getMagnatiude(){
		//Hypotenius is the magnitude.
		return Math.sqrt(x*x*1.0 + y*y*1.0);
	}
	
}
