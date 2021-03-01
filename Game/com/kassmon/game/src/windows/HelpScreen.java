package com.kassmon.game.src.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

import com.kassmon.game.src.windows.Console.ResizeListener;

@SuppressWarnings({ "unused", "serial" })
public class HelpScreen extends JInternalFrame {
	
	private String menuSl = "home";
	
	private JButton back, home, programingCommands, busItems, consoleCommands;
	private JButton branching, bus, control, math, output;
	private JButton nop, jmp, jsr, lda, ldb, mov, rsr, sta, stb;
	private JButton add, and, div, mod, mul, not, or, sub, xor;
	private JButton och, olf, onm;
	private JButton clk, psh, pul;
	private JButton cmp, jez, jnz, jgz, jlz;
	
	private JLabel[] nopL, jmpL, jsrL, ldaL, ldbL, movL, rsrL, staL, stbL;
	private JLabel[] addL, andL, divL, modL, mulL, notL, orL, subL, xorL;
	private JLabel[] ochL, olfL, onmL, clkL, pshL, pulL;
	private JLabel[] cmpL, jezL, jnzL, jgzL, jlzL;
	
	public HelpScreen() {
		super("Help");
		this.setSize(400, 300);
		this.setLayout(null);
		this.setResizable(false);
		this.setClosable(true);
		
		homeMenuINIT();
		programmingMenuINIT();
		programmingMathINIT();
		programmingControlMenuINIT();
		programmingBranchingMenuINIT();
		programmingBusMenuINIT();
		programmingOutputMenuINIT();
	}
	
