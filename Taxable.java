package lab9.cscd211interfaces;

public interface Taxable {

// Tax rate is set to 0.09

    static final double BASE_TAX_RATE = 0.09;

/**
 * The calculateTaxes is defined in the implementing class
 * Returns:
 * double Representing the calculated taxes
 */

    double calculateTaxes();

} // end Taxable
