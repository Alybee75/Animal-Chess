import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitleGUI extends JFrame
{
    JButton startBtn;
    JLabel title;
    public TitleGUI()
    {
        super("Animal Chess");
        setSize(800, 600);
        setLayout(new BorderLayout());
        initScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initScreen()
    {
        title = new JLabel("Animal Chess");
        add(title, BorderLayout.CENTER);
        startBtn = new JButton("Start");
        add(startBtn, BorderLayout.SOUTH);
    }

    public void setListeners(ActionListener listener)
    {
        startBtn.addActionListener(listener);
    }

    


}
