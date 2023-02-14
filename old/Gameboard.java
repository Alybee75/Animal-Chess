import java.util.*;

public class Gameboard {
    private final int ROW = 9;
    private final int COL = 7;

	//Set to 2 for now as both only have dog and lion
	private int p1Animals = 2;
	private int p2Animals = 2;
    private Tile[][] board;
	private int[] animalsLeft;

	/**
	 * This constructor is responsible for initializing the board
	 * with entities. Each "spot" in the board is a different entity
	 * consisting of player 1's animals, player 2's animals, terrain
	 * and the players' dens.
	 */

    public Gameboard() {
		animalsLeft = new int[2];
		animalsLeft[0] = p1Animals;
		animalsLeft[1] = p2Animals;
		board = new Tile[COL][ROW];

		//Red player animals have R on the names, while Blue player
		//animals have B on the names.		
        board[5][1] = new Dog(5, 1, 1, "RDOG");
        board[1][7] = new Dog(1, 7, 2, "BDOG");
		
	    board[6][0] = new Lion(6, 0, 1, "RLIO");
        board[0][8] = new Lion(0, 8, 2, "BLIO");

        board[3][0] = new Den(3, 0, 1, "RDEN");
        board[3][8] = new Den(3, 8, 2, "BDEN");

        board[1][3] = new River(1, 3, "~~~~");
        board[2][3] = new River(2, 3, "~~~~");
        board[4][3] = new River(4, 3, "~~~~");
        board[5][3] = new River(5, 3, "~~~~");

        board[1][4] = new River(1, 4, "~~~~");
        board[2][4] = new River(2, 4, "~~~~");
        board[4][4] = new River(4, 4, "~~~~");
        board[5][4] = new River(5, 4, "~~~~");

        board[1][5] = new River(1, 5, "~~~~");
        board[2][5] = new River(2, 5, "~~~~");
        board[4][5] = new River(4, 5, "~~~~");
        board[5][5] = new River(5, 5, "~~~~");
    }

	/**
	 * This constructor's purpose is to display the contents of the
	 * board. It is spaced out cleanly to imitate a gameboard.
	 */

    public void displayBoard() {
        System.out.println("----------------------------------------------------------------------------------");
		for (int i = 0; i < COL; i++) {
			System.out.print("|");

			for (int j = 0; j < ROW; j++) {
				if (board[i][j] == null)
					System.out.print("        "); 

				else
					System.out.print("  " + board[i][j].toString() + "  "); 
				
				System.out.print ("|");
			}

			System.out.println("\n----------------------------------------------------------------------------------");
		}
    }

	/**
	 * This method is the most important for this project. It is responsible
	 * for constantly updating the board to accomodate for the movement directions,
	 * captures, win conditions, inputs, error checking, etc. It returns the 
	 * Entity that would have its location updated.
	 * 
	 * @param n name of Entity
	 * @param p player number of Entity
	 * @param sc Scanner input passed from main to to this class
	 * @return Entity to update its information
	 */

