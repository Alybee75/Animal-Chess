/** 
 * The class Player monitors whose turn and the choosing of the 
 * animals.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Player {
	/**
	 * This variable pNum is used for which turn is it.
	 */
	private int pNum;

	/**
	 * This constructor gets the parameter boolean t and is the
	 * indicator on who will be the first to move their animals.
	 * 
	 * @param t indicator on who goes first
	 */
	
	public Player (boolean t) {
		if (t == false) {
			pNum = 1;
			System.out.println("It is Red's turn.");
		}

		else {
			pNum = 2;
			System.out.println("It is Blue's turn.");
		}
	}
	
	/**
	 * This method returns the player number.
	 * @return player number
	 */

	public int getPNum () {
		return pNum;
	}

	/**
	 * This method, when called, checks pNum (player number)
	 * if it's the first player and it will return true, else
	 * it will return false
	 * 
	 * @return boolean value
	 */
	
	public boolean nextTurn () {
		if (pNum == 1) {
			pNum = 2;
			return true;
		}
		else {
			pNum = 1;
			return false;
		}
	}
}