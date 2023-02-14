import java.util.*;

public class Gameboard{
    private final int ROW = 9;
    private final int COL = 7;

	//Set to 2 for now as both only have dog and lion
	private int p1Animals = 8;
	private int p2Animals = 8;
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
		board[6][2] = new Tile(new Mouse(6, 2, 1, "rMOU"), 6, 2);
		board[0][6] = new Tile(new Mouse(0, 6, 2, "bMOU"), 0, 6);
		
		board[1][1] = new Tile(new Cat(1, 1, 1, "rCAT"), 1, 1);
		board[5][7] = new Tile(new Cat(5, 7, 2, "bCAT"), 5, 7);
		
		board[2][2] = new Tile(new Wolf(2, 2, 1, "rWLF"), 2, 2);
		board[4][6] = new Tile(new Wolf(4, 6, 2, "bWLF"), 4, 6);
		
        board[5][1] = new Tile(new Dog(5, 1, 1, "rDOG"), 5, 1);
        board[1][7] = new Tile(new Dog(1, 7, 2, "bDOG"), 1, 7);
		
		board[4][2] = new Tile(new Leopard( 4, 2, 1, "rLPD"), 4, 2);
		board[2][6] = new Tile(new Leopard( 2, 6, 2, "bLPD"), 2, 6);
		
		board[0][0] = new Tile(new Tiger( 0, 0, 1, "rTIG"), 0, 0);
		board[6][8] = new Tile(new Tiger( 6, 8, 2, "bTIG"), 6, 8);
		
	    board[6][0] = new Tile(new Lion(6, 0, 1, "rLIO"), 6, 0);
        board[0][8] = new Tile(new Lion(0, 8, 2, "bLIO"), 0, 8);
		
		board[0][2] = new Tile(new Elephant( 0, 2, 1, "rELE"), 0, 2);
		board[6][6] = new Tile(new Elephant( 6, 6, 2, "bELE"), 6, 6);

        board[3][0] = new Tile(new Den(3, 0, 1, "rDEN"), 3, 0);
        board[3][8] = new Tile(new Den(3, 8, 2, "bDEN"), 3, 8);
		
        board[1][3] = new Tile(new River(1, 3, "~~~~"), 1, 3);
        board[2][3] = new Tile(new River(2, 3, "~~~~"), 2, 3);
        board[4][3] = new Tile(new River(4, 3, "~~~~"), 4, 3);
        board[5][3] = new Tile(new River(5, 3, "~~~~"), 5, 3);

        board[1][4] = new Tile(new River(1, 4, "~~~~"), 1, 4);
        board[2][4] = new Tile(new River(2, 4, "~~~~"), 2, 4);
        board[4][4] = new Tile(new River(4, 4, "~~~~"), 4, 4);
        board[5][4] = new Tile(new River(5, 4, "~~~~"), 5, 4);

        board[1][5] = new Tile(new River(1, 5, "~~~~"), 1, 5);
        board[2][5] = new Tile(new River(2, 5, "~~~~"), 2, 5);
        board[4][5] = new Tile(new River(4, 5, "~~~~"), 4, 5);
        board[5][5] = new Tile(new River(5, 5, "~~~~"), 5, 5);
    
		board[2][0] = new Tile(new Trap(2, 0, 1, "TRAP"), 2, 0);
		board[4][0] = new Tile(new Trap(4, 0, 1, "TRAP"), 4, 0);
		board[3][1] = new Tile(new Trap(3, 1, 1, "TRAP"), 3, 1);

		board[2][8] = new Tile(new Trap(2, 8, 2, "TRAP"), 2, 8);
		board[4][8] = new Tile(new Trap(4, 8, 2, "TRAP"), 4, 8);
		board[3][7] = new Tile(new Trap(3, 7, 2, "TRAP"), 3, 7);
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
				if (board[i][j] != null)
					System.out.print("  " + board[i][j].toString() + "  "); 

				else
					System.out.print("        "); 
				
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

