package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.main.Main_Ui;
import com.dasol.editor.util.FileManager;
import com.dasol.editor.util.Registry;

public class Command_Load extends Command_Common {
	public static final String CMD_NAME = "load";

	@Override
	public int process(String[] args) throws ArgumentException {

		if (args.length <= 1 || args.length > 3)
			throw new ArgumentException(null , 0);
		if(args.length == 2)
			load(args[1]);
		else if (args.length == 3)
			load(args[1], args[2]);
		return Registry.textLength();
	}

	private void load(String path) throws ArgumentException{
		Main_Ui.setCurrentFile(FileManager.load_file(path, "UTF-8"));
		
	}
	private void load(String path , String encoding) throws ArgumentException{
		Main_Ui.setCurrentFile(FileManager.load_file(path , encoding));
	}

	@Override
	public String toString() {
		return CMD_NAME + " : 텍스트 파일을 불러옵니다.";
	}

}
