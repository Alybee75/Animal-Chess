import java.awt.event.*;

public class RandomizerController implements ActionListener
{
    private RandomizerGUI randomizerG;
    private Game game;
    private int p1Num;
    private int p2Num;
    private int result;
    private boolean colorFirst;

    public RandomizerController(RandomizerGUI r, Game g)
    {
        randomizerG = r;
        game = g;
        randomizerG.setListeners(this);
    }

    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand().equals("Animal Number 1 (P1)"))
        {
            p1Num = game.randomize(1);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 2 (P1)"))
        {
            p1Num = game.randomize(2);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 3 (P1)"))
        {
            p1Num = game.randomize(3);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 4 (P1)"))
        {
            p1Num = game.randomize(4);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 5 (P1)"))
        {
            p1Num = game.randomize(5);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Animal Number 6 (P1)"))
        {
            p1Num = game.randomize(6);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 7 (P1)"))
        {
            p1Num = game.randomize(7);   
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
                
        else if (e.getActionCommand().equals("Animal Number 8 (P1)"))
        {
            p1Num = game.randomize(8);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            

        else if (e.getActionCommand().equals("Animal Number 1 (P2)"))
        {
            p2Num = game.randomize(1);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            

        else if (e.getActionCommand().equals("Animal Number 2 (P2)"))
        {
            p2Num = game.randomize(2);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Animal Number 3 (P2)"))
        {
            p2Num = game.randomize(3);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Animal Number 4 (P2)"))
        {
            p2Num = game.randomize(4);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 5 (P2)"))
        {
            p2Num = game.randomize(5);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 6 (P2)"))
        {
            p2Num = game.randomize(6);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
    
        else if (e.getActionCommand().equals("Animal Number 7 (P2)"))
        {
            p2Num = game.randomize(7);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        
        else if (e.getActionCommand().equals("Animal Number 8 (P2)"))
        {
            p2Num = game.randomize(8);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Red"))
        {
            colorFirst = false;
            randomizerG.setColorChoiceText("Player " + result + " chose Red! The other player will be Blue!");
            randomizerG.disableButtonColors();
            randomizerG.enableDoneButton();
        }

        else if (e.getActionCommand().equals("Blue"))
        {
            colorFirst = true;
            randomizerG.setColorChoiceText("Player " + result + " chose Blue! The other player will be Red!");
            randomizerG.disableButtonColors();
            randomizerG.enableDoneButton();
        }

        else if (e.getActionCommand().equals("Done!"))
        {
            BoardGUI bg = new BoardGUI();
            Gameboard gb = new Gameboard();
            Player p = new Player(colorFirst);
            BoardController bc = new BoardController(result, colorFirst, gb, p, bg);
        }

        
            
    }

    public void results()
    {
        if (p1Num != 0 && p2Num != 0) {
            result = game.whoFirst(p1Num, p2Num);
            System.out.println(result);

            if (result == 1) {
                randomizerG.setFirstResult("Player 1 gets to move first! Pick between Red (Left) or Blue (Right)");
                randomizerG.enableButtonColors();
            }

            else if (result == 2) {
                randomizerG.setFirstResult("Player 2 gets to move first! Pick between Red (Left) or Blue (Right)");
                randomizerG.enableButtonColors();
            }

            else {
                randomizerG.setFirstResult("Both got the same animals! Please try again.");
                randomizerG.enableButtonsP1();
                randomizerG.enableButtonsP2();
                p1Num = 0;
                p2Num = 0;
            }
        }
    }
}
