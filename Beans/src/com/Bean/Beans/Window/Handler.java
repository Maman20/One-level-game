package com.Bean.Beans.Window;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.Bean.Beans.Framework.GameObject;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Objects.Block;

public class Handler { //class to hold all our game objects to a lsit , updates and renders all of them
	 //create in maingame class	
	public LinkedList<GameObject> object = new LinkedList<GameObject>(); //list of game objects -- creates methods to add to that list 
		private GameObject tempObject;
		
		
		//render and update the list
		public void tick() {
			for (int i = 0; i < object.size(); i++) {  //we dont know th esize of our list
				tempObject = object.get(i); //setting our tempObject to whatever our object at this current point is -- if i = 1 sets temp object to object @ index 1
				tempObject.tick(object); //tick then -- render
				}

		}
		public void render(Graphics g) { //pass in the graphics
			for (int i = 0; i < object.size(); i++) {  //we dont know th esize of our list
				tempObject = object.get(i); //setting our tempObject to whatever our object at this current point is
				tempObject.render(g);
				}

		}
		
		//adding and removing items in our list 
		public void addObject(GameObject object) {
			this.object.add(object); //this. refers to the object list
		}
		public void removeObject(GameObject object) { //removes object in our list
			this.object.remove(object); //this. refers to the object list
		}
		
		//our level
		public void createLevel () {
			//Random g = new Random();
//			for(int yy = 0; yy < mainGame.width+32; yy += 32) {
//					addObject(new Block(0, yy, ObjectId.Block));
//				}
//			for (int xx = 0; xx <mainGame.width + 32; xx+=32) {
//				addObject(new Block(xx, mainGame.height-32, ObjectId.Block)); //must create enum contant of test before using it in handler class
//		    }
//			for (int xx = 0; xx <600; xx+=32) {
//				addObject(new Block(xx, 400, ObjectId.Block)); //must create enum contant of test before using it in handler class
//		    }
//			
//				
//				for(int zz = 0; zz < mainGame.height+32; zz += 32) {
//					addObject(new Block(mainGame.height-609, zz, ObjectId.Block)); //must create enum contant of test before using it in handler class
//				}		
				//addObject(new Block(xx, g.nextInt(600), ObjectId.Block)); //must create enum contant of test before using it in handler class
//crate width and height first -- in main game -- cause its not getting our proper width and height if you just pass in the width of the window
			
		}
}
