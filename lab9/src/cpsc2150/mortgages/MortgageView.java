package cpsc2150.mortgages;
import java.util.Scanner;

public class MortgageView implements IMortgageView {
    private Scanner input;
    private IMortgageController Controller;

    /**
     * Constructor
     */
    MortgageView(){
        input = new Scanner(System.in);
    }

    public void setController(IMortgageController c){
        Controller = c;
    }

    public double getHouseCost(){
        printToUser("How much does the house cost?");
        return Integer.parseInt(input.nextLine());
    }

    public double getDownPayment(){
        printToUser("How much is the down payment?");
        return Integer.parseInt(input.nextLine());
    }

    public int getYears(){
        printToUser("How many years?");
        return Integer.parseInt(input.nextLine());
    }

    public double getMonthlyDebt(){
        printToUser("How much are your monthly debt payments?");
        return Integer.parseInt(input.nextLine());
    }

    public double getYearlyIncome(){
        printToUser("How much is your yearly income?");
        return Integer.parseInt(input.nextLine());
    }

    public int getCreditScore(){
        printToUser("What is your credit score?");
        return Integer.parseInt(input.nextLine());
    }

    public String getName(){
        printToUser("What's your name?");
        return input.nextLine();
    }

    public void printToUser(String s){
        System.out.println(s);
    }

    public void displayPayment(double p){
        printToUser(String.format("Monthly Payment: %.2f", p));
    }

    /**
     *
     * @param r the (APR) interest rate for the loan
     * @pre 0 <= r <= 1
     */
    public void displayRate(double r){
        printToUser(String.format("Interest Rate: %.1f%%", r*100));
    }

    public void displayApproved(boolean a){
        if (a){
            printToUser("Load approved.");
        }
        else{
            printToUser("Loan not approved.");
        }
    }

    public boolean getAnotherMortgage(){
        char answer;
        do {
            printToUser("Would you like to apply for another mortgage? Y/N");
            answer = input.nextLine().charAt(0);
        } while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n');
        return (answer == 'Y' || answer == 'y');
    }

    public boolean getAnotherCustomer(){
        char answer;
        do {
            printToUser("Would you like to consider another customer? Y/N");
            answer = input.nextLine().charAt(0);
        } while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n');
        return (answer == 'Y' || answer == 'y');
    }
}
