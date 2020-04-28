package com.Bean.Beans.Window;

import com.Bean.Beans.Framework.GameObject;

public class Camera {  //follows player
	protected float x,y;

	public Camera(float x, float y) {
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
		public void setX(float x) {
			this.x = x;
		}
		public void setY(float y) {
			this.y = y;
		}

		public void tick(GameObject player) {  //we watn camera to snap onto player
			// TODO Auto-generated method stub
			//tweaning algorithm
			x= -player.getX() + ((mainGame.width)/2);
			
		}
}
