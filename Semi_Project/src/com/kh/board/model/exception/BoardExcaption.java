package com.kh.board.model.exception;

public class BoardExcaption extends RuntimeException{
	
	public BoardExcaption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardExcaption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BoardExcaption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BoardExcaption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BoardExcaption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
