import java.awt.event.*;

/**
 * The class Board Controller is the controller for the BoardGUI, Gameboard,
 * and Player classes. It will handle the logic between these classes, and will act
 * as a sort of mediator between them, hence the MVC architecture. The Model being
 * Gameboard, Player, and all of the other classes that it utilizes (like Animal and
 * Terrain). The View being the BoardGUI which will work in tandem to BoardController,
 * and finally, the Controller itself, which is this class. It also extends
 * MouseAdapter which will be used as the main listeners for the buttons. It will 
 * utilize the MouseClicked method.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class BoardController extends MouseAdapter {
    /**
	 * This variable will take in who was first in the constructor.
	 * It will come from the Randomizer java files.
	 */
    private int firstT;
	/**
	 * This variable will take in the color that was picked for the
	 * first turn. It will come from the Randomizer java files.
	 */
    private boolean colorTurn;
	/**
	 * This variable will take in Gameboard and will be used for the
	 * controller.
	 */
    private Gameboard board;
	/**
	 * This variable will take in Player and will be used for the
	 * controller.
	 */
    private Player play;
	/**
	 * This attribute is to be taken by the controller so that it can be
	 * modified using the Model files.
	 */
    protected BoardGUI bGUI;
	/**
	 * This attribute is a 2D array of tile which will later have the same
	 * tiles as the ones in Gameboard.
	 */
    private Tile[][] tileGrid;
	/**
	 * This variable would be the x value of the animal that you click on the
	 * board. Default value is -1.
	 */
    private int x1 = -1;
	/**
	 * This variable would be the x value of the tile that you choose to move
	 * to (the one highlighted in yellow). Default value is -1.
	 */
	private int x2 = -1;
	/**
	 * This variable would be the y value of the animal that you click on the
	 * board. Default value is -1.
	 */
    private int y1 = -1;
	/**
	 * This variable would be the y value of the tile that you choose to move
	 * to (the one highlighted in yellow). Default value is -1.
	 */
	private int y2 = -1;
	/**
	 * This static final variable holds the number of rows for the board.
	 */
	private static final int ROW = 9;
	 /**
	 * This static final variable holds the number of columns for the board.
	 */
    private static final int COL = 7;

    /**
	 * This contstructor initializes the variables to be used for the BoardController.
	 * The first two variables, whoFirst and cFirst, came from the results of the
	 * randomizer; these are the results on who goes first and the color they picked,
	 * respectively. Next, the third and fourth variable are the Models in this MVC.
	 * Gameboard and Player utilizes the other java files such as Entity, Animal, Terrain,
	 * Dog, Tile, etc. Lastly, it will take in the View in MVC, which is BoardGUI. This
	 * is the GUI for the whole game itself and will be updated by this controller.
	 * 
	 * @param whoFirst the result of the randomization on who won
	 * @param cFirst the color the winning player of the randomization that they picked
	 * @param gb gameboard to be used for the controller (Model)
	 * @param p player to be used for the controller (Model)
	 * @param bg boardGUI to be used for the controller (View)
	 */

    public BoardController (int whoFirst, boolean cFirst, Gameboard gb, Player p, BoardGUI bg) {
        firstT = whoFirst;
        colorTurn = cFirst;
        board = gb;
        play = p;
        bGUI = bg;
        bGUI.setListeners(this);
		setupBoard();
		bGUI.setWhoTurn(colorTurn);
    }
    
	/**
	 * This method overrides mouseClicked that came from MouseAdapter. This
	 * is responsible for what happens when you click a button in the board,
	 * as well as click the highighted yellow tile (when you try to move).
	 * This also has the function for the reset button which will just reset
	 * the game, going back to the randomization screen. It also calls the
	 * game method, which has the logic to update the GUI from the model files.
	 */
    @Override
    public void mouseClicked (MouseEvent e) {
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
				//if the button clicked is in the board and it's highlighted yellow
				if (e.getSource() == bGUI.gridBtns[i][j] && bGUI.gridBtns[i][j].isHighlightedYellow()) {
					x2 = i;
					y2 = j;
					bGUI.isSelected(i, j);
				}

				//if the button that was clicked is in the board
				else if (e.getSource() == bGUI.gridBtns[i][j]) {
					if (x1 != -1 && y1 != -1){
						bGUI.removeYellow();
						bGUI.removeSelected(x1, y1);
					}
		
					//if the button that was clicked is a red animal AND it's red's turn, then
					//that button will be highlighted, as well as check the areas around it if they
					//can move there.
					if (((JButton2D) e.getSource()).getColor() == 1 && colorTurn == false) {
						x1 = i;
						y1 = j;
						bGUI.isSelected(i, j);
						moveSpots(x1, y1);
					}

					//if the button that was clicked is a blue animal AND it's blue's turn, then
					//that button will be highlighted, as well as check the areas around it if they
					//can move there.
					else if (((JButton2D) e.getSource()).getColor() == 2 && colorTurn == true) {
						x1 = i;
						y1 = j;
						bGUI.isSelected(i, j);
						moveSpots(x1, y1);
					}	
				}

				//if the button that was clicked is a tile that isn't occupied yet
				else if (e.getSource() == bGUI.grid[i][j] && x1 != -1 && y1 != -1){
					x2 = i;
					y2 = j;
				}
			}
		}
		//calls the game method to oversee the game process.
		game();

		//if the reset button was clicked, it will dispose the GUI and open the randomizer Screen.
		if (e.getSource() == bGUI.resetBtn) {
			bGUI.dispose();
			Game g = new Game();
            RandomizerGUI randomizerG = new RandomizerGUI();
            RandomizerController r = new RandomizerController(randomizerG, g);
		}

		
    }

	/**
	 * This method sets up the board from the model Gameboard.
	 */

    public void setupBoard () {
        board = new Gameboard();
        tileGrid = board.getTiles();
    }

	/**
	 * This method updates the buttons whenever movement happens in the
	 * gameboard.
	 * 
	 * @param a x value of the one being updated
	 * @param b y value of the one being updated
	 * @param n tile that is moving on
	 */
	
	public void updateButtons (int a, int b, Tile n) {
		int c = 0, d = 0, color = 0;
		String s, name;
		
		c = n.getX();
		d = n.getY();
		
		s = bGUI.getImageBtnDescription(a, b);
		name = n.toString();
		color = n.getAnimal().getPNum();
		
		bGUI.gridBtns[c][d].updateColor(color);
		bGUI.setImage(s, c, d);
		bGUI.gridBtns[a][b].setIcon(null);
	}

	/**
	 * This method calls checkUp, checkDown, checkLeft and checkRight,
	 * to check if these will return true or not.
	 * 
	 * @param x x value of the selected animal
	 * @param y y value of the selected animal
	 */
	
	public void moveSpots (int x, int y) {
        checkUp(x, y);
		checkDown(x, y);
		checkLeft(x, y);
        checkRight(x, y);
    }

	/**
	 * This method checks if the tile above the animal can be moved to.
	 * 
	 * @param x x value of the animal
	 * @param y y value of the animal
	 * @return boolean value of it's possible to move here
	 */

    public boolean checkUp (int x, int y) {
		Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		//checks if the spot is out of bounds
		if (ani[x][y].getAnimal().ifOutOfBounds(x - 1, y) == true)
			return false;
        if (bGUI.gridBtns[x - 1][y].getIcon() == null) {
			//checks if it's moving to your own den
			if ((x - 1 == 3 && y == 0 && p == 1) || (x - 1 == 3 && y == 8 && p == 2))
				return false;
			//checks if the spot is an instance of river
			else if (ani[x - 1][y] != null && ani[x - 1][y].getTerrain() instanceof River) {
				//if the animal being controlled is a lion, it can do ferocious leap
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x - 1][y] != null && t.ferociousLeap(ani[x - 1][y]) == true){
						while (ani[x - 1][y] != null && ani[x - 1][y].getTerrain() instanceof River)
							x--;
					}
					
					//if it reaches land or grass, it can safely move here
					if (ani[x - 1][y] == null) {
						bGUI.canMoveHere(x - 1, y);
						return true;			
					}				
				}

				//if the animal being controlled is a tiger, it can do ferocious leap
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x - 1][y] != null && t.ferociousLeap(ani[x-1][y]) == true) {
						while (ani[x-1][y] != null && ani[x-1][y].getTerrain() instanceof River) 
							x--;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x - 1][y] == null) {
						bGUI.canMoveHere(x-1, y);
						return true;			
					}		
				}	

				//if the animal being controlled is a mouse, it can swim across the river
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x - 1][y] != null && m.swim(ani[x - 1][y])) {
						bGUI.canMoveHere(x-1, y);
						return true;			
					}	
				}

				else 
					return false;
			}
			else {
				bGUI.canMoveHere(x-1, y);
				return true;
			}
        }

		//if there is an animal on the spot, checks the capture condition
		if (ani[x - 1][y] != null && ani[x - 1][y].getAnimal() != null) {
			if (ani[a][b].getAnimal().capture(ani[x - 1][y].getAnimal()) == true){
				bGUI.canMoveHere(x-1, y);
				return true;
			}

			else
				return false;
		}
        return false;
    }

	/**
	 * This method checks if the tile below the animal can be moved to.
	 * 
	 * @param x x value of the animal
	 * @param y y value of the animal
	 * @return boolean value of it's possible to move here
	 */
	
    public boolean checkDown (int x, int y) {
        Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		//checks if the spot is out of bounds
		if (ani[x][y].getAnimal().ifOutOfBounds(x + 1, y) == true)
			return false;
        if (bGUI.gridBtns[x + 1][y].getIcon() == null) {
			//checks if it's moving to your own den
			if ((x + 1 == 3 && y == 0 && p == 1) || (x + 1 == 3 && y == 8 && p == 2))
				return false;
			
			//checks if the spot is an instance of river
			else if(ani[x + 1][y] != null && ani[x + 1][y].getTerrain() instanceof River) {
				//if the animal being controlled is a lion, it can do ferocious leap
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x + 1][y] != null && t.ferociousLeap(ani[x + 1][y]) == true){
						while (ani[x + 1][y] != null && ani[x+1][y].getTerrain() instanceof River)
							x++;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x + 1][y] == null) {
						bGUI.canMoveHere(x + 1, y);
						return true;			
					}				
				}

				//if the animal being controlled is a tiger, it can do ferocious leap
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x + 1][y] != null && t.ferociousLeap(ani[x + 1][y]) == true){
						while (ani[x + 1][y] != null && ani[x + 1][y].getTerrain() instanceof River) 
							x++;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x + 1][y] == null) {
						bGUI.canMoveHere(x + 1, y);
						return true;			
					}		
				}	

				//if the animal being controlled is a mouse, it can swim across the river
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x + 1][y] != null && m.swim(ani[x + 1][y])){
						bGUI.canMoveHere(x + 1, y);
						return true;			
					}	
				}
				else
					return false;
			}
			else{
				bGUI.canMoveHere(x + 1, y);
				return true;
			}
        }

		//if there is an animal on the spot, checks the capture condition
		if (ani[x+1][y] != null && ani[x+1][y].getAnimal() != null) {
			if (ani[a][b].getAnimal().capture(ani[x+1][y].getAnimal()) == true){
				bGUI.canMoveHere(x+1, y);
				return true;
			}
			else
				return false;
		}
        return false;
    }

	/**
	 * This method checks if the tile left of the animal can be moved to.
	 * 
	 * @param x x value of the animal
	 * @param y y value of the animal
	 * @return boolean value of it's possible to move here
	 */

    public boolean checkLeft (int x, int y) {
        Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		//checks if the spot is out of bounds
		if (ani[x][y].getAnimal().ifOutOfBounds(x, y-1) == true)
			return false;
        if (bGUI.gridBtns[x][y-1].getIcon() == null) {
			//checks if it's moving to your own den
			if ((x == 3 && y-1 == 0 && p == 1) || (x == 3 && y-1 == 8 && p == 2))
				return false;
			
			//checks if the spot is an instance of river
			else if(ani[x][y-1] != null && ani[x][y-1].getTerrain() instanceof River) {
				//if the animal being controlled is a lion, it can do ferocious leap
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x][y-1] != null && t.ferociousLeap(ani[x][y-1]) == true){
						while (ani[x][y-1] != null && ani[x][y-1].getTerrain() instanceof River)
							y--;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x][y-1] == null) {
						bGUI.canMoveHere(x, y-1);
						return true;			
					}				
				}

				//if the animal being controlled is a tiger, it can do ferocious leap
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x][y-1] != null && t.ferociousLeap(ani[x][y-1]) == true){
						while (ani[x][y-1] != null && ani[x][y-1].getTerrain() instanceof River) 
							y--;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x][y-1] == null) {
						bGUI.canMoveHere(x, y-1);
						return true;			
					}	
				}	

				//if the animal being controlled is a mouse, it can swim
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x][y-1] != null && m.swim(ani[x][y-1])){
						bGUI.canMoveHere(x, y-1);
						return true;			
					}	
				}
				else 
					return false;
			}
			else{
				bGUI.canMoveHere(x, y-1);
				return true;
			}
        }

		//if there is an animal on the spot, checks the capture condition
		if (ani[x][y-1] != null && ani[x][y-1].getAnimal() != null) {
			if (ani[a][b].getAnimal().capture(ani[x][y-1].getAnimal()) == true){
				bGUI.canMoveHere(x, y-1);
				return true;
			}
			else
				return false;
		}
        return false;
    }

	/**
	 * This method checks if the tile right of the animal can be moved to.
	 * 
	 * @param x x value of the animal
	 * @param y y value of the animal
	 * @return boolean value of it's possible to move here
	 */

    public boolean checkRight (int x, int y) {
        Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		//checks if the spot is out of bounds
		if (ani[x][y].getAnimal().ifOutOfBounds(x, y + 1) == true)
			return false;
        if (bGUI.gridBtns[x][y+1].getIcon() == null) {
			//checks if it's moving to your own den
			if ((x == 3 && y+1 == 0 && p == 1) || (x == 3 && y+1 == 8 && p == 2))
				return false; 
			
			//checks if the spot is an instance of river
			else if(ani[x][y+1] != null && ani[x][y+1].getTerrain() instanceof River) {
				//if the animal being controlled is a lion, then it can do ferocious leap
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x][y+1] != null && t.ferociousLeap(ani[x][y+1]) == true) {
						while (ani[x][y+1] != null && ani[x][y+1].getTerrain() instanceof River)
							y++;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x][y+1] == null) {
						bGUI.canMoveHere(x, y+1);
						return true;			
					}				
				}

				//if the animal being controlled is a lion, then it can do ferocious leap
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x][y+1] != null && t.ferociousLeap(ani[x][y+1]) == true) {
						while (ani[x][y+1] != null && ani[x][y+1].getTerrain() instanceof River) 
							y++;
					}

					//if it reaches land or grass, it can safely move here
					if (ani[x][y+1] == null) {
						bGUI.canMoveHere(x, y+1);
						return true;			
					}	
				}	

				//if the animal being controlled is a mouse, it can swim
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x][y+1] != null && m.swim(ani[x][y+1])) {
						bGUI.canMoveHere(x, y+1);
						return true;			
					}	
				}
				else
					return false;
			}
			else{
				bGUI.canMoveHere(x, y+1);
				return true;
			}
        }

		//if there is an animal on the spot, checks the capture condition
		if (ani[x][y+1] != null && ani[x][y+1].getAnimal() != null) {
			if (ani[a][b].getAnimal().capture(ani[x][y+1].getAnimal()) == true){
				bGUI.canMoveHere(x, y+1);
				return true;
			}
			else
				return false;
		}
        return false;
    }

	/**
	 * This method is going to manage the whole game process. It also monitors if someone
	 * has won already.
	 */
	
    public void game () {
		boolean tempTurn;
		tempTurn = colorTurn;
		Tile temp;
		
		
		String move = "A", name = "A";
		System.out.println(x1+ " " + y1 + " " + x2 + " " + y2);
		if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1){
			System.out.println("CHECK");
			if (x1-x2 == 0){
				if(y1-y2 < 0){
					move = "R";
				}
				else if(y1-y2 > 0){
					move = "L";
				}
			}
			else if (y1-y2 == 0){
				if(x1-x2 < 0){
					move = "D";
				}
				else if(x1-x2 > 0){
					move = "U";
				}
			}
			
			System.out.println("MOVE " + move);
			bGUI.removeSelected(x1, y1);
			bGUI.removeSelected(x2, y2);
			bGUI.removeYellow();
			
			name = tileGrid[x1][y1].toString();
			firstT = play.getPNum();

			temp = board.updateBoard(name, firstT, move);
			
			if (temp != tileGrid[x1][y1]) {
				updateButtons(x1, y1, temp);
				System.out.println(temp.toString());
				colorTurn = play.nextTurn();
				bGUI.setWhoTurn(colorTurn);

				//Checks if someone has won
				if(board.checkWin(temp, firstT) || board.getAnimalsLeft(0) == 0 || board.getAnimalsLeft(1) == 0)
					System.out.println("congrats");

				//checks if someone has landed on blue den, meaning red wins
				if (board.checkWin(temp, firstT) == true && firstT == 1) {
					bGUI.setWhoWin(false);
					
				}

				//checks if someone has landed on red den, meaning blue wins
				else if (board.checkWin(temp, firstT) == true && firstT == 2) {
					bGUI.setWhoWin(true);
					
				}

				//checks if red team has no more animals left, blue wins
				else if (board.getAnimalsLeft(0) == 0) {
					bGUI.setWhoWin(true);
					
				}	

				//checks if blue team has no more animals left, red wins
				else if (board.getAnimalsLeft(1) == 0) {
					bGUI.setWhoWin(false);

				}	
			}
				
			x1 = -1;
			y1 = -1;
			x2 = -1;
			y2 = -1;
		}
    }
}