package catan;

public class InvalidExchangeException extends Exception {
	public InvalidExchangeException() {
		super("You can't exchange resources of the same type.");
	}
}
