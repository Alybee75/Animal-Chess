/**
 * The class Gameboard handles everything about the Gameboard. It
 * updates and sends values to the Controller (which is responsible
 * for updating the GUI for the Board).
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Gameboard {
	/**
	 * This value is the final value of the number of ROW which is 9.
	 */
    private final int ROW = 9;
	/**
	 * This value is the final value of the number of COL which is 7.
	 */
    private final int COL = 7;
	/**
	 * p1Animals is the number of animals player 1 has. The default number
	 * is 8.
	 */
	private int p1Animals = 8;
	/**
	 * p2Animals is the number of animals player 2 has. The default number
	 * is 8.
	 */
	private int p2Animals = 8;
	/**
	 * This 2D array of Tile would be used as the representation of the board
	 * and would be used to update the board controller.
	 */
    private Tile[][] board;
	/**
	 * This 1D array is to determine how many animals are left. Index 0 would
	 * be for Player 1 while Index 1 would be for Player 2.
	 */
	private int[] animalsLeft;

	/**
	 * This constructor is responsible for initializing the board
	 * with Tiles consisting of animals and terrains. 
	 */

    public Gameboard () {
		animalsLeft = new int[2];
		animalsLeft[0] = p1Animals;
		animalsLeft[1] = p2Animals;
		board = new Tile[COL][ROW];

		/*
		Red player animals have r on the names, while Blue player
		animals have b on the names.
		*/
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
	 * This method one of the more important ones. It is responsible
	 * for constantly updating the board to accomodate for the movement directions,
	 * captures, win conditions, inputs, error checking, etc. It returns the 
	 * Entity that would have its location updated.
	 * 
	 * @param n name of Entity
	 * @param p player number of Entity
	 * @param move string representation of move
	 * @return Entity to update its information
	 */

	public Tile updateBoard (String n, int p, String move) {
		int x = 0, y = 0;
		int a = 0, b = 0;
		int c = 0, d = 0;
		int trapNum = 0;
		boolean done = false;
		boolean capture = false;
		
		for (int  i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				if (board[i][j] != null) {
					if (n.equals(board[i][j].toString())) {
						a = i;
						b = j;
						
						//If the move chosen was Up
						if (move.equals("U")) {
							x = board[i][j].getAnimal().MoveUp();
							y = j;
							
							if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
									Lion t = new Lion (i, j, p, n);

									if (t.ferociousLeap(board[x][y]) == true) {
										while (board[x][y] != null && board[x][y].getTerrain() instanceof River)
											x--;
									}

									if (board[x][y] == null)
										done = true;	
								}

								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
									Tiger t = new Tiger (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
										while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
											x--;

									}

									if (board[x][y] == null)
										done = true;
								}

								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Mouse) {
									Mouse m = new Mouse(i, j, p, n);
									if (m.swim(board[x][y]))
										done = true;
								}
									
								//this is the code for trapped animals
								if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
									if (board[x][y].getTerrain() != null) {
										if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum())
											done = true;
											
										else
											done = true;
									}
								}

								//this if condition checks if the animal is going to be captured
								if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
									if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true) {
										//this if condition determines how many animals are left
										if (p == 1)
											setAnimalsLeft(1);

										else
											setAnimalsLeft(0);
										capture = true;
										done = true;
									}
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

							if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
								//this if condition will determine if the animal can do a "ferocious leap"
								//across the river (only Tiger and Lion have the ability to do so)
								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
									Lion t = new Lion (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
										while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
											x++;
									}

									if (board[x][y] == null)
										done = true;
								}

								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
									Tiger t = new Tiger (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
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

								//this is the code for trapped animals
								if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
									if (board[x][y].getTerrain() != null) {
										if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum()){
											done = true;
										}
										
										else
											done = true;
									}
								}
									
								//this if condition checks if the animal is going to be captured
								if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
									if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true) {
										//this if condition determines how many animals are left
										if (p == 1)
											setAnimalsLeft(1);

										else
											setAnimalsLeft(0);
										capture = true;
										done = true;
									}
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
								
							if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
								//this if condition will determine if the animal can do a "ferocious leap"
								//across the river (only Tiger and Lion have the ability to do so)
								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
									Lion t = new Lion (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
										while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
											y--;
									}

									if (board[x][y] == null)
											done = true;
								}

								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
									Tiger t = new Tiger (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
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
											done = true;
										}

										else
											done = true;
									}	
								}
									
								//this if condition checks if the animal is going to be captured
								if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
									if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true) {
										//this if condition determines how many animals are left
										if (p == 1)
											setAnimalsLeft(1);

										else
											setAnimalsLeft(0);
										capture = true;
										done = true;
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
							y = board[i][j].getAnimal().MoveRight();

							if (board[x][y] != null && !(x == 3 && y == 0) && !(x == 3 && y == 8)) {
								//this if condition will determine if the animal can do a "ferocious leap"
								//across the river (only Tiger and Lion have the ability to do so)
								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Lion) {
									Lion t = new Lion (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
										while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
											y++;
									}

									if (board[x][y] == null)
										done = true;
								}

								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Tiger) {
									Tiger t = new Tiger (i, j, p, n);
									if (t.ferociousLeap(board[x][y]) == true) {
										while (board[x][y] != null && board[x][y].getTerrain() instanceof River) 
											y++;
									}

									if (board[x][y] == null)
										done = true;
								}

								if (board[i][j].getAnimal() != null && board[i][j].getAnimal() instanceof Mouse) {
									Mouse m = new Mouse(i, j, p, n);
									if (m.swim(board[x][y]))
										done = true;
								}
									
								//trapped code
								if (board[x][y] != null && board[x][y].isTrap(x, y) != 0) {
									if (board[x][y].getTerrain() != null) {
										if (board[x][y].getTerrain().getPNum() != board[i][j].getAnimal().getPNum()) {
											done = true;
										}

										else
											done = true;
									}	
								}
									
								//this if condition checks if the animal is going to be captured
								if (done == false && board[x][y] != null && board[x][y].getAnimal() != null) {
									if (board[i][j].getAnimal().capture(board[x][y].getAnimal()) == true) {
										//this if condition determines how many animals are left
										if (p == 1)
											setAnimalsLeft(1);

										else
											setAnimalsLeft(0);
										capture = true;
										done = true;
									}	
								}
								
							}

							else {
								done = true;
							}
						}		
					}
				}
			}
		}
		
		if (done == false) {
			return board[a][b];
		}
		c = x;
		d = y;
		if (board[a][b].getAnimal() != null) {
			if(capture == true){
				if (board[a][b].getAnimal() instanceof Dog || board[a][b].getAnimal() instanceof Wolf){
					if (move.equals("U"))
						x--;
					else if (move.equals("D"))
						x++;
					else if (move.equals("L"))
						y--;
					else if (move.equals("R"))
						y++;
				}
			}
			board[a][b].getAnimal().updateXY(x, y);
			board[x][y] = new Tile(board[a][b].getAnimal().whichAnimal(), x, y);
			board[a][b] = null;
		}

		if (board[c][d].isRiver(a, b)) {
			board[a][b] = new Tile(new River(a, b, "~~~~"), a, b);
		}

		if (board[c][d].isTrap(a, b) != 0) {
			trapNum = board[c][d].isTrap(a, b);
			board[a][b] = new Tile(new Trap(a, b, trapNum, "TRAP"), a, b);
		}
		
		return board[x][y];
	}

	/**
	 * This method returns a boolean value that determines if
	 * someone has won. The primary winning condition is that an
	 * animal should take over the enemy den. It takes the 
	 * tile, and its player number.
	 * 
	 * @param t Tile to be checked
	 * @param p player number of animal
	 * @return boolean value to determine if it's a win
	 */
	
	public boolean checkWin (Tile t, int p) {
		if (t == board[3][0] && p != 1)
			return true;
		
		else if (t == board[3][8] && p != 2)
			return true;

		return false;
	}

	/**
	 * This method determines if a particular animal is captured
	 * or not. It only takes the name to determine if it is
	 * captured.
	 * 
	 * @param n name of the animal being checked
	 * @return boolean value whether animal is captured or not
	 */
	
	public boolean isCaptured (String n) {
		for (int i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				if (board[i][j] != null) {
					if (n.equals(board[i][j].toString())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * This method returns the animals left in the
	 * player's hands.
	 * 
	 * @param p player number
	 * @return the number of animals left
	 */
	
	public int getAnimalsLeft (int p) {
		return animalsLeft[p];
	}

	/**
	 * This method changes the animals left when an animal
	 * of theirs is captured in the game.
	 * 
	 * @param p player number
	 */
	
	public void setAnimalsLeft (int p) {
		animalsLeft[p] = animalsLeft[p] - 1;
	}

	/**
	 * This method gets the tiles in the Gameboard class.
	 * 
	 * @return 2D array of Tile
	 */

	public Tile[][] getTiles () {
		return board;
	}
}