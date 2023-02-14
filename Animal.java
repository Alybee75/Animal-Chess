/**
 * The class Animal handles all the animals' functions and what they
 * do. It extends from the class Entity.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Animal extends Entity {
    /**
     * This constructor calls the super class Entity with the x and y
	 * direction values of the animal, the player number of the animal, and 
	 * the name of the animal.
     * 
     * @param x x value direction of the animal
     * @param y y value direction of the animal
     * @param p player number of the animal
     * @param n name of the animal
     */

    public Animal (int x, int y, int p, String n) {
		super(x, y, p, n);
    }

    /**
     * This constructor is used for the randomization before the 
     * start of the game. Only requires rank and name.
     * 
     * @param r rank of the animal
     * @param n name of the animal
     */

    public Animal (int r, String n) {
        super(r, n);
    }

	/**
	 * This method returns the updated direction whenever the
	 * animal is going up.
	 * 
	 * @return updated x value that makes the animal go up in the board
	 */
	
	public int MoveUp () {
		return x - 1;
	}

	/**
	 * This method returns the updated direction whenever the
	 * animal is going down.
	 * 
	 * @return updated x value that makes the animal go down in the board
	 */
	
	public int MoveDown () {
		return x + 1;
	}

	/**
	 * This method returns the updated direction whenever the
	 * animal is going left.
	 * 
	 * @return updated y value that makes the animal go left in the board
	 */
	
	public int MoveLeft () {
		return y - 1;
	}

	/**
	 * This method returns the updated direction whenever the
	 * animal is going right.
	 * 
	 * @return updated y value that makes the animal go right in the board
	 */
	
	public int MoveRight () {
		return y + 1;
	}

	/**
	 * This method updates the x and y values of the animal.
	 * 
	 * @param x the new x value to replace the old value
	 * @param y the new y value to replace the old value
	 */

	public void updateXY (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * This method checks a boolean value if a specific direction is
	 * out of bounds of the board.
	 * 
	 * @param x the x direction of the animal that is out of bounds
	 * @param y the y direction of the animal that is out of bounds
	 * @return check to indicate if it's true or false
	 */

  	public boolean ifOutOfBounds (int x, int y) {
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
	 * animals in conflict and compares their ranks. Whichever
	 * has the higher rank wins and captures the other.
	 * 
	 * @param a First animal
	 * @return boolean that will determine who won
	 */

  	public boolean capture (Animal a) { 
		int rank1, rank2;
		int p1, p2;
		int x1, x2;
		int y1, y2;
		
		rank1 = a.getRank(); //the animal to be captured
		rank2 = this.getRank(); //the animal currently being controlled
			
		p1 = a.getPNum(); //player number of animal to be captured
		p2 = this.getPNum(); //player number of the animal currently being controlled
		
		x1 = a.getX(); //x value of the animal to be captured
		x2 = this.getX(); //x value of the animal currently being controlled
		
		y1 = a.getY(); //y value of the animal to be captured
		y2 = this.getY(); //y value of the animal currently being controlled
		
		Tile layout = new Tile(x1, y1); //initializes a Tile variable to check if special terrain

		/*
		Mouse Special Abilities and Movements
		*/
		if (p1 != p2 && rank1 == 1 && rank2 == 1 && layout.isRiver(x1, y1) && layout.isRiver(x2, y2))
			return true; //a mouse on the river may capture another mouse on the river
		if ((layout.isRiver(x1, y1) && !(layout.isRiver(x2, y2))) || (!(layout.isRiver(x1, y1)) && layout.isRiver(x2, y2)))
			return false; //a mouse on the river may not capture another animal on land	//no animal can capture a mouse on the river
		if (p1 != p2 && rank1 == 8 && rank2 == 1)
			return true; //a mouse can capture an elephant
		if (p1 != p2 && layout.isTrap(x1, y1) != 0 && p1 != layout.isTrap(x1, y1))
			return true; //if animal to be captured is trapped
		if (p1 != p2 && rank1 == 1 && rank2 == 8)
			return false; //an elephant may not capture a mouse
		if (p1 != p2 && rank1 <= rank2)
			return true;
		
		return false;
	}

	/**
	 * This method determines what subclass of Animal is a particular, 
	 * specific instance.
	 * 
	 * @return the subclass of the animal that it is
	 */

	public Animal whichAnimal () {
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