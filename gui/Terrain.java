public class Terrain extends Entity{

    /**
     * This constructor initializes the Terrain with the x and y values,
     * and the name. This will be used for the subclasses.
     * 
     * @param x x value direction of the terrain
     * @param y y value direction of the terrain
     * @param n name of the terrain
     */

    public Terrain (int x, int y, String n) {
		super(x, y, n);
    }

    public Terrain (int x, int y, int p, String n) {
		super(x, y, p, n);
    }
}