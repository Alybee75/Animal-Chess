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
	
	public int whoFirst(Scanner sc){
		int pick1 = 0, pick2 = 0;
		int ran1, ran2;
		String ran1Name, ran2Name;
		boolean ifEqual = true;
		
		ran1Name = new String();
        ran2Name = new String();
		
		do {
		//For the first player, they will pick a number from 1 to 8 which is an array
         //of entities randomized.
          
          do {
            System.out.println("\nFor the first player, please pick a number from 1 to 8!");
			
			try{
				pick1 = sc.nextInt();
				if (pick1 < 1 || pick1 > 8)
					System.out.println("ERROR: Invalid input!");
            }
			catch(Exception e){
				System.out.println("ERROR: Invalid input!");
			}
			sc.nextLine();
          } while (pick1 < 1 || pick1 > 8);
          
          ran1 = randomize(pick1);
          ran1Name = toString();
            
          //For the second player, they will pick a number from 1 to 8 which is an array
          //of entities randomized.
          do {
            System.out.println("For the second player, please pick a number from 1 to 8!");
           
		   try{
				pick2 = sc.nextInt();
				if (pick2 < 1 || pick2 > 8)
					System.out.println("ERROR: Invalid input!");
            }
			catch(Exception e){
				System.out.println("ERROR: Invalid input!");
			}
			sc.nextLine();
          } while (pick2 < 1 || pick2 > 8);
          
          ran2 = randomize(pick2);
          ran2Name = toString();
  
          //if conditions to determine which one had the higher rank of animal in the
          //randomization. If it's equal, it will repeat the process
          if (ran1 > ran2) {
              System.out.println("\nFirst player got " + ran1Name + ": " + ran1);
              System.out.println("Second player got " + ran2Name + ": " + ran2);
              System.out.println("The first who picked goes first!\n");
			  return 1;
          }
  
          else if (ran2 > ran1) {
              System.out.println("\nFirst player got " + ran1Name + ": " + ran1);
              System.out.println("Second player got " + ran2Name + ": " + ran2);
              System.out.println("The second who picked goes first!\n");
			  return 2;
          }
  
          else {
              System.out.println("\nFirst player got " + ran1Name + ": " + ran1);
              System.out.println("Second player got " + ran2Name + ": " + ran2);
              System.out.println("Both have equal values! Please input new values again.\n");
          }
		} while (ifEqual == true);
		
		return 0;
	}
}