package com.kassmon.game.src;

import java.awt.event.*;
import javax.swing.*;

import com.kassmon.game.windows.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements WindowListener{
	
	//menu items
	private JMenuBar menuBar;
	private JMenu programs;
	private JButton exit;
	private JButton consoleButton;
	private JButton helpScreenButton;
	
	//windows
	private Console console;
	private HelpScreen helpScreen;
	
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
		this.consoleButton = new JButton("Console");
		this.helpScreenButton = new JButton("Help");
		
		this.menuBar.add(this.programs);
		this.programs.add(consoleButton);
		this.programs.add(this.helpScreenButton);
		menuBar.add(Box.createHorizontalGlue());
		this.menuBar.add(this.exit);
		
		this.consoleButton.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					console.setVisible(!console.isVisible());
				}
			});
		
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		this.helpScreenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helpScreen.setVisible(!helpScreen.isVisible());
			}
		});
		
		setJMenuBar(menuBar);
		
		//windows
		this.console = new Console(400, 300);
		add(this.console);
		this.console.setVisible(true);
		this.helpScreen = new HelpScreen();
		this.add(this.helpScreen);
		this.helpScreen.setVisible(true);
		
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
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}
	
	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}
	
	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}
	
	private void close () {
		System.exit(0);
	}
	
}