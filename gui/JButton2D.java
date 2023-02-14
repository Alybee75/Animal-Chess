import javax.swing.*;

public class JButton2D extends JButton {
    private int x;
    private int y;
    private String name;
    private int color;
	private boolean isHighlightedYellow;

    public JButton2D(ImageIcon i, int x, int y, String n, int t) {
        super(i);
        this.x = x;
        this.y = y;
        name = n;
        color = t;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        return name;
    }

    public int getColor() {
        return color;
    }

	public void updateColor(int c){
		color = c;
	}
	
	public boolean isHighlightedYellow() {
        return isHighlightedYellow;
    }

    public void setHighlightYellow(boolean t) {
        isHighlightedYellow = t;
    }
}