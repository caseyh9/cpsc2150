package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {
    private IMortgageView view;

    public MortgageController (IMortgageView v){
        view = v;
    }

    public void submitApplication(){
        // Get name
        String name = view.getName();
        // Get income from user
        double income = view.getYearlyIncome();
        // Get monthly debt payments
        double debt_payments = view.getMonthlyDebt();
        // Get credit score
        int credit = view.getCreditScore();
        // Get house cost
        double house_cost = view.getHouseCost();
        // Get down payment
        double down_payment = view.getDownPayment();
        // Get years
        int years = view.getYears();
        // Validate all input and alert user to error if necessary
        if (income <= 0) {
            view.printToUser("Income must be greater than 0.");
        }
        else if (debt_payments < 0) {
            view.printToUser("Debt must be greater than or equal to 0.");
        }
        else if (credit <= 0 || credit >= 850) {
            view.printToUser("Credit score must be greater than 0 and less than 850");
        }
        else if (house_cost <= 0) {
            view.printToUser("Cost must be greater than 0.");
        }
        else if (down_payment <= 0 || down_payment >= house_cost) {
            view.printToUser("Down payment must be greater than 0 and less than the cost of the house.");
        }
        else if (years <= 0) {
            view.printToUser("Years must be greater than 0.");
        }
        // If no input errors are found, continue with mortgage application
        else{
            // Create customer and mortgage
            ICustomer customer = new Customer(debt_payments, income, credit, name);
            IMortgage mortgage = new Mortgage(house_cost, down_payment, years, customer);
            // Display loan approval or disapproval
            view.displayApproved(mortgage.loanApproved());
            // If approved, display rate and monthly payments
            if (mortgage.loanApproved()) {
                view.displayRate(mortgage.getRate());
                view.displayPayment(mortgage.getPayment());
            }
            // Otherwise, display zeros for these
            else{
                view.displayRate(0);
                view.displayPayment(0);
            }
        }
    }
}
