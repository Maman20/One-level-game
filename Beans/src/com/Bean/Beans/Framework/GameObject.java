package com.Bean.Beans.Framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject { //everything (objectwise) we use will extend the game object
    protected float x,y; //protected -- child class can use no one else
    protected ObjectId id;
    protected float velX = 0, velY =0;
	protected boolean falling = true;
	protected boolean jumping = false; //handles falling and jumping
    
	
	public GameObject(float x, float y, ObjectId id) {
		super();
		this.x = x;
		this.y = y;
		this.id = id;
	}
	//below are fucntions required by our game object class to have
	
	//tick method with linklist parameter that lists the game object -- for collision detection
	
	

	public  abstract void tick (LinkedList<GameObject> object);
	public  abstract void render (Graphics g); //-- rendering our graphics
	public  abstract Rectangle getBounds(); //gets collision bounding for our player
	//methods our game object requires
	public float getX() {
	
		return x;
	}
	public float getY() {
		
		return y;
	}
 //abstract meaning we can override -- if we want
	
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {

		this.y = y;
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
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public ObjectId getId() {// returns what the game object is
		
		return id;
	}
	
 
}
