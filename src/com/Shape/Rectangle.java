package com.Shape;

import java.awt.Color;
import java.awt.Graphics2D;

import com.PropertiesOfObjects.AbstractLine;


public class Rectangle extends Shape  {
	java.awt.Rectangle r;
	private AbstractLine[] lines = new AbstractLine[4];
	
	
	public Rectangle( int positionX, int positionY, int width, int height) {
		super(positionX, positionY);
		setWidth(width);
		setHeight(height);
	    r = new java.awt.Rectangle(positionX, positionY, width, height);
	    createLines();
	}
	
	
	
	public void show(Graphics2D g2d){
		g2d.setColor(getColor());	
		
		if(getFilled())
			g2d.fillRect(getPositionX(), getPositionY(), getWidth(), getHeight());
		else
			g2d.drawRect(getPositionX(), getPositionY(), getWidth(), getHeight());
		
	}
	
	
	
	@Override
	public void setPositionX(int positionX) {
		super.setPositionX(positionX);
	}
	
	@Override
	public void setPositionY(int positionY) {
		super.setPositionY(positionY);
	}



	@Override
	public boolean crash(Shape shape) {
		
		setVelocityDirection(new AbstractLine(getOldPositionX(), getOldPositionY(), getPositionX(), getPositionY()));
		
		if(shape instanceof Rectangle){
			return ((Rectangle) shape).getWidth() > 0 && ((Rectangle) shape).getHeight() > 0 && getWidth() > 0 && getHeight() > 0
				   && shape.getPositionX() < getPositionX() + getWidth() && shape.getPositionX() + ((Rectangle) shape).getWidth() > getPositionX()
				   && shape.getPositionY() < getPositionY() + getHeight() && shape.getPositionY() + ((Rectangle) shape).getHeight()> getPositionY();
				   
		}else if(shape instanceof Circle){
			
		}else if(shape instanceof Line){
			
		}
		return false;
	}



	@Override
	public boolean contain(Shape shape) {
		return false;
	}

	
	public AbstractLine[] getLines() {
		return lines;
	}

	private void createLines(){
		lines[0] = new AbstractLine(getPositionX(), getPositionY(), getPositionX()+getWidth(), getPositionY());
		lines[1] = new AbstractLine(getPositionX()+getWidth(), getPositionY(), getPositionX()+getWidth(), getPositionY()+getHeight());
		lines[2] = new AbstractLine(getPositionX()+getWidth(), getPositionY()+getHeight(), getPositionX(), getPositionY()+getHeight());
		lines[3] = new AbstractLine(getPositionX(), getPositionY()+getHeight(),getPositionX(), getPositionY());
	}


	
	


}
