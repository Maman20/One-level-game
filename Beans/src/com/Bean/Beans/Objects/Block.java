package com.Bean.Beans.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Framework.Texture;
import com.Bean.Beans.Window.mainGame;

public class Block extends GameObject{

	Texture tex = mainGame.getInstance();
	private int type;
	
	public Block(float x, float y,int type, ObjectId id) { 
		super(x, y, id);
		this.type = type;
	}

	public void tick(LinkedList<GameObject> object) { //required as this class is a child and parent has abstarct methods
		
	}

	public void render(Graphics g) {
		//what the graphics for this object will render
		if (type == 0)  //dirt block
			g.drawImage(tex.block[0], (int)x, (int)y, null); //array positioning system where by 0 is the first pixel which is an image
		if (type ==1)   //grass block
				g.drawImage(tex.block[1], (int)x, (int)y, null);	
	}

	public Rectangle getBounds() { //required
		return new Rectangle((int)x, (int)y, 32, 32) ; //size of our blocks
	}

}
