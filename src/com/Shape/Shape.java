package com.Shape;

import java.awt.Color;
import java.awt.Graphics2D;

import com.PropertiesOfObjects.AbstractLine;
import com.PropertiesOfObjects.Behaviour;
import com.PropertiesOfObjects.Motion;
import com.Substructure.Player;
import com.UsefulItems.List;

public abstract class Shape {
	
	private static List shapeList = new List();

	public final Behaviour behaviour;
	private AbstractLine velocityDirection;
	
	private int positionX, positionY, oldPositionX, oldPositionY;
	
	private Color color;
	private boolean filled;
	
	private int speedLimit;
	private int speedX, speedY;
	private int width, height, weight;
	
	
	public abstract void show(Graphics2D g2d);
	
	public abstract boolean crash(Shape shape);
	public abstract boolean contain(Shape shape);
	
	public Shape( int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		oldPositionX = positionX;
		oldPositionY = positionY;
		color = Color.BLACK;
		filled = true;
		shapeList.add(this);
		speedLimit = 5;
		speedX = 0;
		speedY = 0;
		weight = 1;
		
		behaviour = new Behaviour();
		velocityDirection = new AbstractLine(getOldPositionX(),getOldPositionY() , getPositionX(), getPositionY());
		
		

	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionX(int positionX) {
		this.oldPositionX = getPositionX();
		this.positionX = positionX;
		velocityDirection.setX1(oldPositionX);
		velocityDirection.setX2(positionX);
	}
	
	public void setPositionY(int positionY) {
		this.oldPositionY = getPositionY();
		this.positionY = positionY;
		velocityDirection.setY1(oldPositionY);
		velocityDirection.setY2(positionY);
	}
	
	public static List getShapeList() {
		return shapeList;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}
	
	public int getSpeedLimit() {
		return speedLimit;
	}
	
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public int getSpeedY() {
		return speedY;
	}
	
	public Behaviour getBehaviour() {
		return behaviour;
	}
	
	public int getOldPositionX() {
		return oldPositionX;
	}
	
	public int getOldPositionY() {
		return oldPositionY;
	}
	
	public void setOldPositionX(int oldPositionX) {
		this.oldPositionX = oldPositionX;
	}
	public void setOldPositionY(int oldPositionY) {
		this.oldPositionY = oldPositionY;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public static void showAll(Graphics2D g2d){
		Shape shape;
		for(int i=0; i<Shape.getShapeList().size(); i++){
			shape = Shape.getShapeList().get(i);
				getShapeList().get(i).show(g2d);
		}
	}
	
	public void destroy(){
		setPositionX(0-width);
		setPositionY(0-height);
		setSpeedX(0);
		setSpeedY(0);
		behaviour.solid(false);
		behaviour.solid(false);
	}
	
	public AbstractLine getVelocityDirection() {
		return velocityDirection;
	}
	
	public void setVelocityDirection(AbstractLine velocityDirection) {
		this.velocityDirection = velocityDirection;
	}
	

	
		
	

}
