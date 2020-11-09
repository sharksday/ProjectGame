package com.kassmon.game.frames;

import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;
import com.kassmon.assembly.commands.Command;
import com.kassmon.library.tokenizers.*;

public class Console extends JInternalFrame {
	//frame items
	private JTextArea consoleOutput = new JTextArea("test");
	private JScrollPane consoleOutputPanel = new JScrollPane(consoleOutput);
	private JTextField consoleInput = new JTextField();
	//tokenizer items
	private Tokenizer t = new Tokenizer();
	
	//Component flags
	
	private String mode = "command";
	
	//constructor and window code
	public Console (int width, int height) {
		super.addComponentListener(new ResizeListener());
		this.setClosable(true);
		this.setSize(width, height);
		this.setResizable(true);
		consoleOutputPanel.setSize(this.getWidth() - 20, this.getHeight() - 100);
		//consoleOutputPanel.setLocation(10, 10);
		consoleOutput.setEditable(false);
		consoleInput.setSize(this.getWidth() - 30, 20);
		consoleInput.setLocation(10, this.getHeight() - 60);
		
		this.add(this.consoleInput);
		this.add(this.consoleOutputPanel);
		
		setupTokenizer();
		
		this.consoleInput.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {inputEvent();}
		});
	}
	
	private void resize() {
		this.consoleOutputPanel.setSize(this.getWidth() - 20, this.getHeight() - 100);
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
		
		for (Command command : com.kassmon.util.Vars.masterCommandList) {
			t.addPattern(Pattern.compile("^( " + command.getPattern() + "\\b)"), "HelpArg");
		}
		
	}
	
	//Component code
	
	private void addLineToConsoleOutputa(String input) {
		 consoleOutput.setText(consoleOutput.getText() + input + System.lineSeparator());
	}
	
	//console input control
	private void inputEvent () {
		if (t.hasNextToken()) {
			Token token = t.getNextToken();
			if (token.getType().equals("command")) {
				switch (token.getToken()) {
					case "help":
						help();
					break;
					case "exit":
					
					break;
					case "clear":
						
					break;
					case "projects":
					
					break;
					case "mode":
					
					break;
				}
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
	
	
	
}