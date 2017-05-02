package com.dasol.editor.command;

import java.util.Iterator;
import java.util.Map;

import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.Registry;

public class Command_Help extends Command_Common {
	public static final String CMD_NAME = "help";

	@Override
	public int process(String[] args) throws ArgumentException {
		help();
		return 0;
	}

	private void help() {

		Map<String, Command> map = Registry.getCommandMap();
		Iterator<String> iter = map.keySet().iterator();

		/*
		 * Map<String, String> map = new HashMap<String,String>(); map.put("a",
		 * "1"); map.put("b", "1"); map.put("c", "1");
		 * 
		 * Set<String> mapList = map.keySet(); Iterator<String> iter =
		 * mapList.iterator();
		 */
		while (iter.hasNext()) {
			System.out.println(map.get(iter.next()).toString());

		}

	}

	@Override
	public String toString() {
		return CMD_NAME + " : 도움말을 출력합니다.";
	}

}
