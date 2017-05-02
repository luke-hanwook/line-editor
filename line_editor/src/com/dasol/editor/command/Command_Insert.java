package com.dasol.editor.command;

import java.util.List;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.Registry;

public class Command_Insert extends Command_Common {
	public static final String CMD_NAME = "insert";

	@Override
	public int process(String[] args) throws ArgumentException {
		int result = 0;
		int[] iArgs = super.validate(args);

		// 파라미터가 없거나, 넘을 경우
		// validation check
		switch (iArgs.length) {
		case 1:
			result = insert(iArgs[0] , args[0]);
			break;
		case 2:
			result = insert(iArgs[0] , iArgs[1], args[0]);
			break;
		default:
			throw new ArgumentException(args.length);
		}
//		if (args.length <= 2 || args.length > 3) {
//			throw new ArgumentException(args.length);
//		}

//		if (args.length == 3) { // 새로운 LINE을 만들어서 지정한 라인에 삽입(+1)
//			result = insert(iArgs[0], args[0]);
//		} else if (args.length == 4) { // 선택된 LINE에서 지정한 위치에 삽입
//			result = insert(iArgs[0], iArgs[1], args[0]);
//		}

		return result;
	}

	// 새로운 LINE을 만들어서 지정한 라인에 삽입(+1)
	private int insert(int line, String newString) {
		List<StringBuffer> lineList = Registry.getText();
		lineList.add(line, new StringBuffer(newString));
		return Registry.textLength();
	}

	// 선택된 LINE에서 지정한 위치에 삽입
	private int insert(int line, int offset, String newString) {
		StringBuffer str = Registry.getText().get(line);
		str.insert(offset, newString);
		return Registry.textLength();
	}

	@Override
	public String toString() {
		return CMD_NAME + " : 새로운 내용을 기존의 라인 또는 라인 안에 삽입합니다.";
	}
}
