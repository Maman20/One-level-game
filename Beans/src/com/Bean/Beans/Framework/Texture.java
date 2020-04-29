package com.Bean.Beans.Framework;

import java.awt.image.BufferedImage;

import com.Bean.Beans.Window.BufferedImageLoader;

public class Texture {  //loads all our texture in our game
   
	SpriteSheet bs , ps;
   private BufferedImage block_sheet = null;
   private BufferedImage player_sheet = null;
   public BufferedImage [] block  = new BufferedImage[2]; 
   public BufferedImage [] player = new BufferedImage[7];
    
   public Texture () {
	   
	   BufferedImageLoader loader = new BufferedImageLoader();
	   try {
		block_sheet = loader.loadImage("/block_sheet.png");
		player_sheet = loader.loadImage("/player_sheet.png");
	} catch (Exception e) {
		// TODO: handle exception
	}
	bs = new SpriteSheet(block_sheet);
	ps = new SpriteSheet(player_sheet);
	
	getTextures();
   }


private void getTextures() {  //handles getting all pour textures
	// TODO Auto-generated method stub
	block[0] = bs.grabImage(1, 1, 32, 32); //dirt block
   block[1] = bs.grabImage(2, 1, 32, 32); //grass block	
   
   player[0] = ps.grabImage(1, 1, 32, 64); //idle
   player[1] = ps.grabImage(2, 1, 32, 64);//walking player
   player[2] = ps.grabImage(3, 1, 32, 64);//walking
   player[3] = ps.grabImage(4, 1, 32, 64);//walking
   player[4] = ps.grabImage(5, 1, 32, 64);

   player[5] = ps.grabImage(6, 1, 32, 64);//running
   player[6] = ps.grabImage(7, 1, 32, 64);//running

   
}
}
