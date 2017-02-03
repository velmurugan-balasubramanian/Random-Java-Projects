

import javax.swing.*;
import java.util.regex.*;
import java.awt.event.*;
import java.io.*;

/******************************************************************************************************
 * 
 * A class that handles the menu bar, menus and items in the menu in the JFrame
 * 
 * 
 *
 */
public class FileMenuHandler implements ActionListener {

   private TemperatureGUI tempGUI;
   private static Temperature tempArray[] = new Temperature[100];
   private static TemperatureList tempList = new TemperatureList();
   private static int size;
   
   /**
    * Parameterized Constructor
    * 
    * @param jf the JFrame to be worked with
    */
   public FileMenuHandler (TemperatureGUI jf) {
      tempGUI = jf;
   }
   
   /**
    * Describes the action to be performed 
    * for each item in the menu
    */
   public void actionPerformed(ActionEvent event) {
      String  menuName = event.getActionCommand();
      
      if (menuName.equals("Open")) 			/* Opens a file */
         openFile(); 
      else if (menuName.equals("Add"))		/* Adds a new Temperature using JOptionPane */
    	  add();
      else if (menuName.equals("Quit"))		/* Closes the GUI & terminates the program */
         System.exit(0);
   }
   /**
    * Method to open the data file
    */
   private void openFile() {
      JFileChooser chooser = new JFileChooser();
      int status;
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      status = chooser.showOpenDialog(null);
      
      if (status == JFileChooser.APPROVE_OPTION) 
         readFromFile(chooser.getSelectedFile());
      else 
         JOptionPane.showMessageDialog(null, "Open File dialog canceled");
   }
   /**
    * 
	* Reads temperature values from input file
	* and stores in an array and list of temperature objects
	* 
    * @param chosenFile Data file to be read
    */
   private void readFromFile(File chosenFile) {
	   String chosenFileName = chosenFile.getAbsolutePath();
	   TextFileInput in = new TextFileInput(chosenFileName);
	   
	   /* Clears the array and list of Temperatures
	    * before reading data from a file */
	   size = 0;		
	   tempList.clearList();
	   
	   String line = in.readLine();
	   
	   while(line != null) {
		   insertTemp(line);		
		   line = in.readLine();
	   }
	   sort_Display();
   }
   
   /**
    * Adds a new Temperature value into the array & list
    */
   private void add() {
	  String temp;
	  temp = JOptionPane.showInputDialog(null,"Enter a temperature:");
	  insertTemp(temp);
	  sort_Display(); 
   }
   
   /**
    * Checks if the temperature is valid
    * and inserts into the array and list
    * 
    * @param data data read from the file
    */
   private void insertTemp(String data) {
	  try {
		  if(isValidTemperature(data)) {
			  tempArray[size] = new Temperature(Float.parseFloat(data));
			  tempList.insert(tempArray[size]);
			  size++;
		  }
		  else
			  /* In case the data read from the file
			   *  is not a valid Temperature throws a user defined Exception */
			  throw new IllegalTemperatureException("Invalid Temperature:"+ data); 
	  }	
	  
	  catch(IllegalTemperatureException ite) {
		  System.err.println(ite);
	  }
	  catch(IndexOutOfBoundsException iobe) {
		  System.err.println(iobe);
	  }
   }
   
   /**
    * Method to sort the array 
    * and display both array and list of Temperatures
    */
   private void sort_Display() {
	   SelectionSort.selectionSort(tempArray,size);
       tempGUI.addTemptoJFrame(tempList,tempArray,size);
   }
   
   /**
    * Checks if the data read is a valid Temperature
    * 
    * @param temp data to be verified
    * @return true if data matches the regular expression specified
    * and false if does not match
    */
   private boolean isValidTemperature(String temp) {
	   Pattern p;
	   Matcher m;
	   
	   /* Can be a negative or a positive number, 
	    * must contain not more than 3 digits before decimal 
	    * and not more than 2 digits after decimal */
	   String tempPattern = "^-?\\d{0,3}\\.{1}\\d{0,2}$";
	   
	   p = Pattern.compile(tempPattern);
	   m = p.matcher(temp);
	   return m.matches();
	   
   }
}
