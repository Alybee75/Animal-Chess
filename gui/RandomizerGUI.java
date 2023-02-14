import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomizerGUI extends JFrame 
{
    JLabel p1;
    JLabel p2;
    private JButton[] p1RanBtns;
    private JButton[] p2RanBtns;
    JLabel p1Result, p2Result;
    JLabel whoFirst;
    JLabel chooseColor;
    JButton redBtn, blueBtn;
    JButton doneBtn;

    public RandomizerGUI()
    {
        super("Randomizer");
        setSize(800, 600);
        setLayout(new BorderLayout());
        randomizerScreen();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void randomizerScreen()
    {
        JPanel p1Random;
        JPanel p2Random;
        JPanel resultPanel;
        JPanel colorPanel;
        JLabel p1Label, p2Label;
        chooseColor = new JLabel();
        redBtn = new JButton("Red");
        blueBtn = new JButton("Blue");
        redBtn.setEnabled(false);
        blueBtn.setEnabled(false);
        whoFirst = new JLabel();
        doneBtn = new JButton("Done!");
        doneBtn.setEnabled(false);
        colorPanel = new JPanel();
        resultPanel = new JPanel();
        p1Random = new JPanel();
        p1Random.setLayout(new BoxLayout(p1Random, BoxLayout.Y_AXIS));
        p1RanBtns = new JButton[8];
        p2RanBtns = new JButton[8];
        p1Label = new JLabel("Player 1");
        p2Label = new JLabel("Player 2");
        p1Result = new JLabel();
        p2Result = new JLabel();
        add(colorPanel, BorderLayout.CENTER);
        colorPanel.add(chooseColor);
        colorPanel.add(redBtn);
        colorPanel.add(blueBtn);
        
        add(resultPanel, BorderLayout.SOUTH);
        add(p1Random, BorderLayout.WEST);
        p1Random.add(p1Label);

        for (int i = 0; i < 8; i++)
        {
            p1RanBtns[i] = new JButton("Animal Number " + (i + 1) + " (P1)");
            p1Random.add(p1RanBtns[i]);
        }
        p1Random.add(p1Result);
    
        p2Random = new JPanel();
        p2Random.setLayout(new BoxLayout(p2Random, BoxLayout.Y_AXIS));

        add(p2Random, BorderLayout.EAST);
        p2Random.add(p2Label);

        for (int i = 0; i < 8; i++)
        {
            p2RanBtns[i] = new JButton("Animal Number " + (i + 1) + " (P2)");
            p2Random.add(p2RanBtns[i]);
        }
        p2Random.add(p2Result);

        resultPanel.add(whoFirst);
        resultPanel.add(doneBtn);

    
    }
    

    public void disableButtonsP1()
    {
        for (int i = 0; i < 8; i++)
        {
            p1RanBtns[i].setEnabled(false);
        }

    }

    public void enableButtonsP1()
    {
        for (int i = 0; i < 8; i++)
        {
            p1RanBtns[i].setEnabled(true);
        }

    }

    public void disableButtonsP2()
    {
        for (int i = 0; i < 8; i++)
        {
            p2RanBtns[i].setEnabled(false);
        }
    }

    public void enableButtonsP2()
    {
        for (int i = 0; i < 8; i++)
        {
            p2RanBtns[i].setEnabled(true);
        }
    }

    public boolean isP1ButtonsDisabled()
    {
        boolean check = false;
        for (int i = 0; i < 8; i++)
        {
            if (p1RanBtns[i].isEnabled() == true)
                check = true;
        }
        return check;
    }

    public boolean isP2ButtonsDisabled()
    {
        boolean check = true;
        for (int i = 0; i < 8; i++)
        {
            if (p2RanBtns[i].isEnabled() == true)
                check = false;
        }
        return check;
    }

    public void enableButtonColors()
    {
        redBtn.setEnabled(true);
        blueBtn.setEnabled(true);
    }

    public void disableButtonColors()
    {
        redBtn.setEnabled(false);
        blueBtn.setEnabled(false);
    }

    public void enableDoneButton()
    {
        doneBtn.setEnabled(true);
    }

    public void setListeners(ActionListener listener)
    {
        for (int i = 0; i < 8; i++)
        {
            p1RanBtns[i].addActionListener(listener);
        }

        for (int i = 0; i < 8; i++)
        {
            p2RanBtns[i].addActionListener(listener);
        }

        redBtn.addActionListener(listener);
        blueBtn.addActionListener(listener);
        doneBtn.addActionListener(listener);
    }

    public void setTextResultP1(String s)
    {
        p1Result.setText(s);
    }

    public void setTextResultP2(String s)
    {
        p2Result.setText(s);
    }

    public void setFirstResult(String s)
    {
        whoFirst.setText(s);
    }

    public void setColorChoiceText(String s)
    {
        chooseColor.setText(s);
    }
}

