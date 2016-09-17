import javax.swing.*;
import java.awt.*;

/**
 * A GUI Class that displays the sorted array 
 * and list of temperatures
 * 
 * @author Renuka Anbalagan Lab Section 03
 *
 */
@SuppressWarnings("serial")
public class TemperatureGUI extends JFrame {
	
	private TextArea tempArray,tempList;
	private Container cPane;
	private JMenuBar menuBar;
	private JMenuItem item;
	private FileMenuHandler fmh;
	
	/**
	 * Default constructor
	 * It sets the attributes of the JFrame
	 */
	public TemperatureGUI() {
		
		setTitle("Temperature");
		setSize(400,400);
		setLocation(500,100);
		setLayout(new GridLayout(1,2));
		
		cPane = getContentPane();
		
		/* Text Area to insert
		 * sorted array of temperature objects 
		 * and list of temperature nodes
		 */
		tempArray = new TextArea();
		tempArray.setEditable(false);
		cPane.add(tempArray);
		
		tempList = new TextArea();
		tempList.setEditable(false);
		cPane.add(tempList);
		
		menuBar  = new JMenuBar();
		fmh = new FileMenuHandler(this);
		setJMenuBar(menuBar);
		createFileMenu();
		createEditMenu();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Creates the file menu, its corresponding items
	 * and adds to the menu bar
	 */
	private void createFileMenu() {
		
	    JMenu fileMenu = new JMenu("File");

	    item = new JMenuItem("Open");    // Open
	    item.addActionListener( fmh );
	    fileMenu.add( item );

	    fileMenu.addSeparator();           // Add a horizontal separator line
	    
	    item = new JMenuItem("Quit");       // Quit
	    item.addActionListener( fmh );
	    fileMenu.add( item );
	      
	    menuBar.add(fileMenu);

	}
	
	/**
	 * Creates the edit menu, its corresponding items
	 * and adds to the menu bar
	 */
	private void createEditMenu () {
	    JMenu editMenu = new JMenu("Edit");
	    
	    item = new JMenuItem("Add");	// Add
	    item.addActionListener( fmh );
	    editMenu.add ( item );
	    
	    menuBar.add(editMenu);
	    
	   }
	/**
	 * Displays the sorted list and array of temperature objects
	 * on the JFrame
	 * 
	 * @param tempList list of Temperature nodes 
	 * in ascending order of their temperatures(degree celsius)
	 * @param tempArray sorted array of Temperature objects
	 * @param length length filled in the array of Temperature objects
	 */
	public void addTemptoJFrame( TemperatureList tempList, Temperature[] tempArray, int length ) {
		
		this.tempArray.setText("Temperature Object Array: \n");

		for (int i = 0; i < length; i++)
			this.tempArray.append(tempArray[i].toString() + " C\n");	/* Appends data in the array of temperature objects */
		
		this.tempArray.append("The length of the array: "+ length);		
		
		this.tempList.setText("Temperature Object List: \n");
		this.tempList.append(tempList.toString());				/* Appends data in the list of temperature nodes */
		this.tempList.append("The length of the list: "+ tempList.getLength());	
	}

}