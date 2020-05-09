package com.Bean.Beans.Window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.Bean.Beans.Framework.KeyInput;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Framework.Texture;
import com.Bean.Beans.Objects.Player;

//game class what runs the game
public class mainGame extends Canvas implements Runnable { 
	
	private static final long serialVersionUID = -571047980453441592L;

// we extend the  runnable interface
    
	//starting our thread
	private boolean running = false;
	private Thread thread;
	
	static MainMenu menu; //creates class of type menu
	
	//tells the current state that the game is in
	public enum STATE{
		Menu,
		Game
	};
	
	public STATE gameState = STATE.Menu;
	
	public static int width ,height;
	
	
	BufferedImage level = null;
	//handler is better than doing test1,test2,test3 etc
	static BufferedImageLoader loader;
	public static BufferedImage bg = null;
	
	//Object
	Handler handler;
	Camera cam;
	static Texture tex;
	
	public static int LEVEL = 1;
	
	private void init() { //initialises everything - gets called before we start our loop
		
		
		width = getWidth();
		height = getHeight();
		
	    tex = new Texture();
	    
		 loader = new BufferedImageLoader();
		level = loader.loadImage("/Level_1.png");
		bg = loader.loadImage("/background.png");

		cam = new Camera(0, 0);

		handler = new Handler(cam);
		menu = new MainMenu(this, handler);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
	    if(gameState == STATE.Game)
		handler.LoadImageLevel(level);
		
		//this.addKeyListener(new KeyInput(handler)); //in order for key input to work we must add the new keyinput
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
		
		if(gameState == STATE.Game) {
			handler.tick(); //ticks all the objects
			for (int i = 0; i<handler.object.size(); i++) {
				if (handler.object.get(i).getId() == ObjectId.Player) {
					cam.tick(handler.object.get(i)); //object we pass in paramater at index i must be player -- ticks the player with the proper object we want
				}
			}
		}else if(gameState == STATE.Menu) {
			
			menu.tick();
		}
	}
 private void render() {
	 // to get our buffering
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
	  g.fillRect(0, 0,  getWidth(), getHeight());// our surface
	  
	  g.drawImage(bg, 0, 0, null);
	
	  g2D.translate(cam.getX(), cam.getY()); //translate everything it sandwiches  //begin of cam
	  
	  //anything in btwn g2d start of cam and end of cam is going to be affected by the camera which is  -- handler.render
	  
	  handler.render(g);
	  if(gameState == STATE.Game) {
		  g2D.translate(-cam.getX(), -cam.getY());  //end of cam
	  }else if(gameState == STATE.Menu) {
			menu.render(g);//renders Main Menu
	  }else {
		  g.setColor(Color.white);
		  g.drawString("Menu", 100, 100);
	  }
	  
		  /////////////////////
	 g.dispose(); // disposes of this graphics context
	 bs.show(); // . show makes next bufferstart visible
	}

 	public static Texture getInstance() {  //gets instance of our texture  -- in player class just say maingame.getisnatnce()
	 	return tex;
 	}
 	
 	public static void main(String[] args) {
  		new beanWindow(800, 600 , "Happy Bean runner", new mainGame()); //creates a window for us 
	}
}
