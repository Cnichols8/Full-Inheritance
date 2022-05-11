package lab9.cscd211classes.players;

public class BaseballPlayer extends Player implements Cloneable {

    protected double batAvg;

/**
 * Constructs a baseball player by calling the parent class and then setting the batting average
 * Parameters:
 * name - Players name
 * ssn - Players SSN
 * salary - Players salary
 * position - Players position
 * batAvg - Players batting average
 * Throws:
 * IllegalArgumentException - If batting average is less than 0
 */

    public BaseballPlayer(String name, String ssn, int salary, String position, double batAvg) {
        super(name, ssn, salary, position);
        if (batAvg < 0) {
            throw new IllegalArgumentException("Batting average is less than 0.");
        }
        this.batAvg = batAvg;
    } // end constructor

/**
 * Returns the name SPACE ssn SPACE salary SPACE position Calls the parents toString and appends Batting Avg: value
 * Overrides:
 * toString in class Player
 * Returns:
 * String Representing the parents toString and the appended batting average
*/

    @Override
    public String toString() {
        return super.toString() + " Batting Average: " + batAvg + "\n";
    } // end toString

/**
 * Returns a cloned player object by calling the clone method in the parent class and casting that as
 * a player Returns super.clone() cast to a BaseballPlayer
 * Overrides:
 * clone in class Player
 * Returns:
 * BaseballPlayer The cloned baseball player
 * Throws:
 * CloneNotSupportedException
 */

    public BaseballPlayer clone() throws CloneNotSupportedException {
        return (BaseballPlayer) super.clone();
    } // clone

} // end BaseballPlayer
