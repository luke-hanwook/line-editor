package com.hk.line_editor.command;

import com.hk.line_editor.exception.ArgumentException;

public interface Command {
	public int process(String[] args) throws ArgumentException;
}
