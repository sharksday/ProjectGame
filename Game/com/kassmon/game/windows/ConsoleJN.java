package com.kassmon.game.windows;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ConsoleJN extends JInternalFrame {
	
	private JTextArea consoleOutput;
	private JScrollPane consoleOutputPanel;
	private JTextField consoleInput;
	
	public ConsoleJN(String name) {
		super(name);
		super.addComponentListener(new ResizeListener());
		
		
		
		this.resize();
		this.add(this.consoleInput);
		this.add(this.consoleOutputPanel);
	}
	
	public ConsoleJN() {
		super.addComponentListener(new ResizeListener());
		
		
		
		this.resize();
		this.add(this.consoleInput);
		this.add(this.consoleOutputPanel);
	}
	
	
	private void resize() {
		this.consoleOutputPanel.setSize(this.getWidth() - 30, this.getHeight() - 80);
		this.consoleInput.setSize(this.getWidth() - 30, 20);
		consoleInput.setLocation(10, this.getHeight() - 60);
		this.repaint();
	}
	
	class ResizeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            resize();
        }
	}
	
}
