import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Initializes the Gameboard for the board, Game for the randomizer, and Scanner for inputs
        GUI gui = new GUI();
        Controller c = new Controller(gui);
		Gameboard gb = new Gameboard();
        Game g = new Game();
        Scanner sc = new Scanner(System.in);

        //Initializations of variables to be used in Main
        int player, first;
        int colorChoice = 0;
        String name = " ";
        char color;
        boolean t, done = false;
        boolean choose = false, finish = false;
        
        System.out.println("Welcome to Animal Chess!");
        
        first = g.whoFirst(sc);
        
        //The player who won in the randomization gets to pick which color
        //they want to play as. If they want red, they play the left side.
        //If they want blue, they play the blue side. 
        do {
            System.out.println("Player " + first + ", pick between red or blue.");
            System.out.println("1 - Red");
            System.out.println("2 - Blue");
			
			try{
				colorChoice = sc.nextInt();
				if (colorChoice != 1 && colorChoice != 2)
					System.out.println("ERROR: Invalid input!");
			}
			catch(Exception e){
				System.out.println("ERROR: Invalid input!");
			}
			sc.nextLine();
        } while (colorChoice != 1 && colorChoice != 2);
        

        if (colorChoice == 1)
            t = false;
        else 
            t = true;

        //The do while loop is here to determine of someone has won already.
        do {
            //Initializes the turn class
            Player turn = new Player(t);
            player = turn.getPNum();
            choose = false;
            
            //Displays the gameboard
            gb.displayBoard();

            //This if else condition just deterimines that Red is player 1 and
            //Blue is player 2.
            if (player == 1)
                color = 'r';
            else
                color = 'b';

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