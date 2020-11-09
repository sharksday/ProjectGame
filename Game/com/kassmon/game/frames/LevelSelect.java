package com.kassmon.game.frames;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class LevelSelect extends JInternalFrame {
	
	private int level = 0;
	
	private JButton buttons[] = new JButton[10];
	
	private JButton next;
	private JButton previous;
	
	public LevelSelect () {
		
		for (JButton obj: buttons) {
			obj = new JButton ("Test");
		}
		
		this.next = new JButton("next page");
		this.previous = new JButton("previous page");
		
		
		
	}
	
	
	
}
