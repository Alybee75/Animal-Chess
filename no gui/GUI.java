import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class GUI
{
    private JFrame frame;
    private JLabel label;
    private JButton startBtn;
    private JButton helpBtn;
    private JButton exitBtn;
    private JButton[] ranBtnsP1;
    private JButton[] ranBtnsP2;

    private JLabel instructionImg;

    public GUI()
    {
       titleScreen();
    }

    public void titleScreen()
    {
        frame = new JFrame("Animal Chess");
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Animal Chess");
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        label.setBounds(300, 200, 200, 50);
        frame.add(label);

        startBtn = new JButton("Start");
        startBtn.setBounds(300, 300, 100, 50);
        frame.add(startBtn);

        helpBtn = new JButton("Help");
        helpBtn.setBounds(300, 350, 100, 50);
        frame.add(helpBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(300, 400, 100, 50);
        frame.add(exitBtn);
    }

    public void randomizerScreen()
    {
        ranBtnsP1 = new JButton[8];
        ranBtnsP2 = new JButton[8];
        frame = new JFrame("Randomizer");
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label = new JLabel("For the first player, please pick a button!");
        ranBtnsP1[0] = new JButton("1");
        ranBtnsP1[1] = new JButton("2");
        ranBtnsP1[2] = new JButton("3");
        ranBtnsP1[3] = new JButton("4");
        ranBtnsP1[4] = new JButton("5");
        ranBtnsP1[5] = new JButton("6");
        ranBtnsP1[6] = new JButton("7");
        ranBtnsP1[7] = new JButton("8");

        ranBtnsP2[0] = new JButton("1");
        ranBtnsP2[1] = new JButton("2");
        ranBtnsP2[2] = new JButton("3");
        ranBtnsP2[3] = new JButton("4");
        ranBtnsP2[4] = new JButton("5");
        ranBtnsP2[5] = new JButton("6");
        ranBtnsP2[6] = new JButton("7");
        ranBtnsP2[7] = new JButton("8");
        frame.add(label);
        for (int i = 0; i < 8; i++)
        {
            frame.add(ranBtnsP1[i]);
        }

        for (int i = 0; i < 8; i++)
        {
            frame.add(ranBtnsP2[i]);
        }


    }

    public void helpScreen()
    {
        frame = new JFrame("Instructions");
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        instructionImg = new JLabel("Test");
        frame.add(instructionImg);

    }

    public void gameScreen()
    {
        frame = new JFrame("Animal Chess");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(7, 9));
        frame.add(gamePanel, BorderLayout.CENTER);

        JLabel[][] grid = new JLabel[7][9];
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                grid[i][j] = new JLabel("O_O");
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                //grid[i][j].setBackground(Color.black);
                grid[i][j].setOpaque(true);
                gamePanel.add(grid[i][j]);
            }
        }
    }

    public void setListener (ActionListener listener)
	{
		startBtn.addActionListener (listener);
		helpBtn.addActionListener (listener);
		exitBtn.addActionListener (listener);

        for (int i = 0; i < 8; i++)
        {
            ranBtnsP1[i].addActionListener(listener);
        }

        for (int i = 0; i < 8; i++)
        {
            ranBtnsP2[i].addActionListener(listener);
        }
	}

    

}
