/************************************************************
 * 
 * A class that creates a node of type temperature
 * 
 * 
 *
 */
public class TemperatureNode {
	
	Temperature temp;
	TemperatureNode next;
	
	/**
	 * Default Constructor
	 */
	public TemperatureNode() {
		temp = new Temperature();
		next = null;
	}
		
	/**
	 * Parameterized Constructor
	 * 
	 * @param t object of type Temperature
	 */
	public TemperatureNode(Temperature t) {
		temp = new Temperature(t.getTemperature());
		next = null;
	}
}
