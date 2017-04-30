package com.hk.line_editor.command;

import com.hk.line_editor.exception.ArgumentException;
import com.hk.line_editor.util.Registry;

public abstract class Command_Common implements Command {
	protected int[] validate(String[] args) throws ArgumentException {
		int[] iArr = new int[args.length - 1];
		int i = 0;
		try {
			for (; i < args.length - 1; i++) {
				iArr[i] = Integer.parseInt(args[i + 1]);
			}
			if(iArr.length == 0)
				return iArr;
			if (Registry.textLength() < iArr[0]) {
				throw new ArgumentException(new IndexOutOfBoundsException(), iArr[0]);
			}
		} catch (NumberFormatException e) {
			throw new ArgumentException(e, iArr[i]);
		}
		return iArr;
	}
}