	public Tile updateBoard(String n, int p, String move) {
		int x = 0, y = 0;
		int a = 0, b = 0;
		char change = 'c';
		int trapNum = 0;
		boolean done = false, choose = false;
		
		for (int  i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				if (board[i][j] != null) {
					if (n.equals(board[i][j].toString())) {
						a = i;
						b = j;
						System.out.println(i+ " " + j);
							//if up direction was chosen
							if (move.equals("U")) {
								x = board[i][j].getAnimal().MoveUp();
								y = j;
								
								if (board[i][j].getAnimal().ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");
								
								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River)
												x--;
										}
										if (board[x][y] == null)
											done = true;
										
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												x--;
										}
										if (board[x][y] == null)
											done = true;
									}	
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Mouse) {
										Mouse m = new Mouse(i, j, p, n);
										if(m.swim(board[x][y]))
											done = true;
									}
									
									//trapped code
									if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
										if (board[x][y].getTerrain() != null) {
											if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum()){
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
												done = true;
											}
											else
												done = true;
										}
										else if (board[x][y].getAnimal() != null) 
											if (board[x][y].isTrap(x, y) != board[i][j].getAnimal().getPNum())
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
									}

									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
										if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true){
											System.out.println(board[x][y].getAnimal().toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else
											System.out.println("Invalid move.");
									}
									else if (done == false) {
										System.out.println("Invalid move.");
									}
								}

								else {
									done = true;
								}
							}

							//if down direction was chosen
							else if (move.equals("D")) {
								x = board[i][j].getAnimal().MoveDown();
								y = j;

								if (board[i][j].getAnimal().ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");

								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												x++;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												x++;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Mouse) {
										Mouse m = new Mouse(i, j, p, n);
										if(m.swim(board[x][y]))
											done = true;
									}

									//trapped code
									if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
										if (board[x][y].getTerrain() != null) {
											if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum()){
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
												done = true;
											}
											else
												done = true;
										}
										else if (board[x][y].getAnimal() != null) 
											if (board[x][y].isTrap(x, y) != board[i][j].getAnimal().getPNum())
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
									}
									
									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
										if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true){
											System.out.println(board[x][y].getAnimal().toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else
											System.out.println("Invalid move.");
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
								y = board[i][j].getAnimal().MoveLeft();
								
								if (board[i][j].getAnimal().ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");

								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												y--;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												y--;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Mouse) {
										Mouse m = new Mouse(i, j, p, n);
										if(m.swim(board[x][y]))
											done = true;
									}
									
									//trapped code
									if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
										if (board[x][y].getTerrain() != null) {
											if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum()){
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
												done = true;
											}
											else
												done = true;
										}
										else if (board[x][y].getAnimal() != null) 
											if (board[x][y].isTrap(x, y) != board[i][j].getAnimal().getPNum())
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
									}
									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
										if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true){
											System.out.println(board[x][y].getAnimal().toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else
											System.out.println("Invalid move.");
									}
									else if (done == false) {
										System.out.println("Invalid move.");
									}
								}

								else {
									done = true;
								}
							}

							//if right direction was chosen
							else if (move.equals("R")) {
								x = i;
								y = board[i][j].getAnimal().MoveRight();

								if (board[i][j].getAnimal().ifOutOfBounds(x, y) == true)
									System.out.println("Error: Out of Bounds");

								else if ((x == 3 && y == 0 && p == 1) || (x == 3 && y == 8 && p == 2))
									System.out.println("Invalid move. You cannot enter your own den.");

								else if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
									//this if condition will determine if the animal can do a "ferocious leap"
									//across the river (only Tiger and Lion have the ability to do so)
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
										Lion t = new Lion (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												y++;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
										Tiger t = new Tiger (i, j, p, n);
										if (t.ferociousLeap(board[x][y]) == true){
											while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
												y++;
										}
										if (board[x][y] == null)
											done = true;
									}
									if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Mouse) {
										Mouse m = new Mouse(i, j, p, n);
										if(m.swim(board[x][y]))
											done = true;
									}
									
									//trapped code
									if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
										if (board[x][y].getTerrain() != null) {
											if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum()){
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
												done = true;
											}
											else
												done = true;
										}
										else if (board[x][y].getAnimal() != null) 
											if (board[x][y].isTrap(x, y) != board[i][j].getAnimal().getPNum())
												System.out.println(board[i][j].getAnimal().toString() + " is trapped");
									}
									
									//this if condition checks if the animal is going to be captured
									if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
										if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true){
											System.out.println(board[x][y].getAnimal().toString() + " got captured");

											//this if condition determines how many animals are left
											if (p == 1)
												setAnimalsLeft(1);

											else
												setAnimalsLeft(0);

											done = true;
										}
										else
											System.out.println("Invalid move.");
									}
									else if (done == false) {
										System.out.println("Invalid move.");
									}
								}
								else {
									done = true;
								}
							}
							else
								System.out.println("ERROR: Invalid!");
								
					}
				}
			}
		}
		
		if (done == false){
			return board[a][b];
		}
		if (board[a][b].getAnimal() != null){
			board[a][b].getAnimal().updateXY(x, y);
			board[x][y] = new Tile(board[a][b].getAnimal().whichAnimal(), x, y);
			board[a][b] = null;
		}
		if (board[x][y].isRiver(a, b)){
			board[a][b] = new Tile(new River(a, b, "~~~~"), a, b);
		}
		if (board[x][y].isTrap(a, b) != 0){
			trapNum = board[x][y].isTrap(a, b);
			board[a][b] = new Tile(new Trap(a, b, trapNum, "TRAP"), a, b);
		}
		
			return board[x][y];
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

	public Tile[][] getTiles() {
		return board;
	}
}