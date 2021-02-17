package com.kassmon.game.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import com.kassmon.game.windows.Console.ResizeListener;

@SuppressWarnings({ "unused", "serial" })
public class HelpScreen extends JInternalFrame {
	
	private String menuSl = "home";
	
	private JButton back;
	private JButton home;
	private JButton branching, bus, control, math, output;
	private JButton nop, jmp, jsr, lda, ldb, mov, rsr, sta, stb;
	private JButton add, and, div, mod, mul, not, or, sub, xor;
	private JButton och, olf, onm;
	private JButton clk, psh, pul;
	private JButton cmp, jez, jnz, jgz, jlz;
	
	public HelpScreen() {
		super("Help");
		this.setSize(400, 300);
		this.setLayout(null);
		this.setResizable(false);
		this.setClosable(true);
		//controls
		back = new JButton("back");
		home = new JButton("home");
		home.setSize(70, 20);
		back.setSize(70, 20);
		back.setLocation(10, 0);
		home.setLocation(90, 0);
		this.add(back);
		this.add(home);
		
		//menu items
		branching = new JButton("Branching Commands");
		bus = new JButton("Bus Commands");
		control = new JButton("Control Commands");
		math = new JButton("Math Commands");
		output = new JButton("Output Commands");
		
		branching.setSize(170, 20);
		bus.setSize(170, 20);
		control.setSize(170, 20);
		math.setSize(170, 20);
		output.setSize(170, 20);
		
		branching.setLocation(10, 90);
		bus.setLocation(10, 120);
		control.setLocation(10, 60);
		math.setLocation(10, 30);
		output.setLocation(10, 150);
		
		this.add(branching);
		this.add(bus);
		this.add(control);
		this.add(math);
		this.add(output);
		
		
		
	}
	
	private void setVisHomeMenu(boolean vis) {
		this.branching.setVisible(vis);
		this.bus.setVisible(vis);
		this.control.setVisible(vis);
		this.math.setVisible(vis);
		this.output.setVisible(vis);
	}
	
	private void events() {
		this.home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisHomeMenu(true);	
			}
		});
	}
	
}