	private void homeMenuINIT() {
		back = new JButton("back");
		home = new JButton("home");
		programingCommands = new JButton("Programing reference");
		busItems = new JButton("Bus reference");
		consoleCommands = new JButton("Console reference");
		
		home.setSize(70, 20);
		back.setSize(70, 20);
		programingCommands.setSize(200, 20);
		busItems.setSize(200, 20);
		consoleCommands.setSize(200, 20);
		
		back.setLocation(10, 0);
		home.setLocation(90, 0);
		programingCommands.setLocation(10, 30);
		busItems.setLocation(10, 60);
		consoleCommands.setLocation(10, 90);
		
		this.add(back);
		this.add(home);
		this.add(programingCommands);
		this.add(busItems);
		this.add(consoleCommands);
		
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisHomeMenu(true);
				menuSl = "home";
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				switch (menuSl) {
					case "command":
						setVisHomeMenu(true);
						menuSl = "home";
						break;
					case "math":
					case "control":
					case "branching":
					case "bus":
					case "output":
						setVisProgrammingCommandMenu(true);
						menuSl = "command";
						break;
				}
			}
		});
		
		programingCommands.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisProgrammingCommandMenu(true);
				menuSl = "command";
			}
		});
		
	}
	
	private void programmingMenuINIT() {
		branching = new JButton("Branching");
		bus = new JButton("Bus");
		control = new JButton("Control");
		math = new JButton("Math");
		output = new JButton("Output");
		
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
		
		setVisProgrammingCommandMenu(false);
		
		math.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisProgrammingMathMenu(true);
				menuSl = "math";
			}
		});
		
		control.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisProgrammingControlMenu(true);
				menuSl = "control";
			}
		});
		
		branching.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisProgrammingBranchingMenu(true);
				menuSl = "branching";
			}
		});
		
		bus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisProgrammingBusMenu(true);
				menuSl = "bus";
			}
		});
		
		output.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visAllMenusFalse();
				setVisProgrammingOutputMenu(true);
				menuSl = "output";
			}
		});
		
	}
	
	private void programmingMathINIT() {
		add = new JButton("add");
		and = new JButton("and");
		div = new JButton("div");
		mod = new JButton("mod");
		mul = new JButton("mul");
		not = new JButton("not");
		or = new JButton("or");
		sub = new JButton("sub");
		xor = new JButton("xor");
		
		add.setSize(60, 20);
		and.setSize(60, 20);
		div.setSize(60, 20);
		mod.setSize(60, 20);
		mul.setSize(60, 20);
		not.setSize(60, 20);
		or.setSize(60, 20);
		sub.setSize(60, 20);
		xor.setSize(60, 20);
		
		add.setLocation(10, 30);
		sub.setLocation(100, 30);
		mul.setLocation(10, 60);
		div.setLocation(100, 60);
		mod.setLocation(200, 60);
		not.setLocation(10, 90);
		and.setLocation(10, 120);
		or.setLocation(10, 150);
		xor.setLocation(100, 150);
		
		this.add(add);
		this.add(and);
		this.add(div);
		this.add(mod);
		this.add(mul);
		this.add(not);
		this.add(or);
		this.add(sub);
		this.add(xor);
		
		setVisProgrammingMathMenu(false);
	}
	
	private void programmingControlMenuINIT() {
		nop = new JButton("nop");
		jmp = new JButton("jmp");
		jsr = new JButton("jsr");
		lda = new JButton("lda");
		ldb = new JButton("ldb");
		mov = new JButton("mov");
		rsr = new JButton("rsr");
		sta = new JButton("sta");
		stb = new JButton("stb");
		
		nop.setSize(60, 20);
		jmp.setSize(60, 20);
		jsr.setSize(60, 20);
		lda.setSize(60, 20);
		ldb.setSize(60, 20);
		mov.setSize(60, 20);
		rsr.setSize(60, 20);
		sta.setSize(60, 20);
		stb.setSize(60, 20);
		
		nop.setLocation(10, 30);
		jmp.setLocation(10, 60);
		jsr.setLocation(10, 90);
		lda.setLocation(10, 120);
		ldb.setLocation(10, 150);
		mov.setLocation(10, 180);
		rsr.setLocation(100, 90);
		sta.setLocation(100, 120);
		stb.setLocation(100, 150);
		
		this.add(nop);
		this.add(jmp);
		this.add(jsr);
		this.add(lda);
		this.add(ldb);
		this.add(mov);
		this.add(rsr);
		this.add(sta);
		this.add(stb);
		
		setVisProgrammingControlMenu(false);
		
	}
	
	private void programmingBranchingMenuINIT() {
		cmp = new JButton("cmp");
		jez = new JButton("jez");
		jnz = new JButton("jnz");
		jgz = new JButton("jgz");
		jlz = new JButton("jlz");
		
		cmp.setSize(60, 20);
		jez.setSize(60, 20);
		jnz.setSize(60, 20);
		jgz.setSize(60, 20);
		jlz.setSize(60, 20);
		
		cmp.setLocation(10, 30);
		jez.setLocation(10, 60);
		jnz.setLocation(10, 90);
		jgz.setLocation(10, 120);
		jlz.setLocation(10, 150);
		
		this.add(cmp);
		this.add(jez);
		this.add(jnz);
		this.add(jgz);
		this.add(jlz);
		
		setVisProgrammingBranchingMenu(false);
		
	}
	
	private void programmingBusMenuINIT() {
		clk = new JButton("clk");
		psh = new JButton("psh");
		pul = new JButton("pul");
		
		clk.setSize(60, 20);
		psh.setSize(60, 20);
		pul.setSize(60, 20);
		
		clk.setLocation(10, 30);
		psh.setLocation(10, 60);
		pul.setLocation(10, 90);
		
		this.add(clk);
		this.add(psh);
		this.add(pul);
		
		setVisProgrammingBusMenu(false);
		
	}
	
	private void programmingOutputMenuINIT() {
		och = new JButton("och");
		olf = new JButton("olf");
		onm = new JButton("onm");
		
		och.setSize(60, 20);
		olf.setSize(60, 20);
		onm.setSize(60, 20);
		
		och.setLocation(10, 30);
		olf.setLocation(10, 60);
		onm.setLocation(10, 90);
		
		this.add(och);
		this.add(olf);
		this.add(onm);
		
		setVisProgrammingOutputMenu(false);
		
	}
	
	private void visAllMenusFalse() {
		setVisHomeMenu(false);
		setVisProgrammingCommandMenu(false);
		setVisProgrammingMathMenu(false);
		setVisProgrammingControlMenu(false);
		setVisProgrammingBranchingMenu(false);
		setVisProgrammingBusMenu(false);
		setVisProgrammingOutputMenu(false);
	}
	
	private void setVisHomeMenu(boolean vis) {
		this.programingCommands.setVisible(vis);
		this.busItems.setVisible(vis);
		this.consoleCommands.setVisible(vis);
	}
	
	private void setVisProgrammingCommandMenu(boolean vis) {
		this.branching.setVisible(vis);
		this.bus.setVisible(vis);
		this.control.setVisible(vis);
		this.math.setVisible(vis);
		this.output.setVisible(vis);
	}
	
	private void setVisProgrammingMathMenu(boolean vis) {
		add.setVisible(vis);
		and.setVisible(vis);
		div.setVisible(vis);
		mod.setVisible(vis);
		mul.setVisible(vis);
		not.setVisible(vis);
		or.setVisible(vis);
		sub.setVisible(vis);
		xor.setVisible(vis);
	}
	
	private void setVisProgrammingControlMenu(boolean vis) {
		nop.setVisible(vis);
		jmp.setVisible(vis);
		jsr.setVisible(vis);
		lda.setVisible(vis);
		ldb.setVisible(vis);
		mov.setVisible(vis);
		rsr.setVisible(vis);
		sta.setVisible(vis);
		stb.setVisible(vis);
	}
	
	private void setVisProgrammingBranchingMenu(boolean vis) {
		cmp.setVisible(vis);
		jez.setVisible(vis);
		jnz.setVisible(vis);
		jgz.setVisible(vis);
		jlz.setVisible(vis);
	}
	
	private void setVisProgrammingBusMenu(boolean vis) {
		clk.setVisible(vis);
		psh.setVisible(vis);
		pul.setVisible(vis);
	}
	
	private void setVisProgrammingOutputMenu(boolean vis) {
		och.setVisible(vis);
		olf.setVisible(vis);
		onm.setVisible(vis);
	}
	
	
	
}