public class Leopard extends Entity {
    /**
     * This subclass constructor initializes the values for the 
     * Leopard. Used to initialize for the board.
     * 
     * @param x x value of Leopard
     * @param y y value of Leopard
     * @param p player number of this Leopard
     * @param n name of Leopard
     */

    public Leopard(int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 5;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Leopard for the randomizer.
     * 
     * @param r rank of Leopard
     * @param n name of Leopard
     */

    public Leopard() {
        rank = 5;
    }
}