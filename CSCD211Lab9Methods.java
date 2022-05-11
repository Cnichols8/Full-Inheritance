package lab9.cscd211methods;

import java.util.*;
import lab9.cscd211classes.*;
import lab9.cscd211classes.players.BaseballPlayer;
import lab9.cscd211classes.players.FootballPlayer;
import lab9.cscd211classes.players.HockeyPlayer;
import lab9.cscd211classes.players.Player;

/**
 * I have provided the menu method for you.  You must write the fill method. Please look at the file teamlist.txt
 * <br>
 * The file format is City\n Number of teams\n Type, Team Name\n Number of Players\n <br>
 * player name, ssn, salary, position, specific info based on type <br>
 * if football then # of touch downs, jersey number <br>
 * if baseball then batting average <br>
 * if hockey then jersey number <br>
 *
 * @NOTE All parameters passed must be final
 */
public class CSCD211Lab9Methods
{	
   /**
    * reads from the file and creates the appropriate player for the array and 
    * creates the appropriate team
    *
    * @param fin Scanner object
    * @param myTeam ArrayList of type Team
    *
    * @throws IllegalArgumentException for fin or myTeam being null
    * @throws CloneNotSupportedException to propagate the clone method
    *
    * @NOTE To add to MyArrayList it is an addLast method call myTeam.addLast(team stuff)
    */
   public static void fillArrayList(final Scanner fin, ArrayList<Team>myTeam)throws CloneNotSupportedException {
      if (fin == null || myTeam == null) {
         throw new IllegalArgumentException("Fin or myTeam is null.");
      } // end exception
      String city, teamName, name, ssn, position, stats, type;
      String [] array;
      int numPlayers, salary, numTeams;
      Player[] playerArray;

      while(fin.hasNext()) {
         city = (fin.nextLine()).trim();
         numTeams = Integer.parseInt((fin.nextLine()).trim());
         for (int i =0; i < numTeams; i++) {
            array = (fin.nextLine()).trim().split(",");
            type = array[0].trim().toLowerCase();
            teamName = array[1].trim();
            numPlayers = Integer.parseInt((fin.nextLine()).trim());

            playerArray = new Player[numPlayers];
            for (int j = 0; j < playerArray.length; j++) {
               array = fin.nextLine().trim().split(",");
               name = array[0].trim();
               ssn = array[1].trim();
               salary = Integer.parseInt(array[2].trim());
               position = array[3].trim();
               stats = array[4].trim();

               if (type.equals("baseball")) {
                  playerArray[j] = new BaseballPlayer(name, ssn, salary, position, Double.parseDouble(stats));
               }
               else if (type.equals("football")) {
                  playerArray[j] = new FootballPlayer(name, ssn, salary, position, Integer.parseInt(stats), Integer.parseInt(array[5].trim()));
               }
               else {
                  playerArray[j] = new HockeyPlayer(name, ssn, salary, position, Integer.parseInt(stats));
               }
            }
            myTeam.add(new Team(city, teamName, playerArray));
         }
      }
      myTeam.trimToSize();
   }// end createAndFill
   
   /**
    * The menu method ensures a valid choice is entered and returns that value
    * <br> 1 Print all Teams
    * <br> 2 Sort all Teams by city and team name
    * <br> 3 Sort all Teams by Payroll
    * <br> 4 Exit program
    *
    * @param kb Representing a valid Scanner object
    * @return int Representing the menu choice
    *
    * @throws IllegalArgumentException If Scanner is null
    */
   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
         
      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print all Teams");
         System.out.println("2) Sort all Teams by city and team name");
         System.out.println("3) Sort all Teams by Payroll");
         System.out.println("4) Exit program");
         System.out.print("Choice --> ");
         choice = kb.nextInt();
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      
      return choice;  
   }// end menu
   
}// end class