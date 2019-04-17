import java.util.Scanner;

public class DoubleSetApp {
    public static void main(String[] args) {
        // Setup
        Scanner in = new Scanner(System.in);
        ISet<Double> set1, set2;
        int action = getSelection(in);
        // Get selection until Exit (4) is chosen
        while(action != 5) {
            // Get the set types and then fill set1
            System.out.println("Make set 1");
            if (getSetType(in) == 1){
                set1 = new ArraySet<>();
            }
            else{
                set1 = new ListSet<>();
            }
            fillSet(in, set1);
            // Repeat with set2
            System.out.println("Make set 2");
            if (getSetType(in) == 1){
                set2 = new ArraySet<>();
            }
            else{
                set2 = new ListSet<>();
            }
            fillSet(in, set2);
            // Print both sets
            System.out.println("Set 1 is:");
            System.out.println(set1.toString());
            System.out.println("Set 2 is:");
            System.out.println(set2.toString());
            // Perform the chosen operation and print the result
            switch (action) {
                case 1:
                    set1.union(set2);
                    System.out.println("The union is:");
                    System.out.println(set1.toString());
                    break;
                case 2:
                    set1.intersect(set2);
                    System.out.println("The intersection is:");
                    System.out.println(set1.toString());
                    break;
                case 3:
                    set1.difference(set2);
                    System.out.println("The difference is:");
                    System.out.println(set1.toString());
                    break;
                case 4:
                    if (set1.equals(set2)){
                        System.out.println("The sets are equal!");
                    }
                    else {
                        System.out.println("The sets are not equal!");
                    }
            }
            System.out.println();
            action = getSelection(in);
        }
    }

    /**
     * Gets the user's choice for what the program will do.
     * @param in the Scanner for System.in
     * @return an integer corresponding to the action chosen by the user
     * @pre
     * in = System.in
     * @post
     * 1 <= getSelection <= 5
     * getSelection = 1 [iff user chose to find union of sets]
     * getSelection = 2 [iff user chose to find intersection of sets]
     * getSelection = 3 [iff user chose to find difference of sets]
     * getSelection = 4 [iff user chose to find if sets are equal]
     * getSelection = 5 [iff user chose to exit program]
     */
    private static int getSelection(Scanner in){
        int input = 0;
        while (input < 1 || input > 5) {
            System.out.println("Make a selection");
            System.out.println("1. Find the Union of Two Sets");
            System.out.println("2. Find the intersection of Two sets");
            System.out.println("3. Find the difference of two Sets");
            System.out.println("4. See if two sets are equal");
            System.out.println("5. Exit");
            input = Integer.parseInt(in.nextLine());
            if (input < 1 || input > 5){
                System.out.println("Invalid input, try again.");
            }
        }
        return input;
    }

    /**
     * Fills a set will input from the user
     * @param in the Scanner for System.in
     * @param set the set the user is filling
     * @pre
     * in = System.in
     * [set is an empty ISet]
     * @post
     * [set is filled with input given by user]
     */
    private static void fillSet(Scanner in, ISet set){
        char letter;
        String line;
        double number;
        // Have the user fill the set
        boolean finish = false;
        while (!finish){
            System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
            line = in.nextLine();
            letter = line.charAt(0);
            // If q is input, finish the loop
            if (letter == 'q'){
                finish = true;
            }
            // Otherwise, check if the value is in the set, and if not add it
            else if (set.getSize() == ISet.MAX_SIZE){
                // If the set has reached max size, tell the user and finish
                System.out.println("Set is already full!");
                finish = true;
            }
            else{
                number = Double.parseDouble(line);
                if (!set.contains(number)){
                    set.add(number);
                }
            }
        }
    }

    /**
     * Gets the user's choice of how to implement ISet.
     * @param in the Scanner for System.in
     * @return an integer corresponding to the user's implementation choice
     * @pre
     * in = System.in
     * @post
     * getSetType = 1 || getSetType = 2
     * getSetType = 1 [iff user chose array implementation]
     * getSetType = 2 [iff user chose list implementation]
     */
    private static int getSetType(Scanner in){
        int number = 0;
        while (number != 1 && number != 2) {
            System.out.println("Enter 1 for an array implementation or 2 for a list implementation");
            number = Integer.parseInt(in.nextLine());
        }
        return number;
    }
}