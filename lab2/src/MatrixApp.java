import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * @invariant 0 <= input <= 4
 * @invariant 1 <= rows <= 10
 * @invariant 1 <= columns <= 10
 * @invariant in is a Scanner object corresponding to stdin
 */
public class MatrixApp {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int input = 0;
        int rows, columns;
        while (input != 4)
        {
            input = chooseAction(in);
            if (input < 1 || input > 4)
                System.out.println("Choose a valid option.");
            else if (input != 4)
            {
                // Ask for the number of rows and columns
                rows = askRows(in);
                columns = askColumns(in);
                switch (input) {
                    case 1:
                        transposeMatrix(rows, columns, in);
                        break;
                    case 2:
                        addMatrices(rows, columns, in);
                        break;
                    case 3:
                        subtractMatrices(rows, columns, in);
                        break;
                }
            }
        }
    }

    /**
     * Gets user input for which functionality to use
     * @param in
     * @post the integer returned is equal to user input
     * @return and int corresponding the the user's choice
     */
    static int chooseAction(Scanner in)
    {
        System.out.println("1. Get the Transpose of a Matrix");
        System.out.println("2. Add two matrices");
        System.out.println("3. Find the difference of two matrices");
        System.out.println("4. Quit");
        return Integer.parseInt(in.nextLine());
    }

    /**
     * Gets the matrix from the user and prints the transpose.
     * @pre rows = the number of rows given by the user
     * @pre columns = the number of columns given by the user
     * @param rows
     * @param columns
     * @param in
     */
    static void transposeMatrix(int rows, int columns, Scanner in)
    {
        Matrix original = askMatrix(rows, columns, in);
        Matrix T = original.transpose();
        System.out.print(T.toString());
    }

    /**
     * Gets the matrices from the user and prints their sum.
     * @param rows the number of rows in the matrix
     * @param columns the number of columns in the matrix
     * @param in the Scanner for the input terminal
     * @pre
     * [rows is the number of rows given by the user]
     * [columns is the number of columns given by the user]
     */
    static void addMatrices(int rows, int columns, Scanner in)
    {
        System.out.println("What values should be in the first matrix?");
        Matrix A = askMatrix(rows, columns, in);
        System.out.println("What values should be in the second matrix?");
        Matrix B = askMatrix(rows, columns, in);
        Matrix C = A.add(B);
        System.out.print(C.toString());
    }

    /**
     * Gets the matrices from the user and prints their difference.
     * @param rows the number of rows in the matrix
     * @param columns the number of columns in the matrix
     * @param in the Scanner for the input terminal
     * @pre
     * [rows is the number of rows given by the user]
     * [columns is the number of columns given by the user]
     */
    static void subtractMatrices(int rows, int columns, Scanner in)
    {
        System.out.println("What values should be in the first matrix?");
        Matrix A = askMatrix(rows, columns, in);
        System.out.println("What values should be in the second matrix?");
        Matrix B = askMatrix(rows, columns, in);
        Matrix C = A.subtract(B);
        System.out.print(C.toString());
    }

    /**
     * Gets the user input for the number of rows in the matrix.
     * @param in the Scanner for the input terminal
     * @return the number of rows entered by the user
     * @post
     * [rows is the number of rows given by the user]
     */
    static int askRows(Scanner in)
    {
        int rows = 0;
        do {
            System.out.println("How many rows should the matrix have?");
            rows = Integer.parseInt(in.nextLine());
            if (rows < 1 || rows > 10)
                System.out.println("Number of rows must be between 1 and 10");
        } while (rows < 1 || rows > 10);
        return rows;
    }

    /**
     * Gets the user input for the number of columns in the matrix.
     * @param in the Scanner for the input terminal
     * @return the number of columns entered by the user
     * @post
     * [columns = the number of columns given by the user]
     */
    static int askColumns(Scanner in)
    {
        int columns = 0;
        do {
            System.out.println("How many columns should the matrix have?");
            columns = Integer.parseInt(in.nextLine());
            if (columns < 1 || columns > 10)
                System.out.println("Number of columns must be between 1 and 10");
        } while (columns < 1 || columns > 10);
        return columns;
    }

    /**
     * Gets user input for a matrix element-by-element.
     * @param rows the number of rows in the matrix
     * @param columns the number of columns in the matrix
     * @return a Matrix with the values entered by the user
     * @pre
     * [rows is the number of rows entered by the user] and
     * [columns is the number of columns entered by the user]
     * @post
     * [rows is the number of rows entered by the user] and
     * [columns is the number of columns entered by the user]
     */
    static Matrix askMatrix(int rows, int columns, Scanner in)
    {
        List<Integer> content = new ArrayList<Integer>();
        int i, j, value;
        for (i = 0; i < rows; i++)
        {
            for (j = 0; j < columns; j++)
            {
                System.out.print("Enter the value for ");
                System.out.println("row " + (i+1) + " column " + (j+1));
                value = Integer.parseInt(in.nextLine());
                content.add(value);
            }
        }
        return new Matrix(rows, columns, content);
    }
}
