package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {
    private IMortgageView view;

    public MortgageController (IMortgageView v){
        view = v;
    }

    public void submitApplication(){
// Declare loop variables
        boolean new_mortgage = true;
        boolean new_customer = true;
        String name = " ";
        double income;
        double debt_payments;
        int credit;
        double house_cost;
        double down_payment;
        int years;
        ICustomer customer;
        IMortgage mortgage;
        // Get name from user if new name is requested
        while (new_customer) {
            name = view.getName();
            new_mortgage = true;
            // Loop while new mortgage is requested
            while (new_mortgage) {
                // Reset loop variables
                income = -1;
                debt_payments = -1;
                credit = -1;
                house_cost = -1;
                down_payment = -1;
                years = -1;

                // Get income from user
                while (income <= 0) {
                    income = view.getYearlyIncome();
                    if (income <= 0) {
                        view.printToUser("Income must be greater than 0.");
                    }
                }
                // Get monthly debt payments
                while (debt_payments < 0) {
                    debt_payments = view.getMonthlyDebt();
                    if (debt_payments < 0) {
                        view.printToUser("Debt must be greater than or equal to 0.");
                    }
                }
                // Get credit score
                while (credit <= 0 || credit >= 850) {
                    credit = view.getCreditScore();
                    if (credit <= 0 || credit >= 850) {
                        view.printToUser("Credit score must be greater than 0 and less than 850");
                    }
                }
                // Get house cost
                while (house_cost <= 0) {
                    house_cost = view.getHouseCost();
                    if (house_cost <= 0) {
                        view.printToUser("Cost must be greater than 0.");
                    }
                }
                // Get down payment
                while (down_payment <= 0 || down_payment >= house_cost) {
                    down_payment = view.getDownPayment();
                    if (down_payment <= 0 || down_payment >= house_cost) {
                        view.printToUser("Down payment must be greater than 0 and less than the cost of the house.");
                    }
                }
                // Get years
                while (years <= 0) {
                    years = view.getYears();
                    if (years <= 0) {
                        view.printToUser("Years must be greater than 0.");
                    }
                }
                // Create mortgage
                customer = new Customer(debt_payments, income, credit, name);
                mortgage = new Mortgage(house_cost, down_payment, years, customer);
                // Print the customer
                view.printToUser(customer.toString());
                // Print the mortgage
                view.printToUser(mortgage.toString());
                // Ask user if they want another mortgage with this customer
                new_mortgage = view.getAnotherMortgage();
            }
            new_customer = view.getAnotherCustomer();
        }
    }
}
