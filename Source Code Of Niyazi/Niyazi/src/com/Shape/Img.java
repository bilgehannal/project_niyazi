package com.Shape;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.Substructure.Game;
import com.Substructure.Screen;

public class Img extends Shape {
	private String url;
	private ImageIcon icon;
	private Image img;

	//It is like a shape.
	public Img(String url, int positionX, int positionY, Screen screen) {
		super(positionX, positionY, screen);
		this.url = url;
		icon  = new ImageIcon(url);
		img = icon.getImage();
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
	}

	
	public void show(Graphics2D g2d) {
		g2d.drawImage(img, getPositionX(), getPositionY(), null);
		
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


	@Override
	public boolean isMouseOver(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
