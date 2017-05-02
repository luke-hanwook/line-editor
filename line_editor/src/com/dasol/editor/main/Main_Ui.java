package com.dasol.editor.main;

import java.io.IOException;
import java.util.Scanner;

import com.dasol.editor.command.Command;
import com.dasol.editor.exception.ArgumentException;
import com.dasol.editor.util.Registry;

public class Main_Ui {
	private static final String INIT_MSG = "파일을 load 해라";
	private static boolean isExit;
	private static String currentFile = INIT_MSG;

	public static void setCurrentFile(String fileName) {
		currentFile = fileName;
	}

	public static void resetCurrentFile() {
		currentFile = INIT_MSG;
	}

	public static void setExit() {
		isExit = true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Registry.init();
		while (!isExit) {
			System.out.printf("%s>", currentFile);
			String input = sc.nextLine();
			String[] arrCommand = parse(input);
			String cmd = arrCommand[0];
			Command command = Registry.getCommandObject(cmd);
			if (isCheck(cmd)) {
				System.out.print("문자열을 입력하거라>>");
				arrCommand[0] = sc.nextLine();
			}
			try {
				if (command != null) {
					int result = command.process(arrCommand);
					if (cmd.equals("search")) {
						System.out.printf("검색 결과 : %d개\n", result);
						continue;
					}
					if (cmd.equals("exit")) {
						continue;
					}
					System.out.println("[line 개수 : " + result + "]");
				} else {
					System.out.println("[" + cmd + "]" + "명령어를 찾을 수 없습니다.");
				}
			} catch (ArgumentException e) {
				System.out.println(e.getOriginal());
				if (e.getOriginal() instanceof IOException) {
					System.out.println("[" + e.getMessage() + "]" + "파일이 없습니다.");
					continue;
				}
				if (e.getOriginal() instanceof NumberFormatException) {
					System.out.println(arrCommand[e.getValue(0)] + "는 정수로 변환할 수 없습니다.");
					continue;
				}
				if (e.getOriginal() instanceof StringIndexOutOfBoundsException) {
					System.out.print("index 오류 : ");
					int[] values = e.getValues();
					for (int i = 0; i < values.length; i++) {
						System.out.printf("%d ", values[i]);
					}
					System.out.println();
					continue;
				}
				if (e.getOriginal() instanceof IndexOutOfBoundsException) {
					System.out.println(Registry.textLength() + "<" + e.getValue(0));
					continue;
				}
				if (e.getOriginal() == null) {
					System.out.println("argument 개수 오류 : " + e.getValue(0));
					continue;
				}

			}
		}
		sc.close();

	}

	private static boolean isCheck(String cmdStr) {
		// TODO Auto-generated method stub
		boolean isc = false;
		if (cmdStr.equals("append") || cmdStr.equals("insert") || cmdStr.equals("modify")) {
			isc = true;
		}
		return isc;
	}

	private static String[] parse(String command) {
		String[] arrCommand = command.split(" ");
		return arrCommand;
	}

}
