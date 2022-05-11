package lab9.cscd211classes;

import java.util.*;
import lab9.cscd211interfaces.*;
import lab9.cscd211classes.players.*;

/**
 * The Team class that defines the information about a team.
 */
public class Team implements Taxable, Payroll, Comparable<Team>
{
   
   protected String city;
   protected String teamName;
   protected int payroll;
   protected ArrayList<Player> players;

/**
 * The Team constructor is for the stand alone class named Team.
 * Parameters:
 * city - Representing the city
 * teamName - Representing the team name
 * players - a ArrayList of Player that holds the player objects
 * Throws:
 * CloneNotSupportedException - Put throws CloneNotSupportedException on the constructor header
 * IllegalArgumentException - If the Strings are null or empty and if players array is null or the length is <= 0
 * NOTE:
 * You must create a new ArrayList and then clone each player before adding the player to the list
 */

   public Team(String city, String teamName, Player[] players)  throws CloneNotSupportedException {
      if (city == null || teamName == null ) {
         throw new IllegalArgumentException("Parameters are bad.");
      } // end exception
      this.city = city;
      this.teamName = teamName;
      this.players = new ArrayList<Player>(players.length);
      for (Player p : players) {
         this.players.add(p.clone());
      }
      this.players.trimToSize();
      this.payroll = calculatePayroll();
   } // end constructor

/**
 * Returns the name of the team
 * Returns:
 * String Representing the team name
 */

   public String getTeamName() {
      return this.teamName;
   } // end getTeamName

/**
 * Returns an ArrayList of Player which holds the Player objects
 * Returns:
 * ArrayList of Player holding the specific Player objects
 */

   public ArrayList<Player> getPlayers() {
      return this.players;
   } // end getPlayers

/**
 * Returns the city name
 * Returns:
 * String Representing the name of the city
 */

   public String getCity() {
      return this.city;
   } // getCity

/**
 * Returns the total team payroll
 * Returns:
 * int Representing the total team playroll
 */

   public int getPayroll() {
      return this.payroll;
   } // end getPayroll

/**
 * Returns the string with city - team name CR Payroll: value CR Taxes this calculateTaxes CR Player Name SSN Salary
 * Position Stats Number CR Jersey Number The player info
 * Overrides:
 * toString in class Object
 * Returns:
 * String representing the above information see sample output run
 * NOTE:
 * don't worry about pretty output
 */

   @Override
   public String toString() {
      return city + " - " + teamName + "\n" +
              "Payroll: " + payroll + "\n" +
              "Taxes: " + calculateTaxes() + "\n" +
              "PLAYER NAME      SSN          SALARY      POSITION       STATS        NUMBER\n" +
              "____________________________________________________________________________\n" +
              this.getPlayers() + "\n";
   } // end toString

/**
 * Calculate Taxes Walks through the array list if a player salary is greater than 250000 taxes are the salary *
 * BASE_TAX_RATE if salary is less than or equal to 250000 the taxes are salary * (BASE_TAX_RATE - .1)
 * Specified by:
 * calculateTaxes in interface Taxable
 * Returns:
 * double Representing the taxes
 */

   public double calculateTaxes() {
      double tax = 0;
      for (int i = 0; i < players.size(); i++) {
         if (players.get(i).getSalary() > 250000) {
            tax += players.get(i).getSalary() * BASE_TAX_RATE;
         }
         else {
            tax += players.get(i).getSalary() * (BASE_TAX_RATE - .1);
         }
      }
      return tax;
   } // end calculateTaxes

/** calculatePayroll - sums the player salary to create the payroll including the base_payroll from the interface Walks
 *  through the ArrayList and sums the player salaries
 * Specified by:
 * calculatePayroll in interface Payroll
 * Returns:
 * int the summed player salaries
 */

   public int calculatePayroll() {
      int sum = 0;
      for (int i = 0; i < players.size(); i++) {
         sum += players.get(i).getSalary();
      }
      return sum + BASE_PAYROLL;
   } // end calculatePayroll

/**
 * Compares first by City and then teamName if city is the same
 * Specified by:
 * compareTo in interface Comparable<Team>
 * Parameters:
 * pi - Representing the passed in Team object
 * Throws:
 * IllegalArgumentException - If pi is null
 */

   @Override
   public int compareTo(Team pi) {
      if (this.city.compareTo(pi.city) == 0) {
         return this.teamName.compareTo(pi.teamName);
      }
      return this.city.compareTo(pi.city);
   } // end compareTo
}// end class