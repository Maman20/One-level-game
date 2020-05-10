/// GENERAL CODE INFO //////////
/* Code info:
 * Authors : Abdirahman Abdi
 *          :Dillon Zieglemann
 *          :Bruce Nyakundi
 *          :Ahmed Mohamoud
 * Course : OOP programming
 * Instructor: Zakaria Baani
 * Due date: 05/10/2020
 */
package com.Bean.Beans.Window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class beanWindow {
	public JFrame frame;
     public beanWindow(int width, int height, String title, mainGame game) {
    	 // current window
    	  
    	 game.setPreferredSize(new Dimension(width, height));
    	 game.setMaximumSize(new Dimension(width, height));
    	 game.setMinimumSize(new Dimension(width, height));

    	
    	 //adds the game object to the Jframe , with its dimensions
    	 frame = new JFrame(title);
    	 frame.add(game);//adds game to frame;
    	 frame.pack(); //packs to window
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 frame.setResizable(false);
    	 frame.setLocationRelativeTo(null); // sets our current frame location 
    	
    	 frame.setVisible(true);
    	 game.Start();
     }
     
}
