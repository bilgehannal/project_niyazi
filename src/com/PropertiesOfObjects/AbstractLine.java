package com.PropertiesOfObjects;

public class AbstractLine {
	
	private int x1,y1,x2,y2;
	
	private double slope, normal;
	public AbstractLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
	}
	
	public double getSlope() {
	    slopeCalculation();
		return slope;
	}
	
	public double getNormal() {
		normalCalculation();
		return normal;
	}
	
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	public void setX2(int x2) {
		this.x2 = x2;
	}
	
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	private void slopeCalculation(){
		slope = Math.round(((y2-y1)*1.0/(x2-x1))*100)/100.0;
		
	}
	
	private void normalCalculation(){
		normal = Math.round((-1/slope)*100)/100;
	}
	
	public double getDegree(){
		double degree;
		slopeCalculation();
		degree = Math.round((Math.atan(slope)*100)*57.2957795)/100.0;
		return degree;
	}

}
