import javax.swing.*;

/**
 * This class is basically a JButton that takes in x and y values
 * as a representation of indices. This will be used as a 2D array
 * in BoardGUI to easily differentiate each 2D array JButton. It 
 * extends from JButton so that it will have the same qualities as
 * JButton.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class JButton2D extends JButton {
    /**
     * This variable is the x value for JButton2D (JButton2D[x][]).
     */
    private int x;
    /**
     * This variable is the y value for JButton2D (JButton2D[][y]).
     */
    private int y;
    /**
     * This variable is the string representation of JButton2D.
     */
    private String name;
    /**
     * This variable will indicate what color this JButton2D is.
     */
    private int color;
    /**
     * This variable indicates if this button is highlighted yellow
     * (meaning if this is a spot that can ba taken by an animal).
     */
	private boolean isHighlightedYellow;

    /**
     * This constructor gets an ImageIcon: icon representing the JButton2D;
     * basically an animal photo, x value of the JButton2D, y value of the
     * JButton2D, the string representation of this button, and the color
     * of the JButton2D: the color of the animal. This also calls the
     * super class, JButton, and takes in the ImageIcon.
     * 
     * @param i image of the JButton2D
     * @param x x value of the JButton2D
     * @param y y value of the JButton2D
     * @param n string of the JButton2D
     * @param c color of the JButton2D
     */

    public JButton2D (ImageIcon i, int x, int y, String n, int c) {
        super(i);
        this.x = x;
        this.y = y;
        name = n;
        color = c;
    }

    /**
     * This method gets the x value of the JButton2D and returns it.
     * 
     * @return x value of JButton2D
     */

    public int getX () {
        return this.x;
    }

    /**
     * This method gets the y value of the JButton2D and returns it.
     * 
     * @return y value of JButton2D
     */

    public int getY () {
        return this.y;
    }

    /**
     * This method gets the color of the JButton2D, either red or blue.
     * 
     * @return color of JButton2D
     */
    public int getColor () {
        return color;
    }

    /**
     * This method updates the color of the JButton2D. It takes in the
     * color for it to change.
     * 
     * @param c color that will be used
     */

	public void updateColor (int c) {
		color = c;
	}

    /**
     * This method indicates if the JButton2D is highlighted yellow, meaning
     * is this JButton a spot that the animal can move to.
     * 
     * @return boolean value if it's highlighted
     */
	
	public boolean isHighlightedYellow () {
        return isHighlightedYellow;
    }

    /**
     * This method changes the boolean value of isHighlightedYellow to either
     * make it true or false.
     * 
     * @param t boolean value to indicate if it highlighted
     */

    public void setHighlightYellow (boolean t) {
        isHighlightedYellow = t;
    }

    /**
     * This method overrides toString and returns the string representation
     * of this JButton2D.
     */
    @Override
    public String toString () {
        return name;
    }
}