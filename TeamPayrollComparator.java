package lab9.cscd211comparators;

import lab9.cscd211classes.Team;

import java.util.Comparator;

public class TeamPayrollComparator implements Comparator<Team> {

    public TeamPayrollComparator() {

    } // end constructor

/**
 * Compares team1 to team2 based on the salary
 * Specified by:
 * compare in interface Comparator<Team>
 * Parameters:
 * t1 - Representing the first Team being passed in
 * t2 - Representing the second Team being passed in
 * Returns:
 * int less than 0, greater than 0 or equal to 0
 * Throws:
 * IllegalArgumentException - if either team is null
 */

    @Override
    public int compare(Team t1, Team t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("One team is null.");
        } // end exception
        return Double.compare(t1.getPayroll(), t2.getPayroll());
    }
} // end comparator
