package com.kassmon.game.frames;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CodeEditer extends JInternalFrame {
	
	private JScrollPane pane;
	private JTextArea text;
	
	public CodeEditer (int width, int height) {
		super(null);
		super.addComponentListener(new ResizeListener());
		
		this.text = new JTextArea();
		this.pane = new JScrollPane(this.text);
		this.pane.setBounds(10, 10, super.getWidth() - 10, super.getHeight() - 10);
		
		add(pane);
		setResizable(true);
		setClosable(true);
		
		this.setSize(width, height);
		this.repaint();
		
	}
	
	public String getText() {
		return this.text.getText();
	}
	
	public void setText(String text) {
		this.text.setText(text);
	}
	
	private void resize() {
		this.pane.setSize(super.getWidth() - 10, super.getHeight() - 10);
		this.repaint();
	}
	
	class ResizeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            resize();
        }
	}
	
}
