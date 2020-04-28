package com.Bean.Beans.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;

public class Block extends GameObject{  //basically same as test
	
	protected float velX = 0, velY =0;
	
	public Block(float x, float y, ObjectId id) {
		super(x, y, id);
		
	}


// add constructor -- add methods or error -- because parent is abstract

	
	
	public void tick(LinkedList<GameObject> object) {
		
		
	}

	
	public void render(Graphics g) {
		
		//what the graphics for this object will render
		
		g.setColor(Color.CYAN);
		g.drawRect((int)x, (int)y, 32, 32); //cast to int coz fillrect takes int param
			
	}


	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 32, 32) ;
	}



	public float getX() {
		
		return x;
	}

	
	public float getY() {
		
		return y;
	}

	
	public void setX(float x) {
	
		this.x = x;
	}


	public void setY(float y) {
		
		this.velY = y;
	}


	public float getVelocityX() {
		return velX;
		
		
	}


	public float getVelocityY() {
		return velY;
	
		
	}
	public void setVelocityX(float velX) {
	
		this.velX = velX;
		
	}



	public void setVelocityY(float velY) {
	
		this.velY = velY;
		
	}
	
	public ObjectId getId() {

		return id;
	}



	


	


	


	

}
