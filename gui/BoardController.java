import java.awt.event.*;

//implements MouseListener is basically implementing Mouse Stuff
public class BoardController implements MouseListener 
{
    //the variables yes
    private int firstT;
    private boolean colorTurn;
    private Gameboard board;
    private Player play;
    protected BoardGUI bGUI;
    private Tile[][] tileGrid;
    private int x1 = -1, x2 = -1;
    private int y1 = -1, y2 = -1;
	private static final int ROW = 9;
    private static final int COL = 7;

    //constructor that initializes everything
    public BoardController(int whoFirst, boolean cFirst, Gameboard gb, Player p, BoardGUI bg) 
    {
        firstT = whoFirst;
        colorTurn = cFirst;
        board = gb;
        play = p;
        bGUI = bg;
        bGUI.setListeners(this);
		setupBoard();
		bGUI.setWhoTurn(colorTurn);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
				if(e.getSource() == bGUI.gridBtns[i][j] && bGUI.gridBtns[i][j].isHighlightedYellow()){
					x2 = i;
					y2 = j;
					bGUI.isSelected(i, j);
				}
				else if (e.getSource() == bGUI.gridBtns[i][j]) {
					if (x1 != -1 && y1 != -1){
						bGUI.removeYellow();
						bGUI.removeSelected(x1, y1);
					}
		
					
					//if ang naclick na button is a Red animal AND its Red's turn then: 
					if (((JButton2D) e.getSource()).getColor() == 1 && colorTurn == false) {
						x1 = i;
						y1 = j;
						bGUI.isSelected(i, j);
						moveSpots(x1, y1);
					}

					//if ang naclick na button is a Blue animal AND its Blue's turn then:
					else if (((JButton2D) e.getSource()).getColor() == 2 && colorTurn == true) {
						x1 = i;
						y1 = j;
						bGUI.isSelected(i, j);
						moveSpots(x1, y1);
					}
					
				}
				else if (e.getSource() == bGUI.grid[i][j] && x1 != -1 && y1 != -1){
					x2 = i;
					y2 = j;
					bGUI.isSelected(i, j);
				}
			}
		}
		game();

		if (e.getSource() == bGUI.resetBtn) {
			bGUI.dispose();
			Game g = new Game();
            RandomizerGUI randomizerG = new RandomizerGUI();
            RandomizerController r = new RandomizerController(randomizerG, g);
		}

		
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
		
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void setupBoard()
    {
        board = new Gameboard();
        tileGrid = board.getTiles();
    }
	
	public void updateButtons(int a, int b, Tile n){
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
	
	public void moveSpots(int x, int y) {
        checkUp(x, y);
		checkDown(x, y);
		checkLeft(x, y);
        checkRight(x, y);
    }


    public boolean checkUp(int x, int y) {
		Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		if (ani[x][y].getAnimal().ifOutOfBounds(x-1, y) == true)
			return false;
        if (bGUI.gridBtns[x - 1][y].getIcon() == null) {
			if ((x-1 == 3 && y == 0 && p == 1) || (x-1 == 3 && y == 8 && p == 2))
				return false;
			else if(ani[x-1][y] != null && ani[x-1][y].getTerrain() instanceof River){
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x-1][y] != null && t.ferociousLeap(ani[x-1][y]) == true){
						while (ani[x-1][y] != null && ani[x-1][y].getTerrain() instanceof River)
							x--;
					}
					if (ani[x-1][y] == null){
						bGUI.canMoveHere(x-1, y);
						return true;			
					}				
				}
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x-1][y] != null && t.ferociousLeap(ani[x-1][y]) == true){
						while (ani[x-1][y] != null && ani[x-1][y].getTerrain() instanceof River) 
							x--;
					}
					if (ani[x-1][y] == null){
						bGUI.canMoveHere(x-1, y);
						return true;			
					}		
				}	
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x-1][y] != null && m.swim(ani[x-1][y])){
						bGUI.canMoveHere(x-1, y);
						return true;			
					}	
				}
				else 
					return false;
			}
			else{
				bGUI.canMoveHere(x-1, y);
				return true;
			}
        }
		if (ani[x-1][y] != null && ani[x-1][y].getAnimal() != null) {
			if (ani[a][b].getAnimal().capture(ani[x-1][y].getAnimal()) == true){
				bGUI.canMoveHere(x-1, y);
				return true;
			}
			else
				return false;
		}
        return false;
    }
	
    public boolean checkDown(int x, int y) {
        Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		if (ani[x][y].getAnimal().ifOutOfBounds(x+1, y) == true)
			return false;
        if (bGUI.gridBtns[x + 1][y].getIcon() == null) {
			if ((x+1 == 3 && y == 0 && p == 1) || (x+1 == 3 && y == 8 && p == 2))
				return false;
			else if(ani[x+1][y] != null && ani[x+1][y].getTerrain() instanceof River){
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x+1][y] != null && t.ferociousLeap(ani[x+1][y]) == true){
						while (ani[x+1][y] != null && ani[x+1][y].getTerrain() instanceof River)
							x++;
					}
					if (ani[x+1][y] == null){
						bGUI.canMoveHere(x+1, y);
						return true;			
					}				
				}
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x+1][y] != null && t.ferociousLeap(ani[x+1][y]) == true){
						while (ani[x+1][y] != null && ani[x+1][y].getTerrain() instanceof River) 
							x++;
					}
					if (ani[x+1][y] == null){
						bGUI.canMoveHere(x+1, y);
						return true;			
					}		
				}	
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x+1][y] != null && m.swim(ani[x+1][y])){
						bGUI.canMoveHere(x+1, y);
						return true;			
					}	
				}
				else
					return false;
			}
			else{
				bGUI.canMoveHere(x+1, y);
				return true;
			}
        }
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

    public boolean checkLeft(int x, int y) {
        Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		if (ani[x][y].getAnimal().ifOutOfBounds(x, y-1) == true)
			return false;
        if (bGUI.gridBtns[x][y-1].getIcon() == null) {
			if ((x == 3 && y-1 == 0 && p == 1) || (x == 3 && y-1 == 8 && p == 2))
				return false;
			else if(ani[x][y-1] != null && ani[x][y-1].getTerrain() instanceof River){
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x][y-1] != null && t.ferociousLeap(ani[x][y-1]) == true){
						while (ani[x][y-1] != null && ani[x][y-1].getTerrain() instanceof River)
							y--;
					}
					if (ani[x][y-1] == null){
						bGUI.canMoveHere(x, y-1);
						return true;			
					}				
				}
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x][y-1] != null && t.ferociousLeap(ani[x][y-1]) == true){
						while (ani[x][y-1] != null && ani[x][y-1].getTerrain() instanceof River) 
							y--;
					}
					if (ani[x][y-1] == null){
						bGUI.canMoveHere(x, y-1);
						return true;			
					}	
				}	
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

    public boolean checkRight(int x, int y) {
        Tile[][] ani;
		ani = board.getTiles();
		int p;
		String n;
		int a = 0, b = 0;
		
		a = x;
		b = y;
		p = ani[x][y].getAnimal().getPNum();
		n = ani[x][y].toString();
		
		if (ani[x][y].getAnimal().ifOutOfBounds(x, y+1) == true)
			return false;
        if (bGUI.gridBtns[x][y+1].getIcon() == null) {
			if ((x == 3 && y+1 == 0 && p == 1) || (x == 3 && y+1 == 8 && p == 2))
				return false; 
			else if(ani[x][y+1] != null && ani[x][y+1].getTerrain() instanceof River){
				if (ani[x][y].getAnimal() instanceof Lion) {
					Lion t = new Lion (x, y, p, n);
					if (ani[x][y+1] != null && t.ferociousLeap(ani[x][y+1]) == true){
						while (ani[x][y+1] != null && ani[x][y+1].getTerrain() instanceof River)
							y++;
					}
					if (ani[x][y+1] == null){
						bGUI.canMoveHere(x, y+1);
						return true;			
					}				
				}
				else if (ani[x][y].getAnimal() instanceof Tiger) {
					Tiger t = new Tiger (x, y, p, n);
					if (ani[x][y+1] != null && t.ferociousLeap(ani[x][y+1]) == true){
						while (ani[x][y+1] != null && ani[x][y+1].getTerrain() instanceof River) 
							y++;
					}
					if (ani[x][y+1] == null){
						bGUI.canMoveHere(x, y+1);
						return true;			
					}	
				}	
				else if (ani[x][y].getAnimal() instanceof Mouse) {
					Mouse m = new Mouse(x, y, p, n);
					if (ani[x][y+1] != null && m.swim(ani[x][y+1])){
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
	
    public void game()
    {
		boolean tempTurn;
		tempTurn = colorTurn;
		Tile temp;
		
		
		String move = "A", name = "A";
		System.out.println(x1+ " " + y1 + " " + x2 + " " + y2);
		if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1){
			System.out.println("HEY");
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
			
			System.out.println("MOOVE " + move);
			bGUI.removeSelected(x1, y1);
			bGUI.removeSelected(x2, y2);
			bGUI.removeYellow();
			
			name = tileGrid[x1][y1].toString();
			firstT = play.getPNum();

			
			
				
			
			temp = board.updateBoard(name, firstT, move);
			
			if (temp != tileGrid[x1][y1]){
				updateButtons(x1, y1, temp);
				System.out.println(temp.toString());
				colorTurn = play.nextTurn();
				bGUI.setWhoTurn(colorTurn);
				if(board.checkWin(temp, firstT) || board.getAnimalsLeft(0) == 0 || board.getAnimalsLeft(1) == 0 )
					System.out.println("congrats");

				if (board.checkWin(temp, firstT) == true && firstT == 1) {
					bGUI.setWhoWin(false);
					
				}

				else if (board.checkWin(temp, firstT) == true && firstT == 2) {
					bGUI.setWhoWin(true);
					
				}

				else if (board.getAnimalsLeft(0) == 0) {
					bGUI.setWhoWin(true);
					
				}	

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
