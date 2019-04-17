import java.util.List;

/**
 * @invariant 1 <= rows <= 10
 * @invariant 1 <= columns <= 10
 * @invariant dimensions of numArray = rows x columns
 */
public class Matrix {
    private int rows, columns, numArray[][];

    /**
     * Regular Matrix constructor.
     * @param numRows the number of rows in the matrix
     * @param numCols the number of columns in the matrix
     * @pre
     * 1 <= numRows <= 10 and 1 <= numCols <= 10
     * @post
     * rows = numRows and columns = numCols
     * [numArray is of size rows x columns]
     */
    Matrix (int numRows, int numCols)
    {
        rows = numRows;
        columns = numCols;
        numArray = new int[rows][columns];
    }

    /**
     * Regular Matrix constructor.
     * @param numRows the number of rows in the matrix
     * @param numCols the number of columns in the matrix
     * @param numList the elements to be added to the matrix,
     *                listed one row after another.
     * @pre
     * 1 <= numRows <= 10 and 1 <= numCols <= 10
     * length of numList = numRows * numCols
     * @post
     * rows = numRows
     * columns = numCols
     * [numArray holds the elements from numList, with the first
     * numCols elements in the first row, the next numCold elements
     * in the second row, etc.]
     */
    Matrix (int numRows, int numCols, List numList)
    {
        rows = numRows;
        columns = numCols;
        numArray = new int[rows][columns];
        int i, j;
        for (i = 0; i < rows; i++)
            for (j = 0; j < columns; j++)
                numArray[i][j] = (Integer) numList.get((i*columns)+j);
    }

    /**
     * @return the number of rows in the matrix
     */
    int getRows()
    {
        return rows;
    }

    /**
     * @return the number of columns in the matrix
     */
    int getColumns()
    {
        return columns;
    }

    /**
     * Creates a new matrix equal to the sum of two matrices.
     * @param B the matrix being added to the Matrix that this function
     *          is called on.
     * @return a Matrix C where C = A+B, with A being the Matrix that the
     * method is called on and B being the Matrix that is passed as a
     * parameter of the method.
     * @pre
     * B.rows = this.rows and B.columns = this.columns
     * @post
     * [this and B are unchanged]
     */
    Matrix add(Matrix B)
    {
        Matrix C = new Matrix(this.rows, this.columns);
        int i, j;
        for (i = 0; i < rows; i++)
            for (j = 0; j < columns; j++)
                C.numArray[i][j] = this.numArray[i][j] + B.numArray[i][j];
        return C;
    }

    /**
     * Creates a new matrix equal to the difference of two matrices.
     * @param B the matrix being subtracted from the Matrix that this
     *          function is called on
     * @return a Matrix C where C = A-B, with A being the Matrix this
     * method is called on and B being the Matrix that is passed as a
     * parameter of the method
     * @pre
     * B.rows = this.rows and B.columns = this.columns
     * @post
     * [this and B are unchanged]
     */
    Matrix subtract(Matrix B)
    {
        Matrix C = new Matrix(this.rows, this.columns);
        int i, j;
        for (i = 0; i < rows; i++)
            for (j = 0; j < columns; j++)
                C.numArray[i][j] = this.numArray[i][j] - B.numArray[i][j];
        return C;
    }

    /**
     * Creates a new Matrix equal to the transpose of the given Matrix.
     * @return the transpose of the original matrix
     * @post
     * [this Matrix is unchanged]
     */
    Matrix transpose()
    {
        Matrix C = new Matrix(this.columns, this.rows);
        int i, j;
        for (i = 0; i < rows; i++)
            for (j = 0; j < columns; j++)
                C.numArray[j][i] = this.numArray[i][j];
        return C;
    }

    /**
     * @return a string of the given Matrix where elements on the same
     * row are separated by " | " and rows are separated by new lines.
     * @post
     * [this Matrix is unchanged]
     */
    public String toString()
    {
        int i, j;
        String str = "";
        for (i = 0; i < rows; i++)
        {
            str += "| ";
            for (j = 0; j < columns; j++)
            {
                str += numArray[i][j];
                str += " | ";
            }
                str += "\n";
        }
        return str;
    }
}
