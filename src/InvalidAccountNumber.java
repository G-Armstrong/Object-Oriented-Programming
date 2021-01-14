import java.lang.Exception;

public class InvalidAccountNumber extends Exception {
	/**
	 * Constructor with no parameters that references the super class Extension
	 */
	
	public InvalidAccountNumber() {
		super();
	}
	/**
	 * Constructor with parameter message
	 * @param message to be returned when exception is caught
	 */
	public InvalidAccountNumber(String message) {
		super(message);
	}
}
