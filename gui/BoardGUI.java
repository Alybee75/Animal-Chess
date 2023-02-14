import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class BoardGUI extends JFrame
{
    private JPanel boardPanel;
    private JPanel infoPanel;

    //grid is basically yes, the grid, they're gonna be the boxes
    protected JPanel[][] grid;
    //gridBtns: each spot in the grid has a gridBtn, this is wot u press.
    protected JButton2D[][] gridBtns;
    //gridBGs: each spot in the grid has a gridBG, this is basically the image, the background.
    protected JLabel2D[][] gridBGs;
    private static final int ROW = 9;
    private static final int COL = 7;
    private JLabel whoTurn;
    private JLabel whoWin;
    private Border border;
    protected JButton resetBtn;
    protected JButton exitBtn;
    
    //private BufferedImage img;

    public BoardGUI()
    {
        super("Animal Chess");
        setSize(850, 750);
        //layout is gridlayout for the whole jframe
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        gameboardScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void gameboardScreen()
    {
        
        boardPanel = new JPanel();
        infoPanel = new JPanel();
        grid = new JPanel[COL][ROW];
        gridBGs = new JLabel2D[COL][ROW];
        gridBtns = new JButton2D[COL][ROW];
        border = new LineBorder(Color.WHITE, 2, false);
        boardPanel.setLayout(new GridLayout(COL, ROW));
        whoTurn = new JLabel("Red Turn");
        whoWin = new JLabel();
        add(boardPanel);
        //add(infoSide, BorderLayout.EAST);

        //initializing the 2d array of JPanels and gridBGs
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                grid[i][j] = new JPanel();
                boardPanel.add(grid[i][j]);
                //These 2 statements are basically here to have the images properly positioned
                //gridBGs[i][j] = new JLabel2D();
                //gridBGs[i][j].setLayout(new FlowLayout(FlowLayout.CENTER));
            }
        }
        //gridBGs[i][j].setIcon(new ImageIcon("Grass.png"));
        //setIcon means its setting an image, first parameter is the filename, second parameter is the description
        //i added dat description cus theres no way to like get the file path of the image after its been made
        //so i added like a description as a sort of identifier.

        //gridBGs wil have the terrain icons

        gridBGs[3][0] = new JLabel2D(new ImageIcon("RDen.png"), 3, 0, "RDen");
        gridBGs[3][8] = new JLabel2D(new ImageIcon("BDen.png"), 3, 8, "BDen");

        gridBGs[1][3] = new JLabel2D(new ImageIcon("River.png"), 1, 3, "River");
        gridBGs[2][3] = new JLabel2D(new ImageIcon("River.png"), 2, 3, "River");
        gridBGs[4][3] = new JLabel2D(new ImageIcon("River.png"), 4, 3, "River");
        gridBGs[5][3] = new JLabel2D(new ImageIcon("River.png"), 5, 3, "River");

        gridBGs[1][4] = new JLabel2D(new ImageIcon("River.png"), 1, 4, "River");
        gridBGs[2][4] = new JLabel2D(new ImageIcon("River.png"), 2, 4, "River");
        gridBGs[4][4] = new JLabel2D(new ImageIcon("River.png"), 4, 4, "River");
        gridBGs[5][4] = new JLabel2D(new ImageIcon("River.png"), 5, 4, "River");

        gridBGs[1][5] = new JLabel2D(new ImageIcon("River.png"), 1, 5, "River");
        gridBGs[2][5] = new JLabel2D(new ImageIcon("River.png"), 2, 5, "River");
        gridBGs[4][5] = new JLabel2D(new ImageIcon("River.png"), 4, 5, "River");
        gridBGs[5][5] = new JLabel2D(new ImageIcon("River.png"), 5, 5, "River");

        gridBGs[2][0] = new JLabel2D(new ImageIcon("RTrap.png"), 2, 0, "RTrap");
        gridBGs[4][0] = new JLabel2D(new ImageIcon("RTrap.png"), 4, 0, "RTrap");
        gridBGs[3][1] = new JLabel2D(new ImageIcon("RTrap.png"), 3, 1, "RTrap");

        gridBGs[2][8] = new JLabel2D(new ImageIcon("BTrap.png"), 2, 8, "BTrap");
        gridBGs[4][8] = new JLabel2D(new ImageIcon("BTrap.png"), 4, 8, "BTrap");
        gridBGs[3][7] = new JLabel2D(new ImageIcon("BTrap.png"), 3, 7, "BTrap");


        //every other spot in the gridBGs are grass
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (gridBGs[i][j] == null) {
                    gridBGs[i][j] = new JLabel2D(new ImageIcon("Grass.png"), i, j, "Grass");
                }
                gridBGs[i][j].setBorder(border);
                gridBGs[i][j].setLayout(new FlowLayout(FlowLayout.CENTER));
                grid[i][j].add(gridBGs[i][j]);
            }
        }
