package com.Bean.Beans.Window;

import com.Bean.Beans.Framework.GameObject;

public class Camera {  //follows player
	protected int x,y;  //we use int here to prevent shaky cameras

	public Camera(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
		public float getX () {
			return x;
		}
		public float getY() {
			return y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}

		public void tick(GameObject player) {  //we want camera to snap onto player
			
			//tweaning algorithm
		float	xx= (int) (-player.getX() + ((mainGame.width)/2)); //online resource //follows player's x and y
		float yy = (int) (-player.getY() + ((mainGame.height)/2));
		     x+= (xx - x) * (0.05);
		     y+= (yy-y) * (0.05);
		}
}
