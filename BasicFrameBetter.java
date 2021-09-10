import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * This class creates the JFrame for the game. 
 * A addContents method is also called to be later implemented by other subclasses to add their contents to the JFrame. 
 */
public abstract class BasicFrameBetter {
	
	protected JFrame frame; //Creates object for JFrame. (Instance variable which is accessed by subclasses). 
	protected abstract void addContents(); //Creates method for subclasses to add contents. 
	/*
	 * Constructor for abstract class. 
	 * Creates all of the properties of the JFrame. 
	 */
	public BasicFrameBetter() { 
		frame = new JFrame();
		frame.setTitle("Inverse Tik Tak Toe");
		frame.setSize(300, 322);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addContents();
		frame.setVisible(true);
	}

}
