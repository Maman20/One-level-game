package com.Bean.Beans.Window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.Bean.Beans.Framework.KeyInput;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Objects.Block;
import com.Bean.Beans.Objects.Player;


//import com.Bean.Beans.Objects.Test;

//game class what runs the game
public class mainGame extends Canvas implements Runnable { /**
	 * 
	 */
	private static final long serialVersionUID = -571047980453441592L;

// we extend the  runnable interface

	
	//private static final long serialVersionUID = 1L;
    
	//starting our thread
	private boolean running = false;
	private Thread thread;
	
	
	public static int width ,height;
	
	private BufferedImage level = null;
	//Test test;  //must import e.g test class to create instance of test class  -- then tick  test 2 and render test 2
	//handler is better than doing test1,test2,test3 etc
	
	//Object
	Handler handler;
	Camera cam;
	Random rand = new Random();
	private void init() { //initialises everything - gets called b4 we start our loop
		width = getWidth();
		height = getHeight();
	
		BufferedImageLoader loader = new BufferedImageLoader();
		
		level = loader.loadImage("/level1.png");
		handler = new Handler();
		cam = new Camera(0, 0);
//		for (int i = 0; i <50; i++) { //no need for test1,2,3 can have 50 objects using random places
//				handler.addObject(new Block(rand.nextInt(800), rand.nextInt(600), ObjectId.Block)); //must create enum contant of test before using it in handler class
//				//USING RANDOM POINT BETWEEN OUR WIDTH AND HEIGHT	
//		}
		handler.addObject(new Player(100, 100,handler, ObjectId.Player));
		//add key input
	
		handler.createLevel();
		this.addKeyListener(new KeyInput(handler)); //inorder for key input to work we must add the new keyinput
	}
	
	public synchronized void Start() {
		if(running) 
			return;
		running = true;
		
		thread = new Thread(this); //starts thread
		thread.start();
		
		
	}
	
	public void run() { //for the thread required by the runnable interface		
		//OUR GAME LOOP
		//runs the game at 60 frames per second
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			
			render();
			
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
 

private void tick() {
		
		handler.tick(); //ticks all the objects
		for (int i = 0; i<handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ObjectId.Player) {
				cam.tick(handler.object.get(i)); //objhect we pass in aramater at index i must be player -- ticks the player with the proper object we want
			}
		}
		
	}
 private void render() {
	 // to get our buiffering
	  BufferStrategy bs = this.getBufferStrategy(); // this refers to the canvas class btw
	  //intiialize once since buffer gets called constantly
	 
	  if(bs == null) 
	  { 
		  this.createBufferStrategy(3);
		 // this.isDisplayable();
		   //triple buffering -- sets amount of buffers behind our first image
		  return;
	  }
	  Graphics g = bs.getDrawGraphics(); // gets graphics context for our buffering
	  //cast to 2d for camera
	  Graphics2D g2D = (Graphics2D) g; //has translate function
	 
	  ////drawing our graphics//////
	  g.setColor(Color.BLACK);
	  g.fillRect(0, 0,  getWidth(), getHeight());
	
	  g2D.translate(cam.getX(), cam.getY()); //translate everything it sandwiches  //begin of cam
	  
	  //anything in btwn g2d start of cam and end of cam is going to be affected by the camera which is  -- handler.ender
	  
	  handler.render(g);
	  
	  
	  g2D.translate(cam.getX(), cam.getY());  //end of cam
	  /////////////////////
	  g.dispose(); // disposes of this graphics context
      bs.show(); // . show makes next bufferstart visible
	}
 

public static void main(String[] args) {
	//mainGame main = new mainGame(); //must create main game object to use methods  since main is static
  	new beanWindow(800, 600 , "Happy Bean runner", new mainGame()); //creates a window for us
//  	main.run();
 	//main.Start();
//new mainGame();  
}
}
