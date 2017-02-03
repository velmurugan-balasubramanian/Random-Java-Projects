import java.text.DecimalFormat;

/***************************************************************
 * 
 * A class that works with Temperature values 
 *  
 * 
 * 
 */

public class Temperature {
	
	private float tc;	/*Temperature in degree celsuis */
	
	/**
	 * Default Constructor
	 */
	public Temperature() {
		tc = 0.0f;
	}
	
	/**
	 * Parameterized constructor 
	 * 
	 * @param tc value is assigned as temperature
	 * in degree celsius
	 */
	public Temperature(float tc) {
		this.tc = tc;
	}
	
	/**
	 * Assigns temperature
	 * 
	 * @param tc sets degree celsius value
	 * 
	 */
	public void setTemperature(float tc) {
		this.tc = tc;
	}
	
	/**
	 * Obtains current temperature	
	 * 
	 * @return temperature in degree celsius
	 */
	public float getTemperature() {
		return tc;
	}
	
	/**
	 * Checks whether two objects are equal
	 * 
	 * @param other object to be compared with
	 * @return true if equal 
	 * and false if not equal
	 */
	public boolean equals(Object other) {
		return ( 	other != null
				&&  getClass() == other.getClass()
				&&  tc == ((Temperature) other).tc	/* Compares celsius temperatures of both objects */
			   );
	}
	
	/**
	 * Compares two temperature objects	
	 * based on the differences in value 
	 * 	
	 * @param other Temperature object
	 * to be compared
	 * @return 1 if difference is greater than 0
	 * -1 if difference is less than 0 and
	 * 0 if difference is equal to 0
	 */
	public int compareTo(Temperature other) {
		float diff = tc - other.tc;
		int res = 0;
		
		if (diff > 0)
			res = 1;
		else if (diff < 0)
			res = -1;
		else if (diff == 0)
			res = 0;
		
		return res;
	}
	
	/**
	 * Displays temperature in one decimal place
	 * 
	 * @return String representing temperature(degree celsius)
	 * in one decimal place	
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return (df.format(tc));
	}
	
}
