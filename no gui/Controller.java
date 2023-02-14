import java.awt.event.*;

public class Controller implements ActionListener
{
    private GUI view;
    public Controller(GUI g)
    {
        view = g;
        view.setListener(this);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            view.randomizerScreen();
        }

        else if (e.getActionCommand().equals("Help"))
        {
            view.helpScreen();
        }

        else if (e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
        
        else if (e.getActionCommand().equals("1") || e.getActionCommand().equals("2") || e.getActionCommand().equals("3") || 
        e.getActionCommand().equals("4") || e.getActionCommand().equals("5") || e.getActionCommand().equals("6") || 
        e.getActionCommand().equals("7") || e.getActionCommand().equals("8"))
        {

        }
    }
}