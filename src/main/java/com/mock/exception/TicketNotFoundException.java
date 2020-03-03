package com.mock.exception;

public class TicketNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketNotFoundException(String message) {
		super(message);
	}

	public TicketNotFoundException(Throwable cause) {
		super(cause);
	}

//	public ItemNotFoundException() {
//		super("No Items to Display");
//		
//	}
//
//	public ItemNotFoundException(String itemName) {
//		super("This item "+itemName+ "not available");
//		
//	}
//
//	public ItemNotFoundException(Long id) {
//		super("This id "+id+"not found");
//		
//	}
	

}
