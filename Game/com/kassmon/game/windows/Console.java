package com.kassmon.game.windows;

import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;
import com.kassmon.library.tokenizers.*;

public class Console extends JInternalFrame {
	
	//frame items
	private JTextArea consoleOutput = new JTextArea("");
	private JScrollPane consoleOutputPanel = new JScrollPane(consoleOutput);
	private JTextField consoleInput = new JTextField();
	
	//tokenizer items
	private Tokenizer t = new Tokenizer();
	
	//Component flags
	private String mode = "command";
	private int level = 0;
	private int project = 0;
	
	//constructor and window code
	public Console (int width, int height) {
		super("Console");
		super.addComponentListener(new ResizeListener());
		super.setLayout(null);
		this.setClosable(true);
		this.setSize(width, height);
		this.setResizable(true);
		consoleOutput.setEditable(false);
		this.consoleOutputPanel.setLocation(10, 10);
		this.resize();
		
		this.add(this.consoleInput);
		this.add(this.consoleOutputPanel);
		
		setupTokenizer();
		
		this.consoleInput.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {inputEvent();}
		});
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
	
	//tokenizer code
	private void setupTokenizer () {
		//t.addPattern(Pattern.compile("^(\\b)"), "command");
		t.addPattern(Pattern.compile("^(exit\\b)"), "command");
		t.addPattern(Pattern.compile("^(clear\\b)"), "command");
		t.addPattern(Pattern.compile("^(help\\b)"), "command");
		t.addPattern(Pattern.compile("^(projects\\b)"), "command");
		t.addPattern(Pattern.compile("^(mode\\b)"), "command");
		
		t.addPattern(Pattern.compile("^([a-zA-Z0-9]+\\b)"), "arg");
	}
	
	//Component code
	private void addLineToConsoleOutputa(String input) {
		 consoleOutput.setText(consoleOutput.getText() + input + System.lineSeparator());
	}
	
	//console input control
	private void inputEvent () {
		t.setInput(this.consoleInput.getText());
		this.consoleInput.setText("");
		if (t.hasNextToken()) {
			Token token = t.getNextToken();
			if (token.getType().equals("command")) {
				switch (token.getToken()) {
					case "help":
						help();
					break;
					case "exit":
						exit();
					break;
					case "clear":
						clear();
					break;
					case "projects":
						projects();
					break;
					case "mode":
						mode();
					break;
					
				}
			}else {
				addLineToConsoleOutputa("input invalid");
			}
		}
	}
	
	private void help() {
		if (mode.equals("command")) {
			if (!t.hasNextToken()) {
				addLineToConsoleOutputa("Commands you can use");
				addLineToConsoleOutputa("\"help\"");
				addLineToConsoleOutputa("\"exit\"");
				addLineToConsoleOutputa("\"clear\"");
				addLineToConsoleOutputa("\"projects\"");
				addLineToConsoleOutputa("\"mode\"");
			}else {
				Token token = t.getNextToken();
				if (token.getType().equals("")) {
					
				}
			}
		}
	}
	
	private void exit() {
		super.setVisible(false);
	}
	
	private void clear() {
		this.consoleOutput.setText("");
	}
	
	private void projects() {
		if (!t.hasNextToken()) {
			
		}else {
			switch (t.getNextToken().getToken()) {
				case "list":
				break;
				case "open":
				break;
				case "save":
				break;
				case "clear":
				break;
				case "description":
				break;
				case "check":
				break;
				case "test":
				break;
				case "help":
				break;
			}
		}
	}
	
	private void mode() {
		if (!t.hasNextToken()) {
			addLineToConsoleOutputa("Console mode is " + this.mode);
		}else {
			switch (t.getNextToken().getToken()) {
				case "switch":
					if (!t.hasNextToken()) {
						addLineToConsoleOutputa("No mode to switch to !error");
					}else {
						Token tmp = t.getNextToken();
						switch (tmp.getToken()) {
							case "command":
							case "program":
								this.mode = tmp.getToken();
								addLineToConsoleOutputa("Mode switch to " + this.mode);
							break;
							default:
								addLineToConsoleOutputa("!input error");
							break;
						}
					}
				break;
				case "list":
					if (!t.hasNextToken()) {
						addLineToConsoleOutputa("Command: navigation and main control mode");
						addLineToConsoleOutputa("Program: programming and programming info mode");
					}
				break;
					
			}
		}
	}
	
	
	
}