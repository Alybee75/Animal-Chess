public class Mouse extends Entity {
    /**
     * This subclass constructor initializes the values for the 
     * Mouse. Used to initialize for the board.
     * 
     * @param x x value of Mouse
     * @param y y value of Mouse
     * @param p player number of this Mouse
     * @param n name of Mouse
     */

    public Mouse(int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 1;
    }  
    
    /**
     * This subclass constructor initializes the values for the 
     * Mouse for the randomizer.
     * 
     * @param r rank of Mouse
     * @param n name of Mouse
     */

    public Mouse() {
        rank = 1;
    }
}