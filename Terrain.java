/**
 * The class Terrain handles all the terrains' functions and what they
 * do. It extends from the class Entity.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Terrain extends Entity {
    /**
     * This constructor initializes the Terrain with the x and y values,
     * and the name. This will be used for the River.
     * 
     * @param x x value direction of the terrain
     * @param y y value direction of the terrain
     * @param n name of the terrain
     */

    public Terrain (int x, int y, String n) {
		  super(x, y, n);
    }

    /**
     * This constructor initializes the Terrain with the x and y values,
     * the player number, and the name. This will be used for the Den and
     * Trap.
     * 
     * @param x x value direction of the terrain
     * @param y y value direction of the terrain
     * @param p player number of the terrain
     * @param n name of the terrain
     */

    public Terrain (int x, int y, int p, String n) {
      super(x, y, p, n);
    }
}