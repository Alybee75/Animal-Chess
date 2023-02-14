import javax.swing.*;

public class JLabel2D extends JLabel {
    private int x;
    private int y;
    private String name;

    public JLabel2D(ImageIcon i, int x, int y, String n) {
        super(i);
        this.x = x;
        this.y = y;
        name = n;
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
}