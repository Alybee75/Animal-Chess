import java.awt.event.*;

public class TitleController implements ActionListener
{
    private TitleGUI titleG;
    public TitleController(TitleGUI t)
    {
        titleG = t;
        t.setListeners(this);
    }

    public void actionPerformed (ActionEvent e)
    {
        RandomizerGUI randomizerG;
        if (e.getActionCommand().equals("Start"))
        {
            Game g = new Game();
            randomizerG = new RandomizerGUI();
            RandomizerController r = new RandomizerController(randomizerG, g);
            
        }
    }
}