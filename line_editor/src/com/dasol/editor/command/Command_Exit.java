package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.main.Main_Ui;
import com.dasol.editor.util.FileManager;

public class Command_Exit extends Command_Common {
	public static final String CMD_NAME = "exit";
	
	@Override
	public int process(String[] args) throws ArgumentException {
		// super.validate(args);
		if (args.length <= 0 || args.length > 3) {
			throw new ArgumentException(0);
		}

		if (args.length == 1) {
			Main_Ui.setExit();
		} else if (args.length == 2) {
			exit(args[1]);
		}

		return 0;
	}

	private void exit(String path) {
		FileManager.save_file(path , "UTF-8");
		Main_Ui.setExit();
	}

	@Override
	public String toString() {
		return CMD_NAME + " : 프로그램을 종료합니다";
	}

}
