/****************************************************************
 * 
 * A class that applies Selection Sort 
 * to the array of Temperature objects
 * 
 * @author Renuka Anbalagan Lab Section 03
 *
 */
public class SelectionSort {
	
	/**
	 * Sorts the array of Temperature objects in ascending order
	 * 
	 * @param tempArray array of temperature objects
	 * @param length length filled in the array of Temperature objects
	 */
	public static void selectionSort(Temperature[] tempArray, int length) { 
		
		for ( int i = 0; i < length - 1; i++ ) { 
			int indexLowest = i; 
			
			for ( int j = i + 1; j < length; j++ ) 
				if (tempArray[j].getTemperature() < tempArray[indexLowest].getTemperature()) 
					indexLowest = j;
			
			if (tempArray[indexLowest].getTemperature() != tempArray[i].getTemperature()) { 
				
				float temp = tempArray[indexLowest].getTemperature();
				tempArray[indexLowest].setTemperature(tempArray[i].getTemperature()); 
				tempArray[i].setTemperature(temp); 
			}
		}
	} 
}

