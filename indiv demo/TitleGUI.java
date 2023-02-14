import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is for the GUI or View part of the Title Screen. It
 * utilizes Java Swing and Java AWT and extends JFrame.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class TitleGUI extends JFrame {
    /**
     * This JButton encompasses the start button, which will start the game.
     */
    private JButton startBtn;
    /**
     * This attribute simply shows the title of the game.
     */
    private JLabel title;

    /**
     * This constructor initializes the JFrame and sets the stage
     * for the titleGUI. It will also call the initScreen method
     * which will initialize the components for the Title GUI.
     */
    
    public TitleGUI() {
        super("Animal Chess");
        setSize(500, 200);
        setLayout(new BorderLayout());
        initScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method creates all the components needed for the GUI
     * like the start button and the title label; utilizing
     * JButton and JLabel respectively. 
     */

    public void initScreen() {  
        title = new JLabel("Animal Chess", SwingConstants.CENTER);
        title.setFont(new Font("Courier New", Font.BOLD, 30));
        add(title, BorderLayout.CENTER);

        startBtn = new JButton("START");
        startBtn.setFont(new Font("Courier New", Font.PLAIN, 20));
        startBtn.setPreferredSize(new Dimension(50, 50));
        add(startBtn, BorderLayout.SOUTH);
    }

    /**
     * This method sets the listener for the start button with
     * Action Listener.
     * 
     * @param listener the listener to be used
     */

    public void setListeners(ActionListener listener) {
        startBtn.addActionListener(listener);
    }
}