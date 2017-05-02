package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.Registry;

public class Command_Modify extends Command_Common {
	public static final String CMD_NAME = "modify";

	@Override
	public int process(String[] args) throws ArgumentException {
		// TODO Auto-generated method stub
		int result = 0;
		int[] iArr = super.validate(args);

		switch (args.length) {
		case 2:
			result = modify(iArr[0], args[0]);
			break;
		case 3:
			result = modify(iArr[0], iArr[1], args[0]);
			break;
		case 4:
			result = modify(iArr[0], iArr[1], iArr[2], args[0]);
			break;
		default:
			throw new ArgumentException(args.length);
		}
		return result;
	}

	private int modify(int lineNum, String newStr) throws ArgumentException {
		return modify(lineNum, 0, newStr);
	}

	private int modify(int lineNum, int beginIdx, String newStr) throws ArgumentException {
		return modify(lineNum, beginIdx, Registry.getText().get(lineNum).length()-1, newStr);
	}

	private int modify(int lineNum, int beginIdx, int endIdx, String newStr) throws ArgumentException {
		try {
			Registry.getText().get(lineNum).replace(beginIdx, endIdx, newStr);
		} catch (StringIndexOutOfBoundsException e) {
			throw new ArgumentException(e, new int[] { beginIdx, endIdx });
		} catch (IndexOutOfBoundsException e) {
			throw new ArgumentException(e, lineNum);
		}
		return Registry.textLength();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return CMD_NAME + " : ";
	}
}
