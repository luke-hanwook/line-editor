package com.dasol.editor.exception;

public class ArgumentException extends Exception {
	private Exception original;
	private int[] values;
	private String msg;
	
	public ArgumentException(Exception original , String msg) {
		this.original = original;
		this.msg = msg;
	}

	public ArgumentException(Exception original, int[] values) {
		this.values = values;
		this.original = original;
	}

	public ArgumentException(Exception original, int value) {
		this.values = new int[1];
		values[0] = value;
		this.original = original;
	}

	public ArgumentException(Exception original) {
		this.original = original;
	}

	public ArgumentException(int[] values) {
		this.values = values;
	}

	public ArgumentException(int value) {
		this.values = new int[1];
		values[0] = value;
	}

	public int getValue(int index) {
		return values[index];
	}

	public Exception getOriginal() {
		return original;
	}

	public int[] getValues() {
		return values;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
}
