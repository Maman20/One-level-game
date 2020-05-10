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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class beanWindow {
	public JFrame frame;
	public JMenuBar bar;
	public JMenu menu;
	public JMenuItem exit;
	
	
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
    	 // frame.setLayout(null);
    	 // added menu bar
    	 // added comments
    	 bar = new JMenuBar();
    	 bar.setBounds(0, 0, width, 25);
    	 menu = new JMenu("Menu");
    	 menu.setBounds(0, 0, 45, 24);
    	 bar.add(menu);
    	 
    	 exit = new JMenuItem("Exit");
    	 menu.add(exit);
    	 exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	 
    	 });
    	 
 
       	 frame.add(bar);
       	 frame.setJMenuBar(bar);
    	 frame.setVisible(true);
    	 game.Start();
     }
     
}
