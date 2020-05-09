package com.Bean.Beans.Window;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.Bean.Beans.Framework.KeyInput;
import com.Bean.Beans.Framework.ObjectId;
import com.Bean.Beans.Framework.Texture;
import com.Bean.Beans.Objects.Block;
import com.Bean.Beans.Objects.Player;

//import com.Bean.Beans.Objects.Test;

//game class what runs the game
public class mainGame extends Canvas implements Runnable { 
	
	private static final long serialVersionUID = -571047980453441592L;

// we extend the  runnable interface
    
	//starting our thread
	private boolean running = false;
	private Thread thread;
	
	
	public static int width ,height;
	
	private BufferedImage level = null;
	//handler is better than doing test1,test2,test3 etc
	
	//Object
	Handler handler;
	Camera cam;
	static Texture tex;
	
	private void init() { //initialises everything - gets called before we start our loop
		width = getWidth();
		height = getHeight();
		
	    tex = new Texture();
	    
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level1.png");
		
		cam = new Camera(0, 0);
		handler = new Handler();
		
		loadImageLevel(level);
		
		this.addKeyListener(new KeyInput(handler)); //in order for key input to work we must add the new keyinput
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
				cam.tick(handler.object.get(i)); //object we pass in paramater at index i must be player -- ticks the player with the proper object we want
			}
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
	
	  g2D.translate(cam.getX(), cam.getY()); //translate everything it sandwiches  //begin of cam
	  
	  //anything in btwn g2d start of cam and end of cam is going to be affected by the camera which is  -- handler.render
	  
	  handler.render(g);
	  
	  
	  g2D.translate(cam.getX(), cam.getY());  //end of cam
	  /////////////////////
	  g.dispose(); // disposes of this graphics context
      bs.show(); // . show makes next bufferstart visible
	}
 private void loadImageLevel( BufferedImage image) {
	 int w = image.getWidth();
	 int h = image.getHeight();
	 
	 System.out.println("width : " + w + " height : " + h);
	 
	 //Deciphering what pixel were on
	 for (int xx=0; xx<h; xx++) {  //we loop thru every pixel of our image with the proper dimensions
		 for (int yy = 0; yy<w ; yy++) {
			 int pixel = image.getRGB(xx, yy); //pixel position -- we used paint.net and zoomed 2400% to start from top left then used pencil to draw our level out -- since one pencil is one pixel then each pixel = 1 box
			 int red = (pixel >> 16) & 0xff; //bit operator 
			 int green = (pixel >> 8) & 0xff;  //gets what pixel were on and gets the rgb values
			 int blue = (pixel) & 0xff;
			 
			 if (red == 255 && green == 255 && blue == 255)handler.addObject(new Block(xx*32, yy*32, 1, ObjectId.Block)); //DETETCS COLOR AND IF COLOR MACHES THE PIXEL THEN Create a block object  //if 0 dirt block if type == 1 then grass block
			 if (red == 0 && green == 0 && blue == 255)handler.addObject(new Player(xx*32, yy*32,handler, ObjectId.Player)); //Detects color and if  olor pixel maches blue player then it sets object to player

		 }
	 }
 }

 public static Texture getInstance() {  //gets instance of our texture  -- in player class just say maingame.getisnatnce()
	 return tex;
 }
public static void main(String[] args) {
	//mainGame main = new mainGame(); //must create main game object to use methods  since main is static
  	new beanWindow(800, 600 , "Happy Bean runner", new mainGame()); //creates a window for us
//  	main.run();
 	//main.Start();
//new mainGame();  
}
}
