/**
 * The class Movement handles the direction of which
 * the animal will go through.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Movement {
	private int x;
	private int y;
	
	/**
	 * This constructor gets the x and y values of e and assigns
	 * them to this constructor's x and y variables.
	 * 
	 * @param e Animal's information
	 */

	public Movement(Entity e) {
		x = e.getX();
		y = e.getY();
	}

	

	/**
	 * This method handles the special movement of Lion and Tiger
	 * (The lion only for this MP phase) in which they can jump across
	 * the river and land on the other side.
	 * 
	 * @param e Entity to be checked
	 * @param n name of the entity to check if Lion/Tiger
	 * @return boolean value to check if they can jump
	 */

  	public boolean ferociousLeap(Entity e, String n) {
		if (e.toString().equals("~~~~") && (n.equals("BLIO") || n.equals("RLIO")))
			return true;
		
		return false;
	}
}