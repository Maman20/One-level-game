package com.Bean.Beans.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Framework.Texture;
import com.Bean.Beans.Window.Animation;
import com.Bean.Beans.Window.Camera;
import com.Bean.Beans.Window.Handler;
import com.Bean.Beans.Window.mainGame;

public class Player extends GameObject {
	
	private float width = 48, height = 96;

	private float gravity = 0.4f; //gravitation resistance to player -- as falling = true
	private final float max_speed = 10; //our velocity will never get less than 10
	private int facing = 1; //sets the direction that the player is facing
	//1 = Right
	//-1 = Left
	
	private Handler handler;
	private Camera cam;
	
	Texture tex = mainGame.getInstance();
	
	private Animation playerWalkRight, playerWalkLeft;
	
	public Player(float x, float y, Handler handler, Camera cam, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		this.cam = cam;
		
		playerWalkRight = new Animation (5, tex.player[1],tex.player[2],tex.player[3],tex.player[4],tex.player[5],tex.player[6]);
		playerWalkLeft = new Animation (5, tex.player[8],tex.player[9],tex.player[10],tex.player[11],tex.player[12],tex.player[13]);
	}


	public void tick(LinkedList<GameObject> object) {
		x += velX; //moves coordinate of player object according to velocity
		y += velY;
		
		if(velX < 0) facing = -1;
		else if(velX > 0) facing = 1;
		
		
		if (falling||jumping) {
			velY += gravity;
			
			if (velY > max_speed) {
				velY = max_speed; 
			}
		}
		if (Player.isFalling() && System.currentTimeMillis()==10000) {
			System.out.println("HAHA");
		}
		
		Collision(object); //can also put method in tick but for better organisation we do it alone
		
		playerWalkRight.runAnimation();
		playerWalkLeft.runAnimation();
	}

	//collision
	private void Collision(LinkedList<GameObject> object)  {
		  for (int i =0; i<handler.object.size(); i ++) {
			  GameObject tempObject = handler.object.get(i); //stores to temporary gameoBJECT
			
			  if (tempObject.getId() == ObjectId.Block) { //if we get to the coordinate for the block th eobject then run the following propgram
				
				  if (getBoundsTop().intersects(tempObject.getBounds())) {
						//when we reach the bounds of the block  object
						  //make same y position to prevent it from getting in block
						  y = tempObject.getY() + 32; //aligned with block
						  velY = 0;
					  }
				  if (getBounds().intersects(tempObject.getBounds())) {
					//when we reach the bounds of the block  object
					  //make same y position to prevent it from getting in block
					  y = tempObject.getY() - height; //aligned with block
					  velY = 0;
					  falling = false;
					  jumping = false;
				  }
				  else { //if it does'nt intersect
					  falling = true;
				  }
				  if (getBoundsRight().intersects(tempObject.getBounds())) {
						//when we reach the bounds of the block  object
						  //make same y position to prevent it from getting in block
						  x = tempObject.getX() - width; //aligned with block
				  }
				  if (getBoundsLeft().intersects(tempObject.getBounds())) {
					//when we reach the bounds of the block  object
					  //make same y position to prevent it from getting in block
					  x = tempObject.getX() + 32; //aligned with block
				  }
			  }else if(tempObject.getId() == ObjectId.Flag) {
					//switch level
					if(getBounds().intersects(tempObject.getBounds())) {
					handler.switchLevel();
					}

					
			  }
		 }
	}
	
	public void render(Graphics g) {
		if(jumping) {
			if(facing == 1) //using our spritesheets 
				g.drawImage(tex.player_jump[2], (int)x, (int)y, 48, 96, null); //at a particular index we have a sprite for jumping 
			else if(facing == -1)
				g.drawImage(tex.player_jump[3], (int)x, (int)y, 48, 96, null);
		}else {
		if(velX != 0) { //moving player
			if(facing == 1)
				playerWalkRight.drawAnimation(g, (int)x, (int)y, 48, 96);
			else
				playerWalkLeft.drawAnimation(g, (int)x, (int)y, 48, 96);
		}else{
			if(facing == 1)
				g.drawImage(tex.player[0], (int)x, (int)y, 48, 96, null);
			else if(facing == -1)
				g.drawImage(tex.player[7], (int)x, (int)y, 48, 96, null);
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/4)), (int) ((int)y+height/2), (int) width/2, (int)height/2); //we want in 2 segments
		
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/4)), (int)y, (int) width/2, (int)height/2);
		
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int) 5, (int)height-10);
		
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int) 5, (int)height-10);
		
	}

}
