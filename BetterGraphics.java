import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class BetterGraphics extends BasicFrameBetter{
	/*
	 * The below nine instance variables are created to check if a space has been filled or not. 
	 */
	protected boolean spaceCheck1 = false; 
	protected boolean spaceCheck2 = false; 
	protected boolean spaceCheck3 = false; 
	protected boolean spaceCheck4 = false; 
	protected boolean spaceCheck5 = false; 
	protected boolean spaceCheck6 = false; 
	protected boolean spaceCheck7 = false; 
	protected boolean spaceCheck8 = false; 
	protected boolean spaceCheck9 = false; 
	/*
	 * The below nine instance variables are created to check if a player has chosen one of the spaces. 
	 */
	protected boolean playerCheck1 = false; 
	protected boolean playerCheck2 = false; 
	protected boolean playerCheck3 = false; 
	protected boolean playerCheck4 = false; 
	protected boolean playerCheck5 = false; 
	protected boolean playerCheck6 = false; 
	protected boolean playerCheck7 = false; 
	protected boolean playerCheck8 = false; 
	protected boolean playerCheck9 = false; 
	/*
	 * The below nine instance variables are created to check if an opponent has chosen one of the spaces. 
	 */
	protected boolean oppCheck1 = false; 
	protected boolean oppCheck2 = false; 
	protected boolean oppCheck3 = false; 
	protected boolean oppCheck4 = false; 
	protected boolean oppCheck5 = false; 
	protected boolean oppCheck6 = false; 
	protected boolean oppCheck7 = false; 
	protected boolean oppCheck8 = false; 
	protected boolean oppCheck9 = false; 
	/*
	 * Creates an ArrayList to store the values of which spaces are empty still. 
	 */
	protected ArrayList<Integer> spaceNumber = new ArrayList<Integer>();
	/*
	 * This method creates a JOPtionPane object and displays a message depending of the situation. 
	 * The program exits once the user presses the exit button on the message. 
	 */
	public void exitProgram (String m) {
		JOptionPane message = new JOptionPane(); //Creates JOPtionPane object. 
		message.showInternalMessageDialog(null, m); //Displays message. 
		message.setVisible(false); //Once message is exited, setVisible to false. 
		frame.dispose(); //Close the frame. 
		System.exit(0); //Exit the program. 
	}
	/*
	 * This method checks when three spaces in a row are filled!
	 */
	public void gameCheck() {
		if (playerCheck1 && playerCheck2 && playerCheck3) { //First Row
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck4 && playerCheck5 && playerCheck6) { //Second Row
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck7 && playerCheck8 && playerCheck9) { //Third Row
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck1 && playerCheck4 && playerCheck7) { //First Column
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck2 && playerCheck5 && playerCheck8) { //Second Column
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck3 && playerCheck6 && playerCheck9) { //Third Column
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck1 && playerCheck5 && playerCheck9) { //First Diagonal
			exitProgram("Game Over! You Lose!");
			return;
		}
		if (playerCheck3 && playerCheck5 && playerCheck7) { //Second Diagonal
			exitProgram("Game Over! You Lose!");
			return;
		}
		
		if (oppCheck1 && oppCheck2 && oppCheck3) { //First Row
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck4 && oppCheck5 && oppCheck6) { //Second Row
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck7 && oppCheck8 && oppCheck9) { //Third Row
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck1 && oppCheck4 && oppCheck7) { //First Column
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck2 && oppCheck5 && oppCheck8) { //Second Column
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck3 && oppCheck6 && oppCheck9) { //Third Column
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck1 && oppCheck5 && oppCheck9) { //First Diagonal
			exitProgram("Game Over! You WIN!");
			return;
		}
		if (oppCheck3 && oppCheck5 && oppCheck7) { //Second Diagonal
			exitProgram("Game Over! You WIN!");
			return;
		}
	}
	/*
	 * The below method checks if each space is empty.
	 * If the space is empty, the corresponding number will be added to the ArrayList, spaceNumber. 
	 * A random number is then created from 0 to the size of the ArrayList.
	 * Now using binary search through a for loop, if one of the element positions are equal to the random number, return the number as the chosen space. 
	 */
	public int spaceNums() {
		if (!spaceCheck1) {
			spaceNumber.add(1);
		}
		if (!spaceCheck2) {
			spaceNumber.add(2);
		}
		if (!spaceCheck3) {
			spaceNumber.add(3);
		}
		if (!spaceCheck4) {
			spaceNumber.add(4);
		}
		if (!spaceCheck5) {
			spaceNumber.add(5);
		}
		if (!spaceCheck6) {
			spaceNumber.add(6);
		}
		if (!spaceCheck7) {
			spaceNumber.add(7);
		}
		if (!spaceCheck8) {
			spaceNumber.add(8);
		}
		if (!spaceCheck9) {
			spaceNumber.add(9);
		}
		if (spaceNumber.size() == 0) {
			gameCheck();
		}
		Random r = new Random(); //Creates Random Object.
		int ranNum = r.nextInt(spaceNumber.size()); //Creates Random Number.
		int chosenSpace = 0;  //Creates variable for the chosen space. 
		for (int i = 0; i< spaceNumber.size(); i++) { //Loops until end of ArrayList. 
			if (i == ranNum) { //Checks if random number is in the list. 
				chosenSpace = spaceNumber.get(i); //Set the chosen space to the number in the list. 
				break; //Breaks loop.
			}
		}
		return chosenSpace; //Return the chosen space. 
	}
	/*
	 * This innerclass is used for the opponent actions activated by the timer set off in the Player MouseListener events. 
	 */
	ActionListener taskPerformer = new ActionListener() {
		/*
		 * This method sets a variable, oppSpace, to the spaceNums() method, which is a random number from the spaceNumber ArrayList.
		 * It then checks if oppSpace and the corresponding space are a true statement.
		 * If true, the frame will draw the diamond symbol through frame.repaint(), and will call gameCheck() to see if three symbols are in a row. 
		 */
		public void actionPerformed(ActionEvent e) {	
			int oppSpace = spaceNums(); //Sets oppSpace to spaceNums() (REFER TO spaceNums() JAVADOC FOR MORE DETAILS!).
			if (oppSpace == 1 && !spaceCheck1) { //Checks if oppSpace is 1 and spaceCheck1 is false. 
				frame.repaint(); //Repaints the frame.
				spaceCheck1 = true; //Sets spaceCheck1 to true;
				oppCheck1 = true; //Sets oppCheck1 to true;
				spaceNumber.clear(); //Clears the arrayList. 
				gameCheck(); //Calls gameCheck function. 
				return; //Ends method. 
			}
			if (oppSpace == 2 && !spaceCheck2) {
				frame.repaint();
				spaceCheck2 = true;
				oppCheck2 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 3 && !spaceCheck3) {
				frame.repaint();
				spaceCheck3 = true;
				oppCheck3 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 4 && !spaceCheck4) {
				frame.repaint();
				spaceCheck4 = true;
				oppCheck4 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 5 &&!spaceCheck5) {
				frame.repaint();
				spaceCheck5 = true;
				oppCheck5 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 6 && !spaceCheck6) {
				frame.repaint();
				spaceCheck6 = true;
				oppCheck6 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 7 && !spaceCheck7) {
				frame.repaint();
				spaceCheck7 = true;
				oppCheck7 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 8 &&!spaceCheck8) {
				frame.repaint();
				spaceCheck8 = true;
				oppCheck8 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
			if (oppSpace == 9 && !spaceCheck9) {
				frame.repaint();
				spaceCheck9 = true;
				oppCheck9 = true;
				spaceNumber.clear();
				gameCheck();
				return;
			}
		}
	};
	/*
	 * This subclass is used to draw all of the graphics on the JFrame such as:
	 * The Grid
	 * The Player's Symbol
	 * The Opponent's Symbol
	 */
	class DrawBoard extends JPanel {
		public void paintComponent(Graphics g) { //Method is used to add graphics. 
			super.paintComponent(g); //Adds all existing elements from paintComponent. 
			g.setColor(Color.WHITE);
			g.drawLine(0, 0, 300, 0); //Top Horizontal Line. 
			g.drawLine(0, 300, 300, 300); //Bottom Horizontal Line. 
			g.drawLine(0, 0, 0, 300); //Left Vertical Line. 
			g.drawLine(300, 0, 300, 300); //Right Vertical Line. 
			g.drawLine(100, 0, 100, 300); //Second Vertical Line. 
			g.drawLine(200, 0, 200, 300); //Third Vertical Line. 
			g.drawLine(0, 100, 300, 100); //Second Horizonal Line. 
			g.drawLine(0, 200, 300, 200); //Third Horizontal Line. 
			g.setColor(Color.CYAN);
			if (spaceCheck1 && playerCheck1) {
				g.drawRect(10, 10, 70, 70); //Draws Square in box. 

			}
			if (spaceCheck2 && playerCheck2) {
				g.drawRect(110, 10, 70, 70); //Draws Square in box. 
				//spaceCheck2 = false; 

			}
			if (spaceCheck3 && playerCheck3) {
				g.drawRect(210, 10, 70, 70); //Draws Square in box. 

			}
			if (spaceCheck4 && playerCheck4) {
				g.drawRect(10, 110, 70, 70); //Draws Square in box. 
				//spaceCheck1 = false; 

			}
			if (spaceCheck5 && playerCheck5) {
				g.drawRect(110, 110, 70, 70); //Draws Square in box. 
				//spaceCheck2 = false; 

			}
			if (spaceCheck6 && playerCheck6) {
				g.drawRect(210, 110, 70, 70); //Draws Square in box. 

			}
			if (spaceCheck7 && playerCheck7) {
				g.drawRect(10, 210, 70, 70); //Draws Square in box. 
				//spaceCheck1 = false; 
		
			}
			if (spaceCheck8 && playerCheck8) {
				g.drawRect(110, 210, 70, 70); //Draws Square in box. 
				//spaceCheck2 = false; 
				
			}
			if (spaceCheck9 && playerCheck9) {
				g.drawRect(210, 210, 70, 70); //Draws Square in box. 

			}
			
			g.setColor(Color.RED);
			if (oppCheck1 && spaceCheck1) {
				g.drawLine(5, 50, 50, 5);
				g.drawLine(50, 5, 95, 50);
				g.drawLine(5, 50, 50, 95);
				g.drawLine(50, 95, 95, 50);

			}
			if (oppCheck2 && spaceCheck2) {
				g.drawLine(105, 50, 150, 5);
				g.drawLine(150, 5, 195, 50);
				g.drawLine(105, 50, 150, 95);
				g.drawLine(150, 95, 195, 50);
			}
			if (oppCheck3 && spaceCheck3) {
				g.drawLine(205, 50, 250, 5);
				g.drawLine(250, 5, 295, 50);
				g.drawLine(205, 50, 250, 95);
				g.drawLine(250, 95, 295, 50);
			}
			if (oppCheck4 && spaceCheck4) {
				g.drawLine(5, 150, 50, 105);
				g.drawLine(50, 105, 95, 150);
				g.drawLine(5, 150, 50, 195);
				g.drawLine(50, 195, 95, 150);
			}
			if (oppCheck5 && spaceCheck5) {
				g.drawLine(105, 150, 150, 105);
				g.drawLine(150, 105, 195, 150);
				g.drawLine(105, 150, 150, 195);
				g.drawLine(150, 195, 195, 150);
			}
			if (oppCheck6 && spaceCheck6) {
				g.drawLine(205, 150, 250, 105);
				g.drawLine(250, 105, 295, 150);
				g.drawLine(205, 150, 250, 195);
				g.drawLine(250, 195, 295, 150);
			}
			if (oppCheck7 && spaceCheck7) {
				g.drawLine(5, 250, 50, 205);
				g.drawLine(50, 205, 95, 250);
				g.drawLine(5, 250, 50, 295);
				g.drawLine(50, 295, 95, 250);
			}
			if (oppCheck8 && spaceCheck8) {
				g.drawLine(105, 250, 150, 205);
				g.drawLine(150, 205, 195, 250);
				g.drawLine(105, 250, 150, 295);
				g.drawLine(150, 295, 195, 250);
			}
			if (oppCheck9 && spaceCheck9) {
				g.drawLine(205, 250, 250, 205);
				g.drawLine(250, 205, 295, 250);
				g.drawLine(205, 250, 250, 295);
				g.drawLine(250, 295, 295, 250); 
			}
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the first box. 
	 */
	class FirstBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck1) { //Checks if space is empty. 
				spaceCheck1 = true; //Sets spaceCheck to true. 
				playerCheck1 = true; //Sets player check for 1st space to true.
				spaceNumber.clear(); //Clears the arrayList holding the numbers for spaces. 
				frame.repaint(); //Repaints the paintComponent method.
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	
	
	/*
	 * This Innerclass is used to create the Mouse Click event for the second box. 
	 */
	class SecondBox extends JPanel implements MouseListener {
		public void mouseClicked(MouseEvent e) { 
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck2) { //Checks if space is empty. 
				spaceCheck2 = true; //Sets spaceCheck to true. 
				playerCheck2 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint();
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the third box. 
	 */
	class ThirdBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {

		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck3) { //Checks if space is empty. 
				spaceCheck3 = true; //Sets spaceCheck to true.
				playerCheck3 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint();
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the forth box. 
	 */
	class ForthBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck4) { //Checks if space is empty. 
				spaceCheck4 = true; //Sets spaceCheck to true. 
				playerCheck4 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the fifth box. 
	 */
	class FifthBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck5) { //Checks if space is empty. 
				spaceCheck5 = true; //Sets spaceCheck to true. 
				playerCheck5 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the sixth box. 
	 */
	class SixthBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck6) { //Checks if space is empty. 
				spaceCheck6 = true; //Sets spaceCheck to true. 
				playerCheck6 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the seventh box. 
	 */
	class SeventhBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck7) { //Checks if space is empty. 
				spaceCheck7 = true; //Sets spaceCheck to true. 
				playerCheck7 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the eighth box. 
	 */
	class EigthBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck8) { //Checks if space is empty. 
				spaceCheck8 = true; //Sets spaceCheck to true. 
				playerCheck8 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This Innerclass is used to create the Mouse Click event for the ninth box. 
	 */
	class NinthBox implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			int delay = 800; //Creates tghe length of the timer.
			Timer t = new Timer(delay, taskPerformer); //Creates object for Timer. 
			if (!spaceCheck9) { //Checks if space is empty. 
				spaceCheck9 = true; //Sets spaceCheck to true. 
				playerCheck9 = true;
				spaceNumber.clear();
				frame.repaint();
				gameCheck(); //Checks for if three are in a row. 
				t.setRepeats(false); //Sets timer to only run once. 
				t.start(); //Starts Timer
			}
			else { //Checks if space is filled. 
				frame.repaint(); //Repaints the paintComponent method.
			} 
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	/*
	 * This implements the addContents method from the Basic Frame class. 
	 * This method adds visuals to the JFrame. 
	 */
	protected void addContents() {
		frame.setBackground(Color.BLACK);
		DrawBoard board = new DrawBoard();
		board.setBackground(Color.BLACK);
		frame.add(board); //Adds all graphics from draw in the frame.
		frame.setVisible(true);
		/*
		 * The following code creates 9 JPanels which cover the mouse click functionality for each box. 
		 */
		JPanel p1 = new JPanel(); //Creates JPanel. 
		p1.setBounds(0, 0, 100, 100); //Sets bounds for JPanel. 
		p1.setPreferredSize(new Dimension(100,100));
		frame.add(p1); //Adds JPanel to frame. 
		p1.addMouseListener(new FirstBox()); //Adds the mouseListener capabilities to the JPanel. 
		
		JPanel p2 = new JPanel();
		p2.setBounds(100, 0, 100, 100);
		p2.setPreferredSize(new Dimension(100,100));
		frame.add(p2);
		p2.addMouseListener(new SecondBox());
		
		JPanel p3 = new JPanel();
		p3.setBounds(200, 0, 100, 100);
		p3.setPreferredSize(new Dimension(100,100));
		frame.add(p3);
		p3.addMouseListener(new ThirdBox());
		
		JPanel p4 = new JPanel();
		p4.setBounds(0, 100, 100, 100);
		p4.setPreferredSize(new Dimension(100,100));
		frame.add(p4);
		p4.addMouseListener(new ForthBox());
		
		JPanel p5 = new JPanel();
		p5.setBounds(100, 100, 100, 100);
		p5.setPreferredSize(new Dimension(100,100));
		frame.add(p5);
		p5.addMouseListener(new FifthBox());
		
		JPanel p6 = new JPanel();
		p6.setBounds(200, 100, 100, 100);
		p6.setPreferredSize(new Dimension(100,100));
		frame.add(p6);
		p6.addMouseListener(new SixthBox());
		
		JPanel p7 = new JPanel();
		p7.setBounds(0, 200, 100, 100);
		p7.setPreferredSize(new Dimension(100,100));
		frame.add(p7);
		p7.addMouseListener(new SeventhBox());
		
		JPanel p8 = new JPanel();
		p8.setBounds(100, 200, 100, 100);
		p8.setPreferredSize(new Dimension(100,100));
		frame.add(p8);
		p8.addMouseListener(new EigthBox());
		
		JPanel p9 = new JPanel();
		p9.setBounds(200, 200, 100, 100);
		p9.setPreferredSize(new Dimension(100,100));
		frame.add(p9);
		p9.addMouseListener(new NinthBox());
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		BetterGraphics gameboard = new BetterGraphics();
		
	}
}
