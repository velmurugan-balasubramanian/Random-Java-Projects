/******************************************************************************************
 * A class that deals with Illegal Temperature Exceptions
 * 
 *
 *
 */
@SuppressWarnings("serial")
public class IllegalTemperatureException extends IllegalArgumentException {

	/**
	 * Parameterized Constructor
	 * 
	 * @param message Message to be displayed at the console 
	 * when Exception is caught
	 */
	public IllegalTemperatureException(String message) {
		super(message);
	}
}
