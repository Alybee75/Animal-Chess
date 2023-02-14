import javax.swing.*;

/**
 * This class is basically a JLabel that takes in x and y values
 * as a representation of indices. This will be used as a 2D array
 * in BoardGUI to easily differentiate each 2D array JLabel. It 
 * extends from JLabel so that it will have the same qualities as
 * JLabel.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */
public class JLabel2D extends JLabel {
    /**
     * This variable is the x value for JLabel2D (JLabel2D[x][]).
     */
    private int x;
    /**
     * This variable is the y value for JLabel2D (JLabel2D[][y]).
     */
    private int y;
    /**
     * This variable is the string representation of JLabel2D.
     */
    private String name;

    /**
     * This constructor gets an ImageIcon: icon representing the JLabel2D;
     * basically a terrain photo, x value of the JLabel2D, y value of the
     * JLabel2D, and the string representation of this label. This also 
     * calls the super class, JLabel, and takes in the ImageIcon.
     * 
     * @param i image of the JLabel2D
     * @param x x value of the JLabel2D
     * @param y y value of the JLabel2D
     * @param n string of the JLabel2D
     */

    public JLabel2D (ImageIcon i, int x, int y, String n) {
        super(i);
        this.x = x;
        this.y = y;
        name = n;
    }

    /**
     * This method gets the x value of the JLabel2D and returns it.
     * 
     * @return x value of JLabel2D
     */

    public int getX () {
        return this.x;
    }

    /**
     * This method gets the y value of the JLabel2D and returns it.
     * 
     * @return y value of JButton2D
     */

    public int getY () {
        return this.y;
    }

    /**
     * This method overrides toString and returns the string representation
     * of this JLabel2D.
     */
    @Override
    public String toString () {
        return name;
    }
}