package com.dasol.editor.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dasol.editor.command.Command;
import com.dasol.editor.command.Command_Append;
import com.dasol.editor.command.Command_Delete;
import com.dasol.editor.command.Command_Exit;
import com.dasol.editor.command.Command_Help;
import com.dasol.editor.command.Command_Insert;
import com.dasol.editor.command.Command_Load;
import com.dasol.editor.command.Command_Modify;
import com.dasol.editor.command.Command_Print;
import com.dasol.editor.command.Command_Save;
import com.dasol.editor.command.Command_Search;

public class Registry {
	private static Map<String, Command> commandMap = new HashMap<>();
	private static List<StringBuffer> text;
	
	public static void init() {
		commandMap.put(Command_Load.CMD_NAME, new Command_Load());
		commandMap.put(Command_Save.CMD_NAME, new Command_Save());
		commandMap.put(Command_Exit.CMD_NAME, new Command_Exit());
		commandMap.put(Command_Append.CMD_NAME, new Command_Append());
		commandMap.put(Command_Insert.CMD_NAME, new Command_Insert());
		commandMap.put(Command_Delete.CMD_NAME, new Command_Delete());
		commandMap.put(Command_Modify.CMD_NAME, new Command_Modify());
		commandMap.put(Command_Search.CMD_NAME, new Command_Search());
		commandMap.put(Command_Print.CMD_NAME, new Command_Print());
		commandMap.put(Command_Help.CMD_NAME, new Command_Help());
	}
	
	public static Command getCommandObject(String command) {
		return commandMap.get(command);
	}

	public static List<StringBuffer> getText() {
		return text;
	}
	
	public static void register(List<StringBuffer> lineList) {
		text = lineList;
	}
	
	public static void unRegister() {
		text = null;
	}

	public static int textLength() {
		if(text == null) {
			return 0;
		}
		return text.size();
	}
	
	public static Map<String, Command> getCommandMap(){
		return commandMap;
	}
}
