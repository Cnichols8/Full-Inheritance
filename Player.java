package lab9.cscd211classes.players;

public abstract class Player extends Object implements Cloneable {

    protected String name;
    protected String ssn;
    protected String position;
    protected int salary;

/**
 * The constructor to create a Player object which is called via super from the children constructor
 * Parameters:
 * name - Representing the name
 * ssn - Representing the social security number
 * salary - Representing the salary
 * position - Representing the position
 * Throws:
 * IllegalArgumentException - If any of the strings are null or empty
 */

    protected Player(String name, String ssn, int salary, String position) {
        if (name == null || ssn == null || position == null) {
            throw new IllegalArgumentException("One of the strings is null.");
        } // end exception
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
        this.position = position;
    } // end constructor

/**
 * Returns a players salary
 * Returns:
 * int The players salary
 */

    public int getSalary() {
        return this.salary;
    } // end getSalary

/**
 * Returns the players position
 * Returns:
 * String The players position
 */

    public String getPosition() {
        return this.position;
    } // end getPosition

/**
 * Returns the players name
 * Returns:
 * String The players name
 */

    public String getName() {
        return this.name;
    } // end getName

/**
 * Returns the players ssn
 * Returns:
 * String The players ssn
 */

    public String getSsn() {
        return this.ssn;
    } // end getSsn

/**
 * Returns the name SPACE ssn SPACE salary SPACE position
 * Overrides:
 * toString in class Object
 */

    @Override
    public String toString() {
        return this.name + " " + this.ssn + " " + this.salary + " " + this.position;
    } // end toString

/**
 * Returns a cloned player object by calling the clone method in the parent class and casting that as a player
 * Overrides:
 * clone in class Object
 * Returns:
 * Player Done via the call to super.clone() cast to a Player
 * Throws:
 * CloneNotSupportedException
 */

    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    } // end clone

} // end Player
