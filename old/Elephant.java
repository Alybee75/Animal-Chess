public class Elephant extends Entity {
    /**
     * This subclass constructor initializes the values for the 
     * Elephant. Used to initialize for the board.
     * 
     * @param x x value of Elephant
     * @param y y value of Elephant
     * @param p player number of this Elephant
     * @param n name of Elephant
     */

    public Elephant(int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 8;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Elephant for the randomizer.
     * 
     * @param r rank of Elephant
     * @param n name of Elephant
     */

    public Elephant() {
        rank = 8;
    }
}