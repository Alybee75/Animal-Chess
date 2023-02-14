public class Cat extends Entity {
    /**
     * This subclass constructor initializes the values for the 
     * Cat. Used to initialize for the board.
     * 
     * @param x x value of Cat
     * @param y y value of Cat
     * @param p player number of this Cat
     * @param n name of Cat
     */

    public Cat(int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 2;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Cat for the randomizer.
     * 
     * @param r rank of Cat
     * @param n name of Cat
     */

    public Cat() {
        rank = 2;
    }
}