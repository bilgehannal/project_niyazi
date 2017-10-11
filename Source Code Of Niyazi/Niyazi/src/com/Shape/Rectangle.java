package com.Shape;

import java.awt.Color;
import java.awt.Graphics2D;

import com.PropertiesOfObjects.AbstractLine;
import com.Substructure.Game;
import com.Substructure.Screen;


public class Rectangle extends Shape  {
	
	
	
	public Rectangle( int positionX, int positionY, int width, int height, Screen screen) {
		
		super(positionX, positionY, screen);
		setWidth(width);
		setHeight(height);
	}
	
	
	
	public void show(Graphics2D g2d){
		g2d.setColor(getColor());	
		
		if(getFilled())
			g2d.fillRect(getPositionX(), getPositionY(), getWidth(), getHeight());
		else
			g2d.drawRect(getPositionX(), getPositionY(), getWidth(), getHeight());
		
	}
	
	
	
	

	


	@Override
	public boolean intersect(Shape shape) {
		boolean returnValue = false;
		setVelocityDirectionLine(new AbstractLine(getOldPositionX(), getOldPositionY(), getPositionX(), getPositionY()));
		
		if(shape instanceof Rectangle){
			returnValue =  ((Rectangle) shape).getWidth() > 0 && ((Rectangle) shape).getHeight() > 0 && getWidth() > 0 && getHeight() > 0
			&& shape.getPositionX() < getPositionX() + getWidth() && shape.getPositionX() + ((Rectangle) shape).getWidth() > getPositionX()
			&& shape.getPositionY() < getPositionY() + getHeight() && shape.getPositionY() + ((Rectangle) shape).getHeight()> getPositionY();
			
			if(returnValue){	  
				if(shape.getPositionX()+shape.getWidth() <= getPositionX()+1){
					setCrashingLine(new AbstractLine(getPositionX(), getPositionY(), getPositionX(), getPositionY()+getHeight()));
				
				}else if(shape.getPositionY()+shape.getHeight() <= getPositionY()+1){
					setCrashingLine(new AbstractLine(getPositionX(), getPositionY(), getPositionX()+getWidth(), getPositionY()));
					
				}else if(shape.getPositionX() >= getPositionX() + getWidth()-1){
					setCrashingLine(new AbstractLine(getPositionX()+getWidth(), getPositionY(), getPositionX()+getWidth(), getPositionY()+getHeight()));
					
				}else if(shape.getPositionY() >= getPositionY()+getHeight()-1){
					setCrashingLine(new AbstractLine(getPositionX(), getPositionY()+getHeight(), getPositionX()+getWidth(), getPositionY()+getHeight()));
					
				}
			}
				   
		}
		
		return returnValue;
		
	}

	@Override
	public boolean contain(Shape shape) {
		return false;
	}



	@Override
	public boolean isMouseOver(int x, int y) {
		int a = getPositionX(), b = getPositionY(), c = getWidth(), d = getHeight();
		 if (a <= x && x <= (a + c) && b <= y && b <= (b + d)) {
			 return true;
		 }else{
			return false;
		 }

	}

	
	



	
	
	
	
	


}
