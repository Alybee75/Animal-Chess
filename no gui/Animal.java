/**
 * The class Entity handles all the animals and terrain
 * and what they should do.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Animal extends Entity {
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

    public Animal (int x, int y, int p, String n) {
		super(x, y, p, n);
    }

    /**
     * This constructor is used for the randomization before the 
     * start of the game. Only requires rank and name.
     * 
     * @param r rank of the entity
     * @param n name of the entity
     */

    public Animal (int r, String n) {
        super(r, n);
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

	public void updateXY(int x, int y)
	{
		this.x = x;
		this.y = y;
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

  	public boolean capture(Animal e) { 
		int rank1, rank2;
		int p1, p2;
		int x1, x2;
		int y1, y2;
		
		rank1 = e.getRank(); // the Entity to be captured
		rank2 = this.getRank(); // the Entity currently being controlled
			
		p1 = e.getPNum(); // player number of Entity to be captured
		p2 = this.getPNum(); // player number of current player
		
		x1 = e.getX();
		x2 = this.getX();
		
		y1 = e.getY();
		y2 = this.getY();
		
		Tile layout = new Tile();

		if ((layout.isRiver(x1, y1) && !(layout.isRiver(x2, y2))) || (!(layout.isRiver(x1, y1)) && layout.isRiver(x2, y2)))
			return false; // a mouse on the river may not capture another animal on land	//no animal can capture a mouse on the river
		if (p1 != p2 && rank1 == 8 && rank2 == 1)
			return true; // a mouse can capture an elephant
		if (p1 != p2 && layout.isTrap(x1, y1) == p2)
			return true; // if animal to be captured is trapped
		if (p1 != p2 && rank1 <= rank2)
			return true;
		

		return false;
	}

	public Animal whichAnimal(){
		int x = getX();
		int y = getY();
		int p = getPNum();
		String n = toString();
		
		if (this instanceof Mouse)
			return new Mouse(x, y, p, n);
		
		else if (this instanceof Cat)
			return new Cat(x, y, p, n);
		
		else if (this instanceof Wolf)
			return new Wolf(x, y, p, n);
		
		else if (this instanceof Dog)
			return new Dog(x, y, p, n);
		
		else if (this instanceof Leopard)
			return new Leopard(x, y, p, n);
		
		else if (this instanceof Tiger)
			return new Tiger(x, y, p, n);
		
		else if (this instanceof Lion)
			return new Lion(x, y, p, n);
		
		else if (this instanceof Elephant)
			return new Elephant(x, y, p, n);
		
		return this;
	}
	
}


