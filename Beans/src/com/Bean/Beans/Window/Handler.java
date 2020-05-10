package com.Bean.Beans.Window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Objects.Block;
import com.Bean.Beans.Objects.Flag;
import com.Bean.Beans.Objects.Player;
import com.Bean.Beans.Window.mainGame.STATE;


public class Handler { //class to hold all our game objects to a list , updates and renders all of them
	 //create in main game class	
	public LinkedList<GameObject> object = new LinkedList<GameObject>(); //list of game objects -- creates methods to add to that list 
	
	private GameObject tempObject;
		
	private Camera cam;
	
	private BufferedImage level2 = null;
	
	public Handler(Camera cam) {
		this.cam = cam;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level2 = loader.loadImage("/Level_2.png"); //Loads the second level.
	}
	
	//render and update the list
	public void tick() {
		for (int i = 0; i < object.size(); i++) {  //we don't know the size of our list
			tempObject = object.get(i); //setting our tempObject to whatever our object at this current point is -- if i = 1 sets temp object to object @ index 1
			tempObject.tick(object); //tick then -- render
			}
	}
	public void render(Graphics g) { //pass in the graphics
		for (int i = 0; i < object.size(); i++) {  //we don't know thr size of our list
			tempObject = object.get(i); //setting our tempObject to whatever our object at this current point is
			tempObject.render(g);
			}
			
	}
	
	public void LoadImageLevel(BufferedImage image) {
		int w = image.getWidth(); //width of the image
		int h = image.getHeight();
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
						int red = (pixel >> 16) & 0xff; //bit operator
						int green = (pixel >> 8) & 0xff; 
						int blue = (pixel) & 0xff;
						
						
						//if we have white pixels then create a block object and pass in and int value to indecate teh index for the image pixel i.e 1
						if(red == 255 && green == 255 && blue == 255) addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));  //0 means dirt and 1 means grass
						if(red == 128 && green == 128 && blue == 128) addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));
						//if blue pixel detected the create a player object
						if(red == 0 && green == 0 && blue == 255) addObject(new Player(xx*32, yy*32, this, cam, ObjectId.Player));
						
						//if its a yellow pixel then create a level object
						if(red == 255 && green == 255 && blue == 0) addObject(new Flag(xx*32, yy*32, ObjectId.Flag));

			}
		}
	}
		
	public void switchLevel() {
		clearLevel();
		cam.setX(0); //reset our camera
		
		switch(mainGame.LEVEL) { //switching btwn levels
		case 1:
			LoadImageLevel(level2);
			mainGame.loader = new BufferedImageLoader();
			mainGame.bg = mainGame.loader.loadImage("/fantasybg.jpg");
			break;
		
	
		}
	}
	
	public void clearLevel() { //clears the level by clearing the leemnts in the list
		object.clear();
	}
	
	//adding and removing items in our list 
	public void addObject(GameObject object) {
		this.object.add(object); //this. refers to the object list
	}
	public void removeObject(GameObject object) { //removes object in our list
		this.object.remove(object); //this. refers to the object list
	}
		
}
