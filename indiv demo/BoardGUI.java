import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is for the GUI or View part of the Board Screen. 
 * It utilizes Java Swing and Java AWT and extends JFrame. This is the
 * View in the MVC for the game itself.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class BoardGUI extends JFrame {
    /**
     * This JPanel serves as the location of all the board components.
     */
    private JPanel boardPanel;
    /**
     * This JPanel serves as the location on whose turn is it, if someone has won, and the reset button.
     */
    private JPanel infoPanel;
    /**
     * This 2D array of JPanels serves as the space in each grid in the gridLayout. It will have
     * JButton2D and JLabel2D to occupy it.
     */
    protected JPanel[][] grid;
    /**
     * This attribute is a 2D array of JButton2D. These are the buttons to press and it will
     * have the images of the animals.
     */
    protected JButton2D[][] gridBtns;
    /**
     * This attribute is a 2D array of JLabel2D. These are the labels that will serve as the background
     * of each JPanel grid, and it's basically the terrain.
     */
    protected JLabel2D[][] gridBGs;
    /**
     * This JLabel would be in the infoPanel and indicates whose turn is it.
     */
    private JLabel whoTurn;
    /**
     * This JLabel would be in the infoPanel and indicates if someone has won already.
     */
    private JLabel whoWin;
    /**
     * This will serve as the button to indicate if something has been selected or highlighted
     * yellow.
     */
    private Border border;
    /**
     * This would be in the infoPanel and allows the game to be reset and open
     * the randomizer screen.
     */
    protected JButton resetBtn;
    /**
     * This would be the number of rows in the grid.
     */
    private static final int ROW = 9;
    /**
     * This would be the number of columns in the grid.
     */
    private static final int COL = 7;
    
    /**
     * This constructor will initialize JFrame and the whole GUI component. It
     * will also call in gameboardScreen to initialize the components inside it.
     */
    public BoardGUI() {
        super("Animal Chess");
        setSize(850, 750);
        //layout is gridlayout for the whole jframe
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        gameboardScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method will initiate everything in the BoardGUI such as JPanels, JButton2D,
     * JLabel2D, and more.
     */

    public void gameboardScreen() {
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

        //Initializing the 2D array of JPanels to be added to the GridLayout
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                grid[i][j] = new JPanel();
                boardPanel.add(grid[i][j]);
            }
        }
        
        //Assigning the gridBGs (the JLabel2D) an imageIcon, the coordinates, and the string representation.
        //All photos are taken from Canva with the exception of Traps with the Canva Free Education License
        
        //Funny Hedgehog as Forest Animal Reserving Mushrooms in Tree Hollow Vector Illustration. 
        //Retrieved from Canva for free with Free Education License
        //Flag. gstudioimagen. Retrieved from Canva for free with Free Education License
        gridBGs[3][0] = new JLabel2D(new ImageIcon("RDen.png"), 3, 0, "RDen");
        gridBGs[3][8] = new JLabel2D(new ImageIcon("BDen.png"), 3, 8, "BDen");

        //Wave Icon. Marco Livolsi. Retrieved from Canva for free with Free Education License
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

        //Trap. Retrieved from Animal Chess PDF DLSU
        gridBGs[2][0] = new JLabel2D(new ImageIcon("RTrap.png"), 2, 0, "RTrap");
        gridBGs[4][0] = new JLabel2D(new ImageIcon("RTrap.png"), 4, 0, "RTrap");
        gridBGs[3][1] = new JLabel2D(new ImageIcon("RTrap.png"), 3, 1, "RTrap");

        gridBGs[2][8] = new JLabel2D(new ImageIcon("BTrap.png"), 2, 8, "BTrap");
        gridBGs[4][8] = new JLabel2D(new ImageIcon("BTrap.png"), 4, 8, "BTrap");
        gridBGs[3][7] = new JLabel2D(new ImageIcon("BTrap.png"), 3, 7, "BTrap");

        //every other spot in the gridBGs are assigned with a grass image.
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (gridBGs[i][j] == null) {
                    //Green Grass. JoyImage. Retrieved from Canva for free with Free Education License
                    //Stone. Clairev. Retrieved from Canva for free with Free Education License
                    //Daisy Flower. DKDesignz. Retrieved from Canva for free with Free Education License
                    gridBGs[i][j] = new JLabel2D(new ImageIcon("Grass.png"), i, j, "Grass");
                }
                gridBGs[i][j].setBorder(border);
                gridBGs[i][j].setLayout(new FlowLayout(FlowLayout.CENTER));
                grid[i][j].add(gridBGs[i][j]);
            }
        }

        //Assigning the gridBtns (the JButton2D) an imageIcon, the coordinates, the string representation.
        //and the color of it.

        //Line Pet Mouse. Sketchify. Retrieved from Canva for free with Free Education License
        gridBtns[6][2] = new JButton2D(new ImageIcon("RMouse.png"), 6, 2, "rMOU", 1);        
        gridBtns[0][6] = new JButton2D(new ImageIcon("BMouse.png"), 0, 6, "bMOU", 2);

        //Cute Cartoon Cat. Sketchify. Retrieved from Canva for free with Free Education License
        gridBtns[1][1] = new JButton2D(new ImageIcon("RCat.png"), 1, 1, "rCAT", 1);
        gridBtns[5][7] = new JButton2D(new ImageIcon("BCat.png"), 5, 7, "bCAT", 2);

        //wolf. DAPA Images. Retrieved from Canva for free with Free Education License
        gridBtns[2][2] = new JButton2D(new ImageIcon("RWolf.png"), 2, 2, "rWLF", 1);
        gridBtns[4][6] = new JButton2D(new ImageIcon("BWolf.png"), 4, 6, "bWLF", 2);
        
        //Full Body Beagle. Sketchify. Retrieved from Canva for free with Free Education License
        gridBtns[5][1] = new JButton2D(new ImageIcon("RDog.png"), 5, 1, "rDOG", 1);
        gridBtns[1][7] = new JButton2D(new ImageIcon("BDog.png"), 1, 7, "bDOG", 2);

        //Jungle Leopard. Julia Dreams from Julia Dreams. Retrieved from Canva for free with Free Education License
        gridBtns[4][2] = new JButton2D(new ImageIcon("RLeopard.png"), 4, 2, "rLPD", 1);
        gridBtns[2][6] = new JButton2D(new ImageIcon("BLeopard.png"), 2, 6, "bLPD", 2);

        //Jungle Tiger. Julia Dreams from Julia Dreams. Retrieved from Canva for free with Free Education License
        gridBtns[0][0] = new JButton2D(new ImageIcon("RTiger.png"), 0, 0, "rTIG", 1);
        gridBtns[6][8] = new JButton2D(new ImageIcon("BTiger.png"), 6, 8, "bTIG", 2);

        //Powerful Lion. NotionPic. Retrieved from Canva for free with Free Education License
        gridBtns[6][0] = new JButton2D(new ImageIcon("RLion.png"), 6, 0, "rLIO", 1);
        gridBtns[0][8] = new JButton2D(new ImageIcon("BLion.png"), 0, 8, "bLIO", 2);

        //Jumping Wild Elephant Flat Icon. Moose. Retrieved from Canva for free with Free Education License
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
                gridBtns[i][j].setContentAreaFilled(false);
                gridBtns[i][j].setPreferredSize(new Dimension(80, 80));
                gridBGs[i][j].add(gridBtns[i][j]);
            }
        }

        //sets up the infoPanel which will have the other labels and the reset button
        infoPanel.setLayout(new FlowLayout());
        resetBtn = new JButton("Reset");
        add(infoPanel);
        infoPanel.add(whoTurn);
        infoPanel.add(whoWin);
        infoPanel.add(resetBtn);
    }

    /**
     * This method sets the listeners for all the buttons in BoardGUI. It 
     * takes in MouseListener for it.
     * 
     * @param listener the listener to give the buttons function
     */
    public void setListeners(MouseListener listener) {
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                grid[i][j].addMouseListener(listener);
				gridBtns[i][j].addMouseListener(listener);
            }
        }

        resetBtn.addMouseListener(listener);
    }

    /**
     * This method, when called, gets the x and y coordinates in the BoardController
     * and uses that for the gridBtns array and add a blue border around it. It
     * indicates if the button is selected.
     * 
     * @param x x value of the button
     * @param y y value of the button
     */

    public void isSelected (int x, int y) {
        border = new LineBorder(Color.BLUE, 2, false);
        gridBGs[x][y].setBorder(border);
    }
	
    /**
     * This method, when called, gets the x and y coordinates in the BoardController
     * and uses that for the gridBtns array and remove the border around it.
     * 
     * @param x x value of the button
     * @param y y value of the button
     */

	public void removeSelected (int x, int y) {
        gridBGs[x][y].setBorder(null);
    }

    /**
     * This method changes the image of a button in gridBtns. It takes in a string,
     * which is the filename of the image, the x value of button, and the y value
     * of the button.
     * 
     * @param s filename of the image
     * @param x x value of the button
     * @param y y value of the button
     */

    public void setImage (String s, int x, int y) {
        gridBtns[x][y].setIcon(new ImageIcon(s));
    }

    /**
     * This method gets the x and y values from the controller and indicates if
     * this spot in the gridBtns can be moved on. It will be highlighted yellow.
     * 
     * @param x x value of the button
     * @param y y value of the button
     */

    public void canMoveHere (int x, int y) {
        border = new LineBorder(Color.YELLOW, 2, false);
        gridBGs[x][y].setBorder(border);
        gridBtns[x][y].setHighlightYellow(true);
    }

    /**
     * This method removes the yellow border of some gridBtns.
     */
	
	public void removeYellow () {
		for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (gridBtns[i][j].isHighlightedYellow()) {
					gridBGs[i][j].setBorder(null);
					gridBtns[i][j].setHighlightYellow(false);
				}
            }
        }
	}

    /**
     * This method gets the image button description of the gridBtn and
     * returns it.
     * 
     * @param x x value of the button
     * @param y y value of the button
     * @return button description
     */

    public String getImageBtnDescription (int x, int y) {
        String s;
        s = ((ImageIcon)gridBtns[x][y].getIcon()).getDescription();
        return s;
    }

    /**
     * This method changes the whoTurn JLabel to determine whose turn
     * is it now: red or blue.
     * 
     * @param t boolean value to indicate which color's turn is it
     */

    public void setWhoTurn (boolean t) {
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

    /**
     * This method changes the whoWin JLabel to determine if someone
     * has won.
     * 
     * @param t boolean value to indicate which color wins
     */

    public void setWhoWin (boolean t) {
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
