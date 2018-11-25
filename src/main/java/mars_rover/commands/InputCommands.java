package mars_rover.commands;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputCommands {
	private Logger logger = Logger.getLogger(getClass().getName());

	private ArrayList<Character> listOfCommands = new ArrayList<>();

	public InputCommands(String listOfCommands) {
		stringToCommandsList(listOfCommands);
	}

	public void setListOfCommands(String listOfCommands) {
		stringToCommandsList(listOfCommands);
	}

	private void stringToCommandsList(String commands) {
		int listSize = commands.length();
		this.listOfCommands.clear();

		for (int i = 0; i < listSize; i++) {
			char ch = Character.toUpperCase(commands.charAt(i));
			if (ch == 'B' || ch == 'F' || ch == 'L' || ch == 'R')
				this.listOfCommands.add(ch);
			else
				logger.log(Level.WARNING,"Ignoring unknown input command: " + ch);
		}
	}

	public List<Character> getListOfCommands() {
		return this.listOfCommands;
	}
}