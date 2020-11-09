package com.kassmon.game.levels;

import javax.swing.JInternalFrame;

public interface Level {
	String getName();
	String getDescription();
	
	JInternalFrame getCodeEditer();
	
}
