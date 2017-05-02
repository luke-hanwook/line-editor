package com.dasol.editor.command;

import com.dasol.editor.exception.ArgumentException;

public interface Command {
	public int process(String[] args) throws ArgumentException;
}
