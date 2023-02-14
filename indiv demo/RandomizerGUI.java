import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is for the GUI or View part of the Randomizer Screen. 
 * It utilizes Java Swing and Java AWT and extends JFrame.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class RandomizerGUI extends JFrame {
    /**
     * This attribute is a 2D array of JButtons which will be the
     * array that will consist of the Player 1 randomized buttons.
     */
    private JButton[] p1RanBtns;
    /**
     * This attribute is a 2D array of JButtons which will be the
     * array that will consist of the Player 2 randomized buttons.
     */
    private JButton[] p2RanBtns;
    /**
     * This attribute is the JLabel in which it will showcase what
     * Player 1 got from the randomized buttons.
     */
    private JLabel p1Result;
    /**
     * This attribute is the JLabel in which it will showcase what
     * Player 2 got from the randomized buttons.
     */
    private JLabel p2Result;
    /**
     * This attribute is the JLabel that will tell who won the
     * randomizer, which will be the first turn in the game that's
     * about to come.
     */
    private JLabel whoFirst;
    /**
     * This JLabel just shows an instruction to the winning player
     * which color do they want to pick: Red (Left) or Blue (Right).
     */
    private JLabel chooseColor;
    /**
     * This JButton, if pressed, the winning player would be on the
     * Red side.
     */
    private JButton redBtn;
    /**
     * This JButton, if pressed, the winning player would be on the
     * Blue side.
     */
    private JButton blueBtn;
    /**
     * This JButton, if pressed, will open the Game of Animal Chess.
     * It will initialize BoardGUI, BoardController, Gameboard, and
     * Player classes.
     */
    private JButton doneBtn;

    /**
     * This constructor would initialize the GUI for the Randomizer.
     * It would also call in randomizerScreen to initialize the
     * contents of the GUI.
     */

    public RandomizerGUI() {
        super("Randomizer");
        setSize(800, 400);
        setLayout(new BorderLayout());
        randomizerScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method will initialize everything that's happening
     * on the Randomizer Screen. It will have the components such as 
     * JPanels, JButtons, JLabels.
     */

    public void randomizerScreen() {
        JPanel p1Random, p2Random;
        JPanel resultPanel;
        JPanel colorPanel;
        JLabel p1Label, p2Label;

        //Initalizing all the components
        p1RanBtns = new JButton[8];
        p2RanBtns = new JButton[8];
        p1Result = new JLabel();
        p2Result = new JLabel();
        whoFirst = new JLabel();
        chooseColor = new JLabel();
        redBtn = new JButton("Red");
        blueBtn = new JButton("Blue");
        doneBtn = new JButton("Done!");
        colorPanel = new JPanel();
        resultPanel = new JPanel();
        p1Random = new JPanel();
        p2Random = new JPanel();
        p1Label = new JLabel("Player 1");
        p2Label = new JLabel("Player 2");
        
        //Setting up all the contents for p1Random JPanel (The left side)
        p1Random.setLayout(new BoxLayout(p1Random, BoxLayout.Y_AXIS));
        add(p1Random, BorderLayout.WEST);

        p1Label.setFont(new Font("Courier New", Font.BOLD, 18));
        p1Random.add(p1Label);

        for (int i = 0; i < 8; i++) {
            p1RanBtns[i] = new JButton("Animal Number " + (i + 1) + " (P1)");
            p1RanBtns[i].setFont(new Font("Verdana", Font.PLAIN, 15));
            p1Random.add(p1RanBtns[i]);
        }

        p1Result.setFont(new Font("Verdana", Font.PLAIN, 15));
        p1Random.add(p1Result);

        //Setting up all the contents for p2Random JPanel (The right side)
        p2Random.setLayout(new BoxLayout(p2Random, BoxLayout.Y_AXIS));
        add(p2Random, BorderLayout.EAST);

        p2Label.setFont(new Font("Courier New", Font.BOLD, 18));
        p2Random.add(p2Label);

        for (int i = 0; i < 8; i++) {
            p2RanBtns[i] = new JButton("Animal Number " + (i + 1) + " (P2)");
            p2RanBtns[i].setFont(new Font("Verdana", Font.PLAIN, 15));
            p2Random.add(p2RanBtns[i]);
        }
        p2Result.setFont(new Font("Verdana", Font.PLAIN, 15));
        p2Random.add(p2Result);

        //Adding all the contents for the colorPanel, where the buttons for colors would be
        add(colorPanel, BorderLayout.CENTER);

        redBtn.setEnabled(false);
        blueBtn.setEnabled(false);
        
        redBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        blueBtn.setFont(new Font("Verdana", Font.PLAIN, 15));
        chooseColor.setFont(new Font("Verdana", Font.PLAIN, 13));

        colorPanel.add(redBtn);
        colorPanel.add(blueBtn);
        colorPanel.add(chooseColor);
        
        //Setting up the contents for resultPanel, which will include the done button and label on who's first
        add(resultPanel, BorderLayout.SOUTH);
        
        doneBtn.setEnabled(false);
    
        whoFirst.setFont(new Font("Verdana", Font.PLAIN, 15));
        doneBtn.setFont(new Font("Verdana", Font.PLAIN, 15));

        resultPanel.add(whoFirst);
        resultPanel.add(doneBtn);
    }

    /**
     * This gives every button in the RandomizerGUI a listener,
     * for them to have a function and a purpose.
     * 
     * @param listener the listener to be used
     */

    public void setListeners(ActionListener listener) {
        for (int i = 0; i < 8; i++)
            p1RanBtns[i].addActionListener(listener);

        for (int i = 0; i < 8; i++)
            p2RanBtns[i].addActionListener(listener);
        
        redBtn.addActionListener(listener);
        blueBtn.addActionListener(listener);
        doneBtn.addActionListener(listener);
    }
    
    /**
     * This method disables all the buttons in the player 1 side
     * from being pressed.
     */

    public void disableButtonsP1() {
        for (int i = 0; i < 8; i++)
            p1RanBtns[i].setEnabled(false);
    }

    /**
     * This method disables all the buttons in the player 2 side
     * from being pressed.
     */

    public void disableButtonsP2() {
        for (int i = 0; i < 8; i++)
            p2RanBtns[i].setEnabled(false);
    }

    /**
     * This method enables all the buttons in the player 1 side
     * from being pressed.
     */

    public void enableButtonsP1() {
        for (int i = 0; i < 8; i++)
            p1RanBtns[i].setEnabled(true);
    }

    /**
     * This method enables all the buttons in the player 2 side
     * from being pressed.
     */

    public void enableButtonsP2() {
        for (int i = 0; i < 8; i++)
            p2RanBtns[i].setEnabled(true);
    }

    /**
     * This method enables all the button colors.
     */

    public void enableButtonColors() {
        redBtn.setEnabled(true);
        blueBtn.setEnabled(true);
    }

    /**
     * This method disables all the button colors.
     */

    public void disableButtonColors() {
        redBtn.setEnabled(false);
        blueBtn.setEnabled(false);
    }

    /**
     * This method enables the done button.
     */

    public void enableDoneButton() {
        doneBtn.setEnabled(true);
    }

    /**
     * This method changes the text for p1Result. It will show
     * what animal did Player 1 get in the randomization.
     * 
     * @param s the text to be set
     */

    public void setTextResultP1(String s) {
        p1Result.setText(s);
    }

    /**
     * This method changes the text for p2Result. It will show
     * what animal did Player 2 get in the randomization.
     * 
     * @param s the text to be set
     */

    public void setTextResultP2(String s) {
        p2Result.setText(s);
    }

    /**
     * This method changes the text for whoFirst. It will show
     * who was the winner in the randomization.
     * 
     * @param s the text to be set
     */

    public void setFirstResult(String s) {
        whoFirst.setText(s);
    }

    /**
     * This method changes the text for chooseColor. It will show
     * the text of which button or color to choose.
     * 
     * @param s the text to be set
     */
    public void setColorChoiceText(String s) {
        chooseColor.setText(s);
    }
}