 /********************************************************************************
 * 
 * A class that arranges the temperature node in ascending order
 * 
 * @author Renuka Anbalagan Lab Section 03
 *
 */
public class TemperatureList {

	private TemperatureNode first = new TemperatureNode();
	private TemperatureNode last = first;
	private int length = 0;
	
	/**
	 * Obtains length
	 * 
	 * @return length of the list
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Inserts a node into the list 
	 * and keeps them in ascending order
	 * 
	 * @param t Temperature object to be made into a node
	 * and inserted into the list
	 */
	public void insert(Temperature t) {
		
		TemperatureNode tNew = new TemperatureNode(t);
		TemperatureNode prevNode = first;
		int insertFlag = 0;
		
		if (first == last) {							/* Insert node in empty list */
			
			first.next = tNew;
			last = tNew;
			insertFlag = 1;
		}
		else {
			
			TemperatureNode nextNode = prevNode.next;
							
			while (nextNode != null) {
				
				/* Checks whether the new node is smaller than 
				 * or equal to the next node pointed in the list and inserts accordingly */
				if (nextNode.temp.compareTo(tNew.temp) >= 0) {		
				
					tNew.next = nextNode;
					prevNode.next = tNew;
					insertFlag = 1;
					break;
				}
			
				prevNode = prevNode.next;
				nextNode = nextNode.next;
			}
			
			if (insertFlag == 0 && nextNode == null) {		/* Appends the node */
				
				last.next = tNew;
				last = tNew;
				insertFlag = 1;
			}
		}
		length++;
	}
	
	/**
	 * A class that concatenates the data in the List
	 * 
	 * @return data in Temperature nodes of the List
	 * as a single string
	 */
	public String toString() {
		TemperatureNode tNode = first.next;
		String tempString = "";
		
		while ( tNode != null) {
			tempString += tNode.temp.toString() +" C\n";
			tNode = tNode.next;
		}
		
		return tempString;
	}	
	/**
	 * Resets the list
	 */
	public void clearList() {
		first = new TemperatureNode();
		last = first;
		length = 0;
	}
}
