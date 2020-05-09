package com.Bean.Beans.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Framework.Texture;
import com.Bean.Beans.Window.mainGame;

public class Flag extends GameObject{  //basically same as test

	Texture tex = mainGame.getInstance();

	protected float velX = 0, velY =0;

	private int type;
	
	public Flag(float x, float y,int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
		
	}


// add constructor -- add methods or error -- because parent is abstract

	
	
	public void tick(LinkedList<GameObject> object) {
		
		
	}

	
	public void render(Graphics g) {
		
		//what the graphics for this object will render
		if (type == 0)  //dirt block
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		if (type ==1)   //grass block
				g.drawImage(tex.block[1], (int)x, (int)y, null);	
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
