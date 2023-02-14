public class River extends Terrain {
    /**
     * This subclass constructor initializes the values for the 
     * River terrain. Used to initialize for the board.
     * 
     * @param x x value of this River
     * @param y y value of this River
     * @param p player number of this River (3 is chosen for other terrain)
     * @param n name of this River (~~~~)
     */

    public River(int x, int y, String n) {
        super(x, y, n);
    }
}