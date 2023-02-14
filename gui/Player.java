import java.util.*;

/** 
 * The class Turn monitors whose turn
 * is it in the middle of the game.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Player {
	private int pNum;

	/**
	 * This constructor gets the parameter boolean t and is the
	 * indicator on who will be the first to move their animals.
	 * 
	 * @param t indicator on who goes first
	 */
	
	public Player(boolean t) {
		if (t == false) {
			pNum = 1;
			System.out.println("It is Red's turn.");
		}

		else {
			pNum = 2;
			System.out.println("It is Blue's turn.");
		}
	}

	public Player(int n) {
		pNum = n;
	}
	
	/**
	 * This method returns the player number.
	 * @return player number
	 */

	public int getPNum() {
		return pNum;
	}

	/**
	 * This method, when called, checks pNum (player number)
	 * if it's the first player and it will return true, else
	 * it will return false
	 * 
	 * @return boolean value
	 */
	
	public boolean nextTurn() {
		if (pNum == 1){
			pNum = 2;
			return true;
		}
		else{
			pNum = 1;
			return false;
		}
	}
	
	public String choosePiece(char c){
		int piece = 0;
		String name = "";
		boolean done = false;
		
		do{
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose an animal:");
			System.out.println("1 - MOUSE (MOU)");
			System.out.println("2 - CAT (CAT)");
			System.out.println("3 - WOLF (WLF)");
			System.out.println("4 - DOG (DOG)");
			System.out.println("5 - LEOPARD (LPD)");
			System.out.println("6 - TIGER (TIG)");
			System.out.println("7 - LION (LIO)");
			System.out.println("8 - ELEPHANT (ELE)");
			
			try{
				piece = sc.nextInt();
				if (piece == 1){
					name = c + "MOU";
					done = true;
				}
				else if (piece == 2){
					name = c + "CAT";
					done = true;
				}
				else if (piece == 3){
					name = c + "WLF";
					done = true;
				}
				else if (piece == 4){
					name = c + "DOG";
					done = true;
				}
				else if (piece == 5){
					name = c + "LPD";
					done = true;
				}
				else if (piece == 6){
					name = c + "TIG";
					done = true;
				}
				else if (piece == 7) {
					name = c + "LIO";
					done = true;
				}
				else if (piece == 8){
					name = c + "ELE";
					done = true;
				}
				else
					System.out.println("Invalid Input!");
			}
			catch(Exception e){
				System.out.println("Invalid Input!");
			}
			sc.nextLine();
		} while(done != true);
		
		return name;
	}
}