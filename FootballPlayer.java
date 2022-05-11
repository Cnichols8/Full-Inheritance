package lab9.cscd211classes.players;

public class FootballPlayer extends Player implements Cloneable {

    protected int td;
    protected int jerseyNumber;

/**
 * Constructs a football player by calling the parent class and then setting the touchdowns and jersey number
 * Parameters:
 * name - Players name
 * ssn - Players SSN
 * salary - Players salary
 * position - Players position
 * td - Players touchdowns
 * jerseyNumber - Players jersey number
 * Throws:
 * IllegalArgumentException - If touchdowns are less than 0
 * IllegalArgumentException - If jersey number is less than 0
 */

    public FootballPlayer(String name, String ssn, int salary, String position, int td, int jerseyNumber) {
        super(name, ssn, salary, position);
        if (td < 0 || jerseyNumber < 0) {
            throw new IllegalArgumentException("Touchdowns or jersey number is less than zero.");
        } // end exception
        this.td = td;
        this.jerseyNumber = jerseyNumber;
    } // end constructor

/**
 * Returns the name SPACE ssn SPACE salary SPACE position Returns parents toString
 * plus TAB Touchdowns: value then TAB jersey number
 * Overrides:
 * toString in class Player
 * Returns:
 * String Returns parents toString plus TAB Touchdowns: value then TAB jersey number
 */

    @Override
    public String toString() {
        return super.toString() + " Touchdowns: " + td + "  " + jerseyNumber + "\n";
    } // end toString

/**
 * Returns a cloned player object by calling the clone method in the parent class and casting that as a player
 * Returns super.clone() cast to a FootballPlayer
 * Overrides:
 * clone in class Player
 * Returns:
 * FootballPlayer Returns super.clone() cast to a FootballPlayer
 * Throws:
 * CloneNotSupportedException
 */

    public FootballPlayer clone() throws CloneNotSupportedException {
        return (FootballPlayer) super.clone();
    } // end clone
} // end FootballPlayer
