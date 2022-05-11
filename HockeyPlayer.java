package lab9.cscd211classes.players;

public class HockeyPlayer extends Player implements Cloneable {

    protected int jerseyNumber;

/**
 * Constructs a hockey player by calling the parent class and then setting the jersey number
 * Parameters:
 * name - Players name
 * ssn - Players SSN
 * salary - Players salary
 * position - Players position
 * jerseyNumber - Players jersey number
 * Throws:
 * IllegalArgumentException - If jersey number is less than 0
 */

    public HockeyPlayer(String name, String ssn, int salary, String position, int jerseyNumber) {
        super(name, ssn, salary, position);
        if (jerseyNumber < 0) {
            throw new IllegalArgumentException("Jersey number is less than 0.");
        } // end exception
        this.jerseyNumber = jerseyNumber;
    } // end constructor

/**
 * Calls the parents toString and appends jersey number: value
 * Overrides:
 * toString in class Player
 * Returns:
 * String Representing the parents toString and the appended jersey number
 */

    @Override
    public String toString() {
        return super.toString() + " Jersey Number: " + jerseyNumber + "\n";
    } // end toString

/**
 * Returns super.clone() cast to a Hockey Player
 *Overrides:
 * clone in class Player
 * Returns:
 * Hockey Player The cloned hockey player
 * Throws:
 * CloneNotSupportedException - per the documentation
 */

    public HockeyPlayer clone() throws CloneNotSupportedException {
        return (HockeyPlayer) super.clone();
    } // end clone
} // end HockeyPlayer
