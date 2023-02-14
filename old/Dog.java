public class Dog extends Entity {
    /**
     * This subclass constructor initializes the values for the 
     * Dog. Used to initialize for the board.
     * 
     * @param x x value of Dog
     * @param y y value of Dog
     * @param p player number of this Dog
     * @param n name of Dog
     */

    public Dog(int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 4;
    }

    /**
     * This subclass constructor initializes the values for the 
     * Dog for the randomizer.
     * 
     * @param r rank of Dog
     * @param n name of Dog
     */
    
    public Dog() {
        rank = 4;
    }
}