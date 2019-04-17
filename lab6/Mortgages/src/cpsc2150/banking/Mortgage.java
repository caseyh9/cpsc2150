package cpsc2150.banking;
import java.lang.Math;

public class Mortgage extends AbsMortgage implements IMortgage {
    private double Payment;
    private double Rate;
    private ICustomer customer;
    private int Years;
    private double DebtToIncomeRatio;
    private double Principal;
    private int NumberOfPayments;
    private double PercentDown;
    private final static int MONTHS_PER_YEAR = 12;

    /**
     * Constructor for a Mortgage object.
     * @param cost the cost of the home
     * @param down_payment the down payment paid by customer
     * @param num_years the number of years over which the mortgage will extend
     * @param customer the customer who is applying for the mortgage
     */
    Mortgage(double cost, double down_payment, int num_years, ICustomer customer){
        this.customer = customer;
        Years = num_years;
        Principal = cost - down_payment;
        NumberOfPayments = num_years * MONTHS_PER_YEAR;
        PercentDown = down_payment / cost;
        Rate = calculateRate();
        Payment = ((Rate/MONTHS_PER_YEAR) * Principal) / (1 - Math.pow((1+(Rate/MONTHS_PER_YEAR)), -NumberOfPayments));
        DebtToIncomeRatio = (customer.getMonthlyDebtPayments() + Payment) / (customer.getIncome() / MONTHS_PER_YEAR);
    }

    /**
     * Calculates the rate of the mortgage based on the length of the loan, the percent down, and
     * the customer's credit score.
     * @return the rate calculated for the customer.
     */
    private double calculateRate(){
        // Start at base rate and get customers credit score
        double new_rate = BASERATE;
        int credit_score = customer.getCreditScore();
        // Adjust based on length of loan
        if (Years < MAX_YEARS)
            new_rate += GOODRATEADD;
        else
            new_rate += NORMALRATEADD;
        // Adjust based on percent down
        if (PercentDown < PREFERRED_PERCENT_DOWN)
            new_rate += GOODRATEADD;
        // Adjust based on credit score
        if (credit_score < BADCREDIT)
            new_rate += VERYBADRATEADD;
        else if (credit_score < FAIRCREDIT)
            new_rate += BADRATEADD;
        else if (credit_score < GOODCREDIT)
            new_rate += NORMALRATEADD;
        else if (credit_score < GREATCREDIT)
            new_rate += GOODRATEADD;
        // Return the final rate value
        return new_rate;
    }

    public boolean loanApproved(){
        if (getRate() >= RATETOOHIGH)
            return false;
        if (PercentDown < MIN_PERCENT_DOWN)
            return false;
        if (DebtToIncomeRatio > DTOITOOHIGH)
            return false;
        // If none of these cases apply, the loan is approved
        return true;
    }

    public double getPayment(){
        return Payment;
    }

    public double getRate(){
        return Rate;
    }

    public double getPrincipal(){
        return Principal;
    }

    public int getYears(){
        return Years;
    }
}
