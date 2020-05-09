package com.Bean.Beans.Framework;

import java.awt.image.BufferedImage;

public class SpriteSheet { //breaks down our images and gets the one we want
		
	private BufferedImage image;
		
	public SpriteSheet (BufferedImage image) {
		this.image = image;
	}

		
	public BufferedImage grabImage (int col, int row, int width, int height ) {//sprite sheet moves by column, row
		BufferedImage img = image.getSubimage((col*width) - width,(row*height) - height , width, height);  //gets column position * width (32) - width which gives u current x position of the image pixel
		return img;
	}
		
}
