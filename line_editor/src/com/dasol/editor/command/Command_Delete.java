package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.Registry;

public class Command_Delete extends Command_Common {
	public static final String CMD_NAME = "delete";

	@Override
	public int process(String[] args) throws ArgumentException {
		// TODO Auto-generated method stub
		int result = 0;
		int[] iArgs = super.validate(args);

		switch (iArgs.length) {
		case 0:
			result = deleteAll();
			break;
		case 1:
			result = delete(iArgs[0]);
			break;
		case 2:
			result = delete(iArgs[0] , iArgs[1]);
			break;
		case 3:
			result = delete(iArgs[0] , iArgs[1] , iArgs[2]);
			break;
		default:
			throw new ArgumentException(args.length);
		}
		return result;
	}

	private int delete(int lineNum) {
		Registry.getText().remove(lineNum);
		return Registry.textLength();
	}

	private int delete(int lineNum, int begin) {
		return delete(lineNum, begin, Registry.getText().get(lineNum).length());
	}

	private int delete(int lineNum, int begin, int end) {
		Registry.getText().get(lineNum).delete(begin, end);
		return Registry.textLength();
	}

	private int deleteAll() {
		Registry.getText().removeAll(null);
		return Registry.textLength();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return CMD_NAME;
	}

}
