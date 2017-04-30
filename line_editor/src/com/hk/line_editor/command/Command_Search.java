package com.hk.line_editor.command;

import com.hk.line_editor.exception.ArgumentException;
import com.hk.line_editor.util.Registry;

public class Command_Search extends Command_Common {
	public static final String CMD_NAME = "search";

	@Override
	public int process(String[] args) throws ArgumentException {
		// TODO Auto-generated method stub
		int result = 0;
		// int[] iArgs = super.validate(args);
		switch (args.length) {
		case 2:
			result = search(args[1]);
			break;
		case 3:
			result = search(Integer.parseInt(args[1]), args[2]);
			break;
		default:
			throw new ArgumentException(args.length);
		}
		return result;
	}

	private int search(String str) {
		int count = 0;
		int len = Registry.textLength();
		for (int i = 0; i < len; i++) {
			count += search(i, str);
		}
		return count;
	}

	private int search(int lineNum, String str) {
		int count = 0;
		StringBuffer line = Registry.getText().get(lineNum);
		for (int i = 0; i < line.length();) {
			i = line.indexOf(str, i);
			if (i >= 0) {
				count++;
				i++;
			} else {
				break;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		return CMD_NAME + " : 텍스트 파일에서 찾는 문자열의 갯수를 출력합니다.";
	}

}
