package com.Bean.Beans.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Window.Handler;

public class Player extends GameObject {
	private float width = 48, height = 96;
	private Handler handler;
	private float gravity = 0.4f; //gravitation resistance to player -- as falling = true
	private final float max_speed = 10; //our velocity will never get less than 10
	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
	}


	public void tick(LinkedList<GameObject> object) {
		x+=velX;
		y+=velY;
		
		if (falling||jumping) {
			velY += gravity;
			
			if (velY > max_speed) {
				velY = max_speed; 
			}
		}
		Collision(object); //can also put method in tick but for better organisation we do it alone
	}

	//collsion
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
				  else { //if it doesnt intersect
					//  jumping = true;
					  falling = true;
				  }
				  if (getBoundsRight().intersects(tempObject.getBounds())) {
						//when we reach the bounds of the block  object
						  //make same y position to prevent it from getting in block
						  x = tempObject.getX() - width; //aligned with block
//						  velY = 0;
//						  falling = false;
//						  jumping = false;
					  }
				  if (getBoundsLeft().intersects(tempObject.getBounds())) {
						//when we reach the bounds of the block  object
						  //make same y position to prevent it from getting in block
						  x = tempObject.getX() + 35; //aligned with block
//						  velY = 0;
//						  falling = false;
//						  jumping = false;
					  }
			  }
		  }
	}
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int) width, (int)height);
	
//		Graphics2D g2D = (Graphics2D) g; //casting our graphics to a grapohics2d variable 
//		g.setColor(Color.RED);
//		g2D.draw(getBounds());
//		g2D.draw(getBoundsRight());
//		g2D.draw(getBoundsLeft());
//		g2D.draw(getBoundsTop());
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+(width/4)), (int) ((int)y+height/2), (int) width/2, (int)height/2); //we want in 2 segments
		
	}
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+(width/4)), (int)y, (int) width/2, (int)height/2);
		
	}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int) 5, (int)height-10);
		
	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y+5, (int) 5, (int)height-10);
		
	}
	
	

}
