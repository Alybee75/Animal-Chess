import java.util.*;

/**
 * This class handles the randomization of who will be first
 * to choose their color and the first to take a turn.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Game {
    /**
     * This variable is an Entity variable which will have the animals
     * and their rank numbers to be used for the randomizer.
     */
    private Entity[] e;
    /**
     * This variable would be what the player's randomized value would be.
     */
    private int chosenRank;

    /**
     * This method initializes and randomizes the e variable
     * which will sort the animals not by rank, but by random
     * order. 
     * 
     * @param p player number
     * @return the chosen rank for that array space
     */

    public int randomize (int p) {
        Random rand = new Random();
        e = new Entity[8];
        e[0] = new Mouse(1, "Mouse");
        e[1] = new Cat(2, "Cat");
        e[2] = new Wolf(3, "Wolf");
        e[3] = new Dog(4, "Dog");
        e[4] = new Leopard(5, "Leopard");
        e[5] = new Tiger(6, "Tiger");
        e[6] = new Lion(7, "Lion");
        e[7] = new Elephant(8, "Elephant");


        //randomizer
        for (int i = e.length - 1; i > 0; i--) {
            int shuffle = rand.nextInt(i + 1);
            Entity a = e[shuffle];
            e[shuffle] = e[i];
            e[i] = a;
        }

        chosenRank = e[p - 1].rank;

        return chosenRank;
    }

    /**
     * This method compares the results that player 1 and player 2
     * got, and returns who is the winner in the randomization.
     * 
     * @param p1Ran result of player 1
     * @param p2Ran result of player 2
     * @return who won the randomization
     */

    public int whoFirst (int p1Ran, int p2Ran) {
        if (p1Ran > p2Ran) 
            return 1;

        else if (p2Ran > p1Ran)
            return 2;
        
        return 0;
	}

    /**
     * This overrides toString() to return the name
     * of the animal by rank.
     * 
     * @return name of Entity
     */
    @Override
    public String toString () {
        switch(chosenRank) {
            case 1:
                return "Mouse";
            case 2:
                return "Cat";
            case 3:
                return "Wolf";
            case 4:
                return "Dog";
            case 5:
                return "Leopard";
            case 6:
                return "Tiger";
            case 7:
                return "Lion";
            case 8:
                return "Elephant";
            default:
                return "None";
        }
    }
}