/*
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                gridBGs[i][j].setLayout(new FlowLayout(FlowLayout.CENTER));
                
                grid[i][j].add(gridBGs[i][j]);
            }
        }*/

        //setIcon means its setting an image, first parameter is the filename, second parameter is the description
        //i added dat description cus theres no way to like get the file path of the image after its been made
        //so i added like a description as a sort of identifier.


        //JButtons wwill have the Animal icons
        gridBtns[6][2] = new JButton2D(new ImageIcon("RMouse.png"), 6, 2, "rMOU", 1);        
        gridBtns[0][6] = new JButton2D(new ImageIcon("BMouse.png"), 0, 6, "bMOU", 2);

        gridBtns[1][1] = new JButton2D(new ImageIcon("RCat.png"), 1, 1, "rCAT", 1);
        gridBtns[5][7] = new JButton2D(new ImageIcon("BCat.png"), 5, 7, "bCAT", 2);

        gridBtns[2][2] = new JButton2D(new ImageIcon("RWolf.png"), 2, 2, "rWLF", 1);
        gridBtns[4][6] = new JButton2D(new ImageIcon("BWolf.png"), 4, 6, "bWLF", 2);
        
        gridBtns[5][1] = new JButton2D(new ImageIcon("RDog.png"), 5, 1, "rDOG", 1);
        gridBtns[1][7] = new JButton2D(new ImageIcon("BDog.png"), 1, 7, "bDOG", 2);

        gridBtns[4][2] = new JButton2D(new ImageIcon("RLeopard.png"), 4, 2, "rLPD", 1);
        gridBtns[2][6] = new JButton2D(new ImageIcon("BLeopard.png"), 2, 6, "bLPD", 2);

        gridBtns[0][0] = new JButton2D(new ImageIcon("RTiger.png"), 0, 0, "rTIG", 1);
        //isSelected(grid[0][0]);
        gridBtns[6][8] = new JButton2D(new ImageIcon("BTiger.png"), 6, 8, "bTIG", 2);

        gridBtns[6][0] = new JButton2D(new ImageIcon("RLion.png"), 6, 0, "rLIO", 1);
        gridBtns[0][8] = new JButton2D(new ImageIcon("BLion.png"), 0, 8, "bLIO", 2);

        gridBtns[0][2] = new JButton2D(new ImageIcon("RElephant.png"), 0, 2, "rELE", 1);
        gridBtns[6][6] = new JButton2D(new ImageIcon("BElephant.png"), 6, 6, "bELE", 2);
        
        //this for loop will add the remaining buttons as null, otherwise the 2d array wont work
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (gridBtns[i][j] == null) {
                    gridBtns[i][j] = new JButton2D(null, i, j, " ", 0);
                    gridBtns[i][j].setIcon(null);
                }
                
                //set Border null is to remove the border of the buttons
                gridBtns[i][j].setBorder(null);

                //setContentAreaFilled is to remove the stuff around the button, i commented it out muna since if its false
                //its hard to tell if u pressed the button lel

                gridBtns[i][j].setContentAreaFilled(false);
				//gridBtns[i][j].setPreferredSize(new Dimension(80, 80));
                gridBtns[i][j].setPreferredSize(new Dimension(80, 80));
                gridBGs[i][j].add(gridBtns[i][j]);
            }
        }
        infoPanel.setLayout(new FlowLayout());
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");
        add(infoPanel);
        infoPanel.add(whoTurn);
        infoPanel.add(whoWin);
        infoPanel.add(resetBtn);
    }

    //sets the listeners so they can be used by the mouse
    public void setListeners(MouseListener listener)
    {
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                grid[i][j].addMouseListener(listener);
				gridBtns[i][j].addMouseListener(listener);
            }
        }

        resetBtn.addMouseListener(listener);


    }


    //ok so this method is meant to basically: if you press a button with an animal on it, the panel its in, will 
    // change the border color, indicating na ito ung sinelect mo
    public void isSelected(int x, int y) {
        border = new LineBorder(Color.BLUE, 2, false);
        gridBGs[x][y].setBorder(border);
    }
	
	public void removeSelected(int x, int y) {
        gridBGs[x][y].setBorder(null);
    }

    //this method basically changes the image of a button, this is for like kung magchachange ng images when moving a piece or smtn
    public void setImage(String s, int x, int y) {
        gridBtns[x][y].setIcon(new ImageIcon(s));
    }

    public void canMoveHere(int x, int y) {
        border = new LineBorder(Color.YELLOW, 2, false);
        gridBGs[x][y].setBorder(border);
        gridBtns[x][y].setHighlightYellow(true);
    }
	
	public void removeYellow(){
		for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (gridBtns[i][j].isHighlightedYellow()){
					gridBGs[i][j].setBorder(null);
					gridBtns[i][j].setHighlightYellow(false);
				}
            }
        }
	}

    public String getImageBtnDescription(int x, int y) {
        String s;
        s = ((ImageIcon)gridBtns[x][y].getIcon()).getDescription();
        return s;
    }


    public void setWhoTurn(boolean t) {
        if (t == false) {
            whoTurn.setFont(new Font("Courier New", Font.BOLD, 18));
            whoTurn.setForeground(Color.RED);
            whoTurn.setText("Red Turn");
        }
            
        else {
            whoTurn.setFont(new Font("Courier New", Font.BOLD, 18));
            whoTurn.setForeground(Color.BLUE);
            whoTurn.setText("Blue Turn");
        }
            
    }

    public void setWhoWin(boolean t) {
        if (t == false) {
            whoWin.setFont(new Font("Courier New", Font.BOLD, 20));
            whoWin.setForeground(Color.RED);
            whoWin.setText("Red Wins!");
        }
            
        else {
            whoWin.setFont(new Font("Courier New", Font.BOLD, 20));
            whoWin.setForeground(Color.BLUE);
            whoWin.setText("Blue Wins!"); 
        }
            
    }
    
}
