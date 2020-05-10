package com.Bean.Beans.Window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {   //loads images
  private BufferedImage image; //java library
  public BufferedImage loadImage (String path) {
	  try {
		  image = ImageIO.read(getClass().getResource(path)); //loads images of given path
	  }
	  catch(IOException e) {
		  e.printStackTrace();
	  }
	  return image;
  }

}
