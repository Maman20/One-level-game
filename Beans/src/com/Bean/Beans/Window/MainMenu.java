package com.Bean.Beans.Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.Bean.Beans.Window.mainGame.STATE;

public class MainMenu extends MouseAdapter{

	private mainGame game;
	private Handler handler;
	int keypressed = 0;//keeps track of number of times you clicked on that area
	public MainMenu(mainGame game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX(); //gets the position of the mouse on the x-axis
		int my = e.getY(); //gets the position of the mouse on the y-axis
		
		//play button
		if(game.gameState == STATE.Menu) {
		if(mouseOver(mx, my, 300, 250, 200, 70)) {
			game.gameState = STATE.Game;
			handler.LoadImageLevel(game.level);
			return;
		}
		}
		//quit button
	
		if(game.gameState == STATE.Menu) { //if we are in menu
		if(mouseOver(mx, my, 300, 350, 200, 70)) {
			System.exit(1);
			return; 
		
		}
		}
		}

	
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) { //checks to see if the mouse is within the width of the box
			if(my > y && my < y + height) { // checks to see if the mouse is within the height of the box
				return true; //only happens if both the if statements have bee met
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("Times New Roman", 10, 30);
		Font fnt2 = new Font("Magneto", 10, 30); //we found this in javas fonts if you go to windows appearance etc..
		//3 rectangles one draw string represents title
		
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("Menu Main", 330, 200);
		
		g.setColor(Color.green);
		g.setFont(fnt2);
		g.drawRect(300, 250, 200, 70);
		g.drawString("Play", 360, 300);

		g.drawRect(300, 350, 200, 70);
		g.drawString("Quit", 370, 400);
	}
	
}
