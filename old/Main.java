import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Initializes the Gameboard for the board, Game for the randomizer, and Scanner for inputs
        Gameboard gb = new Gameboard();
        Game g = new Game();
        Scanner sc = new Scanner(System.in);

        //Initializations of variables to be used in Main
        int pick1, pick2;
        int ran1, ran2;
        int player;
        int colorChoice;
        String ran1Name, ran2Name;
        String name = " ";
        char color;
        boolean ifEqual = true;
        boolean t, done = false;
        boolean choose = false, finish = false;

        ran1Name = new String();
        ran2Name = new String();
        
        System.out.println("Welcome to Animal Chess!");
        do {
          //For the first player, they will pick a number from 1 to 8 which is an array
          //of entities randomized.
          
          do {
            System.out.println("For the first player, please pick a number from 1 to 8!");
            pick1 = sc.nextInt();

            if (pick1 < 1 || pick1 > 8)
                System.out.println("ERROR: Invalid input!");
          } while (pick1 < 1 || pick1 > 8);
          
          ran1 = g.randomize(pick1);
          ran1Name = g.toString();
            
          //For the second player, they will pick a number from 1 to 8 which is an array
          //of entities randomized.
          do {
            System.out.println("For the second player, please pick a number from 1 to 8!");
            pick2 = sc.nextInt();

            if (pick2 < 1 || pick2 > 8)
                System.out.println("ERROR: Invalid input!");
          } while (pick2 < 1 || pick2 > 8);
          
          ran2 = g.randomize(pick2);
          ran2Name = g.toString();
  
          //if conditions to determine which one had the higher rank of animal in the
          //randomization. If it's equal, it will repeat the process
          if (ran1 > ran2) {
              System.out.println(ran1);
              System.out.println(ran2);
              System.out.println(ran1Name + ": " + ran1);
              System.out.println(ran2Name + ": " + ran2);
              System.out.println("The first who picked goes first!");
              ifEqual = false;
          }
  
          else if (ran2 > ran1) {
              System.out.println(ran1Name + ": " + ran1);
              System.out.println(ran2Name + ": " + ran2);
              System.out.println("The second who picked goes first!");
              ifEqual = false;
          }
  
          else {
              System.out.println(ran1Name + ": " + ran1);
              System.out.println(ran2Name + ": " + ran2);
              System.out.println("Both have equal values! Please input new values again.");
          }
        } while (ifEqual == true);
        
        //The player who won in the randomization gets to pick which color
        //they want to play as. If they want red, they play the left side.
        //If they want blue, they play the blue side. 
        do {
            System.out.println("Player who is first, pick between red or blue.");
            System.out.println("1 - Red");
            System.out.println("2 - Blue");
            colorChoice = sc.nextInt();

            if (colorChoice != 1 && colorChoice != 2)
                System.out.println("ERROR: Invalid input!");
        } while (colorChoice != 1 && colorChoice != 2);
        

        if (colorChoice == 1)
            t = false;
        else 
            t = true;

        //The do while loop is here to determine of someone has won already.
        do {
            //Initializes the turn class
            Person turn = new Person(t);
            player = turn.getPNum();
            choose = false;
            
            //Displays the gameboard
            gb.displayBoard();

            //This if else condition just deterimines that Red is player 1 and
            //Blue is player 2.
            if (player == 1)
                color = 'R';
            else
                color = 'B';

            do {
				name = turn.choosePiece(color);
                choose = gb.isCaptured(name);
            } while(choose != true);
			
            //checks if someone wins
            done = gb.checkWin(gb.updateBoard(name, player, sc), player);

            //checks if there are any animals left
            if(gb.getAnimalsLeft(0) == 0 || gb.getAnimalsLeft(1) == 0 )
                finish = true;
        
            //switches to the next player's turn
            t = turn.nextTurn();
        
        } while (done != true && finish != true);
		
        gb.displayBoard();
        
        //Winning message
        System.out.println("\nCongrats! Color " + color + " wins.");

        sc.close();
    }
}