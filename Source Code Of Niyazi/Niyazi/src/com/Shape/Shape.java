package com.Shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;

import com.Physics.Force;
import com.Physics.Gravity;
import com.Physics.Motion;
import com.PropertiesOfObjects.AbstractLine;
import com.PropertiesOfObjects.AbstractVector;
import com.PropertiesOfObjects.Behaviour;
import com.Substructure.*;
import com.UsefulItems.*;




public abstract class Shape  {
	
	private static com.UsefulItems.List shapeList = new com.UsefulItems.List(); //This pbject keeps all object in the game.
	private ArrayList<Shape> intersectingShapes = new ArrayList<Shape>();

	public final Behaviour behaviour;
	
	private int positionX, positionY, oldPositionX, oldPositionY;
	
	private Color color;
	private boolean filled;
	
	private int speedLimitX, speedLimitY;
	private double speedX, speedY;
	private int width, height;
	private double weight;
	private double impulsePercentage;
	private boolean visibility, crash;
	private AbstractLine crashingLine, velocityDirectionLine; // this variables will be used in the future.
	private AbstractVector speedVector; //It gives us the vector of object's speed.
	private Screen screen;
	
	private Gravity gravity;
	
	private Force netForce;
	
	private static int backGroundX=0, backgroundY=0;
	
	
	public abstract void show(Graphics2D g2d);
	
	public abstract boolean intersect(Shape shape);
	
	public abstract boolean contain(Shape shape);
	
	public abstract boolean isMouseOver(int x, int y);
	
	public Shape( int positionX, int positionY, Screen screen) {
		//initial or default values.
		this.screen = screen;
		this.positionX = positionX;
		this.positionY = positionY;
		oldPositionX = positionX;
		oldPositionY = positionY;
		color = Color.BLACK;
		filled = true;
		shapeList.add(this);
		speedLimitX = 50;
		speedLimitY = 50;
		speedX = 0;
		speedY = 0;
		weight = 1;
		
		behaviour = new Behaviour();
		velocityDirectionLine = new AbstractLine(getOldPositionX(),getOldPositionY() , getPositionX(), getPositionY());
		visibility = true;
		crash = false;
		crashingLine = new AbstractLine(0, 0, 0, 0);
		speedVector = new AbstractVector((int)speedX, (int)speedY);
		netForce = new Force(0, 0);
		impulsePercentage = 100;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionX(int positionX) {
		
		this.oldPositionX = getPositionX();
		//Control of wrap propoerties.
		if(behaviour.isWrap())	
			this.positionX = positionX+getWidth() < 0 ? screen.getScreenFactory().getGame().getBackgroundX() : positionX%screen.getScreenFactory().getGame().getWindowX();
		else
			this.positionX = positionX;
		velocityDirectionLine.setX1(oldPositionX);
		
		velocityDirectionLine.setX2(positionX);
	}
	
	public void setPositionY(int positionY) {
		
		this.oldPositionY = getPositionY();
		//Control of wrap propoerties.
		if(behaviour.isWrap())
			this.positionY = positionY+getHeight() < 0 ? screen.getScreenFactory().getGame().getBackgroundY() : positionY%screen.getScreenFactory().getGame().getWindowY();
		else
			this.positionY = positionY;
		velocityDirectionLine.setY1(oldPositionY);
		
		velocityDirectionLine.setY2(positionY);
	}
	
	public static com.UsefulItems.List getShapeList() {
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
	
	public void setSpeedLimitX(int speedLimit) {
		this.speedLimitX = speedLimit;
	}
	
	public int getSpeedLimitX() {
		return speedLimitX;
	}
	
	public void setSpeedLimitY(int speedLimit) {
		this.speedLimitY = speedLimit;
	}
	
	public int getSpeedLimitY() {
		return speedLimitY;
	}
	
	public void setSpeedX(double speedX) {
		if(Mathmatic.abs(speedX)>Mathmatic.abs(speedLimitX)){
			speedX = speedLimitX*speedX/Mathmatic.abs(speedX);
		}
		this.speedX = speedX;
		speedVector.setX((int)speedX);
	}
	
	public double getSpeedX() {
		return speedX;
	}
	public void setSpeedY(double speedY) {
		if(Mathmatic.abs(speedY)>Mathmatic.abs(speedLimitY)){
			speedY = speedLimitY*speedY/Mathmatic.abs(speedY);
		}
		this.speedY = speedY;
		speedVector.setY((int)speedY);
	}
	
	public double getSpeedY() {
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
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
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
		//This method call the show methods of all objects.
		for(int i=0; i<Shape.getShapeList().size(); i++){
			shape = Shape.getShapeList().get(i);
				if(shape.isVisibility() && !shape.behaviour.isInvisible()){
					getShapeList().get(i).show(g2d);
				}
		}
	}
	
	
	
	//Viewible properties
	public void show() {
		visibility = true;
		behaviour.getDfaultSolid();
	}
	public void hide() {
		visibility = false;
		behaviour.solidVisible(false);
	}
	
	public boolean isVisibility() {
		return visibility;
	}

	
	
	public boolean crash(Shape shape) {
		boolean returnValue = false;
		for(int i=0; i<this.getIntersectingShapes().size(); i++){
			if(this.getIntersectingShapes().contains(shape)){
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	
	
	
	public AbstractLine getVelocityDirectionLine() {
		return velocityDirectionLine;
	}
	
	public void setVelocityDirectionLine(AbstractLine velocityDirection) {
		this.velocityDirectionLine = velocityDirection;
	}
	
	public ArrayList<Shape> getIntersectingShapes() {
		return intersectingShapes;
	}
	
	public void setCrashingLine(AbstractLine crashingLine) {
		this.crashingLine = crashingLine;
	}
	
	public AbstractLine getCrashingLine() {
		return crashingLine;
	}
	
	public AbstractVector getSpeedVector() {
		return speedVector;
	}
	
	public void setGravity(Gravity gravity) {
		this.gravity = gravity;
	}
	
	public Gravity getGravity() {
		return gravity;
	}
	
	public Force getNetForce() {
		return netForce;
	}
	
	public void setNetForce(Force netForce) {
		this.netForce = netForce;
	}
	
	public double getImpulsePercentage() {
		return impulsePercentage;
	}
	
	public void setImpulsePercentage(double impulsePercentage) {
		this.impulsePercentage = impulsePercentage;
	}
	
	public void absoluteMotionX(int amount){
		setPositionX(getPositionX()+amount);
	}	
	
	public void absoluteMotionY(int amount){
		setPositionY(getPositionY()+amount);
	}
	
	public static void setBackGroundX(int backGroundX) {
		
		for(int i=0; i<getShapeList().size(); i++){
			getShapeList().get(i).setPositionX(getShapeList().get(i).getPositionX()+backGroundX);
		}
	}
	
	public static int getBackGroundX() {
		return backGroundX;
	}
	
	public static void setBackgroundY(int backgroundY) {
		for(int i=0; i<getShapeList().size(); i++){
			getShapeList().get(i).setPositionY(getShapeList().get(i).getPositionY()+backgroundY);
		}
	}
	
	public static int getBackgroundY() {
		return backgroundY;
	}

}
