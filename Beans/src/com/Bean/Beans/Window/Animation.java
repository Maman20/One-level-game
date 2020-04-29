package com.Bean.Beans.Window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {  
 private int speed;
 private int frames;
 
 private int index = 0;
 private int count = 0;
 
 private BufferedImage[] images;
 private BufferedImage currentImg;
 
 public Animation (int speed, BufferedImage... args) { //allows us an infinite amount of parameters containign our buffered image
	this.speed = speed;
	images = new BufferedImage[args.length];
	for (int i = 0; i < args.length; i++) {
		images[i] = args[i];  //e.g our first image = args[0]
	}
	frames = args.length;
 }
 public void runAnimation () {
	 index++;
	 if(index >speed) {
		 index = 0;
		 nextFrame();
	 }
 }
 private void nextFrame(){
     currentImg = images[count%frames];
     count++;// count is what frame youre currently on
	}
 
 //or
//private void nextFrame() {
//	for (int i =0; i <frames; i++) {  
//		if (count == i)
//			 currentImg = images[i]; //if count = 0 and i =0,, turns current image to image 0-- images[0] our first image
//	}
//	count++;
//	if(count > frames) //repeats the animation once it goes all the way through
//		count = 0;
//}

public void drawAnimation (Graphics g, int x, int y) {
	g.drawImage(currentImg,x,y,null);
}
public void drawAnimation (Graphics g, int x, int y,int scaleX, int scaleY) {
	g.drawImage(currentImg,x,y,scaleX,scaleY,null);
}  //can add getters and setters to reset the count /speed if you go into an animation
}