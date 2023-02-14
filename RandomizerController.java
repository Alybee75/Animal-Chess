import java.awt.event.*;

/**
 * The class RandomizerController is the controller for the RandomizerGUI and Game
 * meaning it will handle the logic of some of the stuff found in RandomizerGUI and Game. 
 * In this GUI, you will have to pick a button from eight of them and you get
 * a random animal and you have to compare it with the other player. This
 * is the C in MVC. Model = Game, View = RandomizerGUI, Controller = 
 * RandomizerController.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class RandomizerController implements ActionListener {
    /**
     * This attribute will serve as the variable for the RandomizerGUI.
     * This will be the View in MVC.
     */
    private RandomizerGUI randomizerG;
    /**
     * This attribute will be of type Game. This will be the Model
     * in MVC.
     */
    private Game game;
    /**
     * This attribute will serve as the value that the player 1 gets
     * when they do the randomization. It will be the rank of the 
     * animal that they got.
     */
    private int p1Num;
    /**
     * This attribute will serve as the value that the player 2 gets
     * when they do the randomization. It will be the rank of the 
     * animal that they got.
     */
    private int p2Num;
    /**
     * This attribute shows the winner of the randomization.
     */
    private int result;
    /**
     * In the randomizer, the player who won will get to pick what
     * color they will be. Whatever they choose, they will be first.
     */
    private boolean colorFirst;

    /**
     * This constructor requires RandomizerGUI and game. Which will
     * initiate the MVC architecture. Game being Model, RandomizerGUI
     * being View, and RandomizerController being controller.
     * 
     * @param r the view of the MVC; the RandomizerGUI class
     * @param g the model of the MVC; the Game class
     */

    public RandomizerController(RandomizerGUI r, Game g) {
        randomizerG = r;
        game = g;
        randomizerG.setListeners(this);
    }

    /**
     * This method overrides actionPerformed from ActionListener. This
     * will have the randomized animals buttons and will have its
     * functions. This will also have the function for the Done button,
     * which is responsible for opening the BoardGUI, BoardRandomizer,
     * Gameboard, and Player classes.
     */
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand().equals("Animal Number 1 (P1)")) {
            p1Num = game.randomize(1);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 2 (P1)")) {
            p1Num = game.randomize(2);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 3 (P1)")) {
            p1Num = game.randomize(3);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 4 (P1)")) {
            p1Num = game.randomize(4);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 5 (P1)")) {
            p1Num = game.randomize(5);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Animal Number 6 (P1)")) {
            p1Num = game.randomize(6);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 7 (P1)")) {
            p1Num = game.randomize(7);   
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
                
        else if (e.getActionCommand().equals("Animal Number 8 (P1)")) {
            p1Num = game.randomize(8);
            randomizerG.disableButtonsP1();
            randomizerG.setTextResultP1("P1 got " + game.toString() + " (" + p1Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 1 (P2)")) {
            p2Num = game.randomize(1);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 2 (P2)")) {
            p2Num = game.randomize(2);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Animal Number 3 (P2)")) {
            p2Num = game.randomize(3);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Animal Number 4 (P2)")) {
            p2Num = game.randomize(4);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 5 (P2)")) {
            p2Num = game.randomize(5);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 6 (P2)")) {
            p2Num = game.randomize(6);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 7 (P2)")) {
            p2Num = game.randomize(7);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }
            
        else if (e.getActionCommand().equals("Animal Number 8 (P2)")) {
            p2Num = game.randomize(8);
            randomizerG.disableButtonsP2();
            randomizerG.setTextResultP2("P2 got " + game.toString() + " (" + p2Num + ")");
            this.results();
        }

        else if (e.getActionCommand().equals("Red")) {
            colorFirst = false;
            randomizerG.setColorChoiceText("Player " + result + " chose Red! The other player will be Blue!");
            randomizerG.disableButtonColors();
            randomizerG.enableDoneButton();
        }

        else if (e.getActionCommand().equals("Blue")) {
            colorFirst = true;
            randomizerG.setColorChoiceText("Player " + result + " chose Blue! The other player will be Red!");
            randomizerG.disableButtonColors();
            randomizerG.enableDoneButton();
        }

        else if (e.getActionCommand().equals("Done!")) {
            //Initalizes the values needed for the Board MVC.
            BoardGUI bg = new BoardGUI();
            Gameboard gb = new Gameboard();
            Player p = new Player(colorFirst);
            BoardController bc = new BoardController(result, colorFirst, gb, p, bg);
            randomizerG.dispose();
        }  
    }

    /**
     * This method is responsible for setting the JLabels in the 
     * RandomizerGUI to display the results of the randomizer.
     */

    public void results () {
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
