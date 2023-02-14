/**
 * The class Entity handles all the animals and terrain
 * and what they should do.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Entity extends Tile{
    protected int playerNo;
    protected int rank;

    /**
     * This constructor initializes the Entity with the x and y values,
     * the player number, and the name. This will count for all animals
     * and terrain. This will be used for the subclasses.
     * 
     * @param x x value direction of the entity
     * @param y y value direction of the entity
     * @param p player number of the entity (3 for terrain)
     * @param n name of the entity
     */

    public Entity (int x, int y, int p, String n) {
		super(x, y, p, n);
    }

    /**
     * This constructor is used for the randomization before the 
     * start of the game. Only requires rank and name.
     * 
     * @param r rank of the entity
     * @param n name of the entity
     */

    public Entity () {
		
    }

	/**
	 * This constructor gets the x and y values of e and assigns
	 * them to this constructor's x and y variables.
	 * 
	 * @param e Animal's information
	 */

	public Entity(Tile e) {
		x = e.getX();
		y = e.getY();
	}

    /**
     * This method returns the player number of the entity.
     * 
     * @return player number of the entity
     */
    
    public int getPNum() {
		return playerNo;
	}

    /**
     * This method returns the rank of the entity.
     * 
     * @return rank of the entity
     */
	
	public int getRank() {
		return rank;
	}

	/**
	 * This method returns the updated direction whenever the
	 * Player wants to move up.
	 * 
	 * @return updated x value that makes the Entity go up in the board
	 */
	
	public int MoveUp() {
		return x - 1;
	}

	/**
	 * This method returns the updated direction whenever the
	 * Player wants to move down.
	 * 
	 * @return updated x value that makes the Entity go down in the board
	 */
	
	public int MoveDown() {
		return x + 1;
	}

	/**
	 * This method returns the updated direction whenever the
	 * Player wants to move left.
	 * 
	 * @return updated y value that makes the Entity go left in the board
	 */
	
	public int MoveLeft() {
		return y - 1;
	}

	/**
	 * This method returns the updated direction whenever the
	 * Player wants to move right.
	 * 
	 * @return updated y value that makes the Entity go right in the board
	 */
	
	public int MoveRight() {
		return y + 1;
	}

	/**
	 * This method checks a boolean value if a specific direction is
	 * out of bounds of the board.
	 * 
	 * @param x the x direction of the entity that is out of bounds
	 * @param y the y direction of the entity that is out of bounds
	 * @return check to indicate if it's true or false
	 */

  	public boolean ifOutOfBounds(int x, int y) {
	  	boolean check = false;

	  	if (x == -1)
	  		check = true;
	  	if (x == 7)
	  		check = true;
	  	if (y == -1)
	  		check = true;
	  	if (y == 9)
			check = true;
		
		return check;
 	}

	/**
	 * This method handles the capture mechanic. It gets the two
	 * entities in conflict and compares their ranks. Whichever
	 * has the higher rank wins and captures the enemy.
	 * 
	 * @param a First entity
	 * @param b Second entity
	 * @return boolean dat will determine who won
	 */

  	public boolean capture(Entity a, Entity b) { // a = the Entity to be captured ; b = // the Entity currently being controlled
		int rank1, rank2;
		int p1, p2;
		
		rank1 = a.getRank(); // the Entity to be captured
		rank2 = b.getRank(); // the Entity currently being controlled
		
		p1 = a.getPNum(); // player number of Entity to be captured
		p2 = b.getPNum(); // player number of current player

		if (p1 != p2 && rank1 <= rank2) {
			return true;
		}

		return false;
	}

}


