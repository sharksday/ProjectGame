package com.kassmon.game.src.levels;

import java.util.ArrayList;

import com.kassmon.assembly.runTime.RuntimeController;

public abstract class Level {
	
	public ArrayList<String> programLineArray(String input) {
		String[] temp = input.split("\n");
		ArrayList<String> list = new ArrayList<>();
		for (String obj: temp) list.add(obj);
		return list;
	}
	
	public abstract String getName();
	public abstract String getDescription();
	
	public abstract String getProblem();
	public abstract boolean checkProgram(RuntimeController controller);
	
	public abstract String getProgramString();
	public abstract void setProgramString();
	
	
	
}
