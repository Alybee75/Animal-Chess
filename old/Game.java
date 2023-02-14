import java.util.*;

/**
 * This class handles the randomization of who will be first
 * to choose their color and the first to take a turn.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Game {
    private Entity[] e;
    private int chosenRank;
	
    /**
     * This method initializes and randomizes the e variable
     * which will sort the animals not by rank, but by random
     * order. 
     * 
     * @param p player number
     * @return the chosen rank for that array space
     */
    public int randomize(int p) {
        Random rand = new Random();
        e = new Entity[8];
        e[0] = new Mouse();
        e[1] = new Cat();
        e[2] = new Wolf();
        e[3] = new Dog();
        e[4] = new Leopard();
        e[5] = new Tiger();
        e[6] = new Lion();
        e[7] = new Elephant();


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
     * This overrides toString() to return the name
     * of the animal by rank.
     * 
     * @return name of Entity
     */

    public String toString() {
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