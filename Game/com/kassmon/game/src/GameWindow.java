package com.kassmon.game.src;

import java.awt.event.*;
import javax.swing.*;
import com.kassmon.game.frames.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements WindowListener{
	
	//menu items
	private JMenuBar menuBar;
	private JMenu programs;
	private JButton exit;
	
	//windows
	private Console console;
	
	
	public GameWindow () {
		super("ExoComputers");
		setLayout(null);
		setExtendedState(MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		addWindowListener(this);
		
		//menu items
		this.menuBar = new JMenuBar();
		this.programs = new JMenu("Programs");
		this.exit = new JButton("exit");
		
		this.menuBar.add(this.programs);
		menuBar.add(Box.createHorizontalGlue());
		this.menuBar.add(this.exit);
		
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		setJMenuBar(menuBar);
		
		//windows
		this.console = new Console(400, 300);
		add(this.console);
		this.console.setVisible(true);
		
	}
	
	public void addProgramMenuItem(JComponent componet) {
		this.menuBar.add(componet);
	}
	
	public void addComponet (JInternalFrame frame) {
		this.add(frame);
	}
	
	
	
	@Override
 	public void windowClosing(WindowEvent e) {
		close();
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	private void close () {
		System.exit(0);
	}
	
}