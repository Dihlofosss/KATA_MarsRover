package MarsRover.Commands;

import java.util.ArrayList;

public class InputCommands {
	private ArrayList<Character> _listOfCommands = new ArrayList<>();

	public InputCommands() {
	}

	public InputCommands(String listOfCommands) {
		stringToCommandsList(listOfCommands);
	}

	public void set_listOfCommands(String listOfCommands) {
		stringToCommandsList(listOfCommands);
	}

	private void stringToCommandsList(String commands) {
		int listSize = commands.length();
		this._listOfCommands.clear();

		for (int i = 0; i < listSize; i++) {
			char ch = Character.toUpperCase(commands.charAt(i));
			if (ch == 'B' || ch == 'F' || ch == 'L' || ch == 'R')
				this._listOfCommands.add(ch);
		}
	}

	public ArrayList<Character> get_listOfCommands() {
		return this._listOfCommands;
	}
}