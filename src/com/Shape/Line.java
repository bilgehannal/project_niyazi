package com.Shape;

import java.awt.Graphics2D;

import com.PropertiesOfObjects.AbstractLine;


public class Line extends Shape  {

	private int positionX2, positionY2;
	private int gapX, gapY;
	private AbstractLine abstractLine;
	
	public Line( int positionX, int positionY, int positionX2, int positionY2) {
		super(positionX, positionY);
		this.positionX2 = positionX2;
		this.positionY2 = positionY2;
		gapX = this.positionX2-positionX;
		gapY = this.positionY2-positionY;
		abstractLine = new AbstractLine(positionX, positionY, positionX2, positionY2);
	}

	@Override
	public void show(Graphics2D g2d) {
		g2d.setColor(getColor());
		g2d.drawLine(getPositionX(), getPositionY(), positionX2, positionY2);
		
	}
	
	
	public void setPositionX(int positionX) {
		super.setPositionX(positionX);
		this.positionX2 = getPositionX() + gapX;
		
	}
	
	public void setPositionY(int positionY) {
		super.setPositionY(positionY);
		this.positionY2 = getPositionY() + gapY;
	}

	@Override
	public boolean crash(Shape shape) {
		return false;
	}

	@Override
	public boolean contain(Shape shape) {
		return false;
	}

	public int getGapX() {
		return gapX;
	}
	
	public int getGapY() {
		return gapY;
	}
	
	public AbstractLine getAbstractLine() {
		return abstractLine;
	}
	
	
	
	

	
}
