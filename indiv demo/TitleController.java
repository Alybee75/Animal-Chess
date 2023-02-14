import java.awt.event.*;

/**
 * The class TitleController is the controller for the TitleGUI, meaning
 * it will handle the logic of some of the stuff found in TitleGUI. For
 * example, the start button's function in TitleGUI is right here in this
 * class. This class also implements ActionListener so that the buttons
 * would work when pressed.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class TitleController implements ActionListener {
    /**
     * This variable is of TitleGUI and it's here for it to be called
     * when the start button is clicked.
     */
    private TitleGUI titleG;

    /**
     * This constructor of TitleController requires TitleGUI in order
     * to control the components inside TitleGUI.
     * 
     * @param t the GUI for the title screen
     */

    public TitleController (TitleGUI t) {
        titleG = t;
        t.setListeners(this);
    }

    /**
     * This method overrides actionPerformed where it only has one
     * function in this class. When the start button is clicked in the
     * TitleGUI, it will open the Randomizer GUI, Controller, and the
     * Game class, which will serve as the Model for the Randomizer.
     */
    @Override
    public void actionPerformed (ActionEvent e) {
        RandomizerGUI randomizerG;
        if (e.getActionCommand().equals("START")) {
            Game g = new Game();
            randomizerG = new RandomizerGUI();
            RandomizerController r = new RandomizerController(randomizerG, g);
        }
    }
}