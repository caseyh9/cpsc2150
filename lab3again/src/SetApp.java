import java.util.Scanner;

public class SetApp
{
    public static void main(String[] args)
    {
        int setType = 0;
        int action;
        ISet set;
        Scanner in = new Scanner(System.in);

        // Get user input for the type of set to use
        while ((setType != 1) && (setType != 2)) {
            System.out.println("Enter 1 for an array implementation or 2 for a list implementation");
            setType = Integer.parseInt(in.nextLine());
            if ((setType != 1) && (setType != 2))
                System.out.println("That is not a valid choice");
        }
        if (setType == 1)
            set = new ArraySet();
        else
            set = new ListSet();
        // Continue prompting user until Exit is chosen
        do {
            action = getAction(in);
            switch (action)
            {
                case 1:
                    addValue(set, in);
                    printSet(set);
                    break;
                case 2:
                    removeValue(set, in);
                    printSet(set);
                    break;
            }
        } while (action == 1 || action == 2);
    }

    /**
     * Gets the choice of action from the user.
     * @param in the Scanner for System.in
     * @return the integer corresponding to the user's choice.
     *      [1 to add a value, 2 to remove a value, and 3 to exit.]
     * @pre [in is the Scanner for the screen where the user will input.]
     * @post [int = the integer entered by the user.]
     */
    private static int getAction(Scanner in)
    {
        int choice = 0;
        while (choice < 1 || choice > 3)
        {
            System.out.println("1. Add a value to the set");
            System.out.println("2. Remove a value from the set");
            System.out.println("3. Exit");
            choice = Integer.parseInt(in.nextLine());
            if (choice < 1 || choice > 3)
                System.out.println("Not a valid operation. Choose Again.");
        }
        return choice;
    }

    /**
     * Adds a value to the set.
     * @param set the set being used.
     * @param in the Scanner for System.in
     */
    private static void addValue(ISet set, Scanner in)
    {
        boolean contained;
        int val;
        if (set.getSize() == ISet.MAX_SIZE)
        {
            System.out.println("Set is already full!");
            return;
        }
        do {
            System.out.println("What value to add to set?");
            val = Integer.parseInt(in.nextLine());
            contained = set.contains(val);
            if (contained)
                System.out.println("That value is already in the set");
        } while (contained);
        set.add(val);
    }

    /**
     * Removes a value from the set.
     * @param set the set being used.
     * @param in the Scanner for System.in.
     */
    private static void removeValue(ISet set, Scanner in)
    {
        if (set.getSize() == 0)
            System.out.println("Can't remove from an empty set!");
        else {
            int pos;
            boolean valid;
            do {
                System.out.println("What position should be removed from the set?");
                pos = Integer.parseInt(in.nextLine());
                valid = (pos >= 0 && pos < set.getSize());
                if (!valid)
                    System.out.println("That's not a valid position");
            } while (!valid);
            set.removePos(pos);
        }
    }

    /**
     * Prints the set.
     * @param set the set being used.
     * @post [set is not modified.]
     */
    private static void printSet(ISet set)
    {
        System.out.println("Set is:");
        System.out.println(set.toString());
    }
}
