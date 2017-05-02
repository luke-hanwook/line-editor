package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.Registry;

public class Command_Print extends Command_Common {
	public static final String CMD_NAME = "print";

	@Override
	public int process(String[] args) throws ArgumentException {
		// TODO Auto-generated method stub
		int[] iArgs = super.validate(args);
		switch (args.length) {
		case 1:
			print();
			break;
		case 2:
			print(iArgs[0]);
			break;
		default:
			break;
		}
		return Registry.textLength();
	}

	private void print() {
		for (int i = 0; i < Registry.textLength(); i++)
			print(i);
	}

	private void print(int lineNum) {
		System.out.println(Registry.getText().get(lineNum));
	}

	@Override
	public String toString() {
		return CMD_NAME + " : 불러온 텍스트파일을 콘솔에 출력합니다.";
	}

}
