package com.hk.line_editor.command;

import java.util.List;

import com.hk.line_editor.exception.ArgumentException;
import com.hk.line_editor.util.Registry;

public class Command_Append extends Command_Common {
	public static final String CMD_NAME = "append";
	@Override
	public int process(String[] args) throws ArgumentException {
		int result = 0;
		int[] iArgs = super.validate(args);
		// 파라미터가 없거나, 넘을 경우 
		// validation check
		if(args.length < 1 || args.length > 3) { 
			throw new ArgumentException(args.length);
		}
		
		// 전체 텍스트의 뒤에 추가(+1)
		if (args.length == 1) { 
			result = append(args[0]);
		// 선택된 Line의 뒤에 추가
		} else if (args.length == 2){ 
			result = append(iArgs[0], args[0]);
		}
		
		// 해당 문서의 전체 라인 수
		return result;
	}
	
	// 전체 텍스트의 뒤에 추가(+1)
	// 새로운 라인에 뉴스트링 추가.. 
	private int append(String newString) {
		List<StringBuffer> lineList = Registry.getText();
		lineList.add(new StringBuffer(newString));
		return Registry.textLength();
	}
	
	// 선택된 Line의 뒤에 추가
	private int append(int line, String newString) {
		StringBuffer str = Registry.getText().get(line);
		str.append(newString);
		return Registry.textLength();
	}

	@Override
	public String toString() {
		return CMD_NAME+" : 원하는 위치의 문장 뒤에 문자열을 추가합니다.";
	}

}