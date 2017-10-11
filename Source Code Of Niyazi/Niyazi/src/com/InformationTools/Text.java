package com.InformationTools;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Label;

import com.Shape.Shape;
import com.Substructure.Screen;

public class Text extends Shape {
	//Subclass of shape. Because it is object as a Rectangle to show in screen.

	private int size;     //Size of font.
	private Label text;   //Label is created to keep the text
	
	public Text(String text, int positionX, int positionY, Screen screen) {
		super(positionX, positionY, screen);
		this.text = new Label(text);
		size = 20;
	}

	@Override
	public void show(Graphics2D g2d) {
		g2d.setColor(getColor());
		g2d.setFont(new Font("", Font.BOLD, size));   //Text settings
		g2d.drawString(text.getText(), getPositionX(), getPositionY());  //Text drawing
		
		
	}

	@Override
	public boolean intersect(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contain(Shape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getText() {
		return text.getText();
	}
	
	public void setText(String text) {
		this.text.setText(text);
	}
	
	public void setSize(int size){
		this.size = size;
	}

	@Override
	public boolean isMouseOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