	public Tile updateBoard(String n, int p, Scanner sc) {
		int x = 0, y = 0;
		int a = 0, b = 0;
		char change = 'c';
		boolean done = false, choose = false;
		String move;
		
		for (int  i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				if (board[i][j] != null) {
					if (n.equals(board[i][j].toString())) {
						Entity movement = new Entity(board[i][j]);
						a = i;
						b = j;
						do {
							System.out.println("Choose direction:");
							System.out.println("U - Up");
							System.out.println("D - Down");
							System.out.println("L - Left");
							System.out.println("R - Right");
							System.out.println("\nX - Choose another animal\n");
							move = sc.nextLine();

							//if up direction was chosen
							if (move.equals("U")) {
								x = movement.MoveUp();
								y = j;

								if (movement.ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");
								
								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j] instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												x--;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j] instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												x--;
										}
										if (board[x][y] == null)
											done = true;
									}

									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && !(board[x][y] instanceof River)) {
										if (movement.capture(board[x][y], board[i][j]) == true){
											System.out.println(board[x][y].toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else if (done == false) {
											System.out.println("Invalid move.");
										}
									}

									
								}

								else {
									done = true;
								}
							}

							//if down direction was chosen
							else if (move.equals("D")) {
								x = movement.MoveDown();
								y = j;

								if (movement.ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");

								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j] instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												x++;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j] instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												x--;
										}
										if (board[x][y] == null)
											done = true;
									}

									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && !(board[x][y] instanceof River)) {
										if (movement.capture(board[x][y], board[i][j]) == true){
											System.out.println(board[x][y].toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
									}
									else if (done == false) {
										System.out.println("Invalid move.");
									}
								}
								else {
									done = true;
								}
							}
							
							//if left direction was chosen
							else if (move.equals("L")) {
								x = i;
								y = movement.MoveLeft();

								if (movement.ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");

								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j] instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												y--;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j] instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												x--;
										}
										if (board[x][y] == null)
											done = true;
									}

									if (done == false && board[x][y] != null && !(board[x][y] instanceof River)) {
										if (movement.capture(((Entity)(board[x][y])), board[i][j]) == true){
											System.out.println(board[x][y].toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else if (done == false) {
											System.out.println("Invalid move.");
										}
									}
								}

								else {
									done = true;
								}
							}

							//if right direction was chosen
							else if (move.equals("R")) {
								x = i;
								y = movement.MoveRight();

								if (movement.ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");

								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j] instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												y++;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j] instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].toString().equals("~~~~")) 
												x--;
										}
										if (board[x][y] == null)
											done = true;
									}

									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && !(board[x][y] instanceof River)) {
										if (movement.capture(((Entity)(board[x][y])), board[i][j]) == true){
											System.out.println(board[x][y].toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else if (done == false) {
											System.out.println("Invalid move.");
										}
									}
								}

								else {
									done = true;
								}
							}
							else if (move.equals("X")) {
								change = 'X';
								done = true;
							}
							else
								System.out.println("ERROR: Invalid!");
							
						} while (done == false);		
					}
				}
				if (change == 'X') {
					Person person = new Person(p);
					do{
						if (p == 1)
							n = person.choosePiece('R');
						else
							n = person.choosePiece('B');
							
							choose = isCaptured(n);
					} while(choose != true);
					i = 0;
					j = -1;
					change = 'c';
					done = false;
					choose = false;
				}
			}
		}

		if (board[a][b] instanceof Lion){
			board[a][b] = null;
			return board[x][y] = new Lion(x, y, p, n);
		}
		else if (board[a][b] instanceof Dog){
			board[a][b] = null;
			return board[x][y] = new Dog(x, y, p, n);
		}
		else{
			board[a][b] = null;
			return board[x][y] = new Entity(x, y, p, n);
		}
	}

	/**
	 * This method returns a boolean value that determines if
	 * someone has won. The primary winning condition is that an
	 * animal should take over the enemy den. It takes the 
	 * entity (the animal), and its player number.
	 * 
	 * @param a Entity to be checked
	 * @param p player number of entity
	 * @return boolean value to determine if it's a win
	 */
	
	public boolean checkWin(Tile e, int p) {
		if (e == board[3][0] && p != 1)
			return true;
		
		else if (e == board[3][8] && p != 2)
			return true;

		return false;
	}

	/**
	 * This method determines if a particular entity is captured
	 * or not. It only takes the name to determine if it is
	 * captured.
	 * 
	 * @param name name of the Entity being checked
	 * @return boolean value whether entity is captured or not
	 */
	
	public boolean isCaptured(String n) {
		for (int i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				if (board[i][j] != null) {
					if (n.equals(board[i][j].toString())) {
						return true;
					}
				}
			}
		}

		System.out.println(n + " is already captured.");
		return false;
	}

	/**
	 * This method returns the animals left in the
	 * player's hands.
	 * 
	 * @param p player number
	 * @return the number of animals left
	 */
	
	public int getAnimalsLeft(int p) {
		return animalsLeft[p];
	}

	/**
	 * This method changes the animals left when an animal
	 * of theirs is captured in the game.
	 * 
	 * @param p player number
	 */
	
	public void setAnimalsLeft(int p) {
		animalsLeft[p] = animalsLeft[p] - 1;
	}
	
}