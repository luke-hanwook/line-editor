package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.FileManager;
import com.dasol.editor.util.Registry;

public class Command_Save extends Command_Common{
	public static final String CMD_NAME = "save";
	@Override
	public int process(String[] args) throws ArgumentException {
		
		if(args.length <= 1 || args.length > 3)
			throw new ArgumentException(null , "");
		
		if(args.length == 2)
			save(args[1]);
		else if(args.length == 3)
			save(args[1], args[2]);
		return Registry.textLength();
	}

	private void save(String path) {
		FileManager.save_file(path , "UTF-8");
	}
	
	private void save(String path, String encoding) {
		FileManager.save_file(path, encoding);
	}

	@Override
	public String toString() {
		return CMD_NAME+" : 작업한 내용을 수정합니다.";
	}
}
