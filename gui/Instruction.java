import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instruction
{
    private JFrame frame;
    private JLabel instructionImg;
    private JButton closeBtn;

    public Instruction()
    {
        frame = new JFrame("Instructions");
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        instructionImg = new JLabel("Test");
        frame.add(instructionImg);

        closeBtn = new JButton("Close");
        frame.add(closeBtn);


    }
}