package com.kassmon.game.src.windows.console;

import java.util.regex.Pattern;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kassmon.library.tokenizers.Tokenizer;

public class Console {
	
	private Tokenizer tokenizer;
	private JTextArea consoleOutput;
	private JScrollPane consoleOutputPanel;
	private JTextField consoleInput;
	
	private void setupTokenizer () {
		tokenizer = new Tokenizer();
		//t.addPattern(Pattern.compile("^(\\b)"), "command");
		tokenizer.addPattern(Pattern.compile("^(exit\\b)"), "command");
		tokenizer.addPattern(Pattern.compile("^(clear\\b)"), "command");
		tokenizer.addPattern(Pattern.compile("^(help\\b)"), "command");
		tokenizer.addPattern(Pattern.compile("^(projects\\b)"), "command");
		tokenizer.addPattern(Pattern.compile("^(mode\\b)"), "command");
		
		tokenizer.addPattern(Pattern.compile("^([a-zA-Z0-9]+\\b)"), "arg");
	}
	
}